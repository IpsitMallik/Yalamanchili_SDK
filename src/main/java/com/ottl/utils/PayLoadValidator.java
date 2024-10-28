package com.ottl.utils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import com.ottl.model.ActivateCardRequest;
import com.ottl.model.AddCardRequest;
import com.ottl.model.CSCEnquiryRequest;
import com.ottl.model.CardBlockOrUnblockReq;
import com.ottl.model.CardDetailRequest;
import com.ottl.model.CardNumberRequest;
import com.ottl.model.CardOrderRequest;
import com.ottl.model.CardOrderStatusRequest;
import com.ottl.model.CardReceiptRequest;
import com.ottl.model.CardReplaceRequest;
import com.ottl.model.ChangeIvrPinRequest;
import com.ottl.model.LoadCardRequest;
import com.ottl.model.NewCardRequest;
import com.ottl.model.NewCardRequest.CustomerInfo;
import com.ottl.model.NewCardRequest.LoadDetails;
import com.ottl.model.SetPinRequest;
import com.ottl.model.StatusRequest;
import com.ottl.model.StockDetailsRequest;
import com.ottl.model.UpdateStockDetailsRequest;
import com.ottl.model.ValidatePinRequest;
import com.ottl.model.XTransactionsRequest;
import com.ottl.soapclient.RequestHeader;
import com.ottl.model.NewCardRequest.CustomerInfo.IdentificationType;

/**
 * Represents a class to validate the request payloads.
 */
public class PayLoadValidator {
	private static final Pattern ACTIVATION_FLAG = Pattern.compile("^(Y|N)$");
	private static final Pattern MOBILE_NUMBER_PATTERN = Pattern.compile("^\\d+(-\\d+)*$");
	private static final Pattern EMAIL_PATTERN = Pattern.compile("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");
	private static final Pattern COUNT_PATTERN = Pattern.compile("^\\d{1,2}$");
	private static final Pattern QTY_PATTERN = Pattern.compile("^\\d+$");
	private static final String DATE_FORMAT = "ddMMyyyy";
	private static final String EXP_DATE_FORMAT = "MMyy";
	private static final String TIME_STAMP_FORMAT = "yyyyMMddHHmmss";
	private static final Pattern GENDER = Pattern.compile("^(M|F)$");
	private static final Pattern CARD_FLAG_PATTERN = Pattern.compile("^(S|A)$");
	private static final Pattern CURRENCY_PATTERN = Pattern.compile("^[A-Z]{3}$");
	private static final Pattern CARD_REPLACEMENT_TYPE = Pattern.compile("^(VP|PP)$");
	private static final List<String> FLAG_PATTERN = Arrays.asList("BL", "BS", "BD", "L", "UL");
	private static final List<String> API_KEYS = Arrays.asList("APNCRD", "APCRDR", "APXTXN", "APACCL", "APCRND",
			"APACBL", "APCHDT", "ACDSTS", "APCDAC", "APCDRP", "APUPCR", "APACAD", "APLCRD", "APFDTR", "APFREX",
			"APCROR", "APSTRC", "APSKUP", "APGTSD", "APSTRQ", "APRFCR", "ACHPSS", "APACRT", "APIPIR", "APIVER",
			"APICHG", "AOVRST", "APALTS", "APIGCN", "ACSENQ", "APCOST", "APIIVR", "APIIVC", "APIPNV", "APFORP",
			"APINST", "AFPOTP", "AVPOTP", "APUSPF", "ACRREG", "APNADC");

	/**
	 * Validates the RequestHeader object.
	 * 
	 * @param request The RequestHeader object to validate.
	 * @throws ValidationFailedException if validation fails.
	 */
	public static void requestHeaderPayLoad(RequestHeader header) throws ValidationFailedException {
		if (header == null) {
			throw new ValidationFailedException("RequestHeader cannot be null.");
		}

		ValidationUtil.validateField("ApiUserId", header.getApiUserId(), true, 1, 8);
		ValidationUtil.validateField("ApiPasswd", header.getApiPasswd(), true, 8, 100);
		ValidationUtil.validateEnumeration("ApiKey", header.getApiKey(), true, 6, 6, API_KEYS);
		ValidationUtil.validateField("ChannelType", header.getChannelType(), true, 3, 6);
		ValidationUtil.validateField("ClientId", header.getClientId(), true, 6, 6);
		ValidationUtil.validateField("MsgRefNo", header.getMsgRefNo(), true, 12, 16);
		ValidationUtil.validateDate("MsgTimeStamp", header.getMsgTimeStamp(), true, 14, 14, TIME_STAMP_FORMAT);
		ValidationUtil.validateField("SessionKey", header.getSessionKey(), false, -1, 100);
		ValidationUtil.validateField("Token", header.getToken(), false, -1, 100);
	}

