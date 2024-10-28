package com.ottl.service;

import com.ottl.model.*;
import com.ottl.soapclient.NaradaApiServiceClient;
import com.ottl.soapclient.RequestHeader;
import com.ottl.soapclient.ResponseBody;
import com.ottl.utils.*;

/**
 * Service class for managing account-related operations.
 */
public class AccountManagementService {
	private final NaradaApiServiceClient serviceClient;

	public AccountManagementService() {
		this.serviceClient = new NaradaApiServiceClient();
	}

	public String updateCustomerDetails(final RequestHeader rh, final String json) {
		try {
			UpdateCustomerRequest req = JsonToObjectConverter.convertJsonToObject(json, UpdateCustomerRequest.class);
			rh.setApiKey("APUPCR");
			PayLoadValidator.requestHeaderPayLoad(rh);
			AccountPayload.updateCustomerPayLoad(req);
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

	public String addAccount(final RequestHeader rh, final String json) {
		try {
			AddAccountRequest req = JsonToObjectConverter.convertJsonToObject(json, AddAccountRequest.class);
			rh.setApiKey("APACAD");
			PayLoadValidator.requestHeaderPayLoad(rh);
			AccountPayload.addAccountPayLoad(req);
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

	public String queryBalance(final RequestHeader rh, final String json) {
		try {
			QueryBalanceRequest req = JsonToObjectConverter.convertJsonToObject(json, QueryBalanceRequest.class);
			rh.setApiKey("APACBL");
			PayLoadValidator.requestHeaderPayLoad(rh);
			AccountPayload.queryBalancePayLoad(req);
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

	public String refundAmount(final RequestHeader rh, final String json) {
		try {
			RefundAmountRequest req = JsonToObjectConverter.convertJsonToObject(json, RefundAmountRequest.class);
			rh.setApiKey("APCRND");
			PayLoadValidator.requestHeaderPayLoad(rh);
			AccountPayload.refundAmountPayLoad(req);
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

	public String accountClosure(final RequestHeader rh, final String json) {
		try {
			AccountClosureRequest req = JsonToObjectConverter.convertJsonToObject(json, AccountClosureRequest.class);
			rh.setApiKey("APACCL");
			PayLoadValidator.requestHeaderPayLoad(rh);
			AccountPayload.accountClosurePayLoad(req);
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

	public String debitCreditAccount(final RequestHeader rh, final String json) {
		try {
			DebitCreditAccountRequest req = JsonToObjectConverter.convertJsonToObject(json,
					DebitCreditAccountRequest.class);
			rh.setApiKey("APCRDR");
			PayLoadValidator.requestHeaderPayLoad(rh);
			AccountPayload.debitCreditAccountPayLoad(req);
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

	public String fundTransfer(final RequestHeader rh, final String json) {
		try {
			FundTransferRequest req = JsonToObjectConverter.convertJsonToObject(json, FundTransferRequest.class);
			rh.setApiKey("APFDTR");
			PayLoadValidator.requestHeaderPayLoad(rh);
			AccountPayload.fundTransferPayLoad(req);
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

	public String updateExchangeRate(final RequestHeader rh, final String json) {
		try {
			UpdateExchangeRateRequest req = JsonToObjectConverter.convertJsonToObject(json,
					UpdateExchangeRateRequest.class);
			rh.setApiKey("APFREX");
			PayLoadValidator.requestHeaderPayLoad(rh);
			AccountPayload.updateExchangeRatePayLoad(req);
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

	public String createProfile(final RequestHeader rh, final String json) {
		try {
			ProfileCreationRequest req = JsonToObjectConverter.convertJsonToObject(json, ProfileCreationRequest.class);
			rh.setApiKey("APRFCR");
			PayLoadValidator.requestHeaderPayLoad(rh);
			AccountPayload.createProfilePayLoad(req);
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

	public String changePassword(final RequestHeader rh, final String json) {
		try {
			ChangePasswordRequest req = JsonToObjectConverter.convertJsonToObject(json, ChangePasswordRequest.class);
			rh.setApiKey("ACHPSS");
			PayLoadValidator.requestHeaderPayLoad(rh);
			AccountPayload.changePasswordPayLoad(req);
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

	public String getAccessRights(final RequestHeader rh, final String json) {
		try {
			AccessRightsRequest req = JsonToObjectConverter.convertJsonToObject(json, AccessRightsRequest.class);
			rh.setApiKey("APACRT");
			PayLoadValidator.requestHeaderPayLoad(rh);
			AccountPayload.getAccessRightsPayLoad(req);
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

	public String retrieveATMPin(final RequestHeader rh, final String json) {
		try {
			RetrievePinRequest req = JsonToObjectConverter.convertJsonToObject(json, RetrievePinRequest.class);
			rh.setApiKey("APIPIR");
			PayLoadValidator.requestHeaderPayLoad(rh);
			AccountPayload.retrieveATMPinPayLoad(req);
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

	public String verifyATMPin(final RequestHeader rh, final String json) {
		try {
			VerifyPinRequest req = JsonToObjectConverter.convertJsonToObject(json, VerifyPinRequest.class);
			rh.setApiKey("APIVER");
			PayLoadValidator.requestHeaderPayLoad(rh);
			AccountPayload.verifyATMPinPayLoad(req);
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

	public String changeATMPin(final RequestHeader rh, final String json) {
		try {
			ChangePinRequest req = JsonToObjectConverter.convertJsonToObject(json, ChangePinRequest.class);
			rh.setApiKey("APICHG");
			PayLoadValidator.requestHeaderPayLoad(rh);
			AccountPayload.changeATMPinPayLoad(req);
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

	public String assignOverrideSettings(final RequestHeader rh, final String json) {
		try {
			OverrideSettingsRequest req = JsonToObjectConverter.convertJsonToObject(json,
					OverrideSettingsRequest.class);
			rh.setApiKey("AOVRST");
			PayLoadValidator.requestHeaderPayLoad(rh);
			AccountPayload.assignOverrideSettingsPayLoad(req);
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

	public String alertSettings(final RequestHeader rh, final String json) {
		try {
			AlertSettingsRequest req = JsonToObjectConverter.convertJsonToObject(json, AlertSettingsRequest.class);
			rh.setApiKey("APALTS");
			PayLoadValidator.requestHeaderPayLoad(rh);
			AccountPayload.alertSettingsPayLoad(req);
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

	public String resetWebPassword(final RequestHeader rh, final String json) {
		try {
			ResetPasswordRequest req = JsonToObjectConverter.convertJsonToObject(json, ResetPasswordRequest.class);
			rh.setApiKey("APFORP");
			PayLoadValidator.requestHeaderPayLoad(rh);
			AccountPayload.resetWebPasswordPayLoad(req);

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

	public String setATMPin(final RequestHeader rh, final String json) {
		try {
			SetAtmPinRequest req = JsonToObjectConverter.convertJsonToObject(json, SetAtmPinRequest.class);
			rh.setApiKey("APINST");
			PayLoadValidator.requestHeaderPayLoad(rh);
			AccountPayload.setATMPinPayLoad(req);
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

	public String newOTPRequest(final RequestHeader rh, final String json) {
		try {
			OTPRequest req = JsonToObjectConverter.convertJsonToObject(json, OTPRequest.class);
			rh.setApiKey("AFPOTP");
			PayLoadValidator.requestHeaderPayLoad(rh);
			AccountPayload.newOTPRequestPayLoad(req);
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

	public String otpValidation(final RequestHeader rh, final String json) {
		try {
			OTPValidationRequest req = JsonToObjectConverter.convertJsonToObject(json, OTPValidationRequest.class);
			rh.setApiKey("AVPOTP");
			PayLoadValidator.requestHeaderPayLoad(rh);
			AccountPayload.otpValidationPayLoad(req);
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

	public String retrieveWebProfile(final RequestHeader rh, final String json) {
		try {
			WebProfileRequest req = JsonToObjectConverter.convertJsonToObject(json, WebProfileRequest.class);
			rh.setApiKey("APUSPF");
			PayLoadValidator.requestHeaderPayLoad(rh);
			AccountPayload.retrieveWebProfilePayLoad(req);
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

	public String corporateRegistration(final RequestHeader rh, final String json) {
		try {
			CorporateRegistrationRequest req = JsonToObjectConverter.convertJsonToObject(json,
					CorporateRegistrationRequest.class);
			rh.setApiKey("ACRREG");
			PayLoadValidator.requestHeaderPayLoad(rh);
			AccountPayload.corporateRegistrationPayLoad(req);
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
