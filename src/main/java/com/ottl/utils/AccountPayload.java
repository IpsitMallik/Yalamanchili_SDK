package com.ottl.utils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import com.ottl.model.AccessRightsRequest;
import com.ottl.model.AccountClosureRequest;
import com.ottl.model.AddAccountRequest;
import com.ottl.model.AddAccountRequest.ProductInfo.Details;
import com.ottl.model.AlertSettingsRequest;
import com.ottl.model.ChangePasswordRequest;
import com.ottl.model.ChangePinRequest;
import com.ottl.model.CorporateRegistrationRequest;
import com.ottl.model.CorporateRegistrationRequest.Corporate.Branch;
import com.ottl.model.CorporateRegistrationRequest.Corporate.Branch.ContactDetails;
import com.ottl.model.DebitCreditAccountRequest;
import com.ottl.model.FundTransferRequest;
import com.ottl.model.OTPRequest;
import com.ottl.model.OTPValidationRequest;
import com.ottl.model.OverrideSettingsRequest;
import com.ottl.model.ProfileCreationRequest;
import com.ottl.model.QueryBalanceRequest;
import com.ottl.model.RefundAmountRequest;
import com.ottl.model.ResetPasswordRequest;
import com.ottl.model.RetrievePinRequest;
import com.ottl.model.SetAtmPinRequest;
import com.ottl.model.UpdateCustomerRequest;
import com.ottl.model.UpdateCustomerRequest.CustomerInfo;
import com.ottl.model.UpdateCustomerRequest.CustomerInfo.IdentificationType;
import com.ottl.model.UpdateExchangeRateRequest;
import com.ottl.model.VerifyPinRequest;
import com.ottl.model.WebProfileRequest;
import com.ottl.model.UpdateExchangeRateRequest.Detail;

public class AccountPayload {
	private static final Pattern MOBILE_NUMBER_PATTERN = Pattern.compile("^\\+\\d{1,3}\\d{4,14}$");
	private static final Pattern EMAIL_PATTERN = Pattern.compile("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");
	private static final String DATE_FORMAT = "ddMMyyyy";
	private static final Pattern CURRENCY_PATTERN = Pattern.compile("^[A-Z]{3}$");
	private static final Pattern AMOUNT_PATTERN = Pattern.compile("^\\d+(\\.\\d{1,2})?$");
	private static final Pattern ATM_EPINBLOCK = Pattern.compile("^[0-9A-Fa-f]{16}$");
	private static final Pattern GENDER = Pattern.compile("^(M|F)$");
	private static final String EXP_DATE_FORMAT = "MMyy";
	private static final Pattern YN_FLAG = Pattern.compile("^(Y|N)$");
	private static final List<String> FLAG_PATTERN = Arrays.asList("DR", "CR");
	private static final List<String> TYPE_PATTERN = Arrays.asList("BAT", "FEE");
	private static final List<String> ALERT_TYPES = Arrays.asList("ATMCWD", "PURCSE", "LOWBAL", "TOPACC");
	private static final List<String> FREQUENCY_TYPES = Arrays.asList("DLY", "WLY", "MLY", "YLY", "TXN");
	private static final List<String> CHANNEL_TYPES = Arrays.asList("SMS", "EMAIL", "BOTH");
	private static final List<String> INVOICE_LEVELS = Arrays.asList("ENT", "COR", "BRN");
	private static final List<String> TITLES = Arrays.asList("Dr", "Mr", "Ms", "Univ", "Prof");

	public static void updateCustomerPayLoad(UpdateCustomerRequest request) throws ValidationFailedException {
		if (request == null) {
			throw new ValidationFailedException("Request cannot be null.");
		}

		ValidationUtil.validateField("TxnRefNo", request.getTxnRefNo(), true, 1, 32);
		ValidationUtil.validateField("ProxyNumber", request.getProxyNumber(), true, 12, 16);
		validateCustomerInfo(request.getCustomerInfo());

	}

