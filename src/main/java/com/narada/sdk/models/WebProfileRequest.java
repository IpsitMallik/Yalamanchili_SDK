package com.narada.sdk.models;

import com.narada.sdk.utilities.XmlElementName;

public class WebProfileRequest {
	@XmlElementName("TxnRefNo")
	private String txnRefNo;

	@XmlElementName("ProxyNumber")
	private String proxyNumber;

	@XmlElementName("Reftext1")
	private String reftext1;

	@XmlElementName("Reftext2")
	private String reftext2;

	@XmlElementName("Reftext3")
	private String reftext3;

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
	 * @return the first reference text
	 */
	public String getReftext1() {
		return reftext1;
	}

	/**
	 * @param reftext1 the first reference text to set
	 */
	public void setReftext1(String reftext1) {
		this.reftext1 = reftext1;
	}

	/**
	 * @return the second reference text
	 */
	public String getReftext2() {
		return reftext2;
	}

	/**
	 * @param reftext2 the second reference text to set
	 */
	public void setReftext2(String reftext2) {
		this.reftext2 = reftext2;
	}

	/**
	 * @return the third reference text
	 */
	public String getReftext3() {
		return reftext3;
	}

	/**
	 * @param reftext3 the third reference text to set
	 */
	public void setReftext3(String reftext3) {
		this.reftext3 = reftext3;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WebProfileRequest [txnRefNo=").append(txnRefNo).append(", proxyNumber=").append(proxyNumber)
				.append(", reftext1=").append(reftext1).append(", reftext2=").append(reftext2).append(", reftext3=")
				.append(reftext3).append("]");
		return builder.toString();
	}
}
