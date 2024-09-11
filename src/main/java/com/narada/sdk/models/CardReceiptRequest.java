package com.narada.sdk.models;

import com.narada.sdk.utilities.XmlElementName;

public class CardReceiptRequest {
	@XmlElementName("TxnRefNo")
	private String txnRefNo;

	@XmlElementName("Receipt")
	private Receipt receipt;

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
     * @return the receipt details
     */
    public Receipt getReceipt() {
        return receipt;
    }

    /**
     * @param receipt the receipt details to set
     */
    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CardReceiptRequest [txnRefNo=").append(txnRefNo).append(", receipt=").append(receipt)
				.append("]");
		return builder.toString();
	}

	public static class Receipt {

		@XmlElementName("OrderRefNo")
		private String orderRefNo;

		@XmlElementName("Quantity")
		private String quantity;

		@XmlElementName("FromPackNo")
		private String fromPackNo;

		@XmlElementName("ToPackNo")
		private String toPackNo;

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
		 * @return the quantity of cards receipted
		 */
		public String getQuantity() {
			return quantity;
		}

		/**
		 * @param quantity the quantity of cards receipted to set
		 */
		public void setQuantity(String quantity) {
			this.quantity = quantity;
		}

		/**
		 * @return the from pack reference number
		 */
		public String getFromPackNo() {
			return fromPackNo;
		}

		/**
		 * @param fromPackNo the from pack reference number to set
		 */
		public void setFromPackNo(String fromPackNo) {
			this.fromPackNo = fromPackNo;
		}

		/**
		 * @return the to pack reference number
		 */
		public String getToPackNo() {
			return toPackNo;
		}

		/**
		 * @param toPackNo the to pack reference number to set
		 */
		public void setToPackNo(String toPackNo) {
			this.toPackNo = toPackNo;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Receipt [orderRefNo=").append(orderRefNo).append(", quantity=").append(quantity)
					.append(", fromPackNo=").append(fromPackNo).append(", toPackNo=").append(toPackNo).append("]");
			return builder.toString();
		}
	}
}