	/**
	 * Validates the NewCardRequest object.
	 * 
	 * @param request The NewCardRequest object to validate.
	 * @throws ValidationFailedException if validation fails.
	 */
	public static void issueNewCardPayLoad(NewCardRequest request) throws ValidationFailedException {
		if (request == null) {
			throw new ValidationFailedException("Request cannot be null.");
		}

		ValidationUtil.validateField("TxnRefNo", request.getTxnRefNo(), true, 1, 32);
		ValidationUtil.validateField("ProxyNumber", request.getProxyNumber(), false, -1, 16);
		ValidationUtil.validateField("CustomerId", request.getCustomerId(), false, -1, 100);
		ValidationUtil.validateField("NameOnCard", request.getNameOnCard(), false, -1, 25);
		ValidationUtil.validateField("CardDesign", request.getCardDesign(), false, -1, 6);
		ValidationUtil.validatePattern("CardActivationFlag", request.getCardActivationFlag(), false, 1, 1,
				ACTIVATION_FLAG);
		validateCustomerInfo(request.getCustomerInfo());
		validateLoadDetails(request.getLoadDetails());
	}

	/**
	 * Validates the CardDetailRequest object.
	 * 
	 * @param request The CardDetailRequest object to validate.
	 * @throws ValidationFailedException if validation fails.
	 */
	public static void getCardDetailPayLoad(CardDetailRequest request) throws ValidationFailedException {
		if (request == null) {
			throw new ValidationFailedException("Request cannot be null.");
		}
		ValidationUtil.validateField("TxnRefNo", request.getTxnRefNo(), true, 1, 32);
		ValidationUtil.validateField("ProxyNumber", request.getProxyNumber(), true, 12, 16);
		ValidationUtil.validateField("CustomerId", request.getCustomerId(), false, 0, 100);
	}

	/**
	 * Validates the ActivateCardRequest object.
	 * 
	 * @param request The ActivateCardRequest object to validate.
	 * @throws ValidationFailedException if validation fails.
	 */
	public static void activateCardPayLoad(ActivateCardRequest request) throws ValidationFailedException {
		if (request == null) {
			throw new ValidationFailedException("Request cannot be null.");
		}
		ValidationUtil.validateField("TxnRefNo", request.getTxnRefNo(), true, 1, 32);
		ValidationUtil.validateField("ProxyNumber", request.getProxyNumber(), true, 12, 16);
		ValidationUtil.validateField("ActivationCode", request.getActivationCode(), false, 6, 6);
		ValidationUtil.validateField("CustomerId", request.getCustomerId(), false, 0, 100);
	}

	/**
	 * Validates the CardBlockOrUnblockReq object.
	 * 
	 * @param request The CardBlockOrUnblockReq object to validate.
	 * @throws ValidationFailedException if validation fails.
	 */
	public static void blockOrUnblockCardPayLoad(CardBlockOrUnblockReq request) {
		if (request == null) {
			throw new ValidationFailedException("Request cannot be null.");
		}
		ValidationUtil.validateField("TxnRefNo", request.getTxnRefNo(), true, 1, 32);
		ValidationUtil.validateField("ProxyNumber", request.getProxyNumber(), true, 12, 16);
		ValidationUtil.validateEnumeration("Flag", request.getFlag(), true, 1, 2, FLAG_PATTERN);
		ValidationUtil.validateField("Reason", request.getReason(), true, 1, 25);
	}

	/**
	 * Validates the CardReplaceRequest object.
	 * 
	 * @param request The CardReplaceRequest object to validate.
	 * @throws ValidationFailedException if validation fails.
	 */
	public static void replaceCardPayLoad(CardReplaceRequest request) throws ValidationFailedException {
		if (request == null) {
			throw new ValidationFailedException("Request cannot be null.");
		}
		ValidationUtil.validateField("TxnRefNo", request.getTxnRefNo(), true, 1, 32);
		ValidationUtil.validateField("ProxyNumber", request.getProxyNumber(), true, 12, 16);
		ValidationUtil.validateField("NewProxyNumber", request.getNewProxyNumber(), false, 12, 16);
		ValidationUtil.validateField("CustomerId", request.getCustomerId(), false, 0, 100);
		ValidationUtil.validatePattern("Type", request.getType(), true, 2, 2, CARD_REPLACEMENT_TYPE);
		ValidationUtil.validateField("CardDesign", request.getCardDesign(), false, 0, 6);
	}

