package com.narada.sdk.models;

import com.narada.sdk.utilities.XmlElementName;

public class AccessRightsRequest {
	@XmlElementName("TxnRefNo")
	private String txnRefNo;
	@XmlElementName("UserId")
	private String userId;

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
	 * @return the user ID
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the user ID to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AccessRightsRequest [txnRefNo=").append(txnRefNo).append(", userId=").append(userId)
				.append("]");
		return builder.toString();
	}
}
