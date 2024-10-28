package com.ottl.model;

import com.ottl.utils.XmlElementName;

public class VerifyPinRequest {
	@XmlElementName("TxnRefNo")
	private String txnRefNo;

	@XmlElementName("ProxyNumber")
	private String proxyNumber;

	@XmlElementName("EPinBlock")
	private String ePinBlock;

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

	/**
	 * @return the customer's date of birth
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
		builder.append("VerifyPinRequest [txnRefNo=").append(txnRefNo).append(", proxyNumber=").append(proxyNumber)
				.append(", ePinBlock=").append(ePinBlock).append(", dob=").append(dob).append("]");
		return builder.toString();
	}
}
