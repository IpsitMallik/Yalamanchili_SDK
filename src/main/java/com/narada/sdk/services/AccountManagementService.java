package com.narada.sdk.services;

import java.nio.charset.StandardCharsets;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import com.narada.sdk.api_client.NaradaApiServiceClient;
import com.narada.sdk.models.AccessRightsRequest;
import com.narada.sdk.models.AccessRightsResponse;
import com.narada.sdk.models.AccountClosureRequest;
import com.narada.sdk.models.AccountClosureResponse;
import com.narada.sdk.models.AddAccountRequest;
import com.narada.sdk.models.AddAccountResponse;
import com.narada.sdk.models.AlertSettingsRequest;
import com.narada.sdk.models.AlertSettingsResponse;
import com.narada.sdk.models.ChangePasswordRequest;
import com.narada.sdk.models.ChangePasswordResponse;
import com.narada.sdk.models.ChangePinRequest;
import com.narada.sdk.models.ChangePinResponse;
import com.narada.sdk.models.CorporateRegistrationRequest;
import com.narada.sdk.models.CorporateRegistrationResponse;
import com.narada.sdk.models.DebitCreditAccountRequest;
import com.narada.sdk.models.DebitCreditAccountResponse;
import com.narada.sdk.models.FundTransferRequest;
import com.narada.sdk.models.FundTransferResponse;
import com.narada.sdk.models.OTPRequest;
import com.narada.sdk.models.OTPRequestResponse;
import com.narada.sdk.models.OTPValidationRequest;
import com.narada.sdk.models.OTPValidationResponse;
import com.narada.sdk.models.OverrideSettingsRequest;
import com.narada.sdk.models.OverrideSettingsResponse;
import com.narada.sdk.models.ProfileCreationRequest;
import com.narada.sdk.models.ProfileCreationResponse;
import com.narada.sdk.models.QueryBalanceRequest;
import com.narada.sdk.models.QueryBalanceResponse;
import com.narada.sdk.models.RefundAmountRequest;
import com.narada.sdk.models.RefundAmountResponse;
import com.narada.sdk.models.RequestHeader;
import com.narada.sdk.models.ResetPasswordRequest;
import com.narada.sdk.models.ResetPasswordResponse;
import com.narada.sdk.models.ResponseBody;
import com.narada.sdk.models.RetrievePinRequest;
import com.narada.sdk.models.RetrievePinResponse;
import com.narada.sdk.models.SetAtmPinRequest;
import com.narada.sdk.models.SetAtmPinResponse;
import com.narada.sdk.models.UpdateCustomerRequest;
import com.narada.sdk.models.UpdateCustomerResponse;
import com.narada.sdk.models.UpdateExchangeRateRequest;
import com.narada.sdk.models.UpdateExchangeRateResponse;
import com.narada.sdk.models.VerifyPinRequest;
import com.narada.sdk.models.VerifyPinResponse;
import com.narada.sdk.models.WebProfileRequest;
import com.narada.sdk.models.WebProfileResponse;
import com.narada.sdk.utilities.AccountPayload;
import com.narada.sdk.utilities.PayLoadValidator;
import com.narada.sdk.utilities.ServiceException;
import com.narada.sdk.utilities.XMLResponseParser;
import com.narada.sdk.utilities.XmlGenerationException;
import com.narada.sdk.utilities.XmlRequestGenerator;

/**
 * Service class for managing account-related operations.
 */
public class AccountManagementService {
	private final NaradaApiServiceClient serviceClient;

	public AccountManagementService() {
		this.serviceClient = new NaradaApiServiceClient();
	}

