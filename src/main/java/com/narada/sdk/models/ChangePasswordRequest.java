package com.narada.sdk.models;

import com.narada.sdk.utilities.XmlElementName;

public class ChangePasswordRequest {

	@XmlElementName("TxnRefNo")
	private String txnRefNo;

	@XmlElementName("OldPassword")
	private String oldPassword;

	@XmlElementName("NewPassword")
	private String newPassword;

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
	 * @return the old password
	 */
	public String getOldPassword() {
		return oldPassword;
	}

	/**
	 * @param oldPassword the old password to set
	 */
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	/**
	 * @return the new password
	 */
	public String getNewPassword() {
		return newPassword;
	}

	/**
	 * @param newPassword the new password to set
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ChangePasswordRequest [txnRefNo=").append(txnRefNo).append(", oldPassword=").append(oldPassword)
				.append(", newPassword=").append(newPassword).append("]");
		return builder.toString();
	}
}
