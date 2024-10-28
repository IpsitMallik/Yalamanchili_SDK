package com.ottl.model;

import com.ottl.utils.XmlElementName;

public class ProfileCreationRequest {
	@XmlElementName("TxnRefNo")
	private String txnRefNo;

	@XmlElementName("ProxyNumber")
	private String proxyNumber;

	@XmlElementName("UserId")
	private String userId;

	@XmlElementName("Password")
	private String password;

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
	 * @return the proxy number
	 */
	public String getProxyNumber() {
		return proxyNumber;
	}

	/**
	 * @param proxyNumber the proxy number to set
	 */
	public void setProxyNumber(String proxyNumber) {
		this.proxyNumber = proxyNumber;
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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the email ID
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
	 * @return the mobile number
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
		builder.append("ProfileCreationRequest [txnRefNo=").append(txnRefNo).append(", proxyNumber=")
				.append(proxyNumber).append(", userId=").append(userId).append(", password=").append(password)
				.append(", emailId=").append(emailId).append(", mobileNumber=").append(mobileNumber).append("]");
		return builder.toString();
	}
}
