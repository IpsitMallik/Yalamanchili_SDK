package com.ottl.sdk;

import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import org.apache.commons.lang3.ObjectUtils;

import com.ottl.model.*;
import com.ottl.soapclient.*;
import com.ottl.utils.*;

@SuppressWarnings("unused")
public class ApiCallClass {
	private static final NaradaApiService service = new NaradaApiService();
	private static final NaradaApiServicePortType port = service.getNaradaApiServiceHttpSoap11Endpoint();

	public static void callMethodByName(String methodName, RequestHeader header, String request) {
		if (ObjectUtils.isEmpty(methodName)) {
			throw new IllegalArgumentException("Method name is required.");
		}
		if (header == null) {
			throw new IllegalArgumentException("RequestHeader is required.");
		}
		if (request == null || ObjectUtils.isEmpty(request)) {
			throw new IllegalArgumentException("Request is required.");
		}
		try {
			// Use String.class directly since the request parameter is of type String
			Method method = ApiCallClass.class.getDeclaredMethod(methodName, RequestHeader.class, String.class);
			// Make the private method accessible
			method.setAccessible(true);
			// Invoke the static method (passing null since it's static)
			method.invoke(null, header, request);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occurred while invoking method: " + e.getMessage());
		}
	}

	private static void getCardDetails(RequestHeader header, String json) {
		try {

			CardDetailRequest cdr = JsonToObjectConverter.convertJsonToObject(json, CardDetailRequest.class);
			header.setApiKey("APCHDT");
			PayLoadValidator.requestHeaderPayLoad(header);
			PayLoadValidator.getCardDetailPayLoad(cdr);

			String requestXml = XmlRequestGenerator.generateXml(cdr);

			EncryptDecryptUtility encryptionUtility = EncryptDecryptUtility.getInstance();
			String msgRefNo = header.getMsgRefNo();

			EncryptionResult result = encryptionUtility.encryptXmlRequest(requestXml, msgRefNo);
			String encryptedXml = result.getEncryptedXml();
			String encryptedSessionKey = result.getEncryptedSessionKey();

			String signedXml = encryptionUtility.signXmlRequest(requestXml);

			header.setSessionKey(encryptedSessionKey);
			header.setToken(signedXml);

			RequestBody body = new RequestBody();
			body.setRequest(encryptedXml);

			NaradaRequest req = new NaradaRequest();
			req.setRequestBody(body);
			req.setRequestHeader(header);

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

	private static void getNewCard(RequestHeader rh, String json) {
		try {
			NewCardRequest req = JsonToObjectConverter.convertJsonToObject(json, NewCardRequest.class);
			rh.setApiKey("APNCRD");
			PayLoadValidator.requestHeaderPayLoad(rh);
			PayLoadValidator.issueNewCardPayLoad(req);

			String requestXml = XmlRequestGenerator.generateXml(req);

			EncryptDecryptUtility encryptionUtility = EncryptDecryptUtility.getInstance();
			String msgRefNo = rh.getMsgRefNo();

			EncryptionResult result = encryptionUtility.encryptXmlRequest(requestXml, msgRefNo);
			String encryptedXml = result.getEncryptedXml();
			String encryptedSessionKey = result.getEncryptedSessionKey();

			String signedXml = encryptionUtility.signXmlRequest(requestXml);

			rh.setSessionKey(encryptedSessionKey);
			rh.setToken(signedXml);

			RequestBody body = new RequestBody();
			body.setRequest(encryptedXml);

			NaradaRequest request = new NaradaRequest();
			request.setRequestBody(body);
			request.setRequestHeader(rh);

			NaradaResponse res = port.serviceCall(request);
			ResponseBody response = res.getResponseBody();

			System.out.println("\nResponse code: " + response.getResponseCode());
			System.out.println("Response text: " + response.getResponseText());
			System.out.println("Response: " + response.getResponse());

		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	private static void activateCard(RequestHeader rh, String json) {
		try {
			ActivateCardRequest req = JsonToObjectConverter.convertJsonToObject(json, ActivateCardRequest.class);
			rh.setApiKey("APCDAC");
			PayLoadValidator.requestHeaderPayLoad(rh);
			PayLoadValidator.activateCardPayLoad(req);

			String requestXml = XmlRequestGenerator.generateXml(req);

			EncryptDecryptUtility encryptionUtility = EncryptDecryptUtility.getInstance();
			String msgRefNo = rh.getMsgRefNo();

			EncryptionResult result = encryptionUtility.encryptXmlRequest(requestXml, msgRefNo);
			String encryptedXml = result.getEncryptedXml();
			String encryptedSessionKey = result.getEncryptedSessionKey();

			String signedXml = encryptionUtility.signXmlRequest(requestXml);

			rh.setSessionKey(encryptedSessionKey);
			rh.setToken(signedXml);

			RequestBody body = new RequestBody();
			body.setRequest(encryptedXml);

			NaradaRequest request = new NaradaRequest();
			request.setRequestBody(body);
			request.setRequestHeader(rh);

			NaradaResponse res = port.serviceCall(request);
			ResponseBody response = res.getResponseBody();

			System.out.println("\nResponse code: " + response.getResponseCode());
			System.out.println("Response text: " + response.getResponseText());
			System.out.println("Response: " + response.getResponse());

		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	private static void blockLockUnlockCard(RequestHeader rh, String json) {
		try {
			CardBlockOrUnblockReq req = JsonToObjectConverter.convertJsonToObject(json, CardBlockOrUnblockReq.class);
			rh.setApiKey("ACDSTS");
			PayLoadValidator.requestHeaderPayLoad(rh);
			PayLoadValidator.blockOrUnblockCardPayLoad(req);

			String requestXml = XmlRequestGenerator.generateXml(req);

			EncryptDecryptUtility encryptionUtility = EncryptDecryptUtility.getInstance();
			String msgRefNo = rh.getMsgRefNo();

			EncryptionResult result = encryptionUtility.encryptXmlRequest(requestXml, msgRefNo);
			String encryptedXml = result.getEncryptedXml();
			String encryptedSessionKey = result.getEncryptedSessionKey();

			String signedXml = encryptionUtility.signXmlRequest(requestXml);

			rh.setSessionKey(encryptedSessionKey);
			rh.setToken(signedXml);

			RequestBody body = new RequestBody();
			body.setRequest(encryptedXml);

			NaradaRequest request = new NaradaRequest();
			request.setRequestBody(body);
			request.setRequestHeader(rh);

			NaradaResponse res = port.serviceCall(request);
			ResponseBody response = res.getResponseBody();

			System.out.println("\nResponse code: " + response.getResponseCode());
			System.out.println("Response text: " + response.getResponseText());
			System.out.println("Response: " + response.getResponse());

		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	private static void replaceCard(RequestHeader rh, String json) {
		try {
			CardReplaceRequest req = JsonToObjectConverter.convertJsonToObject(json, CardReplaceRequest.class);
			rh.setApiKey("APCDRP");
			PayLoadValidator.requestHeaderPayLoad(rh);
			PayLoadValidator.replaceCardPayLoad(req);

			String requestXml = XmlRequestGenerator.generateXml(req);

			EncryptDecryptUtility encryptionUtility = EncryptDecryptUtility.getInstance();
			String msgRefNo = rh.getMsgRefNo();

			EncryptionResult result = encryptionUtility.encryptXmlRequest(requestXml, msgRefNo);
			String encryptedXml = result.getEncryptedXml();
			String encryptedSessionKey = result.getEncryptedSessionKey();

			String signedXml = encryptionUtility.signXmlRequest(requestXml);

			rh.setSessionKey(encryptedSessionKey);
			rh.setToken(signedXml);

			RequestBody body = new RequestBody();
			body.setRequest(encryptedXml);

			NaradaRequest request = new NaradaRequest();
			request.setRequestBody(body);
			request.setRequestHeader(rh);

			NaradaResponse res = port.serviceCall(request);
			ResponseBody response = res.getResponseBody();

			System.out.println("\nResponse code: " + response.getResponseCode());
			System.out.println("Response text: " + response.getResponseText());
			System.out.println("Response: " + response.getResponse());

		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	private static void updateCustomerDetails(RequestHeader rh, String json) {
		try {
			UpdateCustomerRequest req = JsonToObjectConverter.convertJsonToObject(json, UpdateCustomerRequest.class);

			rh.setApiKey("APUPCR");
			PayLoadValidator.requestHeaderPayLoad(rh);
			AccountPayload.updateCustomerPayLoad(req);

			String requestXml = XmlRequestGenerator.generateXml(req);

			EncryptDecryptUtility encryptionUtility = EncryptDecryptUtility.getInstance();
			String msgRefNo = rh.getMsgRefNo();

			EncryptionResult result = encryptionUtility.encryptXmlRequest(requestXml, msgRefNo);
			String encryptedXml = result.getEncryptedXml();
			String encryptedSessionKey = result.getEncryptedSessionKey();

			String signedXml = encryptionUtility.signXmlRequest(requestXml);

			rh.setSessionKey(encryptedSessionKey);
			rh.setToken(signedXml);

			RequestBody body = new RequestBody();
			body.setRequest(encryptedXml);

			NaradaRequest request = new NaradaRequest();
			request.setRequestBody(body);
			request.setRequestHeader(rh);

			NaradaResponse res = port.serviceCall(request);
			ResponseBody response = res.getResponseBody();

			System.out.println("\nResponse code: " + response.getResponseCode());
			System.out.println("Response text: " + response.getResponseText());
			System.out.println("Response: " + response.getResponse());

		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	private static void addAccount(RequestHeader rh, String json) {
		try {
			AddAccountRequest req = JsonToObjectConverter.convertJsonToObject(json, AddAccountRequest.class);

			rh.setApiKey("APACAD");
			PayLoadValidator.requestHeaderPayLoad(rh);
			AccountPayload.addAccountPayLoad(req);

			String requestXml = XmlRequestGenerator.generateXml(req);

			EncryptDecryptUtility encryptionUtility = EncryptDecryptUtility.getInstance();
			String msgRefNo = rh.getMsgRefNo();

			EncryptionResult result = encryptionUtility.encryptXmlRequest(requestXml, msgRefNo);
			String encryptedXml = result.getEncryptedXml();
			String encryptedSessionKey = result.getEncryptedSessionKey();

			String signedXml = encryptionUtility.signXmlRequest(requestXml);

			rh.setSessionKey(encryptedSessionKey);
			rh.setToken(signedXml);

			RequestBody body = new RequestBody();
			body.setRequest(encryptedXml);

			NaradaRequest request = new NaradaRequest();
			request.setRequestBody(body);
			request.setRequestHeader(rh);

			NaradaResponse res = port.serviceCall(request);
			ResponseBody response = res.getResponseBody();

			System.out.println("\nResponse code: " + response.getResponseCode());
			System.out.println("Response text: " + response.getResponseText());
			System.out.println("Response: " + response.getResponse());

		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	private static void loadCard(RequestHeader rh, String json) {
		try {
			LoadCardRequest req = JsonToObjectConverter.convertJsonToObject(json, LoadCardRequest.class);

			rh.setApiKey("APLCRD");
			PayLoadValidator.requestHeaderPayLoad(rh);
			PayLoadValidator.loadCardPayLoad(req);

			String requestXml = XmlRequestGenerator.generateXml(req);

			EncryptDecryptUtility encryptionUtility = EncryptDecryptUtility.getInstance();
			String msgRefNo = rh.getMsgRefNo();

			EncryptionResult result = encryptionUtility.encryptXmlRequest(requestXml, msgRefNo);
			String encryptedXml = result.getEncryptedXml();
			String encryptedSessionKey = result.getEncryptedSessionKey();

			String signedXml = encryptionUtility.signXmlRequest(requestXml);

			rh.setSessionKey(encryptedSessionKey);
			rh.setToken(signedXml);

			RequestBody body = new RequestBody();
			body.setRequest(encryptedXml);

			NaradaRequest request = new NaradaRequest();
			request.setRequestBody(body);
			request.setRequestHeader(rh);

			NaradaResponse res = port.serviceCall(request);
			ResponseBody response = res.getResponseBody();

			System.out.println("\nResponse code: " + response.getResponseCode());
			System.out.println("Response text: " + response.getResponseText());
			System.out.println("Response: " + response.getResponse());

		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	private static void queryBalance(RequestHeader rh, String json) {
		try {
			QueryBalanceRequest req = JsonToObjectConverter.convertJsonToObject(json, QueryBalanceRequest.class);

			rh.setApiKey("APACBL");
			PayLoadValidator.requestHeaderPayLoad(rh);
			AccountPayload.queryBalancePayLoad(req);

			String requestXml = XmlRequestGenerator.generateXml(req);

			EncryptDecryptUtility encryptionUtility = EncryptDecryptUtility.getInstance();
			String msgRefNo = rh.getMsgRefNo();

			EncryptionResult result = encryptionUtility.encryptXmlRequest(requestXml, msgRefNo);
			String encryptedXml = result.getEncryptedXml();
			String encryptedSessionKey = result.getEncryptedSessionKey();

			String signedXml = encryptionUtility.signXmlRequest(requestXml);

			rh.setSessionKey(encryptedSessionKey);
			rh.setToken(signedXml);

			RequestBody body = new RequestBody();
			body.setRequest(encryptedXml);

			NaradaRequest request = new NaradaRequest();
			request.setRequestBody(body);
			request.setRequestHeader(rh);

			NaradaResponse res = port.serviceCall(request);
			ResponseBody response = res.getResponseBody();

			System.out.println("\nResponse code: " + response.getResponseCode());
			System.out.println("Response text: " + response.getResponseText());
			System.out.println("Response: " + response.getResponse());

		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	private static void refundAmount(RequestHeader rh, String json) {
		try {
			RefundAmountRequest req = JsonToObjectConverter.convertJsonToObject(json, RefundAmountRequest.class);

			rh.setApiKey("APCRND");
			PayLoadValidator.requestHeaderPayLoad(rh);
			AccountPayload.refundAmountPayLoad(req);

			String requestXml = XmlRequestGenerator.generateXml(req);

			EncryptDecryptUtility encryptionUtility = EncryptDecryptUtility.getInstance();
			String msgRefNo = rh.getMsgRefNo();

			EncryptionResult result = encryptionUtility.encryptXmlRequest(requestXml, msgRefNo);
			String encryptedXml = result.getEncryptedXml();
			String encryptedSessionKey = result.getEncryptedSessionKey();

			String signedXml = encryptionUtility.signXmlRequest(requestXml);

			rh.setSessionKey(encryptedSessionKey);
			rh.setToken(signedXml);

			RequestBody body = new RequestBody();
			body.setRequest(encryptedXml);

			NaradaRequest request = new NaradaRequest();
			request.setRequestBody(body);
			request.setRequestHeader(rh);

			NaradaResponse res = port.serviceCall(request);
			ResponseBody response = res.getResponseBody();

			System.out.println("\nResponse code: " + response.getResponseCode());
			System.out.println("Response text: " + response.getResponseText());
			System.out.println("Response: " + response.getResponse());

		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	private static void accountClosure(RequestHeader rh, String json) {
		try {
			AccountClosureRequest req = JsonToObjectConverter.convertJsonToObject(json, AccountClosureRequest.class);

			rh.setApiKey("APACCL");
			PayLoadValidator.requestHeaderPayLoad(rh);
			AccountPayload.accountClosurePayLoad(req);

			String requestXml = XmlRequestGenerator.generateXml(req);

			EncryptDecryptUtility encryptionUtility = EncryptDecryptUtility.getInstance();
			String msgRefNo = rh.getMsgRefNo();

			EncryptionResult result = encryptionUtility.encryptXmlRequest(requestXml, msgRefNo);
			String encryptedXml = result.getEncryptedXml();
			String encryptedSessionKey = result.getEncryptedSessionKey();

			String signedXml = encryptionUtility.signXmlRequest(requestXml);

			rh.setSessionKey(encryptedSessionKey);
			rh.setToken(signedXml);

			RequestBody body = new RequestBody();
			body.setRequest(encryptedXml);

			NaradaRequest request = new NaradaRequest();
			request.setRequestBody(body);
			request.setRequestHeader(rh);

			NaradaResponse res = port.serviceCall(request);
			ResponseBody response = res.getResponseBody();

			System.out.println("\nResponse code: " + response.getResponseCode());
			System.out.println("Response text: " + response.getResponseText());
			System.out.println("Response: " + response.getResponse());

		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	private static void getXTransactions(RequestHeader rh, String json) {
		try {
			XTransactionsRequest req = JsonToObjectConverter.convertJsonToObject(json, XTransactionsRequest.class);

			rh.setApiKey("APXTXN");
			PayLoadValidator.requestHeaderPayLoad(rh);
			PayLoadValidator.getXTransactionsPayLoad(req);

			String requestXml = XmlRequestGenerator.generateXml(req);

			EncryptDecryptUtility encryptionUtility = EncryptDecryptUtility.getInstance();
			String msgRefNo = rh.getMsgRefNo();

			EncryptionResult result = encryptionUtility.encryptXmlRequest(requestXml, msgRefNo);
			String encryptedXml = result.getEncryptedXml();
			String encryptedSessionKey = result.getEncryptedSessionKey();

			String signedXml = encryptionUtility.signXmlRequest(requestXml);

			rh.setSessionKey(encryptedSessionKey);
			rh.setToken(signedXml);

			RequestBody body = new RequestBody();
			body.setRequest(encryptedXml);

			NaradaRequest request = new NaradaRequest();
			request.setRequestBody(body);
			request.setRequestHeader(rh);

			NaradaResponse res = port.serviceCall(request);
			ResponseBody response = res.getResponseBody();

			System.out.println("\nResponse code: " + response.getResponseCode());
			System.out.println("Response text: " + response.getResponseText());
			System.out.println("Response: " + response.getResponse());

		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	private static void debitCreditAccount(RequestHeader rh, String json) {
		try {
			DebitCreditAccountRequest req = JsonToObjectConverter.convertJsonToObject(json,
					DebitCreditAccountRequest.class);

			rh.setApiKey("APCRDR");
			PayLoadValidator.requestHeaderPayLoad(rh);
			AccountPayload.debitCreditAccountPayLoad(req);

			String requestXml = XmlRequestGenerator.generateXml(req);

			EncryptDecryptUtility encryptionUtility = EncryptDecryptUtility.getInstance();
			String msgRefNo = rh.getMsgRefNo();

			EncryptionResult result = encryptionUtility.encryptXmlRequest(requestXml, msgRefNo);
			String encryptedXml = result.getEncryptedXml();
			String encryptedSessionKey = result.getEncryptedSessionKey();

			String signedXml = encryptionUtility.signXmlRequest(requestXml);

			rh.setSessionKey(encryptedSessionKey);
			rh.setToken(signedXml);

			RequestBody body = new RequestBody();
			body.setRequest(encryptedXml);

			NaradaRequest request = new NaradaRequest();
			request.setRequestBody(body);
			request.setRequestHeader(rh);

			NaradaResponse res = port.serviceCall(request);
			ResponseBody response = res.getResponseBody();

			System.out.println("\nResponse code: " + response.getResponseCode());
			System.out.println("Response text: " + response.getResponseText());
			System.out.println("Response: " + response.getResponse());

		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	private static void fundTransfer(RequestHeader rh, String json) {
		try {
			FundTransferRequest req = JsonToObjectConverter.convertJsonToObject(json, FundTransferRequest.class);

			rh.setApiKey("APFDTR");
			PayLoadValidator.requestHeaderPayLoad(rh);
			AccountPayload.fundTransferPayLoad(req);

			String requestXml = XmlRequestGenerator.generateXml(req);

			EncryptDecryptUtility encryptionUtility = EncryptDecryptUtility.getInstance();
			String msgRefNo = rh.getMsgRefNo();

			EncryptionResult result = encryptionUtility.encryptXmlRequest(requestXml, msgRefNo);
			String encryptedXml = result.getEncryptedXml();
			String encryptedSessionKey = result.getEncryptedSessionKey();

			String signedXml = encryptionUtility.signXmlRequest(requestXml);

			rh.setSessionKey(encryptedSessionKey);
			rh.setToken(signedXml);

			RequestBody body = new RequestBody();
			body.setRequest(encryptedXml);

			NaradaRequest request = new NaradaRequest();
			request.setRequestBody(body);
			request.setRequestHeader(rh);

			NaradaResponse res = port.serviceCall(request);
			ResponseBody response = res.getResponseBody();

			System.out.println("\nResponse code: " + response.getResponseCode());
			System.out.println("Response text: " + response.getResponseText());
			System.out.println("Response: " + response.getResponse());

		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	private static void updateExchangeRate(RequestHeader rh, String json) {
		try {
			UpdateExchangeRateRequest req = JsonToObjectConverter.convertJsonToObject(json,
					UpdateExchangeRateRequest.class);

			rh.setApiKey("APFREX");
			PayLoadValidator.requestHeaderPayLoad(rh);
			AccountPayload.updateExchangeRatePayLoad(req);

			String requestXml = XmlRequestGenerator.generateXml(req);

			EncryptDecryptUtility encryptionUtility = EncryptDecryptUtility.getInstance();
			String msgRefNo = rh.getMsgRefNo();

			EncryptionResult result = encryptionUtility.encryptXmlRequest(requestXml, msgRefNo);
			String encryptedXml = result.getEncryptedXml();
			String encryptedSessionKey = result.getEncryptedSessionKey();

			String signedXml = encryptionUtility.signXmlRequest(requestXml);

			rh.setSessionKey(encryptedSessionKey);
			rh.setToken(signedXml);

			RequestBody body = new RequestBody();
			body.setRequest(encryptedXml);

			NaradaRequest request = new NaradaRequest();
			request.setRequestBody(body);
			request.setRequestHeader(rh);

			NaradaResponse res = port.serviceCall(request);
			ResponseBody response = res.getResponseBody();

			System.out.println("\nResponse code: " + response.getResponseCode());
			System.out.println("Response text: " + response.getResponseText());
			System.out.println("Response: " + response.getResponse());

		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	private static void cardOrder(RequestHeader rh, String json) {
		try {
			CardOrderRequest req = JsonToObjectConverter.convertJsonToObject(json, CardOrderRequest.class);

			rh.setApiKey("APCROR");
			PayLoadValidator.requestHeaderPayLoad(rh);
			PayLoadValidator.cardOrderPayLoad(req);

			String requestXml = XmlRequestGenerator.generateXml(req);

			EncryptDecryptUtility encryptionUtility = EncryptDecryptUtility.getInstance();
			String msgRefNo = rh.getMsgRefNo();

			EncryptionResult result = encryptionUtility.encryptXmlRequest(requestXml, msgRefNo);
			String encryptedXml = result.getEncryptedXml();
			String encryptedSessionKey = result.getEncryptedSessionKey();

			String signedXml = encryptionUtility.signXmlRequest(requestXml);

			rh.setSessionKey(encryptedSessionKey);
			rh.setToken(signedXml);

			RequestBody body = new RequestBody();
			body.setRequest(encryptedXml);

			NaradaRequest request = new NaradaRequest();
			request.setRequestBody(body);
			request.setRequestHeader(rh);

			NaradaResponse res = port.serviceCall(request);
			ResponseBody response = res.getResponseBody();

			System.out.println("\nResponse code: " + response.getResponseCode());
			System.out.println("Response text: " + response.getResponseText());
			System.out.println("Response: " + response.getResponse());

		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	private static void cardReceipt(RequestHeader rh, String json) {
		try {
			CardReceiptRequest req = JsonToObjectConverter.convertJsonToObject(json, CardReceiptRequest.class);

			rh.setApiKey("APSTRC");
			PayLoadValidator.requestHeaderPayLoad(rh);
			PayLoadValidator.cardOrderPayLoad(req);

			String requestXml = XmlRequestGenerator.generateXml(req);

			EncryptDecryptUtility encryptionUtility = EncryptDecryptUtility.getInstance();
			String msgRefNo = rh.getMsgRefNo();

			EncryptionResult result = encryptionUtility.encryptXmlRequest(requestXml, msgRefNo);
			String encryptedXml = result.getEncryptedXml();
			String encryptedSessionKey = result.getEncryptedSessionKey();

			String signedXml = encryptionUtility.signXmlRequest(requestXml);

			rh.setSessionKey(encryptedSessionKey);
			rh.setToken(signedXml);

			RequestBody body = new RequestBody();
			body.setRequest(encryptedXml);

			NaradaRequest request = new NaradaRequest();
			request.setRequestBody(body);
			request.setRequestHeader(rh);

			NaradaResponse res = port.serviceCall(request);
			ResponseBody response = res.getResponseBody();

			System.out.println("\nResponse code: " + response.getResponseCode());
			System.out.println("Response text: " + response.getResponseText());
			System.out.println("Response: " + response.getResponse());

		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	private static void updateStockDetails(RequestHeader rh, String json) {
		try {
			UpdateStockDetailsRequest req = JsonToObjectConverter.convertJsonToObject(json,
					UpdateStockDetailsRequest.class);

			rh.setApiKey("APSKUP");
			PayLoadValidator.requestHeaderPayLoad(rh);
			PayLoadValidator.updateStockDetailsPayLoad(req);

			String requestXml = XmlRequestGenerator.generateXml(req);

			EncryptDecryptUtility encryptionUtility = EncryptDecryptUtility.getInstance();
			String msgRefNo = rh.getMsgRefNo();

			EncryptionResult result = encryptionUtility.encryptXmlRequest(requestXml, msgRefNo);
			String encryptedXml = result.getEncryptedXml();
			String encryptedSessionKey = result.getEncryptedSessionKey();

			String signedXml = encryptionUtility.signXmlRequest(requestXml);

			rh.setSessionKey(encryptedSessionKey);
			rh.setToken(signedXml);

			RequestBody body = new RequestBody();
			body.setRequest(encryptedXml);

			NaradaRequest request = new NaradaRequest();
			request.setRequestBody(body);
			request.setRequestHeader(rh);

			NaradaResponse res = port.serviceCall(request);
			ResponseBody response = res.getResponseBody();

			System.out.println("\nResponse code: " + response.getResponseCode());
			System.out.println("Response text: " + response.getResponseText());
			System.out.println("Response: " + response.getResponse());

		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	private static void getStockDetails(RequestHeader rh, String json) {
		try {
			StockDetailsRequest req = JsonToObjectConverter.convertJsonToObject(json, StockDetailsRequest.class);

			rh.setApiKey("APGTSD");
			PayLoadValidator.requestHeaderPayLoad(rh);
			PayLoadValidator.getStockDetailsPayLoad(req);

			String requestXml = XmlRequestGenerator.generateXml(req);

			EncryptDecryptUtility encryptionUtility = EncryptDecryptUtility.getInstance();
			String msgRefNo = rh.getMsgRefNo();

			EncryptionResult result = encryptionUtility.encryptXmlRequest(requestXml, msgRefNo);
			String encryptedXml = result.getEncryptedXml();
			String encryptedSessionKey = result.getEncryptedSessionKey();

			String signedXml = encryptionUtility.signXmlRequest(requestXml);

			rh.setSessionKey(encryptedSessionKey);
			rh.setToken(signedXml);

			RequestBody body = new RequestBody();
			body.setRequest(encryptedXml);

			NaradaRequest request = new NaradaRequest();
			request.setRequestBody(body);
			request.setRequestHeader(rh);

			NaradaResponse res = port.serviceCall(request);
			ResponseBody response = res.getResponseBody();

			System.out.println("\nResponse code: " + response.getResponseCode());
			System.out.println("Response text: " + response.getResponseText());
			System.out.println("Response: " + response.getResponse());

		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	private static void getStatusRequest(RequestHeader rh, String json) {
		try {
			StatusRequest req = JsonToObjectConverter.convertJsonToObject(json, StatusRequest.class);

			rh.setApiKey("APSTRQ");
			PayLoadValidator.requestHeaderPayLoad(rh);
			PayLoadValidator.getStatusRequestPayLoad(req);

			String requestXml = XmlRequestGenerator.generateXml(req);

			EncryptDecryptUtility encryptionUtility = EncryptDecryptUtility.getInstance();
			String msgRefNo = rh.getMsgRefNo();

			EncryptionResult result = encryptionUtility.encryptXmlRequest(requestXml, msgRefNo);
			String encryptedXml = result.getEncryptedXml();
			String encryptedSessionKey = result.getEncryptedSessionKey();

			String signedXml = encryptionUtility.signXmlRequest(requestXml);

			rh.setSessionKey(encryptedSessionKey);
			rh.setToken(signedXml);

			RequestBody body = new RequestBody();
			body.setRequest(encryptedXml);

			NaradaRequest request = new NaradaRequest();
			request.setRequestBody(body);
			request.setRequestHeader(rh);

			NaradaResponse res = port.serviceCall(request);
			ResponseBody response = res.getResponseBody();

			System.out.println("\nResponse code: " + response.getResponseCode());
			System.out.println("Response text: " + response.getResponseText());
			System.out.println("Response: " + response.getResponse());

		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	private static void createProfile(RequestHeader rh, String json) {
		try {
			ProfileCreationRequest req = JsonToObjectConverter.convertJsonToObject(json, ProfileCreationRequest.class);

			rh.setApiKey("APRFCR");
			PayLoadValidator.requestHeaderPayLoad(rh);
			AccountPayload.createProfilePayLoad(req);

			String requestXml = XmlRequestGenerator.generateXml(req);

			EncryptDecryptUtility encryptionUtility = EncryptDecryptUtility.getInstance();
			String msgRefNo = rh.getMsgRefNo();

			EncryptionResult result = encryptionUtility.encryptXmlRequest(requestXml, msgRefNo);
			String encryptedXml = result.getEncryptedXml();
			String encryptedSessionKey = result.getEncryptedSessionKey();

			String signedXml = encryptionUtility.signXmlRequest(requestXml);

			rh.setSessionKey(encryptedSessionKey);
			rh.setToken(signedXml);

			RequestBody body = new RequestBody();
			body.setRequest(encryptedXml);

			NaradaRequest request = new NaradaRequest();
			request.setRequestBody(body);
			request.setRequestHeader(rh);

			NaradaResponse res = port.serviceCall(request);
			ResponseBody response = res.getResponseBody();

			System.out.println("\nResponse code: " + response.getResponseCode());
			System.out.println("Response text: " + response.getResponseText());
			System.out.println("Response: " + response.getResponse());

		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	private static void changePassword(RequestHeader rh, String json) {
		try {
			ChangePasswordRequest req = JsonToObjectConverter.convertJsonToObject(json, ChangePasswordRequest.class);

			rh.setApiKey("ACHPSS");
			PayLoadValidator.requestHeaderPayLoad(rh);
			AccountPayload.changePasswordPayLoad(req);

			String requestXml = XmlRequestGenerator.generateXml(req);

			EncryptDecryptUtility encryptionUtility = EncryptDecryptUtility.getInstance();
			String msgRefNo = rh.getMsgRefNo();

			EncryptionResult result = encryptionUtility.encryptXmlRequest(requestXml, msgRefNo);
			String encryptedXml = result.getEncryptedXml();
			String encryptedSessionKey = result.getEncryptedSessionKey();

			String signedXml = encryptionUtility.signXmlRequest(requestXml);

			rh.setSessionKey(encryptedSessionKey);
			rh.setToken(signedXml);

			RequestBody body = new RequestBody();
			body.setRequest(encryptedXml);

			NaradaRequest request = new NaradaRequest();
			request.setRequestBody(body);
			request.setRequestHeader(rh);

			NaradaResponse res = port.serviceCall(request);
			ResponseBody response = res.getResponseBody();

			System.out.println("\nResponse code: " + response.getResponseCode());
			System.out.println("Response text: " + response.getResponseText());
			System.out.println("Response: " + response.getResponse());

		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	private static void getAccessRights(RequestHeader rh, String json) {
		try {
			AccessRightsRequest req = JsonToObjectConverter.convertJsonToObject(json, AccessRightsRequest.class);

			rh.setApiKey("APACRT");
			PayLoadValidator.requestHeaderPayLoad(rh);
			AccountPayload.getAccessRightsPayLoad(req);

			String requestXml = XmlRequestGenerator.generateXml(req);

			EncryptDecryptUtility encryptionUtility = EncryptDecryptUtility.getInstance();
			String msgRefNo = rh.getMsgRefNo();

			EncryptionResult result = encryptionUtility.encryptXmlRequest(requestXml, msgRefNo);
			String encryptedXml = result.getEncryptedXml();
			String encryptedSessionKey = result.getEncryptedSessionKey();

			String signedXml = encryptionUtility.signXmlRequest(requestXml);

			rh.setSessionKey(encryptedSessionKey);
			rh.setToken(signedXml);

			RequestBody body = new RequestBody();
			body.setRequest(encryptedXml);

			NaradaRequest request = new NaradaRequest();
			request.setRequestBody(body);
			request.setRequestHeader(rh);

			NaradaResponse res = port.serviceCall(request);
			ResponseBody response = res.getResponseBody();

			System.out.println("\nResponse code: " + response.getResponseCode());
			System.out.println("Response text: " + response.getResponseText());
			System.out.println("Response: " + response.getResponse());

		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	private static void retrieveATMPin(RequestHeader rh, String json) {
		try {
			RetrievePinRequest req = JsonToObjectConverter.convertJsonToObject(json, RetrievePinRequest.class);

			rh.setApiKey("APIPIR");
			PayLoadValidator.requestHeaderPayLoad(rh);
			AccountPayload.retrieveATMPinPayLoad(req);

			String requestXml = XmlRequestGenerator.generateXml(req);

			EncryptDecryptUtility encryptionUtility = EncryptDecryptUtility.getInstance();
			String msgRefNo = rh.getMsgRefNo();

			EncryptionResult result = encryptionUtility.encryptXmlRequest(requestXml, msgRefNo);
			String encryptedXml = result.getEncryptedXml();
			String encryptedSessionKey = result.getEncryptedSessionKey();

			String signedXml = encryptionUtility.signXmlRequest(requestXml);

			rh.setSessionKey(encryptedSessionKey);
			rh.setToken(signedXml);

			RequestBody body = new RequestBody();
			body.setRequest(encryptedXml);

			NaradaRequest request = new NaradaRequest();
			request.setRequestBody(body);
			request.setRequestHeader(rh);

			NaradaResponse res = port.serviceCall(request);
			ResponseBody response = res.getResponseBody();

			System.out.println("\nResponse code: " + response.getResponseCode());
			System.out.println("Response text: " + response.getResponseText());
			System.out.println("Response: " + response.getResponse());

		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	private static void verifyATMPin(RequestHeader rh, String json) {
		try {
			VerifyPinRequest req = JsonToObjectConverter.convertJsonToObject(json, VerifyPinRequest.class);

			rh.setApiKey("APIVER");
			PayLoadValidator.requestHeaderPayLoad(rh);
			AccountPayload.verifyATMPinPayLoad(req);

			String requestXml = XmlRequestGenerator.generateXml(req);

			EncryptDecryptUtility encryptionUtility = EncryptDecryptUtility.getInstance();
			String msgRefNo = rh.getMsgRefNo();

			EncryptionResult result = encryptionUtility.encryptXmlRequest(requestXml, msgRefNo);
			String encryptedXml = result.getEncryptedXml();
			String encryptedSessionKey = result.getEncryptedSessionKey();

			String signedXml = encryptionUtility.signXmlRequest(requestXml);

			rh.setSessionKey(encryptedSessionKey);
			rh.setToken(signedXml);

			RequestBody body = new RequestBody();
			body.setRequest(encryptedXml);

			NaradaRequest request = new NaradaRequest();
			request.setRequestBody(body);
			request.setRequestHeader(rh);

			NaradaResponse res = port.serviceCall(request);
			ResponseBody response = res.getResponseBody();

			System.out.println("\nResponse code: " + response.getResponseCode());
			System.out.println("Response text: " + response.getResponseText());
			System.out.println("Response: " + response.getResponse());

		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	private static void changeATMPin(RequestHeader rh, String json) {
		try {
			ChangePinRequest req = JsonToObjectConverter.convertJsonToObject(json, ChangePinRequest.class);

			rh.setApiKey("APICHG");
			PayLoadValidator.requestHeaderPayLoad(rh);
			AccountPayload.changeATMPinPayLoad(req);

			String requestXml = XmlRequestGenerator.generateXml(req);

			EncryptDecryptUtility encryptionUtility = EncryptDecryptUtility.getInstance();
			String msgRefNo = rh.getMsgRefNo();

			EncryptionResult result = encryptionUtility.encryptXmlRequest(requestXml, msgRefNo);
			String encryptedXml = result.getEncryptedXml();
			String encryptedSessionKey = result.getEncryptedSessionKey();

			String signedXml = encryptionUtility.signXmlRequest(requestXml);

			rh.setSessionKey(encryptedSessionKey);
			rh.setToken(signedXml);

			RequestBody body = new RequestBody();
			body.setRequest(encryptedXml);

			NaradaRequest request = new NaradaRequest();
			request.setRequestBody(body);
			request.setRequestHeader(rh);

			NaradaResponse res = port.serviceCall(request);
			ResponseBody response = res.getResponseBody();

			System.out.println("\nResponse code: " + response.getResponseCode());
			System.out.println("Response text: " + response.getResponseText());
			System.out.println("Response: " + response.getResponse());

		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	private static void assignOverrideSettings(RequestHeader rh, String json) {
		try {
			OverrideSettingsRequest req = JsonToObjectConverter.convertJsonToObject(json,
					OverrideSettingsRequest.class);

			rh.setApiKey("AOVRST");
			PayLoadValidator.requestHeaderPayLoad(rh);
			AccountPayload.assignOverrideSettingsPayLoad(req);

			String requestXml = XmlRequestGenerator.generateXml(req);

			EncryptDecryptUtility encryptionUtility = EncryptDecryptUtility.getInstance();
			String msgRefNo = rh.getMsgRefNo();

			EncryptionResult result = encryptionUtility.encryptXmlRequest(requestXml, msgRefNo);
			String encryptedXml = result.getEncryptedXml();
			String encryptedSessionKey = result.getEncryptedSessionKey();

			String signedXml = encryptionUtility.signXmlRequest(requestXml);

			rh.setSessionKey(encryptedSessionKey);
			rh.setToken(signedXml);

			RequestBody body = new RequestBody();
			body.setRequest(encryptedXml);

			NaradaRequest request = new NaradaRequest();
			request.setRequestBody(body);
			request.setRequestHeader(rh);

			NaradaResponse res = port.serviceCall(request);
			ResponseBody response = res.getResponseBody();

			System.out.println("\nResponse code: " + response.getResponseCode());
			System.out.println("Response text: " + response.getResponseText());
			System.out.println("Response: " + response.getResponse());

		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	private static void alertSettings(RequestHeader rh, String json) {
		try {
			AlertSettingsRequest req = JsonToObjectConverter.convertJsonToObject(json, AlertSettingsRequest.class);

			rh.setApiKey("APALTS");
			PayLoadValidator.requestHeaderPayLoad(rh);
			AccountPayload.alertSettingsPayLoad(req);

			String requestXml = XmlRequestGenerator.generateXml(req);

			EncryptDecryptUtility encryptionUtility = EncryptDecryptUtility.getInstance();
			String msgRefNo = rh.getMsgRefNo();

			EncryptionResult result = encryptionUtility.encryptXmlRequest(requestXml, msgRefNo);
			String encryptedXml = result.getEncryptedXml();
			String encryptedSessionKey = result.getEncryptedSessionKey();

			String signedXml = encryptionUtility.signXmlRequest(requestXml);

			rh.setSessionKey(encryptedSessionKey);
			rh.setToken(signedXml);

			RequestBody body = new RequestBody();
			body.setRequest(encryptedXml);

			NaradaRequest request = new NaradaRequest();
			request.setRequestBody(body);
			request.setRequestHeader(rh);

			NaradaResponse res = port.serviceCall(request);
			ResponseBody response = res.getResponseBody();

			System.out.println("\nResponse code: " + response.getResponseCode());
			System.out.println("Response text: " + response.getResponseText());
			System.out.println("Response: " + response.getResponse());

		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	private static void getCardNumber(RequestHeader rh, String json) {
		try {
			CardNumberRequest req = JsonToObjectConverter.convertJsonToObject(json, CardNumberRequest.class);

			rh.setApiKey("APIGCN");
			PayLoadValidator.requestHeaderPayLoad(rh);
			PayLoadValidator.getCardNumberPayLoad(req);

			String requestXml = XmlRequestGenerator.generateXml(req);

			EncryptDecryptUtility encryptionUtility = EncryptDecryptUtility.getInstance();
			String msgRefNo = rh.getMsgRefNo();

			EncryptionResult result = encryptionUtility.encryptXmlRequest(requestXml, msgRefNo);
			String encryptedXml = result.getEncryptedXml();
			String encryptedSessionKey = result.getEncryptedSessionKey();

			String signedXml = encryptionUtility.signXmlRequest(requestXml);

			rh.setSessionKey(encryptedSessionKey);
			rh.setToken(signedXml);

			RequestBody body = new RequestBody();
			body.setRequest(encryptedXml);

			NaradaRequest request = new NaradaRequest();
			request.setRequestBody(body);
			request.setRequestHeader(rh);

			NaradaResponse res = port.serviceCall(request);
			ResponseBody response = res.getResponseBody();

			System.out.println("\nResponse code: " + response.getResponseCode());
			System.out.println("Response text: " + response.getResponseText());
			System.out.println("Response: " + response.getResponse());

		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	private static void getCSCEnquiry(RequestHeader rh, String json) {
		try {
			CSCEnquiryRequest req = JsonToObjectConverter.convertJsonToObject(json, CSCEnquiryRequest.class);

			rh.setApiKey("ACSENQ");
			PayLoadValidator.requestHeaderPayLoad(rh);
			PayLoadValidator.getCSCEnquiryPayLoad(req);

			String requestXml = XmlRequestGenerator.generateXml(req);

			EncryptDecryptUtility encryptionUtility = EncryptDecryptUtility.getInstance();
			String msgRefNo = rh.getMsgRefNo();

			EncryptionResult result = encryptionUtility.encryptXmlRequest(requestXml, msgRefNo);
			String encryptedXml = result.getEncryptedXml();
			String encryptedSessionKey = result.getEncryptedSessionKey();

			String signedXml = encryptionUtility.signXmlRequest(requestXml);

			rh.setSessionKey(encryptedSessionKey);
			rh.setToken(signedXml);

			RequestBody body = new RequestBody();
			body.setRequest(encryptedXml);

			NaradaRequest request = new NaradaRequest();
			request.setRequestBody(body);
			request.setRequestHeader(rh);

			NaradaResponse res = port.serviceCall(request);
			ResponseBody response = res.getResponseBody();

			System.out.println("\nResponse code: " + response.getResponseCode());
			System.out.println("Response text: " + response.getResponseText());
			System.out.println("Response: " + response.getResponse());

		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	private static void getCardOrderStatus(RequestHeader rh, String json) {
		try {
			CardOrderStatusRequest req = JsonToObjectConverter.convertJsonToObject(json, CardOrderStatusRequest.class);

			rh.setApiKey("APCOST");
			PayLoadValidator.requestHeaderPayLoad(rh);
			PayLoadValidator.getCardOrderStatusPayLoad(req);

			String requestXml = XmlRequestGenerator.generateXml(req);

			EncryptDecryptUtility encryptionUtility = EncryptDecryptUtility.getInstance();
			String msgRefNo = rh.getMsgRefNo();

			EncryptionResult result = encryptionUtility.encryptXmlRequest(requestXml, msgRefNo);
			String encryptedXml = result.getEncryptedXml();
			String encryptedSessionKey = result.getEncryptedSessionKey();

			String signedXml = encryptionUtility.signXmlRequest(requestXml);

			rh.setSessionKey(encryptedSessionKey);
			rh.setToken(signedXml);

			RequestBody body = new RequestBody();
			body.setRequest(encryptedXml);

			NaradaRequest request = new NaradaRequest();
			request.setRequestBody(body);
			request.setRequestHeader(rh);

			NaradaResponse res = port.serviceCall(request);
			ResponseBody response = res.getResponseBody();

			System.out.println("\nResponse code: " + response.getResponseCode());
			System.out.println("Response text: " + response.getResponseText());
			System.out.println("Response: " + response.getResponse());

		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	private static void setIVRPin(RequestHeader rh, String json) {
		try {
			SetPinRequest req = JsonToObjectConverter.convertJsonToObject(json, SetPinRequest.class);

			rh.setApiKey("APIIVR");
			PayLoadValidator.requestHeaderPayLoad(rh);
			PayLoadValidator.setIVRPinPayLoad(req);

			String requestXml = XmlRequestGenerator.generateXml(req);

			EncryptDecryptUtility encryptionUtility = EncryptDecryptUtility.getInstance();
			String msgRefNo = rh.getMsgRefNo();

			EncryptionResult result = encryptionUtility.encryptXmlRequest(requestXml, msgRefNo);
			String encryptedXml = result.getEncryptedXml();
			String encryptedSessionKey = result.getEncryptedSessionKey();

			String signedXml = encryptionUtility.signXmlRequest(requestXml);

			rh.setSessionKey(encryptedSessionKey);
			rh.setToken(signedXml);

			RequestBody body = new RequestBody();
			body.setRequest(encryptedXml);

			NaradaRequest request = new NaradaRequest();
			request.setRequestBody(body);
			request.setRequestHeader(rh);

			NaradaResponse res = port.serviceCall(request);
			ResponseBody response = res.getResponseBody();

			System.out.println("\nResponse code: " + response.getResponseCode());
			System.out.println("Response text: " + response.getResponseText());
			System.out.println("Response: " + response.getResponse());

		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	private static void changeIVRPin(RequestHeader rh, String json) {
		try {
			ChangeIvrPinRequest req = JsonToObjectConverter.convertJsonToObject(json, ChangeIvrPinRequest.class);

			rh.setApiKey("APIIVC");
			PayLoadValidator.requestHeaderPayLoad(rh);
			PayLoadValidator.changeIVRPinPayLoad(req);

			String requestXml = XmlRequestGenerator.generateXml(req);

			EncryptDecryptUtility encryptionUtility = EncryptDecryptUtility.getInstance();
			String msgRefNo = rh.getMsgRefNo();

			EncryptionResult result = encryptionUtility.encryptXmlRequest(requestXml, msgRefNo);
			String encryptedXml = result.getEncryptedXml();
			String encryptedSessionKey = result.getEncryptedSessionKey();

			String signedXml = encryptionUtility.signXmlRequest(requestXml);

			rh.setSessionKey(encryptedSessionKey);
			rh.setToken(signedXml);

			RequestBody body = new RequestBody();
			body.setRequest(encryptedXml);

			NaradaRequest request = new NaradaRequest();
			request.setRequestBody(body);
			request.setRequestHeader(rh);

			NaradaResponse res = port.serviceCall(request);
			ResponseBody response = res.getResponseBody();

			System.out.println("\nResponse code: " + response.getResponseCode());
			System.out.println("Response text: " + response.getResponseText());
			System.out.println("Response: " + response.getResponse());

		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	private static void validateIVRPin(RequestHeader rh, String json) {
		try {
			ValidatePinRequest req = JsonToObjectConverter.convertJsonToObject(json, ValidatePinRequest.class);

			rh.setApiKey("APIPNV");
			PayLoadValidator.requestHeaderPayLoad(rh);
			PayLoadValidator.validateIVRPinPayLoad(req);

			String requestXml = XmlRequestGenerator.generateXml(req);

			EncryptDecryptUtility encryptionUtility = EncryptDecryptUtility.getInstance();
			String msgRefNo = rh.getMsgRefNo();

			EncryptionResult result = encryptionUtility.encryptXmlRequest(requestXml, msgRefNo);
			String encryptedXml = result.getEncryptedXml();
			String encryptedSessionKey = result.getEncryptedSessionKey();

			String signedXml = encryptionUtility.signXmlRequest(requestXml);

			rh.setSessionKey(encryptedSessionKey);
			rh.setToken(signedXml);

			RequestBody body = new RequestBody();
			body.setRequest(encryptedXml);

			NaradaRequest request = new NaradaRequest();
			request.setRequestBody(body);
			request.setRequestHeader(rh);

			NaradaResponse res = port.serviceCall(request);
			ResponseBody response = res.getResponseBody();

			System.out.println("\nResponse code: " + response.getResponseCode());
			System.out.println("Response text: " + response.getResponseText());
			System.out.println("Response: " + response.getResponse());

		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	private static void resetWebPassword(RequestHeader rh, String json) {
		try {
			ResetPasswordRequest req = JsonToObjectConverter.convertJsonToObject(json, ResetPasswordRequest.class);

			rh.setApiKey("APFORP");
			PayLoadValidator.requestHeaderPayLoad(rh);
			AccountPayload.resetWebPasswordPayLoad(req);

			String requestXml = XmlRequestGenerator.generateXml(req);

			EncryptDecryptUtility encryptionUtility = EncryptDecryptUtility.getInstance();
			String msgRefNo = rh.getMsgRefNo();

			EncryptionResult result = encryptionUtility.encryptXmlRequest(requestXml, msgRefNo);
			String encryptedXml = result.getEncryptedXml();
			String encryptedSessionKey = result.getEncryptedSessionKey();

			String signedXml = encryptionUtility.signXmlRequest(requestXml);

			rh.setSessionKey(encryptedSessionKey);
			rh.setToken(signedXml);

			RequestBody body = new RequestBody();
			body.setRequest(encryptedXml);

			NaradaRequest request = new NaradaRequest();
			request.setRequestBody(body);
			request.setRequestHeader(rh);

			NaradaResponse res = port.serviceCall(request);
			ResponseBody response = res.getResponseBody();

			System.out.println("\nResponse code: " + response.getResponseCode());
			System.out.println("Response text: " + response.getResponseText());
			System.out.println("Response: " + response.getResponse());

		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	private static void setATMPin(RequestHeader rh, String json) {
		try {
			SetAtmPinRequest req = JsonToObjectConverter.convertJsonToObject(json, SetAtmPinRequest.class);

			rh.setApiKey("APINST");
			PayLoadValidator.requestHeaderPayLoad(rh);
			AccountPayload.setATMPinPayLoad(req);

			String requestXml = XmlRequestGenerator.generateXml(req);

			EncryptDecryptUtility encryptionUtility = EncryptDecryptUtility.getInstance();
			String msgRefNo = rh.getMsgRefNo();

			EncryptionResult result = encryptionUtility.encryptXmlRequest(requestXml, msgRefNo);
			String encryptedXml = result.getEncryptedXml();
			String encryptedSessionKey = result.getEncryptedSessionKey();

			String signedXml = encryptionUtility.signXmlRequest(requestXml);

			rh.setSessionKey(encryptedSessionKey);
			rh.setToken(signedXml);

			RequestBody body = new RequestBody();
			body.setRequest(encryptedXml);

			NaradaRequest request = new NaradaRequest();
			request.setRequestBody(body);
			request.setRequestHeader(rh);

			NaradaResponse res = port.serviceCall(request);
			ResponseBody response = res.getResponseBody();

			System.out.println("\nResponse code: " + response.getResponseCode());
			System.out.println("Response text: " + response.getResponseText());
			System.out.println("Response: " + response.getResponse());

		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	private static void newOTPRequest(RequestHeader rh, String json) {
		try {
			OTPRequest req = JsonToObjectConverter.convertJsonToObject(json, OTPRequest.class);

			rh.setApiKey("AFPOTP");
			PayLoadValidator.requestHeaderPayLoad(rh);
			AccountPayload.newOTPRequestPayLoad(req);

			String requestXml = XmlRequestGenerator.generateXml(req);

			EncryptDecryptUtility encryptionUtility = EncryptDecryptUtility.getInstance();
			String msgRefNo = rh.getMsgRefNo();

			EncryptionResult result = encryptionUtility.encryptXmlRequest(requestXml, msgRefNo);
			String encryptedXml = result.getEncryptedXml();
			String encryptedSessionKey = result.getEncryptedSessionKey();

			String signedXml = encryptionUtility.signXmlRequest(requestXml);

			rh.setSessionKey(encryptedSessionKey);
			rh.setToken(signedXml);

			RequestBody body = new RequestBody();
			body.setRequest(encryptedXml);

			NaradaRequest request = new NaradaRequest();
			request.setRequestBody(body);
			request.setRequestHeader(rh);

			NaradaResponse res = port.serviceCall(request);
			ResponseBody response = res.getResponseBody();

			System.out.println("\nResponse code: " + response.getResponseCode());
			System.out.println("Response text: " + response.getResponseText());
			System.out.println("Response: " + response.getResponse());

		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	private static void otpValidation(RequestHeader rh, String json) {
		try {
			OTPValidationRequest req = JsonToObjectConverter.convertJsonToObject(json, OTPValidationRequest.class);

			rh.setApiKey("AVPOTP");
			PayLoadValidator.requestHeaderPayLoad(rh);
			AccountPayload.otpValidationPayLoad(req);

			String requestXml = XmlRequestGenerator.generateXml(req);

			EncryptDecryptUtility encryptionUtility = EncryptDecryptUtility.getInstance();
			String msgRefNo = rh.getMsgRefNo();

			EncryptionResult result = encryptionUtility.encryptXmlRequest(requestXml, msgRefNo);
			String encryptedXml = result.getEncryptedXml();
			String encryptedSessionKey = result.getEncryptedSessionKey();

			String signedXml = encryptionUtility.signXmlRequest(requestXml);

			rh.setSessionKey(encryptedSessionKey);
			rh.setToken(signedXml);

			RequestBody body = new RequestBody();
			body.setRequest(encryptedXml);

			NaradaRequest request = new NaradaRequest();
			request.setRequestBody(body);
			request.setRequestHeader(rh);

			NaradaResponse res = port.serviceCall(request);
			ResponseBody response = res.getResponseBody();

			System.out.println("\nResponse code: " + response.getResponseCode());
			System.out.println("Response text: " + response.getResponseText());
			System.out.println("Response: " + response.getResponse());

		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	private static void retrieveWebProfile(RequestHeader rh, String json) {
		try {
			WebProfileRequest req = JsonToObjectConverter.convertJsonToObject(json, WebProfileRequest.class);

			rh.setApiKey("APUSPF");
			PayLoadValidator.requestHeaderPayLoad(rh);
			AccountPayload.retrieveWebProfilePayLoad(req);

			String requestXml = XmlRequestGenerator.generateXml(req);

			EncryptDecryptUtility encryptionUtility = EncryptDecryptUtility.getInstance();
			String msgRefNo = rh.getMsgRefNo();

			EncryptionResult result = encryptionUtility.encryptXmlRequest(requestXml, msgRefNo);
			String encryptedXml = result.getEncryptedXml();
			String encryptedSessionKey = result.getEncryptedSessionKey();

			String signedXml = encryptionUtility.signXmlRequest(requestXml);

			rh.setSessionKey(encryptedSessionKey);
			rh.setToken(signedXml);

			RequestBody body = new RequestBody();
			body.setRequest(encryptedXml);

			NaradaRequest request = new NaradaRequest();
			request.setRequestBody(body);
			request.setRequestHeader(rh);

			NaradaResponse res = port.serviceCall(request);
			ResponseBody response = res.getResponseBody();

			System.out.println("\nResponse code: " + response.getResponseCode());
			System.out.println("Response text: " + response.getResponseText());
			System.out.println("Response: " + response.getResponse());

		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	private static void corporateRegistration(RequestHeader rh, String json) {
		try {
			CorporateRegistrationRequest req = JsonToObjectConverter.convertJsonToObject(json,
					CorporateRegistrationRequest.class);

			rh.setApiKey("ACRREG");
			PayLoadValidator.requestHeaderPayLoad(rh);
			AccountPayload.corporateRegistrationPayLoad(req);

			String requestXml = XmlRequestGenerator.generateXml(req);

			EncryptDecryptUtility encryptionUtility = EncryptDecryptUtility.getInstance();
			String msgRefNo = rh.getMsgRefNo();

			EncryptionResult result = encryptionUtility.encryptXmlRequest(requestXml, msgRefNo);
			String encryptedXml = result.getEncryptedXml();
			String encryptedSessionKey = result.getEncryptedSessionKey();

			String signedXml = encryptionUtility.signXmlRequest(requestXml);

			rh.setSessionKey(encryptedSessionKey);
			rh.setToken(signedXml);

			RequestBody body = new RequestBody();
			body.setRequest(encryptedXml);

			NaradaRequest request = new NaradaRequest();
			request.setRequestBody(body);
			request.setRequestHeader(rh);

			NaradaResponse res = port.serviceCall(request);
			ResponseBody response = res.getResponseBody();

			System.out.println("\nResponse code: " + response.getResponseCode());
			System.out.println("Response text: " + response.getResponseText());
			System.out.println("Response: " + response.getResponse());

		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	private static void addCardRequest(RequestHeader rh, String json) {
		try {
			AddCardRequest req = JsonToObjectConverter.convertJsonToObject(json, AddCardRequest.class);

			rh.setApiKey("APNADC");
			PayLoadValidator.requestHeaderPayLoad(rh);
			PayLoadValidator.addCardRequestPayLoad(req);

			String requestXml = XmlRequestGenerator.generateXml(req);

			EncryptDecryptUtility encryptionUtility = EncryptDecryptUtility.getInstance();
			String msgRefNo = rh.getMsgRefNo();

			EncryptionResult result = encryptionUtility.encryptXmlRequest(requestXml, msgRefNo);
			String encryptedXml = result.getEncryptedXml();
			String encryptedSessionKey = result.getEncryptedSessionKey();

			String signedXml = encryptionUtility.signXmlRequest(requestXml);

			rh.setSessionKey(encryptedSessionKey);
			rh.setToken(signedXml);

			RequestBody body = new RequestBody();
			body.setRequest(encryptedXml);

			NaradaRequest request = new NaradaRequest();
			request.setRequestBody(body);
			request.setRequestHeader(rh);

			NaradaResponse res = port.serviceCall(request);
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
