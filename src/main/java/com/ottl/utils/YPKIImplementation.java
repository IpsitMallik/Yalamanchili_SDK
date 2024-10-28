package com.ottl.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Security;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.io.pem.PemReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class YPKIImplementation {
    private static final Logger LOG = LoggerFactory.getLogger(YPKIImplementation.class);

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    public static String base64Encode(byte[] binaryData) {
        return Base64.encodeBase64String(binaryData);
    }

    public static byte[] base64Decode(String base64String) {
        return Base64.decodeBase64(base64String);
    }

    public static String signRequest(String pvtKeyFileName, byte[] dataToSign, String pkiProvider,
                                     String signatureAlg, String pvtPass) throws Exception {
        PrivateKey privateKey = getPrivateKey(pvtKeyFileName);
        Signature signature = Signature.getInstance(signatureAlg);
        signature.initSign(privateKey);
        signature.update(dataToSign);
        byte[] signatureBytes = signature.sign();
        return base64Encode(signatureBytes);
    }

    public static boolean verifyRequest(String pubKeyFileName, byte[] encryptedData, byte[] hashedRequest,
                                        String pkiProvider, String signatureAlg, String keyFactoryAlg)
            throws NoSuchAlgorithmException, NoSuchProviderException, IOException, InvalidKeySpecException,
            InvalidKeyException, SignatureException, CertificateException {
        PublicKey pubKey = getPublicKey(pubKeyFileName, keyFactoryAlg);
        LOG.debug("pubkey : " + pubKey);
        Signature verifier = Signature.getInstance(signatureAlg);
        LOG.debug("verifier : " + verifier);
        verifier.initVerify(pubKey);
        verifier.update(hashedRequest);

        boolean isVerified = verifier.verify(encryptedData);
        LOG.debug("status : " + isVerified);
        return isVerified;
    }

    public static byte[] getRequestHash(String dataToHash, String messageDgstAlg, String pkiProvider) {
        byte[] hashedRequest = null;
        try {
            MessageDigest requestHash = MessageDigest.getInstance(messageDgstAlg, pkiProvider);
            hashedRequest = requestHash.digest(dataToHash.getBytes());
        } catch (NoSuchAlgorithmException | NoSuchProviderException e) {
            LOG.debug(e.getMessage());
        }
        return hashedRequest;
    }

    private static FileReader getPVTKeyFile(File pvtFile) {
        FileReader pvtFileReader = null;
        try {
            pvtFileReader = new FileReader(pvtFile);
        } catch (FileNotFoundException e) {
            LOG.debug(e.getMessage());
        }
        return pvtFileReader;
    }

    private static byte[] getPUBKeyData(String pubKeyFileName) throws IOException {
        File pubKeyFile = new File(pubKeyFileName);
        try (FileInputStream pubKeyStream = new FileInputStream(pubKeyFile)) {
            byte[] pubKey = new byte[(int) pubKeyFile.length()];
            pubKeyStream.read(pubKey);
            return pubKey;
        }
    }

    private static PrivateKey getPrivateKey(String filename) throws Exception {
		try {
			String key = new String(Files.readAllBytes(Paths.get(filename)), StandardCharsets.UTF_8);
			key = key.replace("-----BEGIN PRIVATE KEY-----", "").replace("-----END PRIVATE KEY-----", "")
					.replaceAll("\\s", "");
			byte[] keyBytes = java.util.Base64.getDecoder().decode(key);
			PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			return keyFactory.generatePrivate(spec);
		} catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException e) {
			throw new Exception("Error retrieving private key", e);
		}
	}
    public static PrivateKey getPrivateKey(String pvtKeyFileName, String pvtPass) throws Exception {
        String keyPass = strDecrypt(pvtPass);
        try (InputStream inputStream = new FileInputStream(pvtKeyFileName)) {
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            keyStore.load(inputStream, keyPass.toCharArray());
            return (PrivateKey) keyStore.getKey("1", keyPass.toCharArray());
        }
    }

    public static String strDecrypt(String strEncrypt) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        byte[] keyBytes = hexStringToByteArray("4E677041706950617373456E634B6579");
        SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] tmpbyt = hexStringToByteArray(strEncrypt);
        byte[] plainText = cipher.doFinal(tmpbyt);
        return new String(plainText).trim();
    }

    public static byte[] hexStringToByteArray(String paramString) {
        int i = paramString.length();
        byte[] arrayOfByte = new byte[i / 2];
        for (int j = 0; j < i; j += 2) {
            arrayOfByte[j / 2] = (byte) ((Character.digit(paramString.charAt(j), 16) << 4) +
                    Character.digit(paramString.charAt(j + 1), 16));
        }
        return arrayOfByte;
    }

    public static String encrypt(String encrptedData, PublicKey pubKey, String cipherAlg, String pkiProvider)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException,
            BadPaddingException, NoSuchProviderException {
        Cipher encryptCipher = Cipher.getInstance(cipherAlg, pkiProvider);
        encryptCipher.init(Cipher.ENCRYPT_MODE, pubKey);
        byte[] encryptionByte = encryptCipher.doFinal(encrptedData.getBytes());
        return base64Encode(encryptionByte);
    }

    public static byte[] decryptSessionKey(String decrptedData, String pvtKeyFileName, String cipherAlg, String pvtPass) throws Exception {
        PrivateKey privateKey = getPrivateKey(pvtKeyFileName);
        Cipher decryptCipher = Cipher.getInstance(cipherAlg);
        decryptCipher.init(Cipher.DECRYPT_MODE, privateKey);
//        System.out.println("privateKey:::" + privateKey);
        return decryptCipher.doFinal(base64Decode(decrptedData));
    }

    public static byte[] decryptResponseWithSessionKey(byte[] sessionKey, String keyGeneratorAlg, String symetricKeyAlg,
                                                       String encXML, String msgRefNo)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException,
            BadPaddingException, NoSuchProviderException, InvalidAlgorithmParameterException {
        StringBuilder strIv = new StringBuilder(msgRefNo);
        strIv.append("0000");
        LOG.debug("[decryptResponseWithSessionKey] Msg Ref No : " + strIv.toString());
        SecretKeySpec symmKeySpec = new SecretKeySpec(sessionKey, keyGeneratorAlg);
        Cipher symmCipher = Cipher.getInstance(symetricKeyAlg);
        symmCipher.init(Cipher.DECRYPT_MODE, symmKeySpec, new GCMParameterSpec(128, strIv.toString().getBytes()));
        return symmCipher.doFinal(base64Decode(encXML));
    }

    private static PemReader getPvtPemReader(Reader pvtFile) {
        return new PemReader(pvtFile);
    }

    public static byte[] generateSessionKey(String keyGeneratorAlg, String pkiProvider, int symetricKeySize)
            throws NoSuchAlgorithmException, NoSuchProviderException {
        KeyGenerator kgen = KeyGenerator.getInstance(keyGeneratorAlg);
        kgen.init(symetricKeySize);
        SecretKey key = kgen.generateKey();
        return key.getEncoded();
    }

    public static String encryptSessionKey(byte[] sessionKey, String pubKeyFileName, String cipherAlg, String keyFactoryAlg,
                                           String pkiProvider)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException,
            BadPaddingException, NoSuchProviderException, InvalidKeySpecException, IOException, CertificateException {
        PublicKey pubKey = getPublicKey(pubKeyFileName, keyFactoryAlg);
        Cipher encryptCipher = Cipher.getInstance(cipherAlg);
        encryptCipher.init(Cipher.ENCRYPT_MODE, pubKey);
        return base64Encode(encryptCipher.doFinal(sessionKey));
    }

    public static String encryptRequestWithSessionKey(byte[] sessionKey, String keyGeneratorAlg, String symetricKeyAlg,
                                                      byte[] xmlRequestData, String msgRefNo)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException,
            BadPaddingException, NoSuchProviderException, InvalidAlgorithmParameterException {
        Security.addProvider(new BouncyCastleProvider());
        StringBuilder strIv = new StringBuilder(msgRefNo);
        strIv.append("0000");
        SecretKeySpec symmKeySpec = new SecretKeySpec(sessionKey, keyGeneratorAlg);
        Cipher symmCipher = Cipher.getInstance(symetricKeyAlg);
        symmCipher.init(Cipher.ENCRYPT_MODE, symmKeySpec, new GCMParameterSpec(128, strIv.toString().getBytes()));
        byte[] encXMLPidData = symmCipher.doFinal(xmlRequestData);
        return base64Encode(encXMLPidData);
    }

    public static String decrptRSAEncryption(String encryptValue, String pvtKeyFileName, String KeyFactroyAlg, String pvtPass) throws Exception {
        Cipher cipher = Cipher.getInstance(KeyFactroyAlg);
        cipher.init(Cipher.DECRYPT_MODE, getPrivateKey(pvtKeyFileName, pvtPass));
        byte[] enc = encryptValue.getBytes();
        return new String(cipher.doFinal(Base64.decodeBase64(enc)));
    }

    private static PublicKey getPublicKey(String pubKeyFileName, String keyFactoryAlg)
            throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeySpecException, IOException,
            CertificateException {
        Security.addProvider(new BouncyCastleProvider());
        if (pubKeyFileName.endsWith(".cer")) {
            try (FileInputStream fin = new FileInputStream(pubKeyFileName)) {
                CertificateFactory f = CertificateFactory.getInstance("X.509");
                X509Certificate certificate = (X509Certificate) f.generateCertificate(fin);
                return certificate.getPublicKey();
            }
        }
        X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(getPUBKeyData(pubKeyFileName));
        KeyFactory keyFactory = KeyFactory.getInstance(keyFactoryAlg);
        return keyFactory.generatePublic(publicKeySpec);
    }
}