	public static void addAccountPayLoad(AddAccountRequest request) throws ValidationFailedException {
		if (request == null) {
			throw new ValidationFailedException("Request cannot be null.");
		}
		ValidationUtil.validateField("TxnRefNo", request.getTxnRefNo(), true, 1, 32);
		ValidationUtil.validateField("ProxyNumber", request.getProxyNumber(), true, 12, 16);

		if (request.getProductInfo().getDetails() != null) {
			Details details = request.getProductInfo().getDetails();
			ValidationUtil.validateField("ProductCode", details.getProductCode(), true, 1, 6);
			ValidationUtil.validateField("LoadAmount", details.getLoadAmount(), true, 1, 12);
			ValidationUtil.validateField("BillingAmount", details.getBillingAmount(), true, 1, 12);
			ValidationUtil.validatePattern("LoadCurrency", details.getLoadCurrency(), true, 3, 3, CURRENCY_PATTERN);
			ValidationUtil.validatePattern("BillingCurrency", details.getBillingCurrency(), true, 3, 3,
					CURRENCY_PATTERN);
		} else {
			throw new ValidationFailedException("Details must be provided.");
		}
	}

	public static void queryBalancePayLoad(QueryBalanceRequest request) throws ValidationFailedException {
		if (request == null) {
			throw new ValidationFailedException("Request cannot be null.");
		}
		ValidationUtil.validateField("TxnRefNo", request.getTxnRefNo(), true, 1, 32);
		ValidationUtil.validateField("ProxyNumber", request.getProxyNumber(), true, 12, 16);

	}

	public static void refundAmountPayLoad(RefundAmountRequest request) throws ValidationFailedException {
		if (request == null) {
			throw new ValidationFailedException("Request cannot be null.");
		}
		ValidationUtil.validateField("TxnRefNo", request.getTxnRefNo(), true, 1, 32);
		ValidationUtil.validateField("ProxyNumber", request.getProxyNumber(), true, 12, 16);
		ValidationUtil.validateField("ProductCode", request.getProductCode(), true, 6, 6);
		ValidationUtil.validateField("Amount", request.getAmount(), true, 1, 12);
		ValidationUtil.validateField("RequestType", request.getRequestType(), true, 1, 12);
	}

	public static void accountClosurePayLoad(AccountClosureRequest request) throws ValidationFailedException {
		if (request == null) {
			throw new ValidationFailedException("Request cannot be null.");
		}
		ValidationUtil.validateField("TxnRefNo", request.getTxnRefNo(), true, 1, 32);
		ValidationUtil.validateField("ProxyNumber", request.getProxyNumber(), true, 12, 16);
		ValidationUtil.validateField("ProductCode", request.getProductCode(), true, 6, 6);
	}

	public static void createProfilePayLoad(ProfileCreationRequest request) throws ValidationFailedException {
		if (request == null) {
			throw new ValidationFailedException("Request cannot be null.");
		}
		ValidationUtil.validateField("TxnRefNo", request.getTxnRefNo(), true, 12, 32);
		ValidationUtil.validateField("ProxyNumber", request.getProxyNumber(), true, 12, 16);
		ValidationUtil.validateField("UserId", request.getUserId(), true, 8, 8);
		ValidationUtil.validateField("Password", request.getPassword(), true, 8, 16);

		if (request.getEmailId() != null) {
			ValidationUtil.validateField("EmailId", request.getEmailId(), false, 0, 50);
		}

		if (request.getMobileNumber() != null) {
			ValidationUtil.validateField("MobileNumber", request.getMobileNumber(), false, 0, 15);
		}
	}

	public static void changePasswordPayLoad(ChangePasswordRequest request) throws ValidationFailedException {
		if (request == null) {
			throw new ValidationFailedException("Request cannot be null.");
		}

		ValidationUtil.validateField("TxnRefNo", request.getTxnRefNo(), true, 12, 12);
		ValidationUtil.validateField("OldPassword", request.getOldPassword(), true, 8, 16);
		ValidationUtil.validateField("NewPassword", request.getNewPassword(), true, 8, 16);
	}

	public static void getAccessRightsPayLoad(AccessRightsRequest request) throws ValidationFailedException {
		if (request == null) {
			throw new ValidationFailedException("Request cannot be null.");
		}

		ValidationUtil.validateField("TxnRefNo", request.getTxnRefNo(), true, 32, 32);
		ValidationUtil.validateField("UserId", request.getUserId(), true, 8, 8);
	}

