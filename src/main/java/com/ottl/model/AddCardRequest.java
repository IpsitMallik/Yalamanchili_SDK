package com.ottl.model;

import com.ottl.utils.XmlElementName;

public class AddCardRequest {
	@XmlElementName("TxnRefNo")
	private String txnRefNo;

	@XmlElementName("ProxyNumber")
	private String proxyNumber;

	@XmlElementName("NewProxyNumber")
	private String newProxyNumber;

	@XmlElementName("CustomerId")
	private String customerId;

	@XmlElementName("NameOnCard")
	private String nameOnCard;

	@XmlElementName("AddCardFlag")
	private String addCardFlag;

	@XmlElementName("CardDesign")
	private String cardDesign;

	@XmlElementName("CardActivationFlag")
	private String cardActivationFlag;

	@XmlElementName("RefText1")
	private String refText1;

	@XmlElementName("RefText2")
	private String refText2;

	@XmlElementName("RefText3")
	private String refText3;

	@XmlElementName("RefText4")
	private String refText4;

	@XmlElementName("LoadDetails")
	private LoadDetails loadDetails;

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
	 * @return the new proxy number
	 */
	public String getNewProxyNumber() {
		return newProxyNumber;
	}

	/**
	 * @param newProxyNumber the new proxy number to set
	 */
	public void setNewProxyNumber(String newProxyNumber) {
		this.newProxyNumber = newProxyNumber;
	}

	/**
	 * @return the customer ID
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customer ID to set
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the name on the card
	 */
	public String getNameOnCard() {
		return nameOnCard;
	}

	/**
	 * @param nameOnCard the name on the card to set
	 */
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	/**
	 * @return the add card flag
	 */
	public String getAddCardFlag() {
		return addCardFlag;
	}

	/**
	 * @param addCardFlag the add card flag to set
	 */
	public void setAddCardFlag(String addCardFlag) {
		this.addCardFlag = addCardFlag;
	}

	/**
	 * @return the card design
	 */
	public String getCardDesign() {
		return cardDesign;
	}

	/**
	 * @param cardDesign the card design to set
	 */
	public void setCardDesign(String cardDesign) {
		this.cardDesign = cardDesign;
	}

	/**
	 * @return the card activation flag
	 */
	public String getCardActivationFlag() {
		return cardActivationFlag;
	}

	/**
	 * @param cardActivationFlag the card activation flag to set
	 */
	public void setCardActivationFlag(String cardActivationFlag) {
		this.cardActivationFlag = cardActivationFlag;
	}

	/**
	 * @return the reference text 1
	 */
	public String getRefText1() {
		return refText1;
	}

	/**
	 * @param refText1 the reference text 1 to set
	 */
	public void setRefText1(String refText1) {
		this.refText1 = refText1;
	}

	/**
	 * @return the reference text 2
	 */
	public String getRefText2() {
		return refText2;
	}

	/**
	 * @param refText2 the reference text 2 to set
	 */
	public void setRefText2(String refText2) {
		this.refText2 = refText2;
	}

	/**
	 * @return the reference text 3
	 */
	public String getRefText3() {
		return refText3;
	}

	/**
	 * @param refText3 the reference text 3 to set
	 */
	public void setRefText3(String refText3) {
		this.refText3 = refText3;
	}

	/**
	 * @return the reference text 4
	 */
	public String getRefText4() {
		return refText4;
	}

	/**
	 * @param refText4 the reference text 4 to set
	 */
	public void setRefText4(String refText4) {
		this.refText4 = refText4;
	}

	/**
	 * @return the load details
	 */
	public LoadDetails getLoadDetails() {
		return loadDetails;
	}

	/**
	 * @param loadDetails the load details to set
	 */
	public void setLoadDetails(LoadDetails loadDetails) {
		this.loadDetails = loadDetails;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AddCardRequest [txnRefNo=").append(txnRefNo).append(", proxyNumber=").append(proxyNumber)
				.append(", newProxyNumber=").append(newProxyNumber).append(", customerId=").append(customerId)
				.append(", nameOnCard=").append(nameOnCard).append(", addCardFlag=").append(addCardFlag)
				.append(", cardDesign=").append(cardDesign).append(", cardActivationFlag=").append(cardActivationFlag)
				.append(", refText1=").append(refText1).append(", refText2=").append(refText2).append(", refText3=")
				.append(refText3).append(", refText4=").append(refText4).append(", loadDetails=").append(loadDetails)
				.append("]");
		return builder.toString();
	}

	public static class LoadDetails {
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
			builder.append("LoadDetails [productCode=").append(productCode).append(", loadAmount=").append(loadAmount)
					.append(", billingAmount=").append(billingAmount).append(", loadCurrency=").append(loadCurrency)
					.append(", billingCurrency=").append(billingCurrency).append("]");
			return builder.toString();
		}
	}
}
