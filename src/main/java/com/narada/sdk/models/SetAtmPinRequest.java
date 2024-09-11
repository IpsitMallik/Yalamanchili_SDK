package com.narada.sdk.models;

import com.narada.sdk.utilities.XmlElementName;

public class SetAtmPinRequest {
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

	@XmlElementName("EPinBlock")
	private String ePinBlock;

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
	 * @return the expiry date in MMYY format
	 */
	public String getExpiryDate() {
		return expiryDate;
	}

	/**
	 * @param expiryDate the expiry date to set
	 */
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	/**
	 * @return the CVV2 code of the card back panel
	 */
	public String getCvv2() {
		return cvv2;
	}

	/**
	 * @param cvv2 the CVV2 code to set
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
	 * @param dob the date of birth to set
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}

	/**
	 * @return the encrypted PIN block
	 */
	public String getEPinBlock() {
		return ePinBlock;
	}

	/**
	 * @param ePinBlock the encrypted PIN block to set
	 */
	public void setEPinBlock(String ePinBlock) {
		this.ePinBlock = ePinBlock;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AtmPinSetRequest [txnRefNo=").append(txnRefNo).append(", proxyNumber=").append(proxyNumber)
				.append(", expiryDate=").append(expiryDate).append(", cvv2=").append(cvv2).append(", dob=").append(dob)
				.append(", ePinBlock=").append(ePinBlock).append("]");
		return builder.toString();
	}
}
