package com.narada.sdk.models;

import com.narada.sdk.utilities.XmlElementName;

public class CorporateRegistrationResponse {
	@XmlElementName("TxnRefNo")
	private String txnRefNo;

	@XmlElementName("CorporateId")
	private String corporateId;

	@XmlElementName("EnterpriseId")
	private String enterpriseId;

	@XmlElementName("BranchLoginId")
	private String branchLoginId;

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
	 * @return the corporate ID
	 */
	public String getCorporateId() {
		return corporateId;
	}

	/**
	 * @param corporateId the corporate ID to set
	 */
	public void setCorporateId(String corporateId) {
		this.corporateId = corporateId;
	}

	/**
	 * @return the enterprise ID
	 */
	public String getEnterpriseId() {
		return enterpriseId;
	}

	/**
	 * @param enterpriseId the enterprise ID to set
	 */
	public void setEnterpriseId(String enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	/**
	 * @return the branch login ID
	 */
	public String getBranchLoginId() {
		return branchLoginId;
	}

	/**
	 * @param branchLoginId the branch login ID to set
	 */
	public void setBranchLoginId(String branchLoginId) {
		this.branchLoginId = branchLoginId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CorporateRegistrationResponse [txnRefNo=").append(txnRefNo).append(", corporateId=")
				.append(corporateId).append(", enterpriseId=").append(enterpriseId).append(", branchLoginId=")
				.append(branchLoginId).append("]");
		return builder.toString();
	}
}
