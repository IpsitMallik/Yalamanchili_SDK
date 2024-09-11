package com.narada.sdk.utilities;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import com.narada.sdk.config.Configuration;

import java.nio.charset.StandardCharsets;
import java.security.*;

public class EncryptDecryptUtility {

	private static final String AES_ALGORITHM = "AES";
	private static final String AES_CIPHER_ALGORITHM = "AES/GCM/NoPadding";
	private static final int AES_KEY_SIZE = 256;
	private static final String RSA_CIPHER_ALGORITHM = "RSA/ECB/OAEPWITHSHA-256ANDMGF1PADDING";
	private static final String SIGNATURE_ALGORITHM = "SHA512withRSA";

	static {
		Security.addProvider(new BouncyCastleProvider());
	}

	private final String CERTIFICATE_FILE;
	private final String PRIVATE_KEY_FILE;

	private EncryptDecryptUtility(String privateKeyFile, String certificateFile) {
		this.PRIVATE_KEY_FILE = privateKeyFile;
		this.CERTIFICATE_FILE = certificateFile;
	}

	public static EncryptDecryptUtility getInstance() {
		return new EncryptDecryptUtility(Configuration.getPvtKeyFilePath(), Configuration.getCertFilePath());
	}

	/**
	 * Encrypts the XML request using a generated session key.
	 *
	 * @param xmlRequestData the XML request data
	 * @param msgRefNo       the message reference number
	 * @return the encryption result containing the encrypted XML and session key
	 * @throws Exception if an error occurs during encryption
	 */
	public EncryptionResult encryptXmlRequest(String xmlRequestData, String msgRefNo) throws Exception {
		try {
			byte[] sessionKey = generateSessionKey();
//			System.out.println("Generated Session Key: " + YPKIImplementation.base64Encode(sessionKey));

			String encryptedXML = YPKIImplementation.encryptRequestWithSessionKey(sessionKey, AES_ALGORITHM,
					AES_CIPHER_ALGORITHM, xmlRequestData.getBytes(StandardCharsets.UTF_8), msgRefNo);

			String encryptedSessionKey = encryptSessionKey(sessionKey);

			return new EncryptionResult(replaceWhiteSpace(encryptedXML), replaceWhiteSpace(encryptedSessionKey));
		} catch (Exception e) {
			throw new Exception("Error encrypting XML request", e);
		}
	}

	/**
	 * Encrypts the session key using the public key.
	 *
	 * @param sessionKey the session key to encrypt
	 * @return the encrypted session key
	 * @throws Exception if an error occurs during encryption
	 */
	private String encryptSessionKey(byte[] sessionKey) throws Exception {
		try {
			String encryptedSessionKey = YPKIImplementation.encryptSessionKey(sessionKey, CERTIFICATE_FILE,
					RSA_CIPHER_ALGORITHM, "RSA", "BC");
//			System.out.println("Encrypted Session Key: " + encryptedSessionKey);
			return encryptedSessionKey;
		} catch (Exception e) {
			throw new Exception("Error encrypting session key", e);
		}
	}

	/**
	 * Generates a session key for encryption.
	 *
	 * @return the generated session key
	 * @throws Exception if an error occurs during key generation
	 */
	private byte[] generateSessionKey() throws Exception {
		try {
			return YPKIImplementation.generateSessionKey(AES_ALGORITHM, "BC", AES_KEY_SIZE);
		} catch (NoSuchAlgorithmException | NoSuchProviderException e) {
			throw new Exception("Error generating session key", e);
		}
	}

	/**
	 * Signs the XML request data.
	 *
	 * @param xmlRequestData the XML request data to sign
	 * @return the signed XML request
	 * @throws Exception if an error occurs during signing
	 */
	public String signXmlRequest(String xmlRequestData) throws Exception {
		try {
			byte[] hashedRequest = YPKIImplementation.getRequestHash(xmlRequestData, "SHA-256", "BC");
//			System.out.println("Hashed Request: " + YPKIImplementation.base64Encode(hashedRequest));

			String signedXML = YPKIImplementation.signRequest(PRIVATE_KEY_FILE, hashedRequest, "BC",
					SIGNATURE_ALGORITHM, "");

//			System.out.println("Signed XML: " + signedXML);
			return replaceWhiteSpace(signedXML);
		} catch (Exception e) {
			throw new Exception("Error signing XML request", e);
		}
	}

	/**
	 * Verifies the signature of the response data.
	 *
	 * @param signedData   the signed data
	 * @param responseData the response data to verify
	 * @return true if the signature is valid, false otherwise
	 * @throws Exception if an error occurs during verification
	 */
	public boolean verifySignature(String signedData, String responseData) throws Exception {
		try {
			byte[] hashedResponse = YPKIImplementation.getRequestHash(responseData, "SHA-256", "BC");
//			System.out.println("Hashed Response: " + YPKIImplementation.base64Encode(hashedResponse));

			byte[] encryptedSignature = YPKIImplementation.base64Decode(signedData);

			return YPKIImplementation.verifyRequest(CERTIFICATE_FILE, encryptedSignature, hashedResponse, "BC",
					SIGNATURE_ALGORITHM, "RSA");
		} catch (Exception e) {
			throw new Exception("Error verifying the signature", e);
		}
	}

	/**
	 * Decrypts the XML response using the session key.
	 *
	 * @param encryptedXmlData    the encrypted XML data
	 * @param encryptedSessionKey the encrypted session key
	 * @param msgRefNo            the message reference number
	 * @return the decrypted XML response
	 * @throws Exception if an error occurs during decryption
	 */
	public String decryptXmlResponse(String encryptedXmlData, String encryptedSessionKey, String msgRefNo)
			throws Exception {
		try {
			byte[] decryptedSessionKey = YPKIImplementation.decryptSessionKey(encryptedSessionKey, PRIVATE_KEY_FILE,
					RSA_CIPHER_ALGORITHM, "");

//			System.out.println("Decrypted Session Key: " + YPKIImplementation.base64Encode(decryptedSessionKey));

			byte[] decryptedResponseData = YPKIImplementation.decryptResponseWithSessionKey(decryptedSessionKey,
					AES_ALGORITHM, AES_CIPHER_ALGORITHM, encryptedXmlData, msgRefNo);

			return new String(decryptedResponseData, StandardCharsets.UTF_8);
		} catch (Exception e) {
			throw new Exception("Error decrypting XML response", e);
		}
	}
	
	public static String replaceWhiteSpace(String s) {
	    if (s == null) return s; 
	    return ((s.indexOf("</") == -1) ? s.replaceAll("\\s*", "") : s).trim();
	 }
}
