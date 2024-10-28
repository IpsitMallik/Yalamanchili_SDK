package com.ottl.model;

import java.util.List;

import com.ottl.utils.XmlElementName;


public class XTransactionsResponse {
	@XmlElementName("TxnRefNo")
	private String txnRefNo;
	@XmlElementName("ProxyNumber")
	private String proxyNumber;
	@XmlElementName("ActivateDate")
	private String activateDate;
	@XmlElementName("Transactions")
	private List<TransactionDetail> transactions;

	public String getTxnRefNo() {
		return txnRefNo;
	}

	public void setTxnRefNo(String txnRefNo) {
		this.txnRefNo = txnRefNo;
	}

	public String getProxyNumber() {
		return proxyNumber;
	}

	public void setProxyNumber(String proxyNumber) {
		this.proxyNumber = proxyNumber;
	}

	public String getActivateDate() {
		return activateDate;
	}

	public void setActivateDate(String activateDate) {
		this.activateDate = activateDate;
	}

	public List<TransactionDetail> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<TransactionDetail> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("XTransactionsResponse [txnRefNo=").append(txnRefNo).append(", proxyNumber=").append(proxyNumber)
				.append(", activateDate=").append(activateDate).append(", transactions=").append(transactions)
				.append("]");
		return builder.toString();
	}

	public static class TransactionDetail {
		@XmlElementName("TxnRefNo")
		private String txnRefNo;

		@XmlElementName("TransactionDate")
		private String transactionDate;

		@XmlElementName("TransactionTime")
		private String transactionTime;

		@XmlElementName("ProductCode")
		private String productCode;

		@XmlElementName("TransactionCode")
		private String transactionCode;

		@XmlElementName("TransSettleDate")
		private String transSettleDate;

		@XmlElementName("TransRefNo")
		private String transRefNo;

		@XmlElementName("Description")
		private String description;

		@XmlElementName("TransCurrency")
		private String transCurrency;

		@XmlElementName("TransStatus")
		private String transStatus;

		@XmlElementName("TransAmt")
		private String transAmt;

		@XmlElementName("BillingCurrency")
		private String billingCurrency;

		@XmlElementName("BillingAmt")
		private String billingAmt;

		@XmlElementName("DrCrIndicator")
		private String drCrIndicator;

		@XmlElementName("ExRate")
		private String exRate;

		@XmlElementName("AuthId")
		private String authId;

		@XmlElementName("MccCode")
		private String mccCode;

		@XmlElementName("MerchantId")
		private String merchantId;

		@XmlElementName("MerchantName")
		private String merchantName;

		@XmlElementName("TerminalId")
		private String terminalId;

		@XmlElementName("MerchLocation")
		private String merchLocation;

		@XmlElementName("MerchCountryCode")
		private String merchCountryCode;

		@XmlElementName("PosEntryMode")
		private String posEntryMode;

		@XmlElementName("ResponseCode")
		private String responseCode;

		@XmlElementName("ResponseReason")
		private String responseReason;

		public String getTxnRefNo() {
			return txnRefNo;
		}

		public void setTxnRefNo(String txnRefNo) {
			this.txnRefNo = txnRefNo;
		}

		public String getTransactionDate() {
			return transactionDate;
		}

		public void setTransactionDate(String transactionDate) {
			this.transactionDate = transactionDate;
		}

		public String getTransactionTime() {
			return transactionTime;
		}

		public void setTransactionTime(String transactionTime) {
			this.transactionTime = transactionTime;
		}

		public String getProductCode() {
			return productCode;
		}

		public void setProductCode(String productCode) {
			this.productCode = productCode;
		}

		public String getTransactionCode() {
			return transactionCode;
		}

		public void setTransactionCode(String transactionCode) {
			this.transactionCode = transactionCode;
		}

		public String getTransSettleDate() {
			return transSettleDate;
		}

		public void setTransSettleDate(String transSettleDate) {
			this.transSettleDate = transSettleDate;
		}

		public String getTransRefNo() {
			return transRefNo;
		}

		public void setTransRefNo(String transRefNo) {
			this.transRefNo = transRefNo;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getTransCurrency() {
			return transCurrency;
		}

		public void setTransCurrency(String transCurrency) {
			this.transCurrency = transCurrency;
		}

		public String getTransStatus() {
			return transStatus;
		}

		public void setTransStatus(String transStatus) {
			this.transStatus = transStatus;
		}

		public String getTransAmt() {
			return transAmt;
		}

		public void setTransAmt(String transAmt) {
			this.transAmt = transAmt;
		}

		public String getBillingCurrency() {
			return billingCurrency;
		}

		public void setBillingCurrency(String billingCurrency) {
			this.billingCurrency = billingCurrency;
		}

		public String getBillingAmt() {
			return billingAmt;
		}

		public void setBillingAmt(String billingAmt) {
			this.billingAmt = billingAmt;
		}

		public String getDrCrIndicator() {
			return drCrIndicator;
		}

		public void setDrCrIndicator(String drCrIndicator) {
			this.drCrIndicator = drCrIndicator;
		}

		public String getExRate() {
			return exRate;
		}

		public void setExRate(String exRate) {
			this.exRate = exRate;
		}

		public String getAuthId() {
			return authId;
		}

		public void setAuthId(String authId) {
			this.authId = authId;
		}

		public String getMccCode() {
			return mccCode;
		}

		public void setMccCode(String mccCode) {
			this.mccCode = mccCode;
		}

		public String getMerchantId() {
			return merchantId;
		}

		public void setMerchantId(String merchantId) {
			this.merchantId = merchantId;
		}

		public String getMerchantName() {
			return merchantName;
		}

		public void setMerchantName(String merchantName) {
			this.merchantName = merchantName;
		}

		public String getTerminalId() {
			return terminalId;
		}

		public void setTerminalId(String terminalId) {
			this.terminalId = terminalId;
		}

		public String getMerchLocation() {
			return merchLocation;
		}

		public void setMerchLocation(String merchLocation) {
			this.merchLocation = merchLocation;
		}

		public String getMerchCountryCode() {
			return merchCountryCode;
		}

		public void setMerchCountryCode(String merchCountryCode) {
			this.merchCountryCode = merchCountryCode;
		}

		public String getPosEntryMode() {
			return posEntryMode;
		}

		public void setPosEntryMode(String posEntryMode) {
			this.posEntryMode = posEntryMode;
		}

		public String getResponseCode() {
			return responseCode;
		}

		public void setResponseCode(String responseCode) {
			this.responseCode = responseCode;
		}

		public String getResponseReason() {
			return responseReason;
		}

		public void setResponseReason(String responseReason) {
			this.responseReason = responseReason;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("TransactionDetail [txnRefNo=").append(txnRefNo).append(", transactionDate=")
					.append(transactionDate).append(", transactionTime=").append(transactionTime)
					.append(", productCode=").append(productCode).append(", transactionCode=").append(transactionCode)
					.append(", transSettleDate=").append(transSettleDate).append(", transRefNo=").append(transRefNo)
					.append(", description=").append(description).append(", transCurrency=").append(transCurrency)
					.append(", transStatus=").append(transStatus).append(", transAmt=").append(transAmt)
					.append(", billingCurrency=").append(billingCurrency).append(", billingAmt=").append(billingAmt)
					.append(", drCrIndicator=").append(drCrIndicator).append(", exRate=").append(exRate)
					.append(", authId=").append(authId).append(", mccCode=").append(mccCode).append(", merchantId=")
					.append(merchantId).append(", merchantName=").append(merchantName).append(", terminalId=")
					.append(terminalId).append(", merchLocation=").append(merchLocation).append(", merchCountryCode=")
					.append(merchCountryCode).append(", posEntryMode=").append(posEntryMode).append(", responseCode=")
					.append(responseCode).append(", responseReason=").append(responseReason).append("]");
			return builder.toString();
		}

	}
}