	public static void loadCardPayLoad(LoadCardRequest request) throws ValidationFailedException {
		if (request == null) {
			throw new ValidationFailedException("Request cannot be null.");
		}

		ValidationUtil.validateField("TxnRefNo", request.getTxnRefNo(), true, 1, 32);
		ValidationUtil.validateField("ProxyNumber", request.getProxyNumber(), true, 12, 16);
		if (request.getProductInfo() != null) {
			ValidationUtil.validateField("ProductCode", request.getProductInfo().getProductCode(), true, 6, 6);
			ValidationUtil.validateField("LoadAmount", request.getProductInfo().getLoadAmount(), true, 1, 12);
			ValidationUtil.validateField("BillingAmount", request.getProductInfo().getBillingAmount(), true, 1, 12);
			ValidationUtil.validatePattern("LoadCurrency", request.getProductInfo().getLoadCurrency(), true, 3, 3,
					CURRENCY_PATTERN);
			ValidationUtil.validatePattern("BillingCurrency", request.getProductInfo().getBillingCurrency(), true, 3, 3,
					CURRENCY_PATTERN);
		}
	}

	public static void getXTransactionsPayLoad(XTransactionsRequest request) throws ValidationFailedException {
		if (request == null) {
			throw new ValidationFailedException("Request cannot be null.");
		}

		ValidationUtil.validateField("TxnRefNo", request.getTxnRefNo(), true, 1, 32);
		ValidationUtil.validateField("ProxyNumber", request.getProxyNumber(), true, 12, 16);
		ValidationUtil.validateField("FromDate", request.getFromDate(), true, 8, 8);
		ValidationUtil.validateField("ToDate", request.getToDate(), true, 8, 8);
		ValidationUtil.validatePattern("Count", request.getCount(), true, 1, 2, COUNT_PATTERN);
		ValidationUtil.validateField("PageNumber", request.getPageNumber(), false, 1, 2);
	}

	public static void cardOrderPayLoad(CardOrderRequest request) throws ValidationFailedException {
		if (request == null) {
			throw new ValidationFailedException("Request cannot be null.");
		}

		ValidationUtil.validateField("TxnRefNo", request.getTxnRefNo(), true, 1, 32);
		if (request.getOrder() != null) {
			ValidationUtil.validateField("BranchId", request.getOrder().getBranchId(), false, 8, 8);
			ValidationUtil.validateField("ProductCode", request.getOrder().getProductCode(), true, 6, 6);
			ValidationUtil.validateField("CardDesign", request.getOrder().getCardDesign(), true, 6, 6);
			ValidationUtil.validatePattern("Quantity", request.getOrder().getQuantity(), true, 1, 10,QTY_PATTERN);
			validateDelivery(request.getOrder().getDelivery());
		} else {
			throw new ValidationFailedException("Order is required.");
		}
	}

	public static void cardReceiptPayLoad(CardReceiptRequest request) throws ValidationFailedException {
		if (request == null) {
			throw new ValidationFailedException("Request cannot be null.");
		}

		ValidationUtil.validateField("TxnRefNo", request.getTxnRefNo(), true, 1, 32);
		if (request.getReceipt() != null) {
			ValidationUtil.validateField("OrderRefNo", request.getReceipt().getOrderRefNo(), true, 1, 10);
			ValidationUtil.validatePattern("Quantity", request.getReceipt().getQuantity(), true, 1, 10,QTY_PATTERN );
			ValidationUtil.validateField("FromPackNo", request.getReceipt().getFromPackNo(), true, 1, 12);
			ValidationUtil.validateField("ToPackNo", request.getReceipt().getToPackNo(), true, 1, 12);
		} else {
			throw new ValidationFailedException("Receipt details are required.");
		}
	}