	public static void debitCreditAccountPayLoad(DebitCreditAccountRequest request) throws ValidationFailedException {
		if (request == null) {
			throw new ValidationFailedException("Request cannot be null.");
		}
		ValidationUtil.validateField("TxnRefNo", request.getTxnRefNo(), true, 12, 32);
		ValidationUtil.validateField("ProxyNumber", request.getProxyNumber(), true, 12, 16);
		ValidationUtil.validateField("ProductCode", request.getProductCode(), true, 6, 6);
		ValidationUtil.validateEnumeration("Type", request.getType(), true, 3, 3, TYPE_PATTERN);
		ValidationUtil.validateEnumeration("Flag", request.getFlag(), true, 2, 2, FLAG_PATTERN);
		ValidationUtil.validatePattern("Amount", request.getAmount(), true, 12, 12, AMOUNT_PATTERN);
		ValidationUtil.validatePattern("Currency", request.getCurrency(), true, 3, 3, CURRENCY_PATTERN);
		ValidationUtil.validateField("Remarks", request.getRemarks(), true, 1, 250);
	}

	public static void fundTransferPayLoad(FundTransferRequest request) throws ValidationFailedException {
		if (request == null) {
			throw new ValidationFailedException("Request cannot be null.");
		}
		ValidationUtil.validateField("TxnRefNo", request.getTxnRefNo(), true, 12, 32);
		ValidationUtil.validateField("ExchangeRate", request.getExchangeRate(), false, 0, 12);

		if (request.getSourceAccount() != null) {
			ValidationUtil.validateField("SourceAccount ProxyNumber", request.getSourceAccount().getProxyNumber(), true,
					12, 16);
			ValidationUtil.validateField("SourceAccount ProductCode", request.getSourceAccount().getProductCode(), true,
					6, 6);
			ValidationUtil.validatePattern("SourceAccount AccountCcy", request.getSourceAccount().getAccountCcy(), true,
					3, 3, CURRENCY_PATTERN);
		} else {
			throw new ValidationFailedException("SourceAccount is required.");
		}

		if (request.getDestAccount() != null) {
			ValidationUtil.validateField("DestAccount ProxyNumber", request.getDestAccount().getProxyNumber(), true, 12,
					16);
			ValidationUtil.validateField("DestAccount ProductCode", request.getDestAccount().getProductCode(), true, 6,
					6);
			ValidationUtil.validatePattern("DestAccount AccountCcy", request.getDestAccount().getAccountCcy(), true, 3,
					3, CURRENCY_PATTERN);
			ValidationUtil.validateField("DestAccount Amount", request.getDestAccount().getAmount(), true, 12, 12);
		} else {
			throw new ValidationFailedException("DestAccount is required.");
		}

	}

	public static void updateExchangeRatePayLoad(UpdateExchangeRateRequest request) throws ValidationFailedException {
		if (request == null) {
			throw new ValidationFailedException("Request cannot be null.");
		}
		ValidationUtil.validateField("TxnRefNo", request.getTxnRefNo(), true, 12, 32);
		if (request.getExRates() == null || request.getExRates().isEmpty()) {
			throw new ValidationFailedException("At least one ExRates/Detail must be provided.");
		}

		for (Detail detail : request.getExRates()) {
			ValidationUtil.validatePattern("BuyCurrency", detail.getBuyCurrency(), true, 3, 3, CURRENCY_PATTERN);
			ValidationUtil.validatePattern("SellCurrency", detail.getSellCurrency(), true, 3, 3, CURRENCY_PATTERN);
			ValidationUtil.validateField("ExRate", detail.getExRate(), true, 0, 12);
		}
	}

	public static void retrieveATMPinPayLoad(RetrievePinRequest request) throws ValidationFailedException {
		if (request == null) {
			throw new ValidationFailedException("Request cannot be null.");
		}

		ValidationUtil.validateField("TxnRefNo", request.getTxnRefNo(), true, 12, 32);
		ValidationUtil.validateField("ProxyNumber", request.getProxyNumber(), true, 12, 16);
		ValidationUtil.validateDate("ExpiryDate", request.getExpiryDate(), true, 4, 4, EXP_DATE_FORMAT);
		ValidationUtil.validateField("CVV2", request.getCvv2(), true, 3, 3);
		ValidationUtil.validateDate("DOB", request.getDob(), true, 8, 8, DATE_FORMAT);
	}

