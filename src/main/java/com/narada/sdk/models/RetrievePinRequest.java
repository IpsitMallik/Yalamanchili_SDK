package com.narada.sdk.models;

import com.narada.sdk.utilities.XmlElementName;

public class RetrievePinRequest {
	@XmlElementName("TxnRefNo")
	private String txnRefNo;

	@XmlElementName("ProxyNumber")
	private String proxyNumber;

	@XmlElementName("ExpiryDate")
	private String expiryDate;

	@XmlElementName("CVV2")
	private String cvv2;

	@XmlElementName("DOB")
	private String dob;

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
	 * @return the proxy number or card number
	 */
	public String getProxyNumber() {
		return proxyNumber;
	}

	/**
	 * @param proxyNumber the proxy number or card number to set
	 */
	public void setProxyNumber(String proxyNumber) {
		this.proxyNumber = proxyNumber;
	}

	/**
	 * @return the expiry date of the card in MMYY format
	 */
	public String getExpiryDate() {
		return expiryDate;
	}

	/**
	 * @param expiryDate the expiry date of the card to set
	 */
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	/**
	 * @return the CVV2 of the card
	 */
	public String getCvv2() {
		return cvv2;
	}

	/**
	 * @param cvv2 the CVV2 of the card to set
	 */
	public void setCvv2(String cvv2) {
		this.cvv2 = cvv2;
	}

	/**
	 * @return the customer's date of birth in DDMMYYYY format
	 */
	public String getDob() {
		return dob;
	}

	/**
	 * @param dob the customer's date of birth to set
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PINRetrievalRequest [txnRefNo=").append(txnRefNo).append(", proxyNumber=").append(proxyNumber)
				.append(", expiryDate=").append(expiryDate).append(", cvv2=").append(cvv2).append(", dob=").append(dob)
				.append("]");
		return builder.toString();
	}
}