	public static void updateStockDetailsPayLoad(UpdateStockDetailsRequest request) throws ValidationFailedException {
		if (request == null) {
			throw new ValidationFailedException("Request cannot be null.");
		}

		ValidationUtil.validateField("TxnRefNo", request.getTxnRefNo(), true, 1, 32);
		ValidationUtil.validateField("OrderRefNo", request.getOrderRefNo(), true, 1, 12);
		ValidationUtil.validateField("Quantity", request.getQuantity(), true, 1, 10);

		List<UpdateStockDetailsRequest.PackNo> refNumbers = request.getRefNumbers();
		if (refNumbers == null || refNumbers.isEmpty()) {
			throw new ValidationFailedException("At least one PackNo must be provided.");
		}
		for (UpdateStockDetailsRequest.PackNo packNo : refNumbers) {
			if (packNo == null || packNo.getPackNo() == null || packNo.getPackNo().isEmpty()) {
				throw new ValidationFailedException("Each PackNo must be provided.");
			}
			ValidationUtil.validateField("PackNo", packNo.getPackNo(), true, 12, 12);
		}
	}

	public static void getStockDetailsPayLoad(StockDetailsRequest request) throws ValidationFailedException {
		if (request == null) {
			throw new ValidationFailedException("Request cannot be null.");
		}

		ValidationUtil.validateField("TxnRefNo", request.getTxnRefNo(), true, 1, 32);
		ValidationUtil.validateField("BranchId", request.getBranchId(), true, 1, 20);
	}

	public static void getStatusRequestPayLoad(StatusRequest request) throws ValidationFailedException {
		if (request == null) {
			throw new ValidationFailedException("Request cannot be null.");
		}

		ValidationUtil.validateField("TxnRefNo", request.getTxnRefNo(), true, 1, 32);
	}

	public static void getCardNumberPayLoad(CardNumberRequest request) throws ValidationFailedException {
		if (request == null) {
			throw new ValidationFailedException("Request cannot be null.");
		}

		ValidationUtil.validateField("TxnRefNo", request.getTxnRefNo(), true, 1, 32);
		ValidationUtil.validateField("ProxyNumber", request.getProxyNumber(), true, 12, 16);

		ValidationUtil.validateField("Reftext1", request.getReftext1(), false, 0, 100);
		ValidationUtil.validateField("Reftext2", request.getReftext2(), false, 0, 100);
		ValidationUtil.validateField("Reftext3", request.getReftext3(), false, 0, 100);

	}

	public static void getCSCEnquiryPayLoad(CSCEnquiryRequest request) throws ValidationFailedException {
		if (request == null) {
			throw new ValidationFailedException("Request cannot be null.");
		}

		ValidationUtil.validateField("TxnRefNo", request.getTxnRefNo(), true, 1, 32);
		ValidationUtil.validateField("ProxyNumber", request.getProxyNumber(), true, 12, 16);
		ValidationUtil.validateDate("ExpiryDate", request.getExpiryDate(), true, 4, 4, EXP_DATE_FORMAT);

	}

	public static void getCardOrderStatusPayLoad(CardOrderStatusRequest request) throws ValidationFailedException {
		if (request == null) {
			throw new ValidationFailedException("Request cannot be null.");
		}

		ValidationUtil.validateField("TxnRefNo", request.getTxnRefNo(), true, 1, 32);
		ValidationUtil.validateField("InvoiceNo", request.getInvoiceNo(), true, 1, 13);

	}

	public static void setIVRPinPayLoad(SetPinRequest request) throws ValidationFailedException {
		if (request == null) {
			throw new ValidationFailedException("Request cannot be null.");
		}

		ValidationUtil.validateField("TxnRefNo", request.getTxnRefNo(), true, 1, 32);
		ValidationUtil.validateField("ProxyNumber", request.getProxyNumber(), true, 12, 16);
		ValidationUtil.validateField("IvrPin", request.getIvrPin(), true, 6, 6);
		ValidationUtil.validateDate("DOB", request.getDob(), true, 8, 8, DATE_FORMAT);

	}

	public static void changeIVRPinPayLoad(ChangeIvrPinRequest request) throws ValidationFailedException {
		if (request == null) {
			throw new ValidationFailedException("Request cannot be null.");
		}

		ValidationUtil.validateField("TxnRefNo", request.getTxnRefNo(), true, 1, 32);
		ValidationUtil.validateField("ProxyNumber", request.getProxyNumber(), true, 12, 16);
		ValidationUtil.validateField("OldIvrPin", request.getOldIvrPin(), true, 6, 6);
		ValidationUtil.validateField("NewIvrPin", request.getNewIvrPin(), true, 6, 6);

	}

