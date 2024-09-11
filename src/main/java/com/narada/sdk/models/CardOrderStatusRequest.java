package com.narada.sdk.models;

import com.narada.sdk.utilities.XmlElementName;

public class CardOrderStatusRequest {
	@XmlElementName("TxnRefNo")
	private String txnRefNo;

	@XmlElementName("InvoiceNo")
	private String invoiceNo;

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
	 * @return the invoice number or order reference number
	 */
	public String getInvoiceNo() {
		return invoiceNo;
	}

	/**
	 * @param invoiceNo the invoice number or order reference number to set
	 */
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CardOrderStatusRequest [txnRefNo=").append(txnRefNo).append(", invoiceNo=").append(invoiceNo)
				.append("]");
		return builder.toString();
	}
}