	public static void verifyATMPinPayLoad(VerifyPinRequest request) throws ValidationFailedException {
		if (request == null) {
			throw new ValidationFailedException("Request cannot be null.");
		}

		ValidationUtil.validateField("TxnRefNo", request.getTxnRefNo(), true, 12, 32);
		ValidationUtil.validateField("ProxyNumber", request.getProxyNumber(), true, 12, 16);
		ValidationUtil.validatePattern("EPinBlock", request.getEPinBlock(), true, 16, 16, ATM_EPINBLOCK);
		ValidationUtil.validateDate("DOB", request.getDob(), true, 8, 8, DATE_FORMAT);
	}

	public static void changeATMPinPayLoad(ChangePinRequest request) throws ValidationFailedException {
		if (request == null) {
			throw new ValidationFailedException("Request cannot be null.");
		}

		ValidationUtil.validateField("TxnRefNo", request.getTxnRefNo(), true, 12, 32);
		ValidationUtil.validateField("ProxyNumber", request.getProxyNumber(), true, 12, 16);
		ValidationUtil.validatePattern("EoldPinBlock", request.getEOldPinBlock(), true, 16, 16, ATM_EPINBLOCK);
		ValidationUtil.validatePattern("EnewPinBlock", request.getENewPinBlock(), true, 16, 16, ATM_EPINBLOCK);
	}

	public static void assignOverrideSettingsPayLoad(OverrideSettingsRequest request) throws ValidationFailedException {
		if (request == null) {
			throw new ValidationFailedException("Request cannot be null.");
		}

		ValidationUtil.validateField("TxnRefNo", request.getTxnRefNo(), true, 32, 32);
		ValidationUtil.validateField("ProxyNumber", request.getProxyNumber(), true, 12, 16);
		ValidationUtil.validateField("CampaignCode", request.getCampaignCode(), true, 10, 10);
		ValidationUtil.validateField("ProductCode", request.getProductCode(), true, 6, 6);
		ValidationUtil.validatePattern("Flag", request.getFlag(), true, 1, 1, YN_FLAG);
	}

	public static void alertSettingsPayLoad(AlertSettingsRequest request) throws ValidationFailedException {
		if (request == null) {
			throw new ValidationFailedException("Request cannot be null.");
		}

		ValidationUtil.validateField("TxnRefNo", request.getTxnRefNo(), true, 32, 32);
		ValidationUtil.validateField("ProxyNumber", request.getProxyNumber(), true, 12, 16);
		ValidationUtil.validateField("ProductCode", request.getProductCode(), true, 6, 6);
		ValidationUtil.validateEnumeration("AlertType", request.getAlertType(), true, 6, 6, ALERT_TYPES);
		ValidationUtil.validateEnumeration("Frequency", request.getFrequency(), true, 3, 3, FREQUENCY_TYPES);
		if (request.getAlertData() != null) {
			ValidationUtil.validateField("AlertData", request.getAlertData(), false, 12, 12);
		}
		ValidationUtil.validateEnumeration("Channel", request.getChannel(), true, 3, 5, CHANNEL_TYPES);
		ValidationUtil.validatePattern("AlertSet", request.getAlertSet(), true, 1, 1, YN_FLAG);
	}

	public static void resetWebPasswordPayLoad(ResetPasswordRequest request) throws ValidationFailedException {
		if (request == null) {
			throw new ValidationFailedException("Request cannot be null.");
		}

		ValidationUtil.validateField("TxnRefNo", request.getTxnRefNo(), true, 32, 32);
		if (request.getReftext1() != null) {
			ValidationUtil.validateField("Reftext1", request.getReftext1(), false, 0, 100);
		}
		if (request.getReftext2() != null) {
			ValidationUtil.validateField("Reftext2", request.getReftext2(), false, 0, 100);
		}
		if (request.getReftext3() != null) {
			ValidationUtil.validateField("Reftext3", request.getReftext3(), false, 0, 100);
		}
		ValidationUtil.validateField("NewPassword", request.getNewPassword(), true, 8, 16);
		ValidationUtil.validateField("ConfirmPassword", request.getConfirmPassword(), true, 8, 16);
		if (!request.getNewPassword().equals(request.getConfirmPassword())) {
			throw new ValidationFailedException("NewPassword and ConfirmPassword must be the same.");
		}
	}