	public static void validateIVRPinPayLoad(ValidatePinRequest request) throws ValidationFailedException {
		if (request == null) {
			throw new ValidationFailedException("Request cannot be null.");
		}

		ValidationUtil.validateField("TxnRefNo", request.getTxnRefNo(), true, 1, 32);
		ValidationUtil.validateField("ProxyNumber", request.getProxyNumber(), true, 12, 16);
		ValidationUtil.validateField("IvrPin", request.getIvrPin(), true, 6, 6);
		ValidationUtil.validateDate("DOB", request.getDob(), false, 8, 8, DATE_FORMAT);

	}

	public static void addCardRequestPayLoad(AddCardRequest request) throws ValidationFailedException {
		if (request == null) {
			throw new ValidationFailedException("Request cannot be null.");
		}

		ValidationUtil.validateField("TxnRefNo", request.getTxnRefNo(), true, 1, 32);
		ValidationUtil.validateField("ProxyNumber", request.getProxyNumber(), true, 1, 16);
		ValidationUtil.validateField("CustomerId", request.getCustomerId(), true, 1, 100);
		ValidationUtil.validatePattern("AddCardFlag", request.getAddCardFlag(), true, 1, 1, CARD_FLAG_PATTERN);

		if (request.getNewProxyNumber() != null) {
			ValidationUtil.validateField("NewProxyNumber", request.getNewProxyNumber(), false, 1, 16);
		}
		if (request.getNameOnCard() != null) {
			ValidationUtil.validateField("NameOnCard", request.getNameOnCard(), false, 0, 25);
		}
		if (request.getCardDesign() != null) {
			ValidationUtil.validateField("CardDesign", request.getCardDesign(), false, 0, 6);
		}
		if (request.getCardActivationFlag() != null) {
			ValidationUtil.validatePattern("CardActivationFlag", request.getCardActivationFlag(), false, 1, 1,
					ACTIVATION_FLAG);
		}
		if (request.getRefText1() != null) {
			ValidationUtil.validateField("RefText1", request.getRefText1(), false, 0, 32);
		}
		if (request.getRefText2() != null) {
			ValidationUtil.validateField("RefText2", request.getRefText2(), false, 0, 32);
		}
		if (request.getRefText3() != null) {
			ValidationUtil.validateField("RefText3", request.getRefText3(), false, 0, 32);
		}
		if (request.getRefText4() != null) {
			ValidationUtil.validateField("RefText4", request.getRefText4(), false, 0, 32);
		}

		if (request.getLoadDetails() != null) {
			ValidationUtil.validateField("ProductCode", request.getLoadDetails().getProductCode(), true, 6, 6);
			ValidationUtil.validateField("LoadAmount", request.getLoadDetails().getLoadAmount(), true, 1, 12);
			ValidationUtil.validateField("BillingAmount", request.getLoadDetails().getBillingAmount(), true, 1, 12);
			ValidationUtil.validatePattern("LoadCurrency", request.getLoadDetails().getLoadCurrency(), true, 3, 3,
					CURRENCY_PATTERN);
			ValidationUtil.validatePattern("BillingCurrency", request.getLoadDetails().getBillingCurrency(), true, 3, 3,
					CURRENCY_PATTERN);
		} else {
			throw new ValidationFailedException("LoadDetails is required.");
		}
	}

	private static void validateDelivery(CardOrderRequest.Order.Delivery delivery) throws ValidationFailedException {
		if (delivery == null) {
			return; // Delivery is optional
		}

		ValidationUtil.validateField("Name", delivery.getName(), true, 1, 50);
		ValidationUtil.validateField("Address1", delivery.getAddress1(), true, 1, 35);
		ValidationUtil.validateField("Address2", delivery.getAddress2(), true, 1, 35);
		ValidationUtil.validateField("Address3", delivery.getAddress3(), false, 1, 35);
		ValidationUtil.validateField("Address4", delivery.getAddress4(), false, 1, 35);
		ValidationUtil.validateField("City", delivery.getCity(), true, 1, 20);
		ValidationUtil.validateField("State", delivery.getState(), true, 1, 20);
		ValidationUtil.validateField("Country", delivery.getCountry(), true, 1, 20);
		ValidationUtil.validateField("PostalCode", delivery.getPostalCode(), true, 1, 15);
	}

