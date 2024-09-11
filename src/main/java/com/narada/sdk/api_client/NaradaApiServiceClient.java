package com.narada.sdk.api_client;

import com.narada.sdk.config.Configuration;
import com.narada.sdk.models.NaradaRequest;
import com.narada.sdk.models.NaradaResponse;
import com.narada.sdk.models.RequestBody;
import com.narada.sdk.models.RequestHeader;
import com.narada.sdk.models.ResponseBody;
import com.narada.sdk.models.ResponseHeader;
import com.narada.sdk.utilities.EncryptDecryptUtility;
import com.narada.sdk.utilities.EncryptionResult;
import com.narada.sdk.utilities.ServiceException;

import jakarta.xml.ws.*;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

@SuppressWarnings("deprecation")
public class NaradaApiServiceClient {

	private final Logger logger = LoggerFactory.getLogger(NaradaApiServiceClient.class);
	private final int MAX_RETRIES = Integer.valueOf(Configuration.getMaxRetries());
	private final ObjectFactory objFact = new ObjectFactory();
	private final EncryptDecryptUtility encryptDecryptUtility = EncryptDecryptUtility.getInstance();
	private final NaradaApiServicePortType port;

	public NaradaApiServiceClient() {
		NaradaApiService service = new NaradaApiService();
		this.port = service.getNaradaApiServiceHttpSoap12Endpoint();
		org.apache.cxf.endpoint.Client client = org.apache.cxf.frontend.ClientProxy.getClient(port);
        client.getInInterceptors().add(new LoggingInInterceptor());
        client.getOutInterceptors().add(new LoggingOutInterceptor());
		configureRequestContext(this.port);
	}

	private void configureRequestContext(NaradaApiServicePortType port) {
		Map<String, Object> requestContext = ((BindingProvider) port).getRequestContext();
		String username = Configuration.getUsername();
		String password = Configuration.getPassword();
		if (username == null || password == null) {
			throw new IllegalStateException("Authentication credentials are not set.");
		}
		requestContext.put(BindingProvider.USERNAME_PROPERTY, username);
		requestContext.put(BindingProvider.PASSWORD_PROPERTY, password);
	}

	public ResponseBody serviceCall(RequestHeader header, String xmlRequest) {
		logger.info("Starting service call with message reference number: {}", header.getMsgRefNo());

		try {
			String msgRefNo = header.getMsgRefNo();

			EncryptionResult result = encryptDecryptUtility.encryptXmlRequest(xmlRequest, msgRefNo);
			String encryptedXml = result.getEncryptedXml();
			String encryptedSessionKey = result.getEncryptedSessionKey();
			String signedXml = encryptDecryptUtility.signXmlRequest(xmlRequest);

			header.setSessionKey(encryptedSessionKey);
			header.setToken(signedXml);

			NaradaRequest request = createNaradaRequest(header, encryptedXml);
			NaradaResponse response = callServiceWithRetry(port, request, MAX_RETRIES);

			return response != null ? verifyAndDecryptResponse(response, msgRefNo) : null;
			
		} catch (Exception e) {
			logger.error("An error occurred during service call", e);
		}
		return null;
	}

	private NaradaRequest createNaradaRequest(RequestHeader header, String encryptedXml) {
		NaradaRequest request = objFact.createNaradaRequest();
		request.setRequestHeader(header);
		request.setRequestBody(createRequestBody(encryptedXml));
		return request;
	}

	private RequestBody createRequestBody(String request) {
		RequestBody body = objFact.createRequestBody();
		body.setRequest(request);
		return body;
	}

	private ResponseBody verifyAndDecryptResponse(NaradaResponse response, String msgRefNo) throws Exception {
		ResponseHeader responseHeader = response.getResponseHeader();
		String encryptedSessionKey = responseHeader.getSessionKey();
		String signedToken = responseHeader.getToken();
		if (response.getResponseBody().getResponse() == null || response.getResponseBody().getResponse().isEmpty()) {
			logger.error("Null response for message reference number: {}", msgRefNo);
			throw new ServiceException("ERR_NULL_RESPONSE", "Received null response from service call.");
        }
		String encryptedResponse = response.getResponseBody().getResponse();

		String decryptedXmlResponse = encryptDecryptUtility.decryptXmlResponse(encryptedResponse, encryptedSessionKey, msgRefNo);

		if (!encryptDecryptUtility.verifySignature(signedToken, decryptedXmlResponse)) {
			logger.error("Invalid signature in response for message reference number: {}", msgRefNo);
			throw new SecurityException("Invalid signature in response.");
		}

		ResponseBody responseBody = objFact.createResponseBody();
		responseBody.setResponseCode(response.getResponseBody().getResponseCode());
		responseBody.setResponse(decryptedXmlResponse);
		responseBody.setResponseText(response.getResponseBody().getResponseText());
		return responseBody;
	}

	private NaradaResponse callServiceWithRetry(NaradaApiServicePortType port, NaradaRequest request, int maxRetries) {
		int attempt = 1;
		while (attempt <= maxRetries) {
			try {
				logger.info("Attempting service call, attempt number: {}", attempt);
				return port.serviceCall(request);
			} catch (WebServiceException e) {
				logger.warn("Attempt {} failed: {}", attempt, e.getMessage());

				if (attempt == maxRetries) {
					logger.error("Max retries reached. Exiting.");
					break;
				}

				performBackoff(attempt);
				attempt++;
			}
		}
		return null;
	}

	private void performBackoff(int attempt) {
		long backoffTime = (long) Math.pow(2, attempt) * 1000;
		long jitter = (long) (Math.random() * 1000);
		long totalWaitTime = backoffTime + jitter;

		try {
			logger.debug("Backing off for {} milliseconds before retry", totalWaitTime);
			Thread.sleep(totalWaitTime);
		} catch (InterruptedException ie) {
			logger.error("Thread interrupted during backoff sleep", ie);
			Thread.currentThread().interrupt();
			throw new RuntimeException("Thread was interrupted during sleep", ie);
		}
	}

	public String echo(String echoRequest) {
		logger.info("Starting echo operation with request: {}", echoRequest);
		try {
			String response = port.echo(echoRequest);
			if (response != null) {
				logger.info("Echo operation successful, response: {}", response);
				return response;
			}
		} catch (Exception e) {
			logger.error("An error occurred during the echo operation", e);
		}
		return null;
	}
}
