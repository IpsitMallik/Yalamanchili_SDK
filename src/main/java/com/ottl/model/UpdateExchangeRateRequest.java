package com.ottl.model;

import java.util.List;

import com.ottl.utils.XmlElementName;

public class UpdateExchangeRateRequest {

	@XmlElementName("TxnRefNo")
	private String txnRefNo;

	@XmlElementName("ExRates")
	private ExRates exRates;

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
	 * Gets the ExRates.
	 *
	 * @return the exchange rates
	 */
	public ExRates getExRates() {
		return exRates;
	}

	/**
	 * Sets the exchange rates.
	 *
	 * @param exRates the exchange rates to set
	 */
	public void setExRates(ExRates exRates) {
		this.exRates = exRates;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ExchangeRateRequest [txnRefNo=").append(txnRefNo).append(", exRates=").append(exRates)
				.append("]");
		return builder.toString();
	}

	public static class ExRates {
		@XmlElementName("Detail")
		List<Detail> detail;

		/**
		 * @return the details
		 */
		public List<Detail> getDetail() {
			return detail;
		}

		/**
		 * @param detail the details to set
		 */
		public void setDetail(List<Detail> detail) {
			this.detail = detail;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("ExRates [detail=").append(detail).append("]");
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
				builder.append("Detail [buyCurrency=").append(buyCurrency).append(", sellCurrency=")
						.append(sellCurrency)
						.append(", exRate=").append(exRate).append("]");
				return builder.toString();
			}
		}
	}

}
