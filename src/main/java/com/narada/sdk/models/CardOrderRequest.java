package com.narada.sdk.models;

import com.narada.sdk.utilities.XmlElementName;

public class CardOrderRequest {

	@XmlElementName("TxnRefNo")
	private String txnRefNo;

	@XmlElementName("Order")
	private Order order;

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
	 * Gets the order details.
	 *
	 * @return the order details
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * Sets the order details.
	 *
	 * @param order the order details to set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CardOrderRequest [txnRefNo=").append(txnRefNo).append(", order=").append(order).append("]");
		return builder.toString();
	}

	public static class Order {

		@XmlElementName("BranchId")
		private String branchId;

		@XmlElementName("ProductCode")
		private String productCode;

		@XmlElementName("CardDesign")
		private String cardDesign;

		@XmlElementName("Quantity")
		private String quantity;

		@XmlElementName("Delivery")
		private Delivery delivery;

		/**
		 * Gets the branch ID.
		 *
		 * @return the branch ID
		 */
		public String getBranchId() {
			return branchId;
		}

		/**
		 * Sets the branch ID.
		 *
		 * @param branchId the branch ID to set
		 */
		public void setBranchId(String branchId) {
			this.branchId = branchId;
		}

		/**
		 * Gets the product code.
		 *
		 * @return the product code
		 */
		public String getProductCode() {
			return productCode;
		}

		/**
		 * Sets the product code.
		 *
		 * @param productCode the product code to set
		 */
		public void setProductCode(String productCode) {
			this.productCode = productCode;
		}

		/**
		 * Gets the card design.
		 *
		 * @return the card design
		 */
		public String getCardDesign() {
			return cardDesign;
		}

		/**
		 * Sets the card design.
		 *
		 * @param cardDesign the card design to set
		 */
		public void setCardDesign(String cardDesign) {
			this.cardDesign = cardDesign;
		}

		/**
		 * Gets the quantity of cards to be ordered.
		 *
		 * @return the quantity of cards
		 */
		public String getQuantity() {
			return quantity;
		}

		/**
		 * Sets the quantity of cards to be ordered.
		 *
		 * @param quantity the quantity of cards to set
		 */
		public void setQuantity(String quantity) {
			this.quantity = quantity;
		}

		/**
		 * Gets the delivery details.
		 *
		 * @return the delivery details
		 */
		public Delivery getDelivery() {
			return delivery;
		}

		/**
		 * Sets the delivery details.
		 *
		 * @param delivery the delivery details to set
		 */
		public void setDelivery(Delivery delivery) {
			this.delivery = delivery;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Order [branchId=").append(branchId).append(", productCode=").append(productCode)
					.append(", cardDesign=").append(cardDesign).append(", quantity=").append(quantity)
					.append(", delivery=").append(delivery).append("]");
			return builder.toString();
		}

		public static class Delivery {

			@XmlElementName("Name")
			private String name;

			@XmlElementName("Address1")
			private String address1;

			@XmlElementName("Address2")
			private String address2;

			@XmlElementName("Address3")
			private String address3;

			@XmlElementName("Address4")
			private String address4;

			@XmlElementName("City")
			private String city;

			@XmlElementName("State")
			private String state;

			@XmlElementName("Country")
			private String country;

			@XmlElementName("PostalCode")
			private String postalCode;

			/**
			 * Gets the name of the branch.
			 *
			 * @return the branch name
			 */
			public String getName() {
				return name;
			}

			/**
			 * Sets the name of the branch.
			 *
			 * @param name the branch name to set
			 */
			public void setName(String name) {
				this.name = name;
			}

			/**
			 * Gets the first line of the branch address.
			 *
			 * @return the address line 1
			 */
			public String getAddress1() {
				return address1;
			}

			/**
			 * Sets the first line of the branch address.
			 *
			 * @param address1 the address line 1 to set
			 */
			public void setAddress1(String address1) {
				this.address1 = address1;
			}

			/**
			 * Gets the second line of the branch address.
			 *
			 * @return the address line 2
			 */
			public String getAddress2() {
				return address2;
			}

			/**
			 * Sets the second line of the branch address.
			 *
			 * @param address2 the address line 2 to set
			 */
			public void setAddress2(String address2) {
				this.address2 = address2;
			}

			/**
			 * Gets the third line of the branch address.
			 *
			 * @return the address line 3
			 */
			public String getAddress3() {
				return address3;
			}

			/**
			 * Sets the third line of the branch address.
			 *
			 * @param address3 the address line 3 to set
			 */
			public void setAddress3(String address3) {
				this.address3 = address3;
			}

			/**
			 * Gets the fourth line of the branch address.
			 *
			 * @return the address line 4
			 */
			public String getAddress4() {
				return address4;
			}

			/**
			 * Sets the fourth line of the branch address.
			 *
			 * @param address4 the address line 4 to set
			 */
			public void setAddress4(String address4) {
				this.address4 = address4;
			}

			/**
			 * Gets the city of the branch address.
			 *
			 * @return the city name
			 */
			public String getCity() {
				return city;
			}

			/**
			 * Sets the city of the branch address.
			 *
			 * @param city the city name to set
			 */
			public void setCity(String city) {
				this.city = city;
			}

			/**
			 * Gets the state of the branch address.
			 *
			 * @return the state name
			 */
			public String getState() {
				return state;
			}

			/**
			 * Sets the state of the branch address.
			 *
			 * @param state the state name to set
			 */
			public void setState(String state) {
				this.state = state;
			}

			/**
			 * Gets the country of the branch address.
			 *
			 * @return the country name
			 */
			public String getCountry() {
				return country;
			}

			/**
			 * Sets the country of the branch address.
			 *
			 * @param country the country name to set
			 */
			public void setCountry(String country) {
				this.country = country;
			}

			/**
			 * Gets the postal code of the branch address.
			 *
			 * @return the postal code
			 */
			public String getPostalCode() {
				return postalCode;
			}

			/**
			 * Sets the postal code of the branch address.
			 *
			 * @param postalCode the postal code to set
			 */
			public void setPostalCode(String postalCode) {
				this.postalCode = postalCode;
			}

			@Override
			public String toString() {
				StringBuilder builder = new StringBuilder();
				builder.append("Delivery [name=").append(name).append(", address1=").append(address1)
						.append(", address2=").append(address2).append(", address3=").append(address3)
						.append(", address4=").append(address4).append(", city=").append(city).append(", state=")
						.append(state).append(", country=").append(country).append(", postalCode=").append(postalCode)
						.append("]");
				return builder.toString();
			}
		}
	}
}
