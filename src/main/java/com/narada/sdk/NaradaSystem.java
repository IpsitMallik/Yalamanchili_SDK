package com.narada.sdk;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.apache.commons.lang3.ObjectUtils;

import com.narada.sdk.api_client.NaradaApiServiceClient;
import com.narada.sdk.models.*;
import com.narada.sdk.services.AccountManagementService;
import com.narada.sdk.services.CardManagementService;
import com.narada.sdk.utilities.RequestHeaderUtil;
import com.narada.sdk.utilities.NoSuchMethodException;

/**
 * The NaradaSystem class provides methods to interact with the Narada API
 * services, including operations related to card management and echo testing.
 */
public class NaradaSystem {

	private final CardManagementService cardManagementService = new CardManagementService();
	private final AccountManagementService accountManagementService = new AccountManagementService();
	
	// Map to hold method names and corresponding method references
    private final Map<String, BiFunction<RequestHeader, Object, Object>> methodMap = new HashMap<>();

    // Constructor to populate the method map
    public NaradaSystem() {
        // Populate the map with method names and corresponding method references
        methodMap.put("getNewCard", (rh, req) -> getNewCard(rh, (NewCardRequest) req));
        methodMap.put("getCardDetails", (rh, req) -> getCardDetails(rh, (CardDetailRequest) req));
        methodMap.put("activateCard", (rh, req) -> activateCard(rh, (ActivateCardRequest) req));
        methodMap.put("blockLockUnlockCard", (rh, req) -> blockLockUnlockCard(rh, (CardBlockOrUnblockReq) req));
        methodMap.put("replaceCard", (rh, req) -> replaceCard(rh, (CardReplaceRequest) req));
        methodMap.put("updateCustomerDetails", (rh, req) -> updateCustomerDetails(rh, (UpdateCustomerRequest) req));
        methodMap.put("addAccount", (rh, req) -> addAccount(rh, (AddAccountRequest) req));
        methodMap.put("loadCard", (rh, req) -> loadCard(rh, (LoadCardRequest) req));
        methodMap.put("queryBalance", (rh, req) -> queryBalance(rh, (QueryBalanceRequest) req));
        methodMap.put("refundAmount", (rh, req) -> refundAmount(rh, (RefundAmountRequest) req));
        methodMap.put("accountClosure", (rh, req) -> accountClosure(rh, (AccountClosureRequest) req));
        methodMap.put("getXTransactions", (rh, req) -> getXTransactions(rh, (XTransactionsRequest) req));
        methodMap.put("debitCreditAccount", (rh, req) -> debitCreditAccount(rh, (DebitCreditAccountRequest) req));
        methodMap.put("fundTransfer", (rh, req) -> fundTransfer(rh, (FundTransferRequest) req));
        methodMap.put("updateExchangeRate", (rh, req) -> updateExchangeRate(rh, (UpdateExchangeRateRequest) req));
        methodMap.put("cardOrder", (rh, req) -> cardOrder(rh, (CardOrderRequest) req));
        methodMap.put("cardReceipt", (rh, req) -> cardReceipt(rh, (CardReceiptRequest) req));
        methodMap.put("updateStockDetails", (rh, req) -> updateStockDetails(rh, (UpdateStockDetailsRequest) req));
        methodMap.put("getStockDetails", (rh, req) -> getStockDetails(rh, (StockDetailsRequest) req));
        methodMap.put("getStatusRequest", (rh, req) -> getStatusRequest(rh, (StatusRequest) req));
        methodMap.put("createProfile", (rh, req) -> createProfile(rh, (ProfileCreationRequest) req));
        methodMap.put("changePassword", (rh, req) -> changePassword(rh, (ChangePasswordRequest) req));
        methodMap.put("getAccessRights", (rh, req) -> getAccessRights(rh, (AccessRightsRequest) req));
        methodMap.put("retrieveATMPin", (rh, req) -> retrieveATMPin(rh, (RetrievePinRequest) req));
        methodMap.put("verifyATMPin", (rh, req) -> verifyATMPin(rh, (VerifyPinRequest) req));
        methodMap.put("changeATMPin", (rh, req) -> changeATMPin(rh, (ChangePinRequest) req));
        methodMap.put("assignOverrideSettings", (rh, req) -> assignOverrideSettings(rh, (OverrideSettingsRequest) req));
        methodMap.put("alertSettings", (rh, req) -> alertSettings(rh, (AlertSettingsRequest) req));
        methodMap.put("getCardNumber", (rh, req) -> getCardNumber(rh, (CardNumberRequest) req));
        methodMap.put("getCSCEnquiry", (rh, req) -> getCSCEnquiry(rh, (CSCEnquiryRequest) req));
        methodMap.put("getCardOrderStatus", (rh, req) -> getCardOrderStatus(rh, (CardOrderStatusRequest) req));
        methodMap.put("setIVRPin", (rh, req) -> setIVRPin(rh, (SetPinRequest) req));
        methodMap.put("changeIVRPin", (rh, req) -> changeIVRPin(rh, (ChangeIvrPinRequest) req));
        methodMap.put("validateIVRPin", (rh, req) -> validateIVRPin(rh, (ValidatePinRequest) req));
        methodMap.put("resetWebPassword", (rh, req) -> resetWebPassword(rh, (ResetPasswordRequest) req));
        methodMap.put("setATMPin", (rh, req) -> setATMPin(rh, (SetAtmPinRequest) req));
        methodMap.put("newOTPRequest", (rh, req) -> newOTPRequest(rh, (OTPRequest) req));
        methodMap.put("otpValidation", (rh, req) -> otpValidation(rh, (OTPValidationRequest) req));
        methodMap.put("retrieveWebProfile", (rh, req) -> retrieveWebProfile(rh, (WebProfileRequest) req));
        methodMap.put("corporateRegistration", (rh, req) -> corporateRegistration(rh, (CorporateRegistrationRequest) req));
        methodMap.put("addCardRequest", (rh, req) -> addCardRequest(rh, (AddCardRequest) req));
    }

    // Common method to invoke service methods based on the method name
    public Object invokeServiceMethod(String methodName, RequestHeader rh, Object req) {
        if (ObjectUtils.isEmpty(methodName) || rh == null || req == null) {
            throw new IllegalArgumentException("Method name, RequestHeader, and request object cannot be null.");
        }

        BiFunction<RequestHeader, Object, Object> method = methodMap.get(methodName);

        if (method == null) {
            throw new NoSuchMethodException("No such method found: " + methodName);
        }

        try {
            return method.apply(rh, req);
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("Invalid request object type for method: " + methodName, e);
        }
    }

	public RequestHeader getHeader(final String channelType, final String msgRefNo) {
		if (ObjectUtils.isEmpty(channelType) || ObjectUtils.isEmpty(msgRefNo)) {
			throw new IllegalArgumentException("channelType and msgRefNo fields are required");
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
