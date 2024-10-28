package com.ottl.model;

import com.ottl.utils.XmlElementName;

public class AlertSettingsRequest {
	@XmlElementName("TxnRefNo")
	private String txnRefNo;

	@XmlElementName("ProxyNumber")
	private String proxyNumber;

	@XmlElementName("ProductCode")
	private String productCode;

	@XmlElementName("AlertType")
	private String alertType;

	@XmlElementName("Frequency")
	private String frequency;

	@XmlElementName("AlertData")
	private String alertData;

	@XmlElementName("Channel")
	private String channel;

	@XmlElementName("AlertSet")
	private String alertSet;

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
	 * @return the alert type
	 */
	public String getAlertType() {
		return alertType;
	}

	/**
	 * @param alertType the alert type to set
	 */
	public void setAlertType(String alertType) {
		this.alertType = alertType;
	}

	/**
	 * @return the frequency of the alert
	 */
	public String getFrequency() {
		return frequency;
	}

	/**
	 * @param frequency the frequency to set
	 */
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	/**
	 * @return the alert data
	 */
	public String getAlertData() {
		return alertData;
	}

	/**
	 * @param alertData the alert data to set
	 */
	public void setAlertData(String alertData) {
		this.alertData = alertData;
	}

	/**
	 * @return the channel for the alert
	 */
	public String getChannel() {
		return channel;
	}

	/**
	 * @param channel the channel to set
	 */
	public void setChannel(String channel) {
		this.channel = channel;
	}

	/**
	 * @return whether the alert is set or unset
	 */
	public String getAlertSet() {
		return alertSet;
	}

	/**
	 * @param alertSet the alert set or unset value to set
	 */
	public void setAlertSet(String alertSet) {
		this.alertSet = alertSet;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AlertSettingsRequest [txnRefNo=").append(txnRefNo).append(", proxyNumber=").append(proxyNumber)
				.append(", productCode=").append(productCode).append(", alertType=").append(alertType)
				.append(", frequency=").append(frequency).append(", alertData=").append(alertData).append(", channel=")
				.append(channel).append(", alertSet=").append(alertSet).append("]");
		return builder.toString();
	}
}
