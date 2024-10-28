package com.ottl.model;

import com.ottl.utils.XmlElementName;

public class RetrievePinResponse {
	@XmlElementName("TxnRefNo")
	private String txnRefNo;

	@XmlElementName("ProxyNumber")
	private String proxyNumber;

	@XmlElementName("EPinBlock")
	private String ePinBlock;

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
	 * @return the encrypted PIN block
	 */
	public String getEPinBlock() {
		return ePinBlock;
	}

	/**
	 * @param ePinBlock the encrypted PIN block to set
	 */
	public void setEPinBlock(String ePinBlock) {
		this.ePinBlock = ePinBlock;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PINRetrievalResponse [txnRefNo=").append(txnRefNo).append(", proxyNumber=").append(proxyNumber)
				.append(", ePinBlock=").append(ePinBlock).append("]");
		return builder.toString();
	}
}
