package com.narada.sdk.models;

import com.narada.sdk.utilities.XmlElementName;


/**
 * Represents a request to fetch card details.
 */
public class CardDetailRequest {
	@XmlElementName("TxnRefNo")
	private String txnRefNo;
	@XmlElementName("ProxyNumber")
	private String proxyNumber;
	@XmlElementName("CustomerId")
	private String customerId;

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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CardRequest [txnRefNo=").append(txnRefNo).append(", proxyNumber=").append(proxyNumber)
				.append(", customerId=").append(customerId).append("]");
		return builder.toString();
	}

}
