package com.narada.sdk.models;

import com.narada.sdk.utilities.XmlElementName;

public class DebitCreditAccountRequest {
	@XmlElementName("TxnRefNo")
	private String txnRefNo;
	@XmlElementName("ProxyNumber")
	private String proxyNumber;
	@XmlElementName("ProductCode")
	private String productCode;
	@XmlElementName("Type")
	private String type;
	@XmlElementName("Flag")
	private String flag;
	@XmlElementName("Amount")
	private String amount;
	@XmlElementName("Currency")
	private String currency;
	@XmlElementName("Remarks")
	private String remarks;

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
	 * @return the transaction type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the transaction type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the flag indicating debit or credit
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * @param flag the flag indicating debit or credit to set
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

	/**
	 * @return the amount to be credited or debited
	 */
	public String getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to be credited or debited to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}

	/**
	 * @return the currency code for the amount
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @param currency the currency code for the amount to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * @return the remarks for the transaction
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks the remarks for the transaction to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RequestXml [txnRefNo=").append(txnRefNo).append(", proxyNumber=").append(proxyNumber)
				.append(", productCode=").append(productCode).append(", type=").append(type).append(", flag=")
				.append(flag).append(", amount=").append(amount).append(", currency=").append(currency)
				.append(", remarks=").append(remarks).append("]");
		return builder.toString();
	}
}
