package com.ottl.model;

import com.ottl.utils.XmlElementName;

/**
 * Represents a request to activate a card.
 */
public class ActivateCardRequest {
	@XmlElementName("TxnRefNo")
	private String txnRefNo;
	@XmlElementName("ProxyNumber")
	private String proxyNumber;
	@XmlElementName("ActivationCode")
	private String activationCode;
	@XmlElementName("CustomerId")
	private String customerId;

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
	 * @return the activation code
	 */
	public String getActivationCode() {
		return activationCode;
	}

	/**
	 * @param activationCode the activation code to set
	 */
	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}

	/**
	 * @return the customer id
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customer id to set
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ActivateCardRequest [txnRefNo=").append(txnRefNo).append(", proxyNumber=").append(proxyNumber)
				.append(", activationCode=").append(activationCode).append(", customerId=").append(customerId)
				.append("]");
		return builder.toString();
	}
}
