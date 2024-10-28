package com.ottl.model;

import java.util.List;

import com.ottl.utils.XmlElementName;

public class AddAccountRequest {
	@XmlElementName("TxnRefNo")
	private String txnRefNo;
	@XmlElementName("ProxyNumber")
	private String proxyNumber;
	@XmlElementName("ProductInfo")
	private ProductInfo productInfo;

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
	 * @return the product info
	 */
	public ProductInfo getProductInfo() {
		return productInfo;
	}

	/**
	 * @param productInfo the product info to set
	 */
	public void setProductInfo(ProductInfo productInfo) {
		this.productInfo = productInfo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AddAccountRequest [txnRefNo=").append(txnRefNo).append(", proxyNumber=").append(proxyNumber)
				.append(", productInfo=").append(productInfo).append("]");
		return builder.toString();
	}

	public static class ProductInfo {

		@XmlElementName("Details")
		private Details details;

		/**
		 * @return the details
		 */
		public Details getDetails() {
			return details;
		}

		/**
		 * @param details the details to set
		 */
		public void setDetails(Details details) {
			this.details = details;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("ProductInfo [details=").append(details).append("]");
			return builder.toString();
		}

		public static class Details {
			@XmlElementName("ProductCode")
			private String productCode;
			@XmlElementName("LoadAmount")
			private String loadAmount;
			@XmlElementName("BillingAmount")
			private String billingAmount;
			@XmlElementName("LoadCurrency")
			private String loadCurrency;
			@XmlElementName("BillingCurrency")
			private String billingCurrency;

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
			 * @return the load amount
			 */
			public String getLoadAmount() {
				return loadAmount;
			}

			/**
			 * @param loadAmount the load amount to set
			 */
			public void setLoadAmount(String loadAmount) {
				this.loadAmount = loadAmount;
			}

			/**
			 * @return the billing amount
			 */
			public String getBillingAmount() {
				return billingAmount;
			}

			/**
			 * @param billingAmount the billing amount to set
			 */
			public void setBillingAmount(String billingAmount) {
				this.billingAmount = billingAmount;
			}

			/**
			 * @return the load currency
			 */
			public String getLoadCurrency() {
				return loadCurrency;
			}

			/**
			 * @param loadCurrency the load currency to set
			 */
			public void setLoadCurrency(String loadCurrency) {
				this.loadCurrency = loadCurrency;
			}

			/**
			 * @return the billing currency
			 */
			public String getBillingCurrency() {
				return billingCurrency;
			}

			/**
			 * @param billingCurrency the billing currency to set
			 */
			public void setBillingCurrency(String billingCurrency) {
				this.billingCurrency = billingCurrency;
			}

			@Override
			public String toString() {
				StringBuilder builder = new StringBuilder();
				builder.append("Details [productCode=").append(productCode).append(", loadAmount=").append(loadAmount)
						.append(", billingAmount=").append(billingAmount).append(", loadCurrency=").append(loadCurrency)
						.append(", billingCurrency=").append(billingCurrency).append("]");
				return builder.toString();
			}
		}
	}
}