	public UpdateCustomerResponse updateCustomerDetails(final RequestHeader rh, final UpdateCustomerRequest req) {
		try {
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
				return XMLResponseParser.parseXml(res, UpdateCustomerResponse.class);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public AddAccountResponse addAccount(final RequestHeader rh, final AddAccountRequest req) {
		try {
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
				return XMLResponseParser.parseXml(res, AddAccountResponse.class);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public QueryBalanceResponse queryBalance(final RequestHeader rh, final QueryBalanceRequest req) {
		try {
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
				return XMLResponseParser.parseXml(res, QueryBalanceResponse.class);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public RefundAmountResponse refundAmount(final RequestHeader rh, final RefundAmountRequest req) {
		try {
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
				return XMLResponseParser.parseXml(res, RefundAmountResponse.class);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public AccountClosureResponse accountClosure(final RequestHeader rh, final AccountClosureRequest req) {
		try {
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
				return XMLResponseParser.parseXml(res, AccountClosureResponse.class);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public DebitCreditAccountResponse debitCreditAccount(final RequestHeader rh, final DebitCreditAccountRequest req) {
		try {
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
				return XMLResponseParser.parseXml(res, DebitCreditAccountResponse.class);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public FundTransferResponse fundTransfer(final RequestHeader rh, final FundTransferRequest req) {
		try {
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
				return XMLResponseParser.parseXml(res, FundTransferResponse.class);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public UpdateExchangeRateResponse updateExchangeRate(final RequestHeader rh, final UpdateExchangeRateRequest req) {
		try {
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
				return XMLResponseParser.parseXml(res, UpdateExchangeRateResponse.class);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public ProfileCreationResponse createProfile(final RequestHeader rh, final ProfileCreationRequest req) {
		try {
			rh.setApiKey("APRFCR");
			PayLoadValidator.requestHeaderPayLoad(rh);
			AccountPayload.createProfilePayLoad(req);
			req.setPassword(hashAndEncodePassword(req.getPassword()));
			final String requestXml = XmlRequestGenerator.generateXml(req);
			final ResponseBody responseBody = serviceClient.serviceCall(rh, requestXml);
			if (responseBody == null) {
				throw new ServiceException("ERR_NULL_RESPONSE", "Received null response from service call.");
			}
			final String status = responseBody.getResponseCode();
			if (status.equals("00")) {
				final String res = responseBody.getResponse();
				return XMLResponseParser.parseXml(res, ProfileCreationResponse.class);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public ChangePasswordResponse changePassword(final RequestHeader rh, final ChangePasswordRequest req) {
		try {
			rh.setApiKey("ACHPSS");
			PayLoadValidator.requestHeaderPayLoad(rh);
			AccountPayload.changePasswordPayLoad(req);
			req.setOldPassword(hashAndEncodePassword(req.getOldPassword()));
			req.setNewPassword(hashAndEncodePassword(req.getNewPassword()));
			final String requestXml = XmlRequestGenerator.generateXml(req);
			final ResponseBody responseBody = serviceClient.serviceCall(rh, requestXml);
			if (responseBody == null) {
				throw new ServiceException("ERR_NULL_RESPONSE", "Received null response from service call.");
			}
			final String status = responseBody.getResponseCode();
			if (status.equals("00")) {
				final String res = responseBody.getResponse();
				return XMLResponseParser.parseXml(res, ChangePasswordResponse.class);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public AccessRightsResponse getAccessRights(final RequestHeader rh, final AccessRightsRequest req) {
		try {
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
				return XMLResponseParser.parseXml(res, AccessRightsResponse.class);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public RetrievePinResponse retrieveATMPin(final RequestHeader rh, final RetrievePinRequest req) {
		try {
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
				return XMLResponseParser.parseXml(res, RetrievePinResponse.class);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public VerifyPinResponse verifyATMPin(final RequestHeader rh, final VerifyPinRequest req) {
		try {
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
				return XMLResponseParser.parseXml(res, VerifyPinResponse.class);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public ChangePinResponse changeATMPin(final RequestHeader rh, final ChangePinRequest req) {
		try {
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
				return XMLResponseParser.parseXml(res, ChangePinResponse.class);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public OverrideSettingsResponse assignOverrideSettings(final RequestHeader rh, final OverrideSettingsRequest req) {
		try {
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
				return XMLResponseParser.parseXml(res, OverrideSettingsResponse.class);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public AlertSettingsResponse alertSettings(final RequestHeader rh, final AlertSettingsRequest req) {
		try {
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
				return XMLResponseParser.parseXml(res, AlertSettingsResponse.class);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public ResetPasswordResponse resetWebPassword(final RequestHeader rh, final ResetPasswordRequest req) {
		try {
			rh.setApiKey("APFORP");
			PayLoadValidator.requestHeaderPayLoad(rh);
			AccountPayload.resetWebPasswordPayLoad(req);
			req.setNewPassword(hashAndEncodePassword(req.getNewPassword()));
			req.setConfirmPassword(hashAndEncodePassword(req.getConfirmPassword()));
			final String requestXml = XmlRequestGenerator.generateXml(req);
			final ResponseBody responseBody = serviceClient.serviceCall(rh, requestXml);
			if (responseBody == null) {
				throw new ServiceException("ERR_NULL_RESPONSE", "Received null response from service call.");
			}
			final String status = responseBody.getResponseCode();
			if (status.equals("00")) {
				final String res = responseBody.getResponse();
				return XMLResponseParser.parseXml(res, ResetPasswordResponse.class);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public SetAtmPinResponse setATMPin(final RequestHeader rh, final SetAtmPinRequest req) {
		try {
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
				return XMLResponseParser.parseXml(res, SetAtmPinResponse.class);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public OTPRequestResponse newOTPRequest(final RequestHeader rh, final OTPRequest req) {
		try {
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
				return XMLResponseParser.parseXml(res, OTPRequestResponse.class);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public OTPValidationResponse otpValidation(final RequestHeader rh, final OTPValidationRequest req) {
		try {
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
				return XMLResponseParser.parseXml(res, OTPValidationResponse.class);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public WebProfileResponse retrieveWebProfile(final RequestHeader rh, final WebProfileRequest req) {
		try {
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
				return XMLResponseParser.parseXml(res, WebProfileResponse.class);
			} else {
				throw new ServiceException(status, responseBody.getResponseText());
			}
		} catch (final XmlGenerationException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServiceException("0", e.getMessage(), e);
		}
	}

	public CorporateRegistrationResponse corporateRegistration(final RequestHeader rh,
			final CorporateRegistrationRequest req) {
		try {
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
				return XMLResponseParser.parseXml(res, CorporateRegistrationResponse.class);
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
