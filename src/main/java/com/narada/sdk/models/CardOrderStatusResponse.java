package com.narada.sdk.models;

import com.narada.sdk.utilities.XmlElementName;

public class CardOrderStatusResponse {

	@XmlElementName("TxnRefNo")
	private String txnRefNo;

	@XmlElementName("InvoiceNo")
	private String invoiceNo;

	@XmlElementName("InvoiceDate")
	private String invoiceDate;

	@XmlElementName("OrderedBy")
	private String orderedBy;

	@XmlElementName("ProductCode")
	private String productCode;

	@XmlElementName("PlasticName")
	private String plasticName;

	@XmlElementName("CardOrdered")
	private String cardOrdered;

	@XmlElementName("OrderStatus")
	private String orderStatus;

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
	 * @return the invoice number
	 */
	public String getInvoiceNo() {
		return invoiceNo;
	}

	/**
	 * @param invoiceNo the invoice number to set
	 */
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	/**
	 * @return the invoice date
	 */
	public String getInvoiceDate() {
		return invoiceDate;
	}

	/**
	 * @param invoiceDate the invoice date to set
	 */
	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	/**
	 * @return the name of the person who initiated the card order
	 */
	public String getOrderedBy() {
		return orderedBy;
	}

	/**
	 * @param orderedBy the name of the person who initiated the card order to set
	 */
	public void setOrderedBy(String orderedBy) {
		this.orderedBy = orderedBy;
	}

	/**
	 * @return the short code of the product
	 */
	public String getProductCode() {
		return productCode;
	}

	/**
	 * @param productCode the short code of the product to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	/**
	 * @return the plastic name of the card order
	 */
	public String getPlasticName() {
		return plasticName;
	}

	/**
	 * @param plasticName the plastic name of the card order to set
	 */
	public void setPlasticName(String plasticName) {
		this.plasticName = plasticName;
	}

	/**
	 * @return the number of cards ordered by the branch up to now
	 */
	public String getCardOrdered() {
		return cardOrdered;
	}

	/**
	 * @param cardOrdered the number of cards ordered by the branch to set
	 */
	public void setCardOrdered(String cardOrdered) {
		this.cardOrdered = cardOrdered;
	}

	/**
	 * @return the current status of the card order
	 */
	public String getOrderStatus() {
		return orderStatus;
	}

	/**
	 * @param orderStatus the current status of the card order to set
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CardOrderStatusResponse [txnRefNo=").append(txnRefNo).append(", invoiceNo=").append(invoiceNo)
				.append(", invoiceDate=").append(invoiceDate).append(", orderedBy=").append(orderedBy)
				.append(", productCode=").append(productCode).append(", plasticName=").append(plasticName)
				.append(", cardOrdered=").append(cardOrdered).append(", orderStatus=").append(orderStatus).append("]");
		return builder.toString();
	}
}
