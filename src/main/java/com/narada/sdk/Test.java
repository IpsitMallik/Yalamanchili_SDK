package com.narada.sdk;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;

import com.narada.sdk.api_client.NaradaApiService;
import com.narada.sdk.api_client.NaradaApiServicePortType;
import com.narada.sdk.models.CardDetailRequest;
import com.narada.sdk.models.NaradaRequest;
import com.narada.sdk.models.NaradaResponse;
import com.narada.sdk.models.RequestBody;
import com.narada.sdk.models.RequestHeader;
import com.narada.sdk.models.ResponseBody;
import com.narada.sdk.utilities.EncryptDecryptUtility;
import com.narada.sdk.utilities.EncryptionResult;
import com.narada.sdk.utilities.PayLoadValidator;
import com.narada.sdk.utilities.RequestHeaderUtil;
import com.narada.sdk.utilities.XmlRequestGenerator;

@SuppressWarnings("deprecation")
public class Test {
	public static void main(String[] args) {
		 cardDetail();
	}
	private static void cardDetail() {
		try {
			NaradaApiService service = new NaradaApiService();
			NaradaApiServicePortType port = service.getNaradaApiServiceHttpSoap12Endpoint();
			org.apache.cxf.endpoint.Client client = org.apache.cxf.frontend.ClientProxy.getClient(port);
			client.getInInterceptors().add(new LoggingInInterceptor());
			client.getOutInterceptors().add(new LoggingOutInterceptor());

			RequestHeader header = RequestHeaderUtil.createHeader("API", "123456123456");
			header.setApiKey("APCHDT");
			PayLoadValidator.requestHeaderPayLoad(header);

			CardDetailRequest cdr = new CardDetailRequest();
			cdr.setTxnRefNo("01234567890123456789012345678901");
			cdr.setProxyNumber("012345678901");
			cdr.setCustomerId("");

			PayLoadValidator.getCardDetailPayLoad(cdr);

			String requestXml = XmlRequestGenerator.generateXml(cdr);
			System.out.println("\n" + requestXml + "\n");

			EncryptDecryptUtility encryptionUtility = EncryptDecryptUtility.getInstance();
			String msgRefNo = header.getMsgRefNo();

			EncryptionResult result = encryptionUtility.encryptXmlRequest(requestXml, msgRefNo);
			String encryptedXml = result.getEncryptedXml();
			String encryptedSessionKey = result.getEncryptedSessionKey();

			String signedXml = encryptionUtility.signXmlRequest(requestXml);

			header.setSessionKey(encryptedSessionKey);
			header.setToken(signedXml);

			System.out.println("\nEncrypted xml: " + encryptedXml);
			System.out.println("Encrypted session key: " + encryptedSessionKey);
			System.out.println("Signed xml: " + signedXml + "\n");

			RequestBody body = new RequestBody();
			body.setRequest(encryptedXml);

			NaradaRequest req = new NaradaRequest();
			req.setRequestBody(body);
			req.setRequestHeader(header);

			System.out.println("\nEcho response: " + port.echo("test, connection") + "\n");
			NaradaResponse res = port.serviceCall(req);
			ResponseBody response = res.getResponseBody();

			System.out.println("\nResponse code: " + response.getResponseCode());
			System.out.println("Response text: " + response.getResponseText());
			System.out.println("Response: " + response.getResponse());

		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

}
