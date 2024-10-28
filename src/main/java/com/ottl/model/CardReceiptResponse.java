package com.ottl.model;

import com.ottl.utils.XmlElementName;

public class CardReceiptResponse {
	@XmlElementName("TxnRefNo")
	private String txnRefNo;
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

	/**
	 * Gets the orderRefNo.
	 *
	 * @return the orderRefNo
	 */
	public String getOrderRefNo() {
		return orderRefNo;
	}

	/**
	 * Sets the orderRefNo.
	 *
	 * @param orderRefNo the orderRefNo to set
	 */
	public void setOrderRefNo(String orderRefNo) {
		this.orderRefNo = orderRefNo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CardReceiptResponse [txnRefNo=").append(txnRefNo).append(", orderRefNo=").append(orderRefNo)
				.append("]");
		return builder.toString();
	}
}
