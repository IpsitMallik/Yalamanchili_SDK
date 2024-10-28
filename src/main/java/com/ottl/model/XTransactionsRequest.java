package com.ottl.model;

import com.ottl.utils.XmlElementName;

public class XTransactionsRequest {
	@XmlElementName("TxnRefNo")
	private String txnRefNo;
	@XmlElementName("ProxyNumber")
	private String proxyNumber;
	@XmlElementName("FromDate")
	private String fromDate;
	@XmlElementName("ToDate")
	private String toDate;
	@XmlElementName("Count")
	private String count;
	@XmlElementName("PageNumber")
	private String pageNumber;

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
	 * @return the fromDate
	 */
	public String getFromDate() {
		return fromDate;
	}
	
	/**
	 * @param fromDate the fromDate to set
	 */
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	
	/**
	 * @return the toDate
	 */
	public String getToDate() {
		return toDate;
	}
	
	/**
	 * @param toDate the toDate to set
	 */
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	
	/**
	 * @return the count
	 */
	public String getCount() {
		return count;
	}
	
	/**
	 * @param count the count to set
	 */
	public void setCount(String count) {
		this.count = count;
	}
	
	/**
	 * @return the pageNumber number
	 */
	public String getPageNumber() {
		return pageNumber;
	}
	
	/**
	 * @param pageNumber the pageNumber to set
	 */
	public void setPageNumber(String pageNumber) {
		this.pageNumber = pageNumber;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GetXTransactionRequest [txnRefNo=").append(txnRefNo).append(", proxyNumber=")
				.append(proxyNumber).append(", fromDate=").append(fromDate).append(", toDate=").append(toDate)
				.append(", count=").append(count).append(", pageNumber=").append(pageNumber).append("]");
		return builder.toString();
	}
}
