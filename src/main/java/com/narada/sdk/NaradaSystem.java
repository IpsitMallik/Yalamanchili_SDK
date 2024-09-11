package com.narada.sdk;

import org.apache.commons.lang3.ObjectUtils;

import com.narada.sdk.api_client.NaradaApiServiceClient;
import com.narada.sdk.models.*;
import com.narada.sdk.services.AccountManagementService;
import com.narada.sdk.services.CardManagementService;
import com.narada.sdk.utilities.RequestHeaderUtil;

/**
 * The NaradaSystem class provides methods to interact with the Narada API
 * services, including operations related to card management and echo testing.
 */
public class NaradaSystem {

	private final CardManagementService cardManagementService = new CardManagementService();
	private final AccountManagementService accountManagementService = new AccountManagementService();

	public RequestHeader getHeader(final String channelType, final String msgRefNo) {
		if (ObjectUtils.isEmpty(channelType) || ObjectUtils.isEmpty(msgRefNo)) {
			throw new IllegalArgumentException("apiKey, channelType and msgRefNo fields are required");
		}
		return RequestHeaderUtil.createHeader(channelType, msgRefNo);
	}

	public String echo(final String echoRequest) {
		if (ObjectUtils.isEmpty(echoRequest)) {
			throw new IllegalArgumentException("echoRequest field is required");
		}
		final NaradaApiServiceClient serviceClient = new NaradaApiServiceClient();
		return serviceClient.echo(echoRequest);
	}

	public NewCardResponse getNewCard(final RequestHeader rh, final NewCardRequest req) {
		return cardManagementService.issueNewCard(rh, req);
	}

	public CardDetailResponse getCardDetails(final RequestHeader rh, final CardDetailRequest req) {
		return cardManagementService.getCardDetail(rh, req);
	}

	public ActivateCardResponse activateCard(final RequestHeader rh, final ActivateCardRequest req) {
		return cardManagementService.acticateCard(rh, req);
	}

	public CardBlockOrUnblockRes blockLockUnlockCard(final RequestHeader rh, final CardBlockOrUnblockReq req) {
		return cardManagementService.blockOrUnblockCard(rh, req);
	}

	public CardReplaceResponse replaceCard(final RequestHeader rh, final CardReplaceRequest req) {
		return cardManagementService.replaceCard(rh, req);
	}

	public UpdateCustomerResponse updateCustomerDetails(final RequestHeader rh, final UpdateCustomerRequest req) {
		return accountManagementService.updateCustomerDetails(rh, req);
	}

	public AddAccountResponse addAccount(final RequestHeader rh, final AddAccountRequest req) {
		return accountManagementService.addAccount(rh, req);
	}

	public LoadCardResponse loadCard(final RequestHeader rh, final LoadCardRequest req) {
		return cardManagementService.loadCard(rh, req);
	}

	public QueryBalanceResponse queryBalance(final RequestHeader rh, final QueryBalanceRequest req) {
		return accountManagementService.queryBalance(rh, req);
	}

	public RefundAmountResponse refundAmount(final RequestHeader rh, final RefundAmountRequest req) {
		return accountManagementService.refundAmount(rh, req);
	}

	public AccountClosureResponse accountClosure(final RequestHeader rh, final AccountClosureRequest req) {
		return accountManagementService.accountClosure(rh, req);
	}

	public XTransactionsResponse getXTransactions(final RequestHeader rh, final XTransactionsRequest req) {
		return cardManagementService.getXTransactions(rh, req);
	}

	public DebitCreditAccountResponse debitCreditAccount(RequestHeader rh, DebitCreditAccountRequest req) {
		return accountManagementService.debitCreditAccount(rh, req);
	}

	public FundTransferResponse fundTransfer(RequestHeader rh, FundTransferRequest req) {
		return accountManagementService.fundTransfer(rh, req);
	}

	public UpdateExchangeRateResponse updateExchangeRate(RequestHeader rh, UpdateExchangeRateRequest req) {
		return accountManagementService.updateExchangeRate(rh, req);
	}

	public CardOrderResponse cardOrder(RequestHeader rh, CardOrderRequest req) {
		return cardManagementService.cardOrder(rh, req);
	}

