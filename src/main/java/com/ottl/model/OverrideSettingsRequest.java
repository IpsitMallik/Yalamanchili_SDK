package com.ottl.model;

import com.ottl.utils.XmlElementName;

public class OverrideSettingsRequest {
	@XmlElementName("TxnRefNo")
	private String txnRefNo;

	@XmlElementName("ProxyNumber")
	private String proxyNumber;

	@XmlElementName("CampaignCode")
	private String campaignCode;

	@XmlElementName("ProductCode")
	private String productCode;

	@XmlElementName("Flag")
	private String flag;

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
	 * @return the campaign code
	 */
	public String getCampaignCode() {
		return campaignCode;
	}

	/**
	 * @param campaignCode the campaign code to set
	 */
	public void setCampaignCode(String campaignCode) {
		this.campaignCode = campaignCode;
	}

	/**
	 * @return the product code
	 */
	public String getProductCode() {
		return productCode;
	}

	/**
	 * @param productCode the product code to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	/**
	 * @return the campaign code flag (Enable/Disable)
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * @param flag the campaign code flag to set (Enable/Disable)
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AssignOverrideSettingsRequest [txnRefNo=").append(txnRefNo).append(", proxyNumber=")
				.append(proxyNumber).append(", campaignCode=").append(campaignCode).append(", productCode=")
				.append(productCode).append(", flag=").append(flag).append("]");
		return builder.toString();
	}
}
