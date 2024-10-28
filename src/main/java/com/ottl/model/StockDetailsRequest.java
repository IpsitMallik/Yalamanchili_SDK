package com.ottl.model;

import com.ottl.utils.XmlElementName;

public class StockDetailsRequest {
	@XmlElementName("TxnRefNo")
	private String txnRefNo;

	@XmlElementName("BranchId")
	private String branchId;
	
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
	 * @return the branch ID
	 */
	public String getBranchId() {
		return branchId;
	}

	/**
	 * @param branchId the branch ID to set
	 */
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StockDetailsRequest [txnRefNo=").append(txnRefNo).append(", branchId=").append(branchId)
				.append("]");
		return builder.toString();
	}
}