	public static void setATMPinPayLoad(SetAtmPinRequest request) throws ValidationFailedException {
		if (request == null) {
			throw new ValidationFailedException("Request cannot be null.");
		}

		ValidationUtil.validateField("TxnRefNo", request.getTxnRefNo(), true, 32, 32);
		ValidationUtil.validateField("ProxyNumber", request.getProxyNumber(), true, 12, 16);
		ValidationUtil.validateDate("ExpiryDate", request.getExpiryDate(), true, 4, 4, EXP_DATE_FORMAT);
		ValidationUtil.validateField("CVV2", request.getCvv2(), true, 3, 3);
		ValidationUtil.validateDate("DOB", request.getDob(), true, 8, 8, DATE_FORMAT);
		ValidationUtil.validatePattern("EPinBlock", request.getEPinBlock(), true, 16, 16, ATM_EPINBLOCK);
	}

	public static void newOTPRequestPayLoad(OTPRequest request) throws ValidationFailedException {
		if (request == null) {
			throw new ValidationFailedException("Request cannot be null.");
		}

		ValidationUtil.validateField("TxnRefNo", request.getTxnRefNo(), true, 12, 12);
		ValidationUtil.validateField("ProxyNumber", request.getProxyNumber(), true, 12, 16);
		ValidationUtil.validateDate("ExpiryDate", request.getExpiryDate(), true, 4, 4, EXP_DATE_FORMAT);
		if (request.getReftext1() != null) {
			ValidationUtil.validateField("Reftext1", request.getReftext1(), false, 0, 25);
		}
		if (request.getReftext2() != null) {
			ValidationUtil.validateField("Reftext2", request.getReftext2(), false, 0, 25);
		}
		if (request.getReftext3() != null) {
			ValidationUtil.validateField("Reftext3", request.getReftext3(), false, 0, 25);
		}
	}

	public static void otpValidationPayLoad(OTPValidationRequest request) throws ValidationFailedException {
		if (request == null) {
			throw new ValidationFailedException("Request cannot be null.");
		}

		ValidationUtil.validateField("TxnRefNo", request.getTxnRefNo(), true, 12, 12);
		ValidationUtil.validateField("ProxyNumber", request.getProxyNumber(), true, 12, 16);
		ValidationUtil.validateField("OTP", request.getOtp(), true, 6, 6);
	}

	public static void retrieveWebProfilePayLoad(WebProfileRequest request) throws ValidationFailedException {
		if (request == null) {
			throw new ValidationFailedException("Request cannot be null.");
		}

		ValidationUtil.validateField("TxnRefNo", request.getTxnRefNo(), true, 32, 32);
		ValidationUtil.validateField("ProxyNumber", request.getProxyNumber(), true, 12, 16);
		if (request.getReftext1() != null) {
			ValidationUtil.validateField("Reftext1", request.getReftext1(), false, 0, 100);
		}
		if (request.getReftext2() != null) {
			ValidationUtil.validateField("Reftext2", request.getReftext2(), false, 0, 100);
		}
		if (request.getReftext3() != null) {
			ValidationUtil.validateField("Reftext3", request.getReftext3(), false, 0, 100);
		}
	}

