package com.narada.sdk.models;

import com.narada.sdk.utilities.XmlElementName;

public class LoadCardResponse {
	@XmlElementName("TxnRefNo")
	private String txnRefNo;
	@XmlElementName("ProxyNumber")
	private String proxyNumber;
	@XmlElementName("BalanceAmt")
	private String balanceAmt;
	@XmlElementName("FeeAmount")
	private String feeAmount;
	
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
	 * @return the balanceAmt
	 */
	public String getBalanceAmt() {
		return balanceAmt;
	}
	
	/**
	 * @param balanceAmt the balanceAmt to set
	 */
	public void setBalanceAmt(String balanceAmt) {
		this.balanceAmt = balanceAmt;
	}
	
	/**
	 * @return the feeAmount
	 */
	public String getFeeAmount() {
		return feeAmount;
	}
	
	/**
	 * @param feeAmount the feeAmount to set
	 */
	public void setFeeAmount(String feeAmount) {
		this.feeAmount = feeAmount;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LoadCardResponse [txnRefNo=").append(txnRefNo).append(", proxyNumber=").append(proxyNumber)
				.append(", balanceAmt=").append(balanceAmt).append(", feeAmount").append(feeAmount)
				.append("]");
		return builder.toString();
	}
}
