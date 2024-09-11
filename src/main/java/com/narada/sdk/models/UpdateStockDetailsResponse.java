package com.narada.sdk.models;

import com.narada.sdk.utilities.XmlElementName;

public class UpdateStockDetailsResponse {

	@XmlElementName("TxnRefNo")
	private String txnRefNo;

	@XmlElementName("OrderRefNo")
	private String orderRefNo;

	@XmlElementName("Quantity")
	private String quantity;

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
	 * @return the order reference number
	 */
	public String getOrderRefNo() {
		return orderRefNo;
	}

	/**
	 * @param orderRefNo the order reference number to set
	 */
	public void setOrderRefNo(String orderRefNo) {
		this.orderRefNo = orderRefNo;
	}

	/**
	 * @return the quantity
	 */
	public String getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UpdateStockResponse [txnRefNo=").append(txnRefNo).append(", orderRefNo=").append(orderRefNo)
				.append(", quantity=").append(quantity).append("]");
		return builder.toString();
	}

}
