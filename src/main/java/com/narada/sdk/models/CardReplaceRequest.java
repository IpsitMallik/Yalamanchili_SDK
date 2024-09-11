package com.narada.sdk.models;

import com.narada.sdk.utilities.XmlElementName;

/**
 * Represents a request to replace a card.
 */
public class CardReplaceRequest {
	@XmlElementName("TxnRefNo")
	private String txnRefNo;
	@XmlElementName("ProxyNumber")
	private String proxyNumber;
	@XmlElementName("NewProxyNumber")
	private String newProxyNumber;
	@XmlElementName("CustomerId")
	private String customerId;
	@XmlElementName("Type")
	private String type;
	@XmlElementName("CardDesign")
	private String cardDesign;
	@XmlElementName("DeliveryFlag")
	private String deliveryFlag;

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

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the card design
	 */
	public String getCardDesign() {
		return cardDesign;
	}

	/**
	 * @param cardDesign the card design to set
	 */
	public void setCardDesign(String cardDesign) {
		this.cardDesign = cardDesign;
	}

	/**
	 * @return the delivery flag
	 */
	public String getDeliveryFlag() {
		return deliveryFlag;
	}

	/**
	 * @param deliveryFlag the delivery flag to set
	 */
	public void setDeliveryFlag(String deliveryFlag) {
		this.deliveryFlag = deliveryFlag;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CardReplaceRequest [txnRefNo=").append(txnRefNo).append(", proxyNumber=").append(proxyNumber)
				.append(", newProxyNumber=").append(newProxyNumber).append(", customerId=").append(customerId)
				.append(", type=").append(type).append(", cardDesign=").append(cardDesign)
				.append(", deliveryFlag=").append(deliveryFlag)
				.append("]");
		return builder.toString();
	}
}