	/**
	 * Validates the provided CustomerInfo object.
	 *
	 * @param customerInfo the CustomerInfo object to validate
	 * @throws ValidationFailedException if any validation check fails
	 */
	private static void validateCustomerInfo(CustomerInfo customerInfo) throws ValidationFailedException {
		if (customerInfo == null) {
			throw new ValidationFailedException("CustomerInfo cannot be null.");
		}

		ValidationUtil.validateField("Title", customerInfo.getTitle(), true, 1, 5);
		ValidationUtil.validateField("FirstName", customerInfo.getFirstName(), true, 1, 25);
		ValidationUtil.validateField("LastName", customerInfo.getLastName(), true, 1, 25);
		ValidationUtil.validateDate("DOB", customerInfo.getDob(), true, 8, 8, DATE_FORMAT);
		ValidationUtil.validatePattern("Gender", customerInfo.getGender(), true, 1, 1, GENDER);
		ValidationUtil.validatePattern("MobileNumber", customerInfo.getMobileNumber(), true, 10, 15,
				MOBILE_NUMBER_PATTERN);
		ValidationUtil.validatePattern("EmailAddress", customerInfo.getEmailAddress(), true, 1, 50, EMAIL_PATTERN);

		if (customerInfo.getAddress() != null) {
			ValidationUtil.validateField("Address1", customerInfo.getAddress().getAddress1(), true, 1, 35);
			ValidationUtil.validateField("Address2", customerInfo.getAddress().getAddress2(), true, 1, 35);
			ValidationUtil.validateField("City", customerInfo.getAddress().getCity(), true, 1, 20);
			ValidationUtil.validateField("State", customerInfo.getAddress().getState(), true, 1, 20);
			ValidationUtil.validateField("Country", customerInfo.getAddress().getCountry(), true, 1, 20);
			ValidationUtil.validateField("PostalCode", customerInfo.getAddress().getPostalCode(), true, 1, 15);
		} else {
			throw new ValidationFailedException("Address is required.");
		}

		if (customerInfo.getMailAddress() != null) {
			ValidationUtil.validateField("MailAddress Address1", customerInfo.getMailAddress().getAddress1(), true, 1,
					35);
			ValidationUtil.validateField("MailAddress Address2", customerInfo.getMailAddress().getAddress2(), true, 1,
					35);
			ValidationUtil.validateField("MailAddress City", customerInfo.getMailAddress().getCity(), true, 1, 20);
			ValidationUtil.validateField("MailAddress State", customerInfo.getMailAddress().getState(), true, 1, 20);
			ValidationUtil.validateField("MailAddress Country", customerInfo.getMailAddress().getCountry(), true, 1,
					20);
			ValidationUtil.validateField("MailAddress PostalCode", customerInfo.getMailAddress().getPostalCode(), true,
					1, 15);
		} else {
			throw new ValidationFailedException("MailAddress is required.");
		}

		if (customerInfo.getIdentificationType() != null) {
			for (IdentificationType idType : customerInfo.getIdentificationType()) {
				ValidationUtil.validateField("IDType", idType.getIdType(), true, 1, 25);
				ValidationUtil.validateField("IDNumber", idType.getIdNumber(), true, 1, 20);
				ValidationUtil.validateDate("ExpiryDate", idType.getExpiryDate(), false, 8, 8, DATE_FORMAT);
				ValidationUtil.validateField("CountryOfIssue", idType.getCountryOfIssue(), true, 1, 20);
			}
		} else {
			throw new ValidationFailedException("IdentificationTypes are required.");
		}
	}

	/**
	 * Validates the given LoadDetails object.
	 * 
	 * @param loadDetails The LoadDetails object to validate.
	 * @throws ValidationFailedException if validation fails.
	 */
	private static void validateLoadDetails(LoadDetails loadDetails) throws ValidationFailedException {
		if (loadDetails == null) {
			throw new ValidationFailedException("LoadDetails cannot be null.");
		}

		ValidationUtil.validateField("ProductCode", loadDetails.getProductCode(), true, 6, 6);
		ValidationUtil.validateField("LoadAmount", loadDetails.getLoadAmount(), true, 1, 12);
		ValidationUtil.validateField("BillingAmount", loadDetails.getBillingAmount(), true, 1, 12);
		ValidationUtil.validatePattern("LoadCurrency", loadDetails.getLoadCurrency(), true, 3, 3, CURRENCY_PATTERN);
		ValidationUtil.validatePattern("BillingCurrency", loadDetails.getBillingCurrency(), true, 3, 3,
				CURRENCY_PATTERN);
	}

}
