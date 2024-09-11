package com.narada.sdk.models;

import com.narada.sdk.utilities.XmlElementName;

public class ValidatePinRequest {
	@XmlElementName("TxnRefNo")
	private String txnRefNo;

	@XmlElementName("ProxyNumber")
	private String proxyNumber;

	@XmlElementName("IvrPin")
	private String ivrPin;

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
	 * @return the IVR PIN
	 */
	public String getIvrPin() {
		return ivrPin;
	}

	/**
	 * @param ivrPin the IVR PIN to set
	 */
	public void setIvrPin(String ivrPin) {
		this.ivrPin = ivrPin;
	}

	/**
	 * @return the date of birth
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ValidatePinRequest [txnRefNo=").append(txnRefNo).append(", proxyNumber=").append(proxyNumber)
				.append(", ivrPin=").append(ivrPin).append(", dob=").append(dob).append("]");
		return builder.toString();
	}
}
