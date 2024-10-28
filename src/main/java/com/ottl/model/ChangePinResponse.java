package com.ottl.model;

import com.ottl.utils.XmlElementName;

public class ChangePinResponse {
    @XmlElementName("TxnRefNo")
	private String txnRefNo;

	@XmlElementName("ProxyNumber")
	private String proxyNumber;

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

    @Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ChangePinResponse [txnRefNo=").append(txnRefNo).append(", proxyNumber=")
				.append(proxyNumber).append("]");
		return builder.toString();
	}
}
