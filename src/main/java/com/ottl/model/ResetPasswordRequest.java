package com.ottl.model;

import com.ottl.utils.XmlElementName;

public class ResetPasswordRequest {
	@XmlElementName("TxnRefNo")
	private String txnRefNo;

	@XmlElementName("Reftext1")
	private String reftext1;

	@XmlElementName("Reftext2")
	private String reftext2;

	@XmlElementName("Reftext3")
	private String reftext3;

	@XmlElementName("NewPassword")
	private String newPassword;

	@XmlElementName("ConfirmPassword")
	private String confirmPassword;

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

	/**
	 * @return the confirm password
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}

	/**
	 * @param confirmPassword the confirm password to set
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ResetPasswordRequest [txnRefNo=").append(txnRefNo).append(", reftext1=").append(reftext1)
				.append(", reftext2=").append(reftext2).append(", reftext3=").append(reftext3).append(", newPassword=")
				.append(newPassword).append(", confirmPassword=").append(confirmPassword).append("]");
		return builder.toString();
	}
}