	public CardReceiptResponse cardReceipt(RequestHeader rh, CardReceiptRequest req) {
		return cardManagementService.cardReceipt(rh, req);
	}

	public UpdateStockDetailsResponse updateStockDetails(RequestHeader rh, UpdateStockDetailsRequest req) {
		return cardManagementService.updateStockDetails(rh, req);
	}

	public StockDetailsResponse getStockDetails(RequestHeader rh, StockDetailsRequest req) {
		return cardManagementService.getStockDetails(rh, req);
	}

	public StatusResponse getStatusRequest(RequestHeader rh, StatusRequest req) {
		return cardManagementService.getStatusRequest(rh, req);
	}

	public ProfileCreationResponse createProfile(RequestHeader rh, ProfileCreationRequest req) {
		return accountManagementService.createProfile(rh, req);
	}

	public ChangePasswordResponse changePassword(RequestHeader rh, ChangePasswordRequest req) {
		return accountManagementService.changePassword(rh, req);
	}

	public AccessRightsResponse getAccessRights(RequestHeader rh, AccessRightsRequest req) {
		return accountManagementService.getAccessRights(rh, req);
	}

	public RetrievePinResponse retrieveATMPin(RequestHeader rh, RetrievePinRequest req) {
		return accountManagementService.retrieveATMPin(rh, req);
	}

	public VerifyPinResponse verifyATMPin(RequestHeader rh, VerifyPinRequest req) {
		return accountManagementService.verifyATMPin(rh, req);
	}

	public ChangePinResponse changeATMPin(RequestHeader rh, ChangePinRequest req) {
		return accountManagementService.changeATMPin(rh, req);
	}

	public OverrideSettingsResponse assignOverrideSettings(RequestHeader rh, OverrideSettingsRequest req) {
		return accountManagementService.assignOverrideSettings(rh, req);
	}

	public AlertSettingsResponse alertSettings(RequestHeader rh, AlertSettingsRequest req) {
		return accountManagementService.alertSettings(rh, req);
	}

	public CardNumberResponse getCardNumber(RequestHeader rh, CardNumberRequest req) {
		return cardManagementService.getCardNumber(rh, req);
	}

	public CSCEnquiryResponse getCSCEnquiry(RequestHeader rh, CSCEnquiryRequest req) {
		return cardManagementService.getCSCEnquiry(rh, req);
	}

	public CardOrderStatusResponse getCardOrderStatus(RequestHeader rh, CardOrderStatusRequest req) {
		return cardManagementService.getCardOrderStatus(rh, req);
	}

	public SetPinResponse setIVRPin(RequestHeader rh, SetPinRequest req) {
		return cardManagementService.setIVRPin(rh, req);
	}

	public ChangeIvrPinResponse changeIVRPin(RequestHeader rh, ChangeIvrPinRequest req) {
		return cardManagementService.changeIVRPin(rh, req);
	}

	public ValidatePinResponse validateIVRPin(RequestHeader rh, ValidatePinRequest req) {
		return cardManagementService.validateIVRPin(rh, req);
	}

	public ResetPasswordResponse resetWebPassword(RequestHeader rh, ResetPasswordRequest req) {
		return accountManagementService.resetWebPassword(rh, req);
	}

	public SetAtmPinResponse setATMPin(RequestHeader rh, SetAtmPinRequest req) {
		return accountManagementService.setATMPin(rh, req);
	}

	public OTPRequestResponse newOTPRequest(RequestHeader rh, OTPRequest req) {
		return accountManagementService.newOTPRequest(rh, req);
	}

	public OTPValidationResponse otpValidation(RequestHeader rh, OTPValidationRequest req) {
		return accountManagementService.otpValidation(rh, req);
	}

	public WebProfileResponse retrieveWebProfile(RequestHeader rh, WebProfileRequest req) {
		return accountManagementService.retrieveWebProfile(rh, req);
	}

	public CorporateRegistrationResponse corporateRegistration(RequestHeader rh, CorporateRegistrationRequest req) {
		return accountManagementService.corporateRegistration(rh, req);
	}

	public AddCardResponse addCardRequest(RequestHeader rh, AddCardRequest req) {
		return cardManagementService.addCardRequest(rh, req);
	}

}
