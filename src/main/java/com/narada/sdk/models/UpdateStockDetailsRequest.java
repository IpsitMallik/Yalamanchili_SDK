package com.narada.sdk.models;

import com.narada.sdk.utilities.XmlElementName;
import java.util.List;

public class UpdateStockDetailsRequest {

	@XmlElementName("TxnRefNo")
	private String txnRefNo;

	@XmlElementName("OrderRefNo")
	private String orderRefNo;

	@XmlElementName("Quantity")
	private String quantity;

	@XmlElementName("RefNumbers")
	private List<PackNo> refNumbers;

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
	 * @return the quantity of damaged cards
	 */
	public String getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity of damaged cards to set
	 */
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the list of pack numbers
	 */
	public List<PackNo> getRefNumbers() {
		return refNumbers;
	}

	/**
	 * @param refNumbers the list of pack numbers to set
	 */
	public void setRefNumbers(List<PackNo> refNumbers) {
		this.refNumbers = refNumbers;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UpdateStockRequest [txnRefNo=").append(txnRefNo).append(", orderRefNo=").append(orderRefNo)
				.append(", quantity=").append(quantity).append(", refNumbers=").append(refNumbers).append("]");
		return builder.toString();
	}

	public static class PackNo {

		@XmlElementName("PackNo")
		private String packNo;

		/**
		 * @return the pack reference number
		 */
		public String getPackNo() {
			return packNo;
		}

		/**
		 * @param packNo the pack reference number to set
		 */
		public void setPackNo(String packNo) {
			this.packNo = packNo;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("PackNo [packNo=").append(packNo).append("]");
			return builder.toString();
		}
	}

}
