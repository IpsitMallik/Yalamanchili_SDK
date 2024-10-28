package com.ottl.service;

import com.ottl.model.*;
import com.ottl.soapclient.NaradaApiServiceClient;
import com.ottl.soapclient.RequestHeader;
import com.ottl.soapclient.ResponseBody;
import com.ottl.utils.*;

/**
 * Service class for managing card-related operations.
 */
public class CardManagementService {

	private final NaradaApiServiceClient serviceClient;

	public CardManagementService() {
		this.serviceClient = new NaradaApiServiceClient();
	}

	public String issueNewCard(final RequestHeader rh, final String json) {
		try {
			NewCardRequest req = JsonToObjectConverter.convertJsonToObject(json, NewCardRequest.class);
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
				return XMLResponseParser.parseXml(res);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}

		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public String getCardDetail(final RequestHeader rh, final String json) {
		try {
			CardDetailRequest req = JsonToObjectConverter.convertJsonToObject(json, CardDetailRequest.class);
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
				return XMLResponseParser.parseXml(res);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public String acticateCard(final RequestHeader rh, final String json) {
		try {
			ActivateCardRequest req = JsonToObjectConverter.convertJsonToObject(json, ActivateCardRequest.class);
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
				return XMLResponseParser.parseXml(res);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public String blockOrUnblockCard(final RequestHeader rh, final String json) {
		try {
			CardBlockOrUnblockReq req = JsonToObjectConverter.convertJsonToObject(json, CardBlockOrUnblockReq.class);
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
				return XMLResponseParser.parseXml(res);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public String replaceCard(final RequestHeader rh, final String json) {
		try {
			CardReplaceRequest req = JsonToObjectConverter.convertJsonToObject(json, CardReplaceRequest.class);
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
				return XMLResponseParser.parseXml(res);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public String loadCard(final RequestHeader rh, final String json) {
		try {
			LoadCardRequest req = JsonToObjectConverter.convertJsonToObject(json, LoadCardRequest.class);
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
				return XMLResponseParser.parseXml(res);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public String getXTransactions(final RequestHeader rh, final String json) {
		try {
			XTransactionsRequest req = JsonToObjectConverter.convertJsonToObject(json, XTransactionsRequest.class);
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
				return XMLResponseParser.parseXml(res);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public String cardOrder(final RequestHeader rh, final String json) {
		try {
			CardOrderRequest req = JsonToObjectConverter.convertJsonToObject(json, CardOrderRequest.class);
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
				return XMLResponseParser.parseXml(res);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public String cardReceipt(final RequestHeader rh, final String json) {
		try {
			CardReceiptRequest req = JsonToObjectConverter.convertJsonToObject(json, CardReceiptRequest.class);
			rh.setApiKey("APSTRC");
			PayLoadValidator.requestHeaderPayLoad(rh);
			PayLoadValidator.cardReceiptPayLoad(req);
			final String requestXml = XmlRequestGenerator.generateXml(req);
			final ResponseBody responseBody = serviceClient.serviceCall(rh, requestXml);
			if (responseBody == null) {
				throw new ServiceException("ERR_NULL_RESPONSE", "Received null response from service call.");
			}
			final String status = responseBody.getResponseCode();
			if (status.equals("00")) {
				final String res = responseBody.getResponse();
				return XMLResponseParser.parseXml(res);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public String updateStockDetails(final RequestHeader rh, final String json) {
		try {
			UpdateStockDetailsRequest req = JsonToObjectConverter.convertJsonToObject(json,
					UpdateStockDetailsRequest.class);
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
				return XMLResponseParser.parseXml(res);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public String getStockDetails(final RequestHeader rh, final String json) {
		try {
			StockDetailsRequest req = JsonToObjectConverter.convertJsonToObject(json, StockDetailsRequest.class);
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
				return XMLResponseParser.parseXml(res);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public String getStatusRequest(final RequestHeader rh, final String json) {
		try {
			StatusRequest req = JsonToObjectConverter.convertJsonToObject(json, StatusRequest.class);
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
				return XMLResponseParser.parseXml(res);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public String getCardNumber(final RequestHeader rh, final String json) {
		try {
			CardNumberRequest req = JsonToObjectConverter.convertJsonToObject(json, CardNumberRequest.class);
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
				return XMLResponseParser.parseXml(res);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public String getCSCEnquiry(final RequestHeader rh, final String json) {
		try {
			CSCEnquiryRequest req = JsonToObjectConverter.convertJsonToObject(json, CSCEnquiryRequest.class);
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
				return XMLResponseParser.parseXml(res);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public String getCardOrderStatus(final RequestHeader rh, final String json) {
		try {
			CardOrderStatusRequest req = JsonToObjectConverter.convertJsonToObject(json, CardOrderStatusRequest.class);
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
				return XMLResponseParser.parseXml(res);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public String setIVRPin(final RequestHeader rh, final String json) {
		try {
			SetPinRequest req = JsonToObjectConverter.convertJsonToObject(json, SetPinRequest.class);
			rh.setApiKey("APIIVR");
			PayLoadValidator.requestHeaderPayLoad(rh);
			PayLoadValidator.setIVRPinPayLoad(req);
			final String requestXml = XmlRequestGenerator.generateXml(req);
			final ResponseBody responseBody = serviceClient.serviceCall(rh, requestXml);
			if (responseBody == null) {
				throw new ServiceException("ERR_NULL_RESPONSE", "Received null response from service call.");
			}
			final String status = responseBody.getResponseCode();
			if (status.equals("00")) {
				final String res = responseBody.getResponse();
				return XMLResponseParser.parseXml(res);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public String changeIVRPin(final RequestHeader rh, final String json) {
		try {
			ChangeIvrPinRequest req = JsonToObjectConverter.convertJsonToObject(json, ChangeIvrPinRequest.class);
			rh.setApiKey("APIIVC");
			PayLoadValidator.requestHeaderPayLoad(rh);
			PayLoadValidator.changeIVRPinPayLoad(req);
			final String requestXml = XmlRequestGenerator.generateXml(req);
			final ResponseBody responseBody = serviceClient.serviceCall(rh, requestXml);
			if (responseBody == null) {
				throw new ServiceException("ERR_NULL_RESPONSE", "Received null response from service call.");
			}
			final String status = responseBody.getResponseCode();
			if (status.equals("00")) {
				final String res = responseBody.getResponse();
				return XMLResponseParser.parseXml(res);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public String validateIVRPin(final RequestHeader rh, final String json) {
		try {
			ValidatePinRequest req = JsonToObjectConverter.convertJsonToObject(json, ValidatePinRequest.class);
			rh.setApiKey("APIPNV");
			PayLoadValidator.requestHeaderPayLoad(rh);
			PayLoadValidator.validateIVRPinPayLoad(req);
			final String requestXml = XmlRequestGenerator.generateXml(req);
			final ResponseBody responseBody = serviceClient.serviceCall(rh, requestXml);
			if (responseBody == null) {
				throw new ServiceException("ERR_NULL_RESPONSE", "Received null response from service call.");
			}
			final String status = responseBody.getResponseCode();
			if (status.equals("00")) {
				final String res = responseBody.getResponse();
				return XMLResponseParser.parseXml(res);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public String addCardRequest(final RequestHeader rh, final String json) {
		try {
			AddCardRequest req = JsonToObjectConverter.convertJsonToObject(json, AddCardRequest.class);
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
				return XMLResponseParser.parseXml(res);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

}
