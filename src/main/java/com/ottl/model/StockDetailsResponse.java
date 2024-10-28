package com.ottl.model;

import java.util.List;

import com.ottl.utils.XmlElementName;


public class StockDetailsResponse {
	@XmlElementName("TxnRefNo")
	private String txnRefNo;

	@XmlElementName("BranchId")
	private String branchId;

	@XmlElementName("StockInfo")
	private List<StockInfo> stockInfo;

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
	 * @return the branch ID
	 */
	public String getBranchId() {
		return branchId;
	}

	/**
	 * @param branchId the branch ID to set
	 */
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	/**
	 * @return the stock information
	 */
	public List<StockInfo> getStockInfo() {
		return stockInfo;
	}

	/**
	 * @param stockInfo the stock information to set
	 */
	public void setStockInfo(List<StockInfo> stockInfo) {
		this.stockInfo = stockInfo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StockDetailsResponse [txnRefNo=").append(txnRefNo).append(", branchId=").append(branchId)
				.append(", stockInfo=").append(stockInfo).append("]");
		return builder.toString();
	}

	public static class StockInfo {

		@XmlElementName("ProductCode")
		private String productCode;

		@XmlElementName("CardOrdered")
		private String cardOrdered;

		@XmlElementName("CardActivated")
		private String cardActivated;

		@XmlElementName("CardWithBranch")
		private String cardWithBranch;

		@XmlElementName("CardDamaged")
		private String cardDamaged;

		/**
		 * @return the product code
		 */
		public String getProductCode() {
			return productCode;
		}

		/**
		 * @param productCode the product code to set
		 */
		public void setProductCode(String productCode) {
			this.productCode = productCode;
		}

		/**
		 * @return the number of cards ordered
		 */
		public String getCardOrdered() {
			return cardOrdered;
		}

		/**
		 * @param cardOrdered the number of cards ordered to set
		 */
		public void setCardOrdered(String cardOrdered) {
			this.cardOrdered = cardOrdered;
		}

		/**
		 * @return the number of cards activated
		 */
		public String getCardActivated() {
			return cardActivated;
		}

		/**
		 * @param cardActivated the number of cards activated to set
		 */
		public void setCardActivated(String cardActivated) {
			this.cardActivated = cardActivated;
		}

		/**
		 * @return the number of cards with the branch
		 */
		public String getCardWithBranch() {
			return cardWithBranch;
		}

		/**
		 * @param cardWithBranch the number of cards with the branch to set
		 */
		public void setCardWithBranch(String cardWithBranch) {
			this.cardWithBranch = cardWithBranch;
		}

		/**
		 * @return the number of cards damaged
		 */
		public String getCardDamaged() {
			return cardDamaged;
		}

		/**
		 * @param cardDamaged the number of cards damaged to set
		 */
		public void setCardDamaged(String cardDamaged) {
			this.cardDamaged = cardDamaged;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("StockInfo [productCode=").append(productCode).append(", cardOrdered=").append(cardOrdered)
					.append(", cardActivated=").append(cardActivated).append(", cardWithBranch=").append(cardWithBranch)
					.append(", cardDamaged=").append(cardDamaged).append("]");
			return builder.toString();
		}
	}
}
