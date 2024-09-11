package com.narada.sdk.models;

import com.narada.sdk.utilities.XmlElementName;
import java.util.List;

public class UpdateExchangeRateRequest {

	@XmlElementName("TxnRefNo")
	private String txnRefNo;

	@XmlElementName("ExRates")
	private List<Detail> exRates;

	/**
	 * Gets the transaction reference number.
	 *
	 * @return the transaction reference number
	 */
	public String getTxnRefNo() {
		return txnRefNo;
	}

	/**
	 * Sets the transaction reference number.
	 *
	 * @param txnRefNo the transaction reference number to set
	 */
	public void setTxnRefNo(String txnRefNo) {
		this.txnRefNo = txnRefNo;
	}

	/**
	 * Gets the list of exchange rates details.
	 *
	 * @return the list of exchange rates details
	 */
	public List<Detail> getExRates() {
		return exRates;
	}

	/**
	 * Sets the list of exchange rates details.
	 *
	 * @param exRates the list of exchange rates details to set
	 */
	public void setExRates(List<Detail> exRates) {
		this.exRates = exRates;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ExchangeRateRequest [txnRefNo=").append(txnRefNo).append(", exRates=").append(exRates)
				.append("]");
		return builder.toString();
	}

	public static class Detail {

		@XmlElementName("BuyCurrency")
		private String buyCurrency;

		@XmlElementName("SellCurrency")
		private String sellCurrency;

		@XmlElementName("ExRate")
		private String exRate;

		/**
		 * Gets the buying currency code.
		 *
		 * @return the buying currency code
		 */
		public String getBuyCurrency() {
			return buyCurrency;
		}

		/**
		 * Sets the buying currency code.
		 *
		 * @param buyCurrency the buying currency code to set
		 */
		public void setBuyCurrency(String buyCurrency) {
			this.buyCurrency = buyCurrency;
		}

		/**
		 * Gets the selling currency code.
		 *
		 * @return the selling currency code
		 */
		public String getSellCurrency() {
			return sellCurrency;
		}

		/**
		 * Sets the selling currency code.
		 *
		 * @param sellCurrency the selling currency code to set
		 */
		public void setSellCurrency(String sellCurrency) {
			this.sellCurrency = sellCurrency;
		}

		/**
		 * Gets the exchange rate.
		 *
		 * @return the exchange rate
		 */
		public String getExRate() {
			return exRate;
		}

		/**
		 * Sets the exchange rate.
		 *
		 * @param exRate the exchange rate to set
		 */
		public void setExRate(String exRate) {
			this.exRate = exRate;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Detail [buyCurrency=").append(buyCurrency).append(", sellCurrency=").append(sellCurrency)
					.append(", exRate=").append(exRate).append("]");
			return builder.toString();
		}
	}

}
