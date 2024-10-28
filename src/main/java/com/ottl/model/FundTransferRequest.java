package com.ottl.model;

import com.ottl.utils.XmlElementName;

public class FundTransferRequest {

	@XmlElementName("TxnRefNo")
	private String txnRefNo;

	@XmlElementName("ExchangeRate")
	private String exchangeRate;

	@XmlElementName("SourceAccount")
	private SourceAccount sourceAccount;

	@XmlElementName("DestAccount")
	private DestAccount destAccount;

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
	 * @return the exchange rate applied for the transfer
	 */
	public String getExchangeRate() {
		return exchangeRate;
	}

	/**
	 * @param exchangeRate the exchange rate to set
	 */
	public void setExchangeRate(String exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	/**
	 * @return the source account details
	 */
	public SourceAccount getSourceAccount() {
		return sourceAccount;
	}

	/**
	 * @param sourceAccount the source account details to set
	 */
	public void setSourceAccount(SourceAccount sourceAccount) {
		this.sourceAccount = sourceAccount;
	}

	/**
	 * @return the destination account details
	 */
	public DestAccount getDestAccount() {
		return destAccount;
	}

	/**
	 * @param destAccount the destination account details to set
	 */
	public void setDestAccount(DestAccount destAccount) {
		this.destAccount = destAccount;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FundTransferRequest [txnRefNo=").append(txnRefNo).append(", exchangeRate=").append(exchangeRate)
				.append(", sourceAccount=").append(sourceAccount).append(", destAccount=").append(destAccount)
				.append("]");
		return builder.toString();
	}

	public static class SourceAccount {
		@XmlElementName("ProxyNumber")
		private String proxyNumber;

		@XmlElementName("ProductCode")
		private String productCode;

		@XmlElementName("AccountCcy")
		private String accountCcy;

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
		 * @return the account currency
		 */
		public String getAccountCcy() {
			return accountCcy;
		}

		/**
		 * @param accountCcy the account currency to set
		 */
		public void setAccountCcy(String accountCcy) {
			this.accountCcy = accountCcy;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("SourceAccount [proxyNumber=").append(proxyNumber).append(", productCode=")
					.append(productCode).append(", accountCcy=").append(accountCcy).append("]");
			return builder.toString();
		}
	}

	public static class DestAccount {
		@XmlElementName("ProxyNumber")
		private String proxyNumber;

		@XmlElementName("ProductCode")
		private String productCode;

		@XmlElementName("AccountCcy")
		private String accountCcy;

		@XmlElementName("Amount")
		private String amount;

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
		 * @return the account currency
		 */
		public String getAccountCcy() {
			return accountCcy;
		}

		/**
		 * @param accountCcy the account currency to set
		 */
		public void setAccountCcy(String accountCcy) {
			this.accountCcy = accountCcy;
		}

		/**
		 * @return the amount to be credited
		 */
		public String getAmount() {
			return amount;
		}

		/**
		 * @param amount the amount to set
		 */
		public void setAmount(String amount) {
			this.amount = amount;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("DestAccount [proxyNumber=").append(proxyNumber).append(", productCode=").append(productCode)
					.append(", accountCcy=").append(accountCcy).append(", amount=").append(amount).append("]");
			return builder.toString();
		}
	}
}
