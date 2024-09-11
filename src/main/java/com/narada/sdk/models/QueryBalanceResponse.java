package com.narada.sdk.models;

import com.narada.sdk.utilities.XmlElementName;

public class QueryBalanceResponse {
	@XmlElementName("TxnRefNo")
	private String txnRefNo;
	@XmlElementName("ProxyNumber")
	private String proxyNumber;
	@XmlElementName("ProductCode")
	private String productCode;
	@XmlElementName("BalanceAmount")
	private String balanceAmount;
	@XmlElementName("AccountCcy")
	private String accountCcy;

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
	 * @return the balanceAmount
	 */
	public String getBalanceAmount() {
		return balanceAmount;
	}

	/**
	 * @param balanceAmount the balanceAmount to set
	 */
	public void setBalanceAmount(String balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	/**
	 * @return the accountCcy
	 */
	public String getAccountCcy() {
		return accountCcy;
	}

	/**
	 * @param accountCcy the accountCcy to set
	 */
	public void setAccountCcy(String accountCcy) {
		this.accountCcy = accountCcy;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("QueryBalanceResponse [txnRefNo=").append(txnRefNo).append(", proxyNumber=").append(proxyNumber)
				.append(", productCode=").append(productCode).append(", balanceAmount=").append(balanceAmount)
				.append(", accountCcy=").append(accountCcy).append("]");
		return builder.toString();
	}
}
