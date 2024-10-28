package com.ottl.sdk;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.apache.commons.lang3.ObjectUtils;

import com.ottl.service.AccountManagementService;
import com.ottl.service.CardManagementService;
import com.ottl.soapclient.NaradaApiServiceClient;
import com.ottl.soapclient.RequestHeader;
import com.ottl.utils.*;
import com.ottl.utils.NoSuchMethodException;

/**
 * The NaradaSystem class provides methods to interact with the Narada API
 * services, including operations related to card management and echo testing.
 */
public class NaradaSystem {

	private final CardManagementService cardManagementService = new CardManagementService();
	private final AccountManagementService accountManagementService = new AccountManagementService();

	// Map to hold method names and corresponding method references
	private final Map<String, BiFunction<RequestHeader, String, String>> methodMap = new HashMap<>();

	// Constructor to populate the method map
	public NaradaSystem() {
		// Populate the map with method names and corresponding method references
		methodMap.put("getNewCard", (rh, req) -> getNewCard(rh, req));
		methodMap.put("getCardDetails", (rh, req) -> getCardDetails(rh, req));
		methodMap.put("activateCard", (rh, req) -> activateCard(rh, req));
		methodMap.put("blockLockUnlockCard", (rh, req) -> blockLockUnlockCard(rh, req));
		methodMap.put("replaceCard", (rh, req) -> replaceCard(rh, req));
		methodMap.put("updateCustomerDetails", (rh, req) -> updateCustomerDetails(rh, req));
		methodMap.put("addAccount", (rh, req) -> addAccount(rh, req));
		methodMap.put("loadCard", (rh, req) -> loadCard(rh, req));
		methodMap.put("queryBalance", (rh, req) -> queryBalance(rh, req));
		methodMap.put("refundAmount", (rh, req) -> refundAmount(rh, req));
		methodMap.put("accountClosure", (rh, req) -> accountClosure(rh, req));
		methodMap.put("getXTransactions", (rh, req) -> getXTransactions(rh, req));
		methodMap.put("debitCreditAccount", (rh, req) -> debitCreditAccount(rh, req));
		methodMap.put("fundTransfer", (rh, req) -> fundTransfer(rh, req));
		methodMap.put("updateExchangeRate", (rh, req) -> updateExchangeRate(rh, req));
		methodMap.put("cardOrder", (rh, req) -> cardOrder(rh, req));
		methodMap.put("cardReceipt", (rh, req) -> cardReceipt(rh, req));
		methodMap.put("updateStockDetails", (rh, req) -> updateStockDetails(rh, req));
		methodMap.put("getStockDetails", (rh, req) -> getStockDetails(rh, req));
		methodMap.put("getStatusRequest", (rh, req) -> getStatusRequest(rh, req));
		methodMap.put("createProfile", (rh, req) -> createProfile(rh, req));
		methodMap.put("changePassword", (rh, req) -> changePassword(rh, req));
		methodMap.put("getAccessRights", (rh, req) -> getAccessRights(rh, req));
		methodMap.put("retrieveATMPin", (rh, req) -> retrieveATMPin(rh, req));
		methodMap.put("verifyATMPin", (rh, req) -> verifyATMPin(rh, req));
		methodMap.put("changeATMPin", (rh, req) -> changeATMPin(rh, req));
		methodMap.put("assignOverrideSettings", (rh, req) -> assignOverrideSettings(rh, req));
		methodMap.put("alertSettings", (rh, req) -> alertSettings(rh, req));
		methodMap.put("getCardNumber", (rh, req) -> getCardNumber(rh, req));
		methodMap.put("getCSCEnquiry", (rh, req) -> getCSCEnquiry(rh, req));
		methodMap.put("getCardOrderStatus", (rh, req) -> getCardOrderStatus(rh, req));
		methodMap.put("setIVRPin", (rh, req) -> setIVRPin(rh, req));
		methodMap.put("changeIVRPin", (rh, req) -> changeIVRPin(rh, req));
		methodMap.put("validateIVRPin", (rh, req) -> validateIVRPin(rh, req));
		methodMap.put("resetWebPassword", (rh, req) -> resetWebPassword(rh, req));
		methodMap.put("setATMPin", (rh, req) -> setATMPin(rh, req));
		methodMap.put("newOTPRequest", (rh, req) -> newOTPRequest(rh, req));
		methodMap.put("otpValidation", (rh, req) -> otpValidation(rh, req));
		methodMap.put("retrieveWebProfile", (rh, req) -> retrieveWebProfile(rh, req));
		methodMap.put("corporateRegistration", (rh, req) -> corporateRegistration(rh, req));
		methodMap.put("addCardRequest", (rh, req) -> addCardRequest(rh, req));
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
	public String invokeServiceMethod(String methodName, RequestHeader rh, String req) throws NoSuchMethodException {
		if (ObjectUtils.isEmpty(methodName)) {
		    throw new IllegalArgumentException("Method name is required.");
		}
		if (rh == null) {
		    throw new IllegalArgumentException("RequestHeader is required.");
		}
		if (req == null || ObjectUtils.isEmpty(req)) {
		    throw new IllegalArgumentException("Request is required.");
		}

		BiFunction<RequestHeader, String, String> method = methodMap.get(methodName);

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
	public String getNewCard(final RequestHeader rh, final String req) {
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
	public String getCardDetails(final RequestHeader rh, final String req) {
		return cardManagementService.getCardDetail(rh, req);
	}

	/**
	 * Activates a card.
	 *
	 * @param rh  the request header
	 * @param req the request object containing details for activating the card
	 * @return response containing the result of the card activation
	 */
	public String activateCard(final RequestHeader rh, final String req) {
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
	public String blockLockUnlockCard(final RequestHeader rh, final String req) {
		return cardManagementService.blockOrUnblockCard(rh, req);
	}

	/**
	 * Replaces a card.
	 *
	 * @param rh  the request header
	 * @param req the request object containing details for replacing the card
	 * @return response containing the result of the card replacement
	 */
	public String replaceCard(final RequestHeader rh, final String req) {
		return cardManagementService.replaceCard(rh, req);
	}

	/**
	 * Updates customer details.
	 *
	 * @param rh  the request header
	 * @param req the request object containing customer details to be updated
	 * @return response containing the result of the update operation
	 */
	public String updateCustomerDetails(final RequestHeader rh, final String req) {
		return accountManagementService.updateCustomerDetails(rh, req);
	}

	/**
	 * Adds a new account.
	 *
	 * @param rh  the request header
	 * @param req the request object containing details for adding the account
	 * @return response containing the result of the account addition
	 */
	public String addAccount(final RequestHeader rh, final String req) {
		return accountManagementService.addAccount(rh, req);
	}

	/**
	 * Loads a card.
	 *
	 * @param rh  the request header
	 * @param req the request object containing details for loading the card
	 * @return response containing the result of the card load
	 */
	public String loadCard(final RequestHeader rh, final String req) {
		return cardManagementService.loadCard(rh, req);
	}

	/**
	 * Queries account balance.
	 *
	 * @param rh  the request header
	 * @param req the request object containing details for querying the balance
	 * @return response containing the account balance
	 */
	public String queryBalance(final RequestHeader rh, final String req) {
		return accountManagementService.queryBalance(rh, req);
	}

	/**
	 * Processes a refund.
	 *
	 * @param rh  the request header
	 * @param req the request object containing refund details
	 * @return response containing the result of the refund
	 */
	public String refundAmount(final RequestHeader rh, final String req) {
		return accountManagementService.refundAmount(rh, req);
	}

	/**
	 * Closes an account.
	 *
	 * @param rh  the request header
	 * @param req the request object containing details for account closure
	 * @return response containing the result of the account closure
	 */
	public String accountClosure(final RequestHeader rh, final String req) {
		return accountManagementService.accountClosure(rh, req);
	}

	/**
	 * Retrieves transactions based on a specific request.
	 *
	 * @param rh  the request header
	 * @param req the request object containing transaction request details
	 * @return response containing transaction details
	 */
	public String getXTransactions(final RequestHeader rh, final String req) {
		return cardManagementService.getXTransactions(rh, req);
	}

	/**
	 * Debits or credits an account.
	 *
	 * @param rh  the request header
	 * @param req the request object containing debit/credit details
	 * @return response containing the result of the debit/credit operation
	 */
	public String debitCreditAccount(final RequestHeader rh, final String req) {
		return accountManagementService.debitCreditAccount(rh, req);
	}

	/**
	 * Transfers funds between accounts.
	 *
	 * @param rh  the request header
	 * @param req the request object containing fund transfer details
	 * @return response containing the result of the fund transfer
	 */
	public String fundTransfer(final RequestHeader rh, final String req) {
		return accountManagementService.fundTransfer(rh, req);
	}

	/**
	 * Updates exchange rates.
	 *
	 * @param rh  the request header
	 * @param req the request object containing exchange rate details
	 * @return response containing the result of the exchange rate update
	 */
	public String updateExchangeRate(final RequestHeader rh, final String req) {
		return accountManagementService.updateExchangeRate(rh, req);
	}

	/**
	 * Places an order for a card.
	 *
	 * @param rh  the request header
	 * @param req the request object containing card order details
	 * @return response containing the result of the card order
	 */
	public String cardOrder(final RequestHeader rh, final String req) {
		return cardManagementService.cardOrder(rh, req);
	}

	/**
	 * Confirms card receipt.
	 *
	 * @param rh  the request header
	 * @param req the request object containing card receipt details
	 * @return response containing the result of the card receipt confirmation
	 */
	public String cardReceipt(final RequestHeader rh, final String req) {
		return cardManagementService.cardReceipt(rh, req);
	}

	/**
	 * Updates stock details.
	 *
	 * @param rh  the request header
	 * @param req the request object containing stock update details
	 * @return response containing the result of the stock update
	 */
	public String updateStockDetails(final RequestHeader rh, final String req) {
		return cardManagementService.updateStockDetails(rh, req);
	}

	/**
	 * Retrieves stock details.
	 *
	 * @param rh  the request header
	 * @param req the request object containing stock query details
	 * @return response containing stock details
	 */
	public String getStockDetails(final RequestHeader rh, final String req) {
		return cardManagementService.getStockDetails(rh, req);
	}

	/**
	 * Retrieves the status of a request.
	 *
	 * @param rh  the request header
	 * @param req the request object containing status request details
	 * @return response containing the status of the request
	 */
	public String getStatusRequest(final RequestHeader rh, final String req) {
		return cardManagementService.getStatusRequest(rh, req);
	}

	/**
	 * Creates a profile.
	 *
	 * @param rh  the request header
	 * @param req the request object containing profile creation details
	 * @return response containing the result of profile creation
	 */
	public String createProfile(final RequestHeader rh, final String req) {
		return accountManagementService.createProfile(rh, req);
	}

	/**
	 * Changes the user's password.
	 *
	 * @param rh  the request header
	 * @param req the request object containing password change details
	 * @return response containing the result of the password change
	 */
	public String changePassword(final RequestHeader rh, final String req) {
		return accountManagementService.changePassword(rh, req);
	}

	/**
	 * Retrieves access rights.
	 *
	 * @param rh  the request header
	 * @param req the request object containing access rights request details
	 * @return response containing the access rights information
	 */
	public String getAccessRights(final RequestHeader rh, final String req) {
		return accountManagementService.getAccessRights(rh, req);
	}

	/**
	 * Retrieves the ATM PIN.
	 *
	 * @param rh  the request header
	 * @param req the request object containing ATM PIN retrieval details
	 * @return response containing the ATM PIN
	 */
	public String retrieveATMPin(final RequestHeader rh, final String req) {
		return accountManagementService.retrieveATMPin(rh, req);
	}

	/**
	 * Verifies the ATM PIN.
	 *
	 * @param rh  the request header
	 * @param req the request object containing ATM PIN verification details
	 * @return response containing the result of ATM PIN verification
	 */
	public String verifyATMPin(final RequestHeader rh, final String req) {
		return accountManagementService.verifyATMPin(rh, req);
	}

	/**
	 * Changes the ATM PIN.
	 *
	 * @param rh  the request header
	 * @param req the request object containing ATM PIN change details
	 * @return response containing the result of the ATM PIN change
	 */
	public String changeATMPin(final RequestHeader rh, final String req) {
		return accountManagementService.changeATMPin(rh, req);
	}

	/**
	 * Assigns override settings.
	 *
	 * @param rh  the request header
	 * @param req the request object containing override settings details
	 * @return response containing the result of assigning override settings
	 */
	public String assignOverrideSettings(final RequestHeader rh, final String req) {
		return accountManagementService.assignOverrideSettings(rh, req);
	}

	/**
	 * Configures alert settings.
	 *
	 * @param rh  the request header
	 * @param req the request object containing alert settings details
	 * @return response containing the result of the alert settings configuration
	 */
	public String alertSettings(final RequestHeader rh, final String req) {
		return accountManagementService.alertSettings(rh, req);
	}

	/**
	 * Retrieves the card number.
	 *
	 * @param rh  the request header
	 * @param req the request object containing card number request details
	 * @return response containing the card number
	 */
	public String getCardNumber(final RequestHeader rh, final String req) {
		return cardManagementService.getCardNumber(rh, req);
	}

	/**
	 * Retrieves CSC enquiry details.
	 *
	 * @param rh  the request header
	 * @param req the request object containing CSC enquiry details
	 * @return response containing CSC enquiry information
	 */
	public String getCSCEnquiry(final RequestHeader rh, final String req) {
		return cardManagementService.getCSCEnquiry(rh, req);
	}

	/**
	 * Retrieves the status of a card order.
	 *
	 * @param rh  the request header
	 * @param req the request object containing card order status request details
	 * @return response containing the card order status
	 */
	public String getCardOrderStatus(final RequestHeader rh, final String req) {
		return cardManagementService.getCardOrderStatus(rh, req);
	}

	/**
	 * Sets the IVR PIN.
	 *
	 * @param rh  the request header
	 * @param req the request object containing IVR PIN set details
	 * @return response containing the result of setting the IVR PIN
	 */
	public String setIVRPin(final RequestHeader rh, final String req) {
		return cardManagementService.setIVRPin(rh, req);
	}

	/**
	 * Changes the IVR PIN.
	 *
	 * @param rh  the request header
	 * @param req the request object containing IVR PIN change details
	 * @return response containing the result of changing the IVR PIN
	 */
	public String changeIVRPin(final RequestHeader rh, final String req) {
		return cardManagementService.changeIVRPin(rh, req);
	}

	/**
	 * Validates the IVR PIN.
	 *
	 * @param rh  the request header
	 * @param req the request object containing IVR PIN validation details
	 * @return response containing the result of validating the IVR PIN
	 */
	public String validateIVRPin(final RequestHeader rh, final String req) {
		return cardManagementService.validateIVRPin(rh, req);
	}

	/**
	 * Resets the web password.
	 *
	 * @param rh  the request header
	 * @param req the request object containing password reset details
	 * @return response containing the result of the password reset
	 */
	public String resetWebPassword(final RequestHeader rh, final String req) {
		return accountManagementService.resetWebPassword(rh, req);
	}

	/**
	 * Sets the ATM PIN.
	 *
	 * @param rh  the request header
	 * @param req the request object containing ATM PIN set details
	 * @return response containing the result of setting the ATM PIN
	 */
	public String setATMPin(final RequestHeader rh, final String req) {
		return accountManagementService.setATMPin(rh, req);
	}

	/**
	 * Requests a new OTP.
	 *
	 * @param rh  the request header
	 * @param req the request object containing OTP request details
	 * @return response containing the result of the OTP request
	 */
	public String newOTPRequest(final RequestHeader rh, final String req) {
		return accountManagementService.newOTPRequest(rh, req);
	}

	/**
	 * Validates the OTP.
	 *
	 * @param rh  the request header
	 * @param req the request object containing OTP validation details
	 * @return response containing the result of the OTP validation
	 */
	public String otpValidation(final RequestHeader rh, final String req) {
		return accountManagementService.otpValidation(rh, req);
	}

	/**
	 * Retrieves the web profile.
	 *
	 * @param rh  the request header
	 * @param req the request object containing web profile request details
	 * @return response containing the web profile
	 */
	public String retrieveWebProfile(final RequestHeader rh, final String req) {
		return accountManagementService.retrieveWebProfile(rh, req);
	}

	/**
	 * Registers a corporate entity.
	 *
	 * @param rh  the request header
	 * @param req the request object containing corporate registration details
	 * @return response containing the result of the corporate registration
	 */
	public String corporateRegistration(final RequestHeader rh, final String req) {
		return accountManagementService.corporateRegistration(rh, req);
	}

	/**
	 * Adds a new card request.
	 *
	 * @param rh  the request header
	 * @param req the request object containing card request details
	 * @return response containing the result of the card addition
	 */
	public String addCardRequest(final RequestHeader rh, final String req) {
		return cardManagementService.addCardRequest(rh, req);
	}

}
