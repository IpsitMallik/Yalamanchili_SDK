package com.ottl.model;

import com.ottl.utils.XmlElementName;

public class AddCardResponse {

	@XmlElementName("TxnRefNo")
	private String txnRefNo;

	@XmlElementName("ProxyNumber")
	private String proxyNumber;

	@XmlElementName("NewProxyNumber")
	private String newProxyNumber;

	@XmlElementName("ActivationCode")
	private String activationCode;

	@XmlElementName("CVV")
	private String cvv;

	@XmlElementName("CardExpiry")
	private String cardExpiry;

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
	 * @return the new proxy number
	 */
	public String getNewProxyNumber() {
		return newProxyNumber;
	}

	/**
	 * @param newProxyNumber the new proxy number to set
	 */
	public void setNewProxyNumber(String newProxyNumber) {
		this.newProxyNumber = newProxyNumber;
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
	 * @return the CVV
	 */
	public String getCvv() {
		return cvv;
	}

	/**
	 * @param cvv the CVV to set
	 */
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	/**
	 * @return the card expiry date
	 */
	public String getCardExpiry() {
		return cardExpiry;
	}

	/**
	 * @param cardExpiry the card expiry date to set
	 */
	public void setCardExpiry(String cardExpiry) {
		this.cardExpiry = cardExpiry;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AddCardResponse [txnRefNo=").append(txnRefNo).append(", proxyNumber=").append(proxyNumber)
				.append(", newProxyNumber=").append(newProxyNumber).append(", activationCode=").append(activationCode)
				.append(", cvv=").append(cvv).append(", cardExpiry=").append(cardExpiry).append("]");
		return builder.toString();
	}
}
