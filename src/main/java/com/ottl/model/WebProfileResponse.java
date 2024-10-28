package com.ottl.model;

import com.ottl.utils.XmlElementName;

public class WebProfileResponse {
	@XmlElementName("TxnRefNo")
	private String txnRefNo;

	@XmlElementName("UserId")
	private String userId;

	@XmlElementName("EmailId")
	private String emailId;

	@XmlElementName("MobileNumber")
	private String mobileNumber;

	/**
	 * @return the transaction reference number
	 */
	public String getTxnRefNo() {
		return txnRefNo;
	}

	/**
	 * @param txnRefNo the transaction reference number to set
	 */
	public void setTxnRefNo(String txnRefNo) {
		this.txnRefNo = txnRefNo;
	}

	/**
	 * @return the user ID
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the user ID to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the email ID of the card holder
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId the email ID to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the mobile number of the customer
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * @param mobileNumber the mobile number to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WebProfileResponse [txnRefNo=").append(txnRefNo).append(", userId=").append(userId)
				.append(", emailId=").append(emailId).append(", mobileNumber=").append(mobileNumber).append("]");
		return builder.toString();
	}
}
