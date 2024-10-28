package com.ottl.model;

import com.ottl.utils.XmlElementName;

public class CardOrderResponse {
	@XmlElementName("TxnRefNo")
	private String txnRefNo;

	@XmlElementName("InvoiceNo")
	private String invoiceNo;

	@XmlElementName("OrderRefNo")
	private String orderRefNo;

	/**
	 * Gets the transaction reference number.
	 *
	 * @return the transaction reference number
	 */
	public String getTxnRefNo() {
		return txnRefNo;
	}

	/**
	 * Sets the transaction reference number.
	 *
	 * @param txnRefNo the transaction reference number to set
	 */
	public void setTxnRefNo(String txnRefNo) {
		this.txnRefNo = txnRefNo;
	}

	/**
	 * Gets the invoice number for the card order placed.
	 *
	 * @return the invoice number
	 */
	public String getInvoiceNo() {
		return invoiceNo;
	}

	/**
	 * Sets the invoice number for the card order placed.
	 *
	 * @param invoiceNo the invoice number to set
	 */
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	/**
	 * Gets the reference number for the order.
	 *
	 * @return the order reference number
	 */
	public String getOrderRefNo() {
		return orderRefNo;
	}

	/**
	 * Sets the reference number for the order.
	 *
	 * @param orderRefNo the order reference number to set
	 */
	public void setOrderRefNo(String orderRefNo) {
		this.orderRefNo = orderRefNo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CardOrderResponse [txnRefNo=").append(txnRefNo).append(", invoiceNo=").append(invoiceNo)
				.append(", orderRefNo=").append(orderRefNo).append("]");
		return builder.toString();
	}

}
