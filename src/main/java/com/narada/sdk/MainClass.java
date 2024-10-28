package com.narada.sdk;

import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;

import com.narada.sdk.api_client.NaradaApiService;
import com.narada.sdk.api_client.NaradaApiServicePortType;
import com.narada.sdk.models.AccessRightsRequest;
import com.narada.sdk.models.AccountClosureRequest;
import com.narada.sdk.models.ActivateCardRequest;
import com.narada.sdk.models.AddAccountRequest;
import com.narada.sdk.models.AddCardRequest;
import com.narada.sdk.models.AlertSettingsRequest;
import com.narada.sdk.models.CSCEnquiryRequest;
import com.narada.sdk.models.CardBlockOrUnblockReq;
import com.narada.sdk.models.CardDetailRequest;
import com.narada.sdk.models.CardNumberRequest;
import com.narada.sdk.models.CardOrderRequest;
import com.narada.sdk.models.CardOrderStatusRequest;
import com.narada.sdk.models.CardReceiptRequest;
import com.narada.sdk.models.CardReplaceRequest;
import com.narada.sdk.models.ChangeIvrPinRequest;
import com.narada.sdk.models.ChangePasswordRequest;
import com.narada.sdk.models.ChangePinRequest;
import com.narada.sdk.models.CorporateRegistrationRequest;
import com.narada.sdk.models.DebitCreditAccountRequest;
import com.narada.sdk.models.FundTransferRequest;
import com.narada.sdk.models.LoadCardRequest;
import com.narada.sdk.models.NaradaRequest;
import com.narada.sdk.models.NaradaResponse;
import com.narada.sdk.models.NewCardRequest;
import com.narada.sdk.models.OTPRequest;
import com.narada.sdk.models.OTPValidationRequest;
import com.narada.sdk.models.OverrideSettingsRequest;
import com.narada.sdk.models.ProfileCreationRequest;
import com.narada.sdk.models.QueryBalanceRequest;
import com.narada.sdk.models.RefundAmountRequest;
import com.narada.sdk.models.RequestBody;
import com.narada.sdk.models.RequestHeader;
import com.narada.sdk.models.ResetPasswordRequest;
import com.narada.sdk.models.ResponseBody;
import com.narada.sdk.models.RetrievePinRequest;
import com.narada.sdk.models.SetAtmPinRequest;
import com.narada.sdk.models.SetPinRequest;
import com.narada.sdk.models.StatusRequest;
import com.narada.sdk.models.StockDetailsRequest;
import com.narada.sdk.models.UpdateCustomerRequest;
import com.narada.sdk.models.UpdateExchangeRateRequest;
import com.narada.sdk.models.UpdateStockDetailsRequest;
import com.narada.sdk.models.ValidatePinRequest;
import com.narada.sdk.models.VerifyPinRequest;
import com.narada.sdk.models.WebProfileRequest;
import com.narada.sdk.models.XTransactionsRequest;
import com.narada.sdk.utilities.AccountPayload;
import com.narada.sdk.utilities.EncryptDecryptUtility;
import com.narada.sdk.utilities.EncryptionResult;
import com.narada.sdk.utilities.PayLoadValidator;
import com.narada.sdk.utilities.XmlRequestGenerator;

public class MainClass {
	private static final NaradaApiService service = new NaradaApiService();
	private static final NaradaApiServicePortType port = service.getNaradaApiServiceHttpSoap12Endpoint();

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		org.apache.cxf.endpoint.Client client = org.apache.cxf.frontend.ClientProxy.getClient(port);
		client.getInInterceptors().add(new LoggingInInterceptor());
		client.getOutInterceptors().add(new LoggingOutInterceptor());

		NaradaSystem ns = NaradaSystemFactory.getInstance();
		System.out.println("\nEcho response: " + port.echo("test, connection"));

		RequestHeader header = ns.getHeader("API", "123456123456");

		CardDetailRequest cdr = new CardDetailRequest();
		cdr.setTxnRefNo("01234567890123456789012345678901");
		cdr.setProxyNumber("012345678901");
		cdr.setCustomerId("");

