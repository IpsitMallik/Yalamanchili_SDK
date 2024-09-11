package com.narada.sdk.services;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import com.narada.sdk.api_client.NaradaApiServiceClient;
import com.narada.sdk.models.*;
import com.narada.sdk.utilities.*;

/**
 * Service class for managing card-related operations.
 */
public class CardManagementService {

	private final NaradaApiServiceClient serviceClient;

	public CardManagementService() {
		this.serviceClient = new NaradaApiServiceClient();
	}

	public NewCardResponse issueNewCard(final RequestHeader rh, final NewCardRequest req) {
		try {
			rh.setApiKey("APNCRD");
			PayLoadValidator.requestHeaderPayLoad(rh);
			PayLoadValidator.issueNewCardPayLoad(req);
			final String requestXml = XmlRequestGenerator.generateXml(req);
			final ResponseBody responseBody = serviceClient.serviceCall(rh, requestXml);
			if (responseBody == null) {
				throw new ServiceException("ERR_NULL_RESPONSE", "Received null response from service call.");
			}
			final String status = responseBody.getResponseCode();
			if (status.equals("00")) {
				final String res = responseBody.getResponse();
				return XMLResponseParser.parseXml(res, NewCardResponse.class);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}

		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public CardDetailResponse getCardDetail(final RequestHeader rh, final CardDetailRequest req) {
		try {
			rh.setApiKey("APCHDT");
			PayLoadValidator.requestHeaderPayLoad(rh);
			PayLoadValidator.getCardDetailPayLoad(req);
			final String requestXml = XmlRequestGenerator.generateXml(req);
			final ResponseBody responseBody = serviceClient.serviceCall(rh, requestXml);
			if (responseBody == null) {
				throw new ServiceException("ERR_NULL_RESPONSE", "Received null response from service call.");
			}
			final String status = responseBody.getResponseCode();
			if (status.equals("00")) {
				final String res = responseBody.getResponse();
				return XMLResponseParser.parseXml(res, CardDetailResponse.class);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public ActivateCardResponse acticateCard(final RequestHeader rh, final ActivateCardRequest req) {
		try {
			rh.setApiKey("APCDAC");
			PayLoadValidator.requestHeaderPayLoad(rh);
			PayLoadValidator.activateCardPayLoad(req);
			final String requestXml = XmlRequestGenerator.generateXml(req);
			final ResponseBody responseBody = serviceClient.serviceCall(rh, requestXml);
			if (responseBody == null) {
				throw new ServiceException("ERR_NULL_RESPONSE", "Received null response from service call.");
			}
			final String status = responseBody.getResponseCode();
			if (status.equals("00")) {
				final String res = responseBody.getResponse();
				return XMLResponseParser.parseXml(res, ActivateCardResponse.class);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public CardBlockOrUnblockRes blockOrUnblockCard(final RequestHeader rh, final CardBlockOrUnblockReq req) {
		try {
			rh.setApiKey("ACDSTS");
			PayLoadValidator.requestHeaderPayLoad(rh);
			PayLoadValidator.blockOrUnblockCardPayLoad(req);
			final String requestXml = XmlRequestGenerator.generateXml(req);
			final ResponseBody responseBody = serviceClient.serviceCall(rh, requestXml);
			if (responseBody == null) {
				throw new ServiceException("ERR_NULL_RESPONSE", "Received null response from service call.");
			}
			final String status = responseBody.getResponseCode();
			if (status.equals("00")) {
				final String res = responseBody.getResponse();
				return XMLResponseParser.parseXml(res, CardBlockOrUnblockRes.class);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public CardReplaceResponse replaceCard(final RequestHeader rh, final CardReplaceRequest req) {
		try {
			rh.setApiKey("APCDRP");
			PayLoadValidator.requestHeaderPayLoad(rh);
			PayLoadValidator.replaceCardPayLoad(req);
			final String requestXml = XmlRequestGenerator.generateXml(req);
			final ResponseBody responseBody = serviceClient.serviceCall(rh, requestXml);
			if (responseBody == null) {
				throw new ServiceException("ERR_NULL_RESPONSE", "Received null response from service call.");
			}
			final String status = responseBody.getResponseCode();
			if (status.equals("00")) {
				final String res = responseBody.getResponse();
				return XMLResponseParser.parseXml(res, CardReplaceResponse.class);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public LoadCardResponse loadCard(final RequestHeader rh, final LoadCardRequest req) {
		try {
			rh.setApiKey("APLCRD");
			PayLoadValidator.requestHeaderPayLoad(rh);
			PayLoadValidator.loadCardPayLoad(req);
			final String requestXml = XmlRequestGenerator.generateXml(req);
			final ResponseBody responseBody = serviceClient.serviceCall(rh, requestXml);
			if (responseBody == null) {
				throw new ServiceException("ERR_NULL_RESPONSE", "Received null response from service call.");
			}
			final String status = responseBody.getResponseCode();
			if (status.equals("00")) {
				final String res = responseBody.getResponse();
				return XMLResponseParser.parseXml(res, LoadCardResponse.class);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public XTransactionsResponse getXTransactions(final RequestHeader rh, final XTransactionsRequest req) {
		try {
			rh.setApiKey("APXTXN");
			PayLoadValidator.requestHeaderPayLoad(rh);
			PayLoadValidator.getXTransactionsPayLoad(req);
			final String requestXml = XmlRequestGenerator.generateXml(req);
			final ResponseBody responseBody = serviceClient.serviceCall(rh, requestXml);
			if (responseBody == null) {
				throw new ServiceException("ERR_NULL_RESPONSE", "Received null response from service call.");
			}
			final String status = responseBody.getResponseCode();
			if (status.equals("00")) {
				final String res = responseBody.getResponse();
				return XMLResponseParser.parseXml(res, XTransactionsResponse.class);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public CardOrderResponse cardOrder(final RequestHeader rh, final CardOrderRequest req) {
		try {
			rh.setApiKey("APCROR");
			PayLoadValidator.requestHeaderPayLoad(rh);
			PayLoadValidator.cardOrderPayLoad(req);
			final String requestXml = XmlRequestGenerator.generateXml(req);
			final ResponseBody responseBody = serviceClient.serviceCall(rh, requestXml);
			if (responseBody == null) {
				throw new ServiceException("ERR_NULL_RESPONSE", "Received null response from service call.");
			}
			final String status = responseBody.getResponseCode();
			if (status.equals("00")) {
				final String res = responseBody.getResponse();
				return XMLResponseParser.parseXml(res, CardOrderResponse.class);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public CardReceiptResponse cardReceipt(final RequestHeader rh, final CardReceiptRequest req) {
		try {
			rh.setApiKey("APSTRC");
			PayLoadValidator.requestHeaderPayLoad(rh);
			PayLoadValidator.cardOrderPayLoad(req);
			final String requestXml = XmlRequestGenerator.generateXml(req);
			final ResponseBody responseBody = serviceClient.serviceCall(rh, requestXml);
			if (responseBody == null) {
				throw new ServiceException("ERR_NULL_RESPONSE", "Received null response from service call.");
			}
			final String status = responseBody.getResponseCode();
			if (status.equals("00")) {
				final String res = responseBody.getResponse();
				return XMLResponseParser.parseXml(res, CardReceiptResponse.class);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public UpdateStockDetailsResponse updateStockDetails(final RequestHeader rh, final UpdateStockDetailsRequest req) {
		try {
			rh.setApiKey("APSKUP");
			PayLoadValidator.requestHeaderPayLoad(rh);
			PayLoadValidator.updateStockDetailsPayLoad(req);
			final String requestXml = XmlRequestGenerator.generateXml(req);
			final ResponseBody responseBody = serviceClient.serviceCall(rh, requestXml);
			if (responseBody == null) {
				throw new ServiceException("ERR_NULL_RESPONSE", "Received null response from service call.");
			}
			final String status = responseBody.getResponseCode();
			if (status.equals("00")) {
				final String res = responseBody.getResponse();
				return XMLResponseParser.parseXml(res, UpdateStockDetailsResponse.class);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public StockDetailsResponse getStockDetails(final RequestHeader rh, final StockDetailsRequest req) {
		try {
			rh.setApiKey("APGTSD");
			PayLoadValidator.requestHeaderPayLoad(rh);
			PayLoadValidator.getStockDetailsPayLoad(req);
			final String requestXml = XmlRequestGenerator.generateXml(req);
			final ResponseBody responseBody = serviceClient.serviceCall(rh, requestXml);
			if (responseBody == null) {
				throw new ServiceException("ERR_NULL_RESPONSE", "Received null response from service call.");
			}
			final String status = responseBody.getResponseCode();
			if (status.equals("00")) {
				final String res = responseBody.getResponse();
				return XMLResponseParser.parseXml(res, StockDetailsResponse.class);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public StatusResponse getStatusRequest(final RequestHeader rh, final StatusRequest req) {
		try {
			rh.setApiKey("APSTRQ");
			PayLoadValidator.requestHeaderPayLoad(rh);
			PayLoadValidator.getStatusRequestPayLoad(req);
			final String requestXml = XmlRequestGenerator.generateXml(req);
			final ResponseBody responseBody = serviceClient.serviceCall(rh, requestXml);
			if (responseBody == null) {
				throw new ServiceException("ERR_NULL_RESPONSE", "Received null response from service call.");
			}
			final String status = responseBody.getResponseCode();
			if (status.equals("00")) {
				final String res = responseBody.getResponse();
				return XMLResponseParser.parseXml(res, StatusResponse.class);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public CardNumberResponse getCardNumber(final RequestHeader rh, final CardNumberRequest req) {
		try {
			rh.setApiKey("APIGCN");
			PayLoadValidator.requestHeaderPayLoad(rh);
			PayLoadValidator.getCardNumberPayLoad(req);
			final String requestXml = XmlRequestGenerator.generateXml(req);
			final ResponseBody responseBody = serviceClient.serviceCall(rh, requestXml);
			if (responseBody == null) {
				throw new ServiceException("ERR_NULL_RESPONSE", "Received null response from service call.");
			}
			final String status = responseBody.getResponseCode();
			if (status.equals("00")) {
				final String res = responseBody.getResponse();
				return XMLResponseParser.parseXml(res, CardNumberResponse.class);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public CSCEnquiryResponse getCSCEnquiry(final RequestHeader rh, final CSCEnquiryRequest req) {
		try {
			rh.setApiKey("ACSENQ");
			PayLoadValidator.requestHeaderPayLoad(rh);
			PayLoadValidator.getCSCEnquiryPayLoad(req);
			final String requestXml = XmlRequestGenerator.generateXml(req);
			final ResponseBody responseBody = serviceClient.serviceCall(rh, requestXml);
			if (responseBody == null) {
				throw new ServiceException("ERR_NULL_RESPONSE", "Received null response from service call.");
			}
			final String status = responseBody.getResponseCode();
			if (status.equals("00")) {
				final String res = responseBody.getResponse();
				return XMLResponseParser.parseXml(res, CSCEnquiryResponse.class);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public CardOrderStatusResponse getCardOrderStatus(final RequestHeader rh, final CardOrderStatusRequest req) {
		try {
			rh.setApiKey("APCOST");
			PayLoadValidator.requestHeaderPayLoad(rh);
			PayLoadValidator.getCardOrderStatusPayLoad(req);
			final String requestXml = XmlRequestGenerator.generateXml(req);
			final ResponseBody responseBody = serviceClient.serviceCall(rh, requestXml);
			if (responseBody == null) {
				throw new ServiceException("ERR_NULL_RESPONSE", "Received null response from service call.");
			}
			final String status = responseBody.getResponseCode();
			if (status.equals("00")) {
				final String res = responseBody.getResponse();
				return XMLResponseParser.parseXml(res, CardOrderStatusResponse.class);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public SetPinResponse setIVRPin(final RequestHeader rh, final SetPinRequest req) {
		try {
			rh.setApiKey("APIIVR");
			PayLoadValidator.requestHeaderPayLoad(rh);
			PayLoadValidator.setIVRPinPayLoad(req);
			req.setIvrPin(hashAndEncodePassword(req.getIvrPin()));
			final String requestXml = XmlRequestGenerator.generateXml(req);
			final ResponseBody responseBody = serviceClient.serviceCall(rh, requestXml);
			if (responseBody == null) {
				throw new ServiceException("ERR_NULL_RESPONSE", "Received null response from service call.");
			}
			final String status = responseBody.getResponseCode();
			if (status.equals("00")) {
				final String res = responseBody.getResponse();
				return XMLResponseParser.parseXml(res, SetPinResponse.class);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public ChangeIvrPinResponse changeIVRPin(final RequestHeader rh, final ChangeIvrPinRequest req) {
		try {
			rh.setApiKey("APIIVC");
			PayLoadValidator.requestHeaderPayLoad(rh);
			PayLoadValidator.changeIVRPinPayLoad(req);
			req.setOldIvrPin(hashAndEncodePassword(req.getOldIvrPin()));
			req.setNewIvrPin(hashAndEncodePassword(req.getNewIvrPin()));
			final String requestXml = XmlRequestGenerator.generateXml(req);
			final ResponseBody responseBody = serviceClient.serviceCall(rh, requestXml);
			if (responseBody == null) {
				throw new ServiceException("ERR_NULL_RESPONSE", "Received null response from service call.");
			}
			final String status = responseBody.getResponseCode();
			if (status.equals("00")) {
				final String res = responseBody.getResponse();
				return XMLResponseParser.parseXml(res, ChangeIvrPinResponse.class);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public ValidatePinResponse validateIVRPin(final RequestHeader rh, final ValidatePinRequest req) {
		try {
			rh.setApiKey("APIPNV");
			PayLoadValidator.requestHeaderPayLoad(rh);
			PayLoadValidator.validateIVRPinPayLoad(req);
			req.setIvrPin(hashAndEncodePassword(req.getIvrPin()));
			final String requestXml = XmlRequestGenerator.generateXml(req);
			final ResponseBody responseBody = serviceClient.serviceCall(rh, requestXml);
			if (responseBody == null) {
				throw new ServiceException("ERR_NULL_RESPONSE", "Received null response from service call.");
			}
			final String status = responseBody.getResponseCode();
			if (status.equals("00")) {
				final String res = responseBody.getResponse();
				return XMLResponseParser.parseXml(res, ValidatePinResponse.class);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public AddCardResponse addCardRequest(final RequestHeader rh, final AddCardRequest req) {
		try {
			rh.setApiKey("APNADC");
			PayLoadValidator.requestHeaderPayLoad(rh);
			PayLoadValidator.addCardRequestPayLoad(req);
			final String requestXml = XmlRequestGenerator.generateXml(req);
			final ResponseBody responseBody = serviceClient.serviceCall(rh, requestXml);
			if (responseBody == null) {
				throw new ServiceException("ERR_NULL_RESPONSE", "Received null response from service call.");
			}
			final String status = responseBody.getResponseCode();
			if (status.equals("00")) {
				final String res = responseBody.getResponse();
				return XMLResponseParser.parseXml(res, AddCardResponse.class);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
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
