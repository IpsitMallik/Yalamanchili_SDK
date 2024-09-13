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
		methodMap.put("corporateRegistration",
				(rh, req) -> corporateRegistration(rh, (CorporateRegistrationRequest) req));
		methodMap.put("addCardRequest", (rh, req) -> addCardRequest(rh, (AddCardRequest) req));
	}

	/**
	 * Invokes a service method identified by the given method name with the
	 * provided {@link RequestHeader} and request object.
	 *
	 * @param methodName The name of the method to be invoked. Must not be null or
	 *                   empty.
	 * @param rh         The {@link RequestHeader} object to be passed to the
	 *                   method. Must not be null.
	 * @param req        The request object to be passed to the method. Must not be
	 *                   null.
	 * @return The result of the method invocation.
	 * @throws IllegalArgumentException If {@code methodName}, {@code rh}, or
	 *                                  {@code req} is null or if the request object
	 *                                  type is invalid for the method.
	 * @throws NoSuchMethodException    If no method with the given
	 *                                  {@code methodName} is found.
	 */
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

	/**
	 * Creates a {@link RequestHeader} using the specified channel type and message
	 * reference number.
	 *
	 * @param channelType The type of the channel. Must not be null or empty.
	 * @param msgRefNo    The message reference number. Must not be null or empty.
	 * @return The created {@link RequestHeader}.
	 * @throws IllegalArgumentException If {@code channelType} or {@code msgRefNo}
	 *                                  is null or empty.
	 */
	public RequestHeader getHeader(final String channelType, final String msgRefNo) {
		if (ObjectUtils.isEmpty(channelType) || ObjectUtils.isEmpty(msgRefNo)) {
			throw new IllegalArgumentException("channelType and msgRefNo fields are required");
		}
		return RequestHeaderUtil.createHeader(channelType, msgRefNo);
	}

	/**
	 * Sends an echo request to the {@link NaradaApiServiceClient} and returns the
	 * response.
	 *
	 * @param echoRequest The echo request string. Must not be null or empty.
	 * @return The echo response from the service.
	 * @throws IllegalArgumentException If {@code echoRequest} is null or empty.
	 */
	public String echo(final String echoRequest) {
		if (ObjectUtils.isEmpty(echoRequest)) {
			throw new IllegalArgumentException("echoRequest field is required");
		}
		final NaradaApiServiceClient serviceClient = new NaradaApiServiceClient();
		return serviceClient.echo(echoRequest);
	}

	/**
	 * Issues a new card.
	 *
	 * @param rh  the request header
	 * @param req the request object containing details for issuing the card
	 * @return response containing the result of the new card issuance
	 */
	public NewCardResponse getNewCard(final RequestHeader rh, final NewCardRequest req) {
		return cardManagementService.issueNewCard(rh, req);
	}

	/**
	 * Retrieves card details.
	 *
	 * @param rh  the request header
	 * @param req the request object containing details for retrieving card
	 *            information
	 * @return response containing card details
	 */
	public CardDetailResponse getCardDetails(final RequestHeader rh, final CardDetailRequest req) {
		return cardManagementService.getCardDetail(rh, req);
	}

	/**
	 * Activates a card.
	 *
	 * @param rh  the request header
	 * @param req the request object containing details for activating the card
	 * @return response containing the result of the card activation
	 */
	public ActivateCardResponse activateCard(final RequestHeader rh, final ActivateCardRequest req) {
		return cardManagementService.acticateCard(rh, req);
	}

	/**
	 * Blocks, locks, or unlocks a card.
	 *
	 * @param rh  the request header
	 * @param req the request object containing details for blocking, locking, or
	 *            unlocking the card
	 * @return response containing the result of the operation
	 */
	public CardBlockOrUnblockRes blockLockUnlockCard(final RequestHeader rh, final CardBlockOrUnblockReq req) {
		return cardManagementService.blockOrUnblockCard(rh, req);
	}

	/**
	 * Replaces a card.
	 *
	 * @param rh  the request header
	 * @param req the request object containing details for replacing the card
	 * @return response containing the result of the card replacement
	 */
	public CardReplaceResponse replaceCard(final RequestHeader rh, final CardReplaceRequest req) {
		return cardManagementService.replaceCard(rh, req);
	}

	/**
	 * Updates customer details.
	 *
	 * @param rh  the request header
	 * @param req the request object containing customer details to be updated
	 * @return response containing the result of the update operation
	 */
	public UpdateCustomerResponse updateCustomerDetails(final RequestHeader rh, final UpdateCustomerRequest req) {
		return accountManagementService.updateCustomerDetails(rh, req);
	}

	/**
	 * Adds a new account.
	 *
	 * @param rh  the request header
	 * @param req the request object containing details for adding the account
	 * @return response containing the result of the account addition
	 */
	public AddAccountResponse addAccount(final RequestHeader rh, final AddAccountRequest req) {
		return accountManagementService.addAccount(rh, req);
	}

	/**
	 * Loads a card.
	 *
	 * @param rh  the request header
	 * @param req the request object containing details for loading the card
	 * @return response containing the result of the card load
	 */
	public LoadCardResponse loadCard(final RequestHeader rh, final LoadCardRequest req) {
		return cardManagementService.loadCard(rh, req);
	}

	/**
	 * Queries account balance.
	 *
	 * @param rh  the request header
	 * @param req the request object containing details for querying the balance
	 * @return response containing the account balance
	 */
	public QueryBalanceResponse queryBalance(final RequestHeader rh, final QueryBalanceRequest req) {
		return accountManagementService.queryBalance(rh, req);
	}

	/**
	 * Processes a refund.
	 *
	 * @param rh  the request header
	 * @param req the request object containing refund details
	 * @return response containing the result of the refund
	 */
	public RefundAmountResponse refundAmount(final RequestHeader rh, final RefundAmountRequest req) {
		return accountManagementService.refundAmount(rh, req);
	}

	/**
	 * Closes an account.
	 *
	 * @param rh  the request header
	 * @param req the request object containing details for account closure
	 * @return response containing the result of the account closure
	 */
	public AccountClosureResponse accountClosure(final RequestHeader rh, final AccountClosureRequest req) {
		return accountManagementService.accountClosure(rh, req);
	}

	/**
	 * Retrieves transactions based on a specific request.
	 *
	 * @param rh  the request header
	 * @param req the request object containing transaction request details
	 * @return response containing transaction details
	 */
	public XTransactionsResponse getXTransactions(final RequestHeader rh, final XTransactionsRequest req) {
		return cardManagementService.getXTransactions(rh, req);
	}

	/**
	 * Debits or credits an account.
	 *
	 * @param rh  the request header
	 * @param req the request object containing debit/credit details
	 * @return response containing the result of the debit/credit operation
	 */
	public DebitCreditAccountResponse debitCreditAccount(final RequestHeader rh, final DebitCreditAccountRequest req) {
		return accountManagementService.debitCreditAccount(rh, req);
	}

	/**
	 * Transfers funds between accounts.
	 *
	 * @param rh  the request header
	 * @param req the request object containing fund transfer details
	 * @return response containing the result of the fund transfer
	 */
	public FundTransferResponse fundTransfer(final RequestHeader rh, final FundTransferRequest req) {
		return accountManagementService.fundTransfer(rh, req);
	}

	/**
	 * Updates exchange rates.
	 *
	 * @param rh  the request header
	 * @param req the request object containing exchange rate details
	 * @return response containing the result of the exchange rate update
	 */
	public UpdateExchangeRateResponse updateExchangeRate(final RequestHeader rh, final UpdateExchangeRateRequest req) {
		return accountManagementService.updateExchangeRate(rh, req);
	}

	/**
	 * Places an order for a card.
	 *
	 * @param rh  the request header
	 * @param req the request object containing card order details
	 * @return response containing the result of the card order
	 */
	public CardOrderResponse cardOrder(final RequestHeader rh, final CardOrderRequest req) {
		return cardManagementService.cardOrder(rh, req);
	}

	/**
	 * Confirms card receipt.
	 *
	 * @param rh  the request header
	 * @param req the request object containing card receipt details
	 * @return response containing the result of the card receipt confirmation
	 */
	public CardReceiptResponse cardReceipt(final RequestHeader rh, final CardReceiptRequest req) {
		return cardManagementService.cardReceipt(rh, req);
	}

	/**
	 * Updates stock details.
	 *
	 * @param rh  the request header
	 * @param req the request object containing stock update details
	 * @return response containing the result of the stock update
	 */
	public UpdateStockDetailsResponse updateStockDetails(final RequestHeader rh, final UpdateStockDetailsRequest req) {
		return cardManagementService.updateStockDetails(rh, req);
	}

	/**
	 * Retrieves stock details.
	 *
	 * @param rh  the request header
	 * @param req the request object containing stock query details
	 * @return response containing stock details
	 */
	public StockDetailsResponse getStockDetails(final RequestHeader rh, final StockDetailsRequest req) {
		return cardManagementService.getStockDetails(rh, req);
	}

	/**
	 * Retrieves the status of a request.
	 *
	 * @param rh  the request header
	 * @param req the request object containing status request details
	 * @return response containing the status of the request
	 */
	public StatusResponse getStatusRequest(final RequestHeader rh, final StatusRequest req) {
		return cardManagementService.getStatusRequest(rh, req);
	}

	/**
	 * Creates a profile.
	 *
	 * @param rh  the request header
	 * @param req the request object containing profile creation details
	 * @return response containing the result of profile creation
	 */
	public ProfileCreationResponse createProfile(final RequestHeader rh, final ProfileCreationRequest req) {
		return accountManagementService.createProfile(rh, req);
	}

	/**
	 * Changes the user's password.
	 *
	 * @param rh  the request header
	 * @param req the request object containing password change details
	 * @return response containing the result of the password change
	 */
	public ChangePasswordResponse changePassword(final RequestHeader rh, final ChangePasswordRequest req) {
		return accountManagementService.changePassword(rh, req);
	}

	/**
	 * Retrieves access rights.
	 *
	 * @param rh  the request header
	 * @param req the request object containing access rights request details
	 * @return response containing the access rights information
	 */
	public AccessRightsResponse getAccessRights(final RequestHeader rh, final AccessRightsRequest req) {
		return accountManagementService.getAccessRights(rh, req);
	}

	/**
	 * Retrieves the ATM PIN.
	 *
	 * @param rh  the request header
	 * @param req the request object containing ATM PIN retrieval details
	 * @return response containing the ATM PIN
	 */
	public RetrievePinResponse retrieveATMPin(final RequestHeader rh, final RetrievePinRequest req) {
		return accountManagementService.retrieveATMPin(rh, req);
	}

	/**
	 * Verifies the ATM PIN.
	 *
	 * @param rh  the request header
	 * @param req the request object containing ATM PIN verification details
	 * @return response containing the result of ATM PIN verification
	 */
	public VerifyPinResponse verifyATMPin(final RequestHeader rh, final VerifyPinRequest req) {
		return accountManagementService.verifyATMPin(rh, req);
	}

	/**
	 * Changes the ATM PIN.
	 *
	 * @param rh  the request header
	 * @param req the request object containing ATM PIN change details
	 * @return response containing the result of the ATM PIN change
	 */
	public ChangePinResponse changeATMPin(final RequestHeader rh, final ChangePinRequest req) {
		return accountManagementService.changeATMPin(rh, req);
	}

	/**
	 * Assigns override settings.
	 *
	 * @param rh  the request header
	 * @param req the request object containing override settings details
	 * @return response containing the result of assigning override settings
	 */
	public OverrideSettingsResponse assignOverrideSettings(final RequestHeader rh, final OverrideSettingsRequest req) {
		return accountManagementService.assignOverrideSettings(rh, req);
	}

	/**
	 * Configures alert settings.
	 *
	 * @param rh  the request header
	 * @param req the request object containing alert settings details
	 * @return response containing the result of the alert settings configuration
	 */
	public AlertSettingsResponse alertSettings(final RequestHeader rh, final AlertSettingsRequest req) {
		return accountManagementService.alertSettings(rh, req);
	}

	/**
	 * Retrieves the card number.
	 *
	 * @param rh  the request header
	 * @param req the request object containing card number request details
	 * @return response containing the card number
	 */
	public CardNumberResponse getCardNumber(final RequestHeader rh, final CardNumberRequest req) {
		return cardManagementService.getCardNumber(rh, req);
	}

	/**
	 * Retrieves CSC enquiry details.
	 *
	 * @param rh  the request header
	 * @param req the request object containing CSC enquiry details
	 * @return response containing CSC enquiry information
	 */
	public CSCEnquiryResponse getCSCEnquiry(final RequestHeader rh, final CSCEnquiryRequest req) {
		return cardManagementService.getCSCEnquiry(rh, req);
	}

	/**
	 * Retrieves the status of a card order.
	 *
	 * @param rh  the request header
	 * @param req the request object containing card order status request details
	 * @return response containing the card order status
	 */
	public CardOrderStatusResponse getCardOrderStatus(final RequestHeader rh, final CardOrderStatusRequest req) {
		return cardManagementService.getCardOrderStatus(rh, req);
	}

	/**
	 * Sets the IVR PIN.
	 *
	 * @param rh  the request header
	 * @param req the request object containing IVR PIN set details
	 * @return response containing the result of setting the IVR PIN
	 */
	public SetPinResponse setIVRPin(final RequestHeader rh, final SetPinRequest req) {
		return cardManagementService.setIVRPin(rh, req);
	}

	/**
	 * Changes the IVR PIN.
	 *
	 * @param rh  the request header
	 * @param req the request object containing IVR PIN change details
	 * @return response containing the result of changing the IVR PIN
	 */
	public ChangeIvrPinResponse changeIVRPin(final RequestHeader rh, final ChangeIvrPinRequest req) {
		return cardManagementService.changeIVRPin(rh, req);
	}

	/**
	 * Validates the IVR PIN.
	 *
	 * @param rh  the request header
	 * @param req the request object containing IVR PIN validation details
	 * @return response containing the result of validating the IVR PIN
	 */
	public ValidatePinResponse validateIVRPin(final RequestHeader rh, final ValidatePinRequest req) {
		return cardManagementService.validateIVRPin(rh, req);
	}

	/**
	 * Resets the web password.
	 *
	 * @param rh  the request header
	 * @param req the request object containing password reset details
	 * @return response containing the result of the password reset
	 */
	public ResetPasswordResponse resetWebPassword(final RequestHeader rh, final ResetPasswordRequest req) {
		return accountManagementService.resetWebPassword(rh, req);
	}

	/**
	 * Sets the ATM PIN.
	 *
	 * @param rh  the request header
	 * @param req the request object containing ATM PIN set details
	 * @return response containing the result of setting the ATM PIN
	 */
	public SetAtmPinResponse setATMPin(final RequestHeader rh, final SetAtmPinRequest req) {
		return accountManagementService.setATMPin(rh, req);
	}

	/**
	 * Requests a new OTP.
	 *
	 * @param rh  the request header
	 * @param req the request object containing OTP request details
	 * @return response containing the result of the OTP request
	 */
	public OTPRequestResponse newOTPRequest(final RequestHeader rh, final OTPRequest req) {
		return accountManagementService.newOTPRequest(rh, req);
	}

	/**
	 * Validates the OTP.
	 *
	 * @param rh  the request header
	 * @param req the request object containing OTP validation details
	 * @return response containing the result of the OTP validation
	 */
	public OTPValidationResponse otpValidation(final RequestHeader rh, final OTPValidationRequest req) {
		return accountManagementService.otpValidation(rh, req);
	}

	/**
	 * Retrieves the web profile.
	 *
	 * @param rh  the request header
	 * @param req the request object containing web profile request details
	 * @return response containing the web profile
	 */
	public WebProfileResponse retrieveWebProfile(final RequestHeader rh, final WebProfileRequest req) {
		return accountManagementService.retrieveWebProfile(rh, req);
	}

	/**
	 * Registers a corporate entity.
	 *
	 * @param rh  the request header
	 * @param req the request object containing corporate registration details
	 * @return response containing the result of the corporate registration
	 */
	public CorporateRegistrationResponse corporateRegistration(final RequestHeader rh,
			final CorporateRegistrationRequest req) {
		return accountManagementService.corporateRegistration(rh, req);
	}

	/**
	 * Adds a new card request.
	 *
	 * @param rh  the request header
	 * @param req the request object containing card request details
	 * @return response containing the result of the card addition
	 */
	public AddCardResponse addCardRequest(final RequestHeader rh, final AddCardRequest req) {
		return cardManagementService.addCardRequest(rh, req);
	}

}
