package com.narada.sdk.models;
import com.narada.sdk.utilities.XmlElementName;

/**
 * Represents a response for card replacement.
 */
public class CardReplaceResponse {
	@XmlElementName("TxnRefNo")
	private String txnRefNo;
	@XmlElementName("ProxyNumber")
	private String proxyNumber;
	@XmlElementName("NewProxyNumber")
	private String newProxyNumber;
	@XmlElementName("CVV")
	private String cvv;
	@XmlElementName("ExpiryDate")
	private String expiryDate;
	
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
	 * @return the cvv number
	 */
	public String getCvv() {
		return cvv;
	}
	/**
	 * @param cvv the cvv number to set
	 */
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	/**
	 * @return the expiry date
	 */
	public String getExpiryDate() {
		return expiryDate;
	}
	/**
	 * @param expiryDate the expiry date to set
	 */
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CardReplaceResponse [txnRefNo=").append(txnRefNo).append(", proxyNumber=").append(proxyNumber)
				.append(", newProxyNumber=").append(newProxyNumber).append(", cvv=").append(cvv)
				.append(", expiryDate=").append(expiryDate)
				.append("]");
		return builder.toString();
	}
}
