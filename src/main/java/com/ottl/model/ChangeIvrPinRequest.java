package com.ottl.model;

import com.ottl.utils.XmlElementName;

public class ChangeIvrPinRequest {
	@XmlElementName("TxnRefNo")
	private String txnRefNo;

	@XmlElementName("ProxyNumber")
	private String proxyNumber;

	@XmlElementName("OldIvrPin")
	private String oldIvrPin;

	@XmlElementName("NewIvrPin")
	private String newIvrPin;

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
	 * @return the old IVR PIN
	 */
	public String getOldIvrPin() {
		return oldIvrPin;
	}

	/**
	 * @param oldIvrPin the old IVR PIN to set
	 */
	public void setOldIvrPin(String oldIvrPin) {
		this.oldIvrPin = oldIvrPin;
	}

	/**
	 * @return the new IVR PIN
	 */
	public String getNewIvrPin() {
		return newIvrPin;
	}

	/**
	 * @param newIvrPin the new IVR PIN to set
	 */
	public void setNewIvrPin(String newIvrPin) {
		this.newIvrPin = newIvrPin;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("IvrPinChangeRequest [txnRefNo=").append(txnRefNo).append(", proxyNumber=").append(proxyNumber)
				.append(", oldIvrPin=").append(oldIvrPin).append(", newIvrPin=").append(newIvrPin).append("]");
		return builder.toString();
	}
}
