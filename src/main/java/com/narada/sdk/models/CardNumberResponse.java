package com.narada.sdk.models;

import com.narada.sdk.utilities.XmlElementName;

public class CardNumberResponse {
	@XmlElementName("TxnRefNo")
	private String txnRefNo;

	@XmlElementName("ProxyNumber")
	private String proxyNumber;

	@XmlElementName("CardNumber")
	private String cardNumber;

	@XmlElementName("ExpiryDate")
	private String expiryDate;

	@XmlElementName("NameOnCard")
	private String nameOnCard;

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
	 * @return the expiry date
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
	 * @return the name on the card
	 */
	public String getNameOnCard() {
		return nameOnCard;
	}

	/**
	 * @param nameOnCard the name on the card to set
	 */
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CardNumberResponse [txnRefNo=").append(txnRefNo).append(", proxyNumber=").append(proxyNumber)
				.append(", cardNumber=").append(cardNumber).append(", expiryDate=").append(expiryDate)
				.append(", nameOnCard=").append(nameOnCard).append("]");
		return builder.toString();
	}
}
