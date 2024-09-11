package com.narada.sdk.models;

import com.narada.sdk.utilities.XmlElementName;

/**
 * Represents the response containing card details.
 */
public class NewCardResponse {
	@XmlElementName("TxnRefNo")
	private String txnRefNo;
	@XmlElementName("ProxyNumber")
	private String proxyNumber;
	@XmlElementName("CardNumber")
	private String cardNumber;
	@XmlElementName("CustomerId")
	private String customerId;
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
	 * @return the card number
	 */
	public String getCardNumber() {
		return cardNumber;
	}

	/**
	 * @param cardNumber the card number to set
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * @return the customer identifier
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customer identifier to set
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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
	 * @return the expiry date
	 */
	public String getCardExpiry() {
		return cardExpiry;
	}

	/**
	 * @param cardExpiry the expiry date to set
	 */
	public void setCardExpiry(String cardExpiry) {
		this.cardExpiry = cardExpiry;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CardResponse [txnRefNo=").append(txnRefNo).append(", proxyNumber=").append(proxyNumber)
				.append(", cardNumber=").append(cardNumber).append(", customerId=").append(customerId)
				.append(", activationCode=").append(activationCode).append(", cvv=").append(cvv).append(", cardExpiry=")
				.append(cardExpiry).append("]");
		return builder.toString();
	}
}