		// MainClass mc = new MainClass();
		getCardDetails(header, cdr);
		// MainClass.callMethodByName("getCardDetails", header, cdr);
	}

	public static void callMethodByName(String methodName, RequestHeader header, Object request) {
		System.out.println("\n-------------------callMethodByName-------------------------\n");
		if (ObjectUtils.isEmpty(methodName) || header == null || request == null) {
			throw new IllegalArgumentException("Method name, RequestHeader, and request object cannot be null.");
		}
		try {

			// Get the class of the request object dynamically
			Class<?> requestClass = request.getClass();
			// Use getDeclaredMethod() to access private methods
			Method method = MainClass.class.getDeclaredMethod(methodName, RequestHeader.class, requestClass);
			// Make the private method accessible
			method.setAccessible(true);
			// Invoke the static method (passing null since it's static)
			method.invoke(null, header, request);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occurred while invoking method: " + e.getMessage());
		}
	}

	private static void getCardDetails(RequestHeader header, CardDetailRequest cdr) {
		try {

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

	private static void getNewCard(RequestHeader rh, NewCardRequest req) {
		try {

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

	private static void activateCard(RequestHeader rh, ActivateCardRequest req) {
		try {

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

	private static void blockLockUnlockCard(RequestHeader rh, CardBlockOrUnblockReq req) {
		try {

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

	private static void replaceCard(RequestHeader rh, CardReplaceRequest req) {
		try {

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

	private static void updateCustomerDetails(RequestHeader rh, UpdateCustomerRequest req) {
		try {

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

	private static void addAccount(RequestHeader rh, AddAccountRequest req) {
		try {

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

	private static void loadCard(RequestHeader rh, LoadCardRequest req) {
		try {

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

	private static void queryBalance(RequestHeader rh, QueryBalanceRequest req) {
		try {

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

	private static void refundAmount(RequestHeader rh, RefundAmountRequest req) {
		try {

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

	private static void accountClosure(RequestHeader rh, AccountClosureRequest req) {
		try {

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

	private static void getXTransactions(RequestHeader rh, XTransactionsRequest req) {
		try {

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

	private static void debitCreditAccount(RequestHeader rh, DebitCreditAccountRequest req) {
		try {

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

	private static void fundTransfer(RequestHeader rh, FundTransferRequest req) {
		try {

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

	private static void updateExchangeRate(RequestHeader rh, UpdateExchangeRateRequest req) {
		try {

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

	private static void cardOrder(RequestHeader rh, CardOrderRequest req) {
		try {

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

	private static void cardReceipt(RequestHeader rh, CardReceiptRequest req) {
		try {

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

	private static void updateStockDetails(RequestHeader rh, UpdateStockDetailsRequest req) {
		try {

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

	private static void getStockDetails(RequestHeader rh, StockDetailsRequest req) {
		try {

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

	private static void getStatusRequest(RequestHeader rh, StatusRequest req) {
		try {

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

	private static void createProfile(RequestHeader rh, ProfileCreationRequest req) {
		try {

			rh.setApiKey("APRFCR");
			PayLoadValidator.requestHeaderPayLoad(rh);
			AccountPayload.createProfilePayLoad(req);
			req.setPassword(hashAndEncodePassword(req.getPassword()));

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

	private static void changePassword(RequestHeader rh, ChangePasswordRequest req) {
		try {

			rh.setApiKey("ACHPSS");
			PayLoadValidator.requestHeaderPayLoad(rh);
			AccountPayload.changePasswordPayLoad(req);
			req.setOldPassword(hashAndEncodePassword(req.getOldPassword()));
			req.setNewPassword(hashAndEncodePassword(req.getNewPassword()));

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

	private static void getAccessRights(RequestHeader rh, AccessRightsRequest req) {
		try {

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

	private static void retrieveATMPin(RequestHeader rh, RetrievePinRequest req) {
		try {

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

	private static void verifyATMPin(RequestHeader rh, VerifyPinRequest req) {
		try {

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

	private static void changeATMPin(RequestHeader rh, ChangePinRequest req) {
		try {

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

	private static void assignOverrideSettings(RequestHeader rh, OverrideSettingsRequest req) {
		try {

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

	private static void alertSettings(RequestHeader rh, AlertSettingsRequest req) {
		try {

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

	private static void getCardNumber(RequestHeader rh, CardNumberRequest req) {
		try {

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

	private static void getCSCEnquiry(RequestHeader rh, CSCEnquiryRequest req) {
		try {

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

	private static void getCardOrderStatus(RequestHeader rh, CardOrderStatusRequest req) {
		try {

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

	private static void setIVRPin(RequestHeader rh, SetPinRequest req) {
		try {

			rh.setApiKey("APIIVR");
			PayLoadValidator.requestHeaderPayLoad(rh);
			PayLoadValidator.setIVRPinPayLoad(req);
			req.setIvrPin(hashAndEncodePassword(req.getIvrPin()));

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

	private static void changeIVRPin(RequestHeader rh, ChangeIvrPinRequest req) {
		try {

			rh.setApiKey("APIIVC");
			PayLoadValidator.requestHeaderPayLoad(rh);
			PayLoadValidator.changeIVRPinPayLoad(req);
			req.setOldIvrPin(hashAndEncodePassword(req.getOldIvrPin()));
			req.setNewIvrPin(hashAndEncodePassword(req.getNewIvrPin()));

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

	private static void validateIVRPin(RequestHeader rh, ValidatePinRequest req) {
		try {

			rh.setApiKey("APIPNV");
			PayLoadValidator.requestHeaderPayLoad(rh);
			PayLoadValidator.validateIVRPinPayLoad(req);
			req.setIvrPin(hashAndEncodePassword(req.getIvrPin()));

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

	private static void resetWebPassword(RequestHeader rh, ResetPasswordRequest req) {
		try {

			rh.setApiKey("APFORP");
			PayLoadValidator.requestHeaderPayLoad(rh);
			AccountPayload.resetWebPasswordPayLoad(req);
			req.setNewPassword(hashAndEncodePassword(req.getNewPassword()));
			req.setConfirmPassword(hashAndEncodePassword(req.getConfirmPassword()));

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

	private static void setATMPin(RequestHeader rh, SetAtmPinRequest req) {
		try {

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

	private static void newOTPRequest(RequestHeader rh, OTPRequest req) {
		try {

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

	private static void otpValidation(RequestHeader rh, OTPValidationRequest req) {
		try {

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

	private static void retrieveWebProfile(RequestHeader rh, WebProfileRequest req) {
		try {

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

	private static void corporateRegistration(RequestHeader rh, CorporateRegistrationRequest req) {
		try {

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

	private static void addCardRequest(RequestHeader rh, AddCardRequest req) {
		try {

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

	private static String hashAndEncodePassword(String password) throws NoSuchAlgorithmException {
		// Hash the password using SHA-256
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hashedBytes = digest.digest(password.getBytes(StandardCharsets.UTF_8));

		// Encode the hashed bytes into a BASE64 string
		return Base64.getEncoder().encodeToString(hashedBytes);
	}
}