	public static void corporateRegistrationPayLoad(CorporateRegistrationRequest request)
			throws ValidationFailedException {
		if (request == null) {
			throw new ValidationFailedException("Request cannot be null.");
		}

		ValidationUtil.validateField("TxnRefNo", request.getTxnRefNo(), true, 32, 32);
		ValidationUtil.validateField("CorpNameOne", request.getCorpNameOne(), true, 1, 100);
		ValidationUtil.validateField("StreetName", request.getStreetName(), true, 1, 100);
		ValidationUtil.validateField("City", request.getCity(), true, 1, 50);
		ValidationUtil.validateField("Country", request.getCountry(), true, 1, 30);
		ValidationUtil.validateField("PostalCode", request.getPostalCode(), true, 1, 8);
		ValidationUtil.validateField("CorporateLoginId", request.getCorporateLoginId(), true, 1, 10);
		if (request.getCorpNameTwo() != null) {
			ValidationUtil.validateField("CorpNameTwo", request.getCorpNameTwo(), false, 0, 100);
		}
		if (request.getCorpNameThree() != null) {
			ValidationUtil.validateField("CorpNameThree", request.getCorpNameThree(), false, 0, 100);
		}
		if (request.getCorporateId() != null) {
			ValidationUtil.validateField("CorporateId", request.getCorporateId(), false, 0, 10);
		}
		if (request.getCrmId() != null) {
			ValidationUtil.validateField("CrmId", request.getCrmId(), false, 0, 20);
		}
		if (request.getEnterpriseId() != null) {
			ValidationUtil.validateField("EnterpriseId", request.getEnterpriseId(), false, 0, 50);
		}
		if (request.getTaxNumber() != null) {
			ValidationUtil.validateField("TaxNumber", request.getTaxNumber(), false, 0, 15);
		}
		if (request.getPrintName() != null) {
			ValidationUtil.validateField("PrintName", request.getPrintName(), false, 0, 20);
		}
		if (request.getOptional1() != null) {
			ValidationUtil.validateField("Optional1", request.getOptional1(), false, 0, 100);
		}
		if (request.getOptional2() != null) {
			ValidationUtil.validateField("Optional2", request.getOptional2(), false, 0, 100);
		}
		if (request.getOptional3() != null) {
			ValidationUtil.validateField("Optional3", request.getOptional3(), false, 0, 100);
		}
		if (request.getCorporateContact() != null) {
			validateCorporateContact(request.getCorporateContact());
		}
		if (request.getLoadDetails() != null) {
			validateLoadDetails(request.getLoadDetails());
		}
		if (request.getCorporate().getBranch() != null) {
			validateBranch(request.getCorporate().getBranch());
		} else {
			throw new ValidationFailedException("Branch is required.");
		}
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
				ValidationUtil.validateField("CountryOfIssue", idType.getCountryOfIssue(), true, 1, 20);
			}
		} else {
			throw new ValidationFailedException("IdentificationTypes are required.");
		}
	}

	private static void validateLoadDetails(CorporateRegistrationRequest.LoadDetails loadDetails)
			throws ValidationFailedException {
		ValidationUtil.validateField("ProductAssigned", loadDetails.getProductAssigned(), true, 0, 100);
		if (loadDetails.getInvoiceLevel() != null) {
			ValidationUtil.validateEnumeration("InvoiceLevel", loadDetails.getInvoiceLevel(), false, 0, 3,
					INVOICE_LEVELS);
		}
		if (loadDetails.getPrefundingPrdCode() != null) {
			ValidationUtil.validateField("PrefundingPrdCode", loadDetails.getPrefundingPrdCode(), false, 0, 6);
		}
		if (loadDetails.getOverrideCode() != null) {
			ValidationUtil.validateField("OverrideCode", loadDetails.getOverrideCode(), false, 0, 6);
		}
	}

	private static void validateCorporateContact(CorporateRegistrationRequest.CorporateContact contact)
			throws ValidationFailedException {

		ValidationUtil.validateField("Gender", contact.getGender(), true, 1, 1);
		ValidationUtil.validatePattern("EmailId", contact.getEmailId(), true, 1, 100, EMAIL_PATTERN);
		ValidationUtil.validateField("LastName", contact.getLastName(), true, 1, 30);
		if (contact.getTitle() != null) {
			ValidationUtil.validateEnumeration("Title", contact.getTitle(), false, 0, 25, TITLES);
		}
		if (contact.getFirstName() != null) {
			ValidationUtil.validateField("FirstName", contact.getFirstName(), false, 0, 30);
		}
		if (contact.getMailAddress() != null) {
			ValidationUtil.validateField("MailAddress", contact.getMailAddress(), false, 0, 100);
		}
		if (contact.getOfficePhone() != null) {
			ValidationUtil.validatePattern("OfficePhone", contact.getOfficePhone(), false, 0, 20,
					MOBILE_NUMBER_PATTERN);
		}
		if (contact.getResidentPhone() != null) {
			ValidationUtil.validatePattern("ResidentPhone", contact.getResidentPhone(), false, 0, 20,
					MOBILE_NUMBER_PATTERN);
		}
		if (contact.getMobile() != null) {
			ValidationUtil.validatePattern("Mobile", contact.getMobile(), false, 0, 20, MOBILE_NUMBER_PATTERN);
		}
		if (contact.getFax() != null) {
			ValidationUtil.validatePattern("Fax", contact.getFax(), false, 0, 20, MOBILE_NUMBER_PATTERN);
		}
		if (contact.getSuburb() != null) {
			ValidationUtil.validateField("Suburb", contact.getSuburb(), false, 0, 30);
		}
		if (contact.getCity() != null) {
			ValidationUtil.validateField("City", contact.getCity(), false, 0, 50);
		}
		if (contact.getState() != null) {
			ValidationUtil.validateField("State", contact.getState(), false, 0, 30);
		}
		if (contact.getCountry() != null) {
			ValidationUtil.validateField("Country", contact.getCountry(), false, 0, 30);
		}
		if (contact.getPostalCode() != null) {
			ValidationUtil.validateField("PostalCode", contact.getPostalCode(), false, 0, 8);
		}
	}

	private static void validateBranch(Branch branch) throws ValidationFailedException {

		ValidationUtil.validateField("CorpBrNmOne", branch.getCorpBrNmOne(), true, 1, 25);
		if (branch.getCorpBrNmTwo() != null) {
			ValidationUtil.validateField("CorpBrNmTwo", branch.getCorpBrNmTwo(), false, 0, 25);
		}
		if (branch.getCorpBrNmThree() != null) {
			ValidationUtil.validateField("CorpBrNmThree", branch.getCorpBrNmThree(), false, 0, 25);
		}
		if (branch.getBranchCode() != null) {
			ValidationUtil.validateField("BranchCode", branch.getBranchCode(), false, 0, 20);
		}
		ValidationUtil.validateField("BranchLoginId", branch.getBranchLoginId(), true, 1, 10);

		if (branch.getContactDetails() != null) {
			validateBranchContactDetails(branch.getContactDetails());
		}
	}

	private static void validateBranchContactDetails(ContactDetails contactDetails) throws ValidationFailedException {
		ValidationUtil.validatePattern("Gender", contactDetails.getGender(), true, 1, 1, GENDER);
		ValidationUtil.validatePattern("EmailId", contactDetails.getEmailId(), true, 1, 100, EMAIL_PATTERN);
		ValidationUtil.validateField("LastName", contactDetails.getLastName(), true, 1, 30);
		if (contactDetails.getTitle() != null) {
			ValidationUtil.validateEnumeration("Title", contactDetails.getTitle(), false, 0, 25, TITLES);
		}
		if (contactDetails.getFirstName() != null) {
			ValidationUtil.validateField("FirstName", contactDetails.getFirstName(), false, 0, 30);
		}
		if (contactDetails.getMailAddress() != null) {
			ValidationUtil.validateField("MailAddress", contactDetails.getMailAddress(), false, 0, 100);
		}
		if (contactDetails.getOfficePhone() != null) {
			ValidationUtil.validatePattern("OfficePhone", contactDetails.getOfficePhone(), false, 0, 20,
					MOBILE_NUMBER_PATTERN);
		}
		if (contactDetails.getResidentPhone() != null) {
			ValidationUtil.validatePattern("ResidentPhone", contactDetails.getResidentPhone(), false, 0, 20,
					MOBILE_NUMBER_PATTERN);
		}
		if (contactDetails.getMobile() != null) {
			ValidationUtil.validatePattern("Mobile", contactDetails.getMobile(), false, 0, 20, MOBILE_NUMBER_PATTERN);
		}
		if (contactDetails.getFax() != null) {
			ValidationUtil.validatePattern("Fax", contactDetails.getFax(), false, 0, 20, MOBILE_NUMBER_PATTERN);
		}
		if (contactDetails.getSuburb() != null) {
			ValidationUtil.validateField("Suburb", contactDetails.getSuburb(), false, 0, 30);
		}
		if (contactDetails.getCity() != null) {
			ValidationUtil.validateField("City", contactDetails.getCity(), false, 0, 50);
		}
		if (contactDetails.getState() != null) {
			ValidationUtil.validateField("State", contactDetails.getState(), false, 0, 30);
		}
		if (contactDetails.getCountry() != null) {
			ValidationUtil.validateField("Country", contactDetails.getCountry(), false, 0, 30);
		}
		if (contactDetails.getPostalCode() != null) {
			ValidationUtil.validateField("PostalCode", contactDetails.getPostalCode(), false, 0, 8);
		}
	}
}
