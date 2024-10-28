package com.ottl.model;

import java.util.List;

import com.ottl.utils.XmlElementName;

/**
 * Represents a request to issue a new card.
 */
public class NewCardRequest {
	@XmlElementName("TxnRefNo")
	private String txnRefNo;
	@XmlElementName("ProxyNumber")
	private String proxyNumber;
	@XmlElementName("CustomerId")
	private String customerId;
	@XmlElementName("NameOnCard")
	private String nameOnCard;
	@XmlElementName("CardDesign")
	private String cardDesign;
	@XmlElementName("CardActivationFlag")
	private String cardActivationFlag;
	@XmlElementName("AlertFlag")
	private String alertFlag;
	@XmlElementName("RefText1")
	private String refText1;
	@XmlElementName("RefText2")
	private String refText2;
	@XmlElementName("RefText3")
	private String refText3;
	@XmlElementName("RefText4")
	private String refText4;
	@XmlElementName("CustomerInfo")
	private CustomerInfo customerInfo;
	@XmlElementName("LoadDetails")
	private LoadDetails loadDetails;

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
	 * @return the customer ID
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customer ID to set
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the name on the card
	 */
	public String getNameOnCard() {
		return nameOnCard;
	}

	/**
	 * @param nameOnCard the name on the card to set
	 */
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	/**
	 * @return the card design
	 */
	public String getCardDesign() {
		return cardDesign;
	}

	/**
	 * @param cardDesign the card design to set
	 */
	public void setCardDesign(String cardDesign) {
		this.cardDesign = cardDesign;
	}

	/**
	 * @return the card activation flag
	 */
	public String getCardActivationFlag() {
		return cardActivationFlag;
	}

	/**
	 * @param cardActivationFlag the card activation flag to set
	 */
	public void setCardActivationFlag(String cardActivationFlag) {
		this.cardActivationFlag = cardActivationFlag;
	}

	/**
	 * @return the alert flag
	 */
	public String getAlertFlag() {
		return alertFlag;
	}

	/**
	 * @param alertFlag the alert flag to set
	 */
	public void setAlertFlag(String alertFlag) {
		this.alertFlag = alertFlag;
	}

	/**
	 * @return the first reference text
	 */
	public String getRefText1() {
		return refText1;
	}

	/**
	 * @param refText1 the first reference text to set
	 */
	public void setRefText1(String refText1) {
		this.refText1 = refText1;
	}

	/**
	 * @return the second reference text
	 */
	public String getRefText2() {
		return refText2;
	}

	/**
	 * @param refText2 the second reference text to set
	 */
	public void setRefText2(String refText2) {
		this.refText2 = refText2;
	}

	/**
	 * @return the third reference text
	 */
	public String getRefText3() {
		return refText3;
	}

	/**
	 * @param refText3 the third reference text to set
	 */
	public void setRefText3(String refText3) {
		this.refText3 = refText3;
	}

	/**
	 * @return the fourth reference text
	 */
	public String getRefText4() {
		return refText4;
	}

	/**
	 * @param refText4 the fourth reference text to set
	 */
	public void setRefText4(String refText4) {
		this.refText4 = refText4;
	}

	/**
	 * @return the customer information
	 */
	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}

	/**
	 * @param customerInfo the customer information to set
	 */
	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}

	/**
	 * @return the load details
	 */
	public LoadDetails getLoadDetails() {
		return loadDetails;
	}

	/**
	 * @param loadDetails the load details to set
	 */
	public void setLoadDetails(LoadDetails loadDetails) {
		this.loadDetails = loadDetails;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CardRequest [txnRefNo=").append(txnRefNo).append(", proxyNumber=").append(proxyNumber)
				.append(", customerId=").append(customerId).append(", nameOnCard=").append(nameOnCard)
				.append(", cardDesign=").append(cardDesign).append(", cardActivationFlag=").append(cardActivationFlag)
				.append(", alertFlag=").append(alertFlag).append(", refText1=").append(refText1).append(", refText2=")
				.append(refText2).append(", refText3=").append(refText3).append(", refText4=").append(refText4)
				.append(", customerInfo=").append(customerInfo).append(", loadDetails=").append(loadDetails)
				.append("]");
		return builder.toString();
	}

	/**
	 * Represents customer information for the card request.
	 */
	public static class CustomerInfo {
		@XmlElementName("Title")
		private String title;
		@XmlElementName("FirstName")
		private String firstName;
		@XmlElementName("LastName")
		private String lastName;
		@XmlElementName("DOB")
		private String dob;
		@XmlElementName("Gender")
		private String gender;
		@XmlElementName("MobileNumber")
		private String mobileNumber;
		@XmlElementName("EmailAddress")
		private String emailAddress;
		@XmlElementName("Image")
		private String image;
		@XmlElementName("Address")
		private Address address;
		@XmlElementName("MailAddress")
		private MailAddress mailAddress;
		@XmlElementName("IdentificationType")
		private List<IdentificationType> identificationType;

		/**
		 * @return the title
		 */
		public String getTitle() {
			return title;
		}

		/**
		 * @param title the title to set
		 */
		public void setTitle(String title) {
			this.title = title;
		}

		/**
		 * @return the first name
		 */
		public String getFirstName() {
			return firstName;
		}

		/**
		 * @param firstName the first name to set
		 */
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		/**
		 * @return the last name
		 */
		public String getLastName() {
			return lastName;
		}

		/**
		 * @param lastName the last name to set
		 */
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		/**
		 * @return the date of birth
		 */
		public String getDob() {
			return dob;
		}

		/**
		 * @param dob the date of birth to set
		 */
		public void setDob(String dob) {
			this.dob = dob;
		}

		/**
		 * @return the gender
		 */
		public String getGender() {
			return gender;
		}

		/**
		 * @param gender the gender to set
		 */
		public void setGender(String gender) {
			this.gender = gender;
		}

		/**
		 * @return the mobile number
		 */
		public String getMobileNumber() {
			return mobileNumber;
		}

		/**
		 * @param mobileNumber the mobile number to set
		 */
		public void setMobileNumber(String mobileNumber) {
			this.mobileNumber = mobileNumber;
		}

		/**
		 * @return the email address
		 */
		public String getEmailAddress() {
			return emailAddress;
		}

		/**
		 * @param emailAddress the email address to set
		 */
		public void setEmailAddress(String emailAddress) {
			this.emailAddress = emailAddress;
		}

		/**
		 * @return the image URL
		 */
		public String getImage() {
			return image;
		}

		/**
		 * @param image the image URL to set
		 */
		public void setImage(String image) {
			this.image = image;
		}

		/**
		 * @return the address
		 */
		public Address getAddress() {
			return address;
		}

		/**
		 * @param address the address to set
		 */
		public void setAddress(Address address) {
			this.address = address;
		}

		/**
		 * @return the mailing address
		 */
		public MailAddress getMailAddress() {
			return mailAddress;
		}

		/**
		 * @param mailAddress the mailing address to set
		 */
		public void setMailAddress(MailAddress mailAddress) {
			this.mailAddress = mailAddress;
		}

		/**
		 * @return the list of identification types
		 */
		public List<IdentificationType> getIdentificationType() {
			return identificationType;
		}

		/**
		 * @param identificationType the list of identification types to set
		 */
		public void setIdentificationType(List<IdentificationType> identificationType) {
			this.identificationType = identificationType;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("CustomerInfo [title=").append(title).append(", firstName=").append(firstName)
					.append(", lastName=").append(lastName).append(", dob=").append(dob).append(", gender=")
					.append(gender).append(", mobileNumber=").append(mobileNumber).append(", emailAddress=")
					.append(emailAddress).append(", image=").append(image).append(", address=").append(address)
					.append(", mailAddress=").append(mailAddress).append(", identificationTypes=")
					.append(identificationType).append("]");
			return builder.toString();
		}

		/**
		 * Represents an address.
		 */
		public static class Address {
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
			@XmlElementName("HomeNumber")
			private String homeNumber;

			/**
			 * @return the first line of the address
			 */
			public String getAddress1() {
				return address1;
			}

			/**
			 * @param address1 the first line of the address to set
			 */
			public void setAddress1(String address1) {
				this.address1 = address1;
			}

			/**
			 * @return the second line of the address
			 */
			public String getAddress2() {
				return address2;
			}

			/**
			 * @param address2 the second line of the address to set
			 */
			public void setAddress2(String address2) {
				this.address2 = address2;
			}

			/**
			 * @return the third line of the address
			 */
			public String getAddress3() {
				return address3;
			}

			/**
			 * @param address3 the third line of the address to set
			 */
			public void setAddress3(String address3) {
				this.address3 = address3;
			}

			/**
			 * @return the fourth line of the address
			 */
			public String getAddress4() {
				return address4;
			}

			/**
			 * @param address4 the fourth line of the address to set
			 */
			public void setAddress4(String address4) {
				this.address4 = address4;
			}

			/**
			 * @return the city
			 */
			public String getCity() {
				return city;
			}

			/**
			 * @param city the city to set
			 */
			public void setCity(String city) {
				this.city = city;
			}

			/**
			 * @return the state
			 */
			public String getState() {
				return state;
			}

			/**
			 * @param state the state to set
			 */
			public void setState(String state) {
				this.state = state;
			}

			/**
			 * @return the country
			 */
			public String getCountry() {
				return country;
			}

			/**
			 * @param country the country to set
			 */
			public void setCountry(String country) {
				this.country = country;
			}

			/**
			 * @return the postal code
			 */
			public String getPostalCode() {
				return postalCode;
			}

			/**
			 * @param postalCode the postal code to set
			 */
			public void setPostalCode(String postalCode) {
				this.postalCode = postalCode;
			}

			/**
			 * @return the home phone number
			 */
			public String getHomeNumber() {
				return homeNumber;
			}

			/**
			 * @param homeNumber the home phone number to set
			 */
			public void setHomeNumber(String homeNumber) {
				this.homeNumber = homeNumber;
			}

			@Override
			public String toString() {
				StringBuilder builder = new StringBuilder();
				builder.append("Address [address1=").append(address1).append(", address2=").append(address2)
						.append(", address3=").append(address3).append(", address4=").append(address4).append(", city=")
						.append(city).append(", state=").append(state).append(", country=").append(country)
						.append(", postalCode=").append(postalCode).append(", homeNumber=").append(homeNumber)
						.append("]");
				return builder.toString();
			}
		}

		/**
		 * Represents a mailing address.
		 */
		public static class MailAddress {
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
			@XmlElementName("WorkNumber")
			private String workNumber;
			@XmlElementName("Extension")
			private String extension;

			/**
			 * @return the first line of the address
			 */
			public String getAddress1() {
				return address1;
			}

			/**
			 * @param address1 the first line of the address to set
			 */
			public void setAddress1(String address1) {
				this.address1 = address1;
			}

			/**
			 * @return the second line of the address
			 */
			public String getAddress2() {
				return address2;
			}

			/**
			 * @param address2 the second line of the address to set
			 */
			public void setAddress2(String address2) {
				this.address2 = address2;
			}

			/**
			 * @return the third line of the address
			 */
			public String getAddress3() {
				return address3;
			}

			/**
			 * @param address3 the third line of the address to set
			 */
			public void setAddress3(String address3) {
				this.address3 = address3;
			}

			/**
			 * @return the fourth line of the address
			 */
			public String getAddress4() {
				return address4;
			}

			/**
			 * @param address4 the fourth line of the address to set
			 */
			public void setAddress4(String address4) {
				this.address4 = address4;
			}

			/**
			 * @return the city
			 */
			public String getCity() {
				return city;
			}

			/**
			 * @param city the city to set
			 */
			public void setCity(String city) {
				this.city = city;
			}

			/**
			 * @return the state
			 */
			public String getState() {
				return state;
			}

			/**
			 * @param state the state to set
			 */
			public void setState(String state) {
				this.state = state;
			}

			/**
			 * @return the country
			 */
			public String getCountry() {
				return country;
			}

			/**
			 * @param country the country to set
			 */
			public void setCountry(String country) {
				this.country = country;
			}

			/**
			 * @return the postal code
			 */
			public String getPostalCode() {
				return postalCode;
			}

			/**
			 * @param postalCode the postal code to set
			 */
			public void setPostalCode(String postalCode) {
				this.postalCode = postalCode;
			}

			/**
			 * @return the work phone number
			 */
			public String getWorkNumber() {
				return workNumber;
			}

			/**
			 * @param workNumber the work phone number to set
			 */
			public void setWorkNumber(String workNumber) {
				this.workNumber = workNumber;
			}

			/**
			 * @return the extension number
			 */
			public String getExtension() {
				return extension;
			}

			/**
			 * @param extension the extension number to set
			 */
			public void setExtension(String extension) {
				this.extension = extension;
			}

			@Override
			public String toString() {
				StringBuilder builder = new StringBuilder();
				builder.append("MailAddress [address1=").append(address1).append(", address2=").append(address2)
						.append(", address3=").append(address3).append(", address4=").append(address4).append(", city=")
						.append(city).append(", state=").append(state).append(", country=").append(country)
						.append(", postalCode=").append(postalCode).append(", workNumber=").append(workNumber)
						.append(", extension=").append(extension).append("]");
				return builder.toString();
			}
		}

		/**
		 * Represents an identification type.
		 */
		public static class IdentificationType {
			@XmlElementName("IdType")
			private String idType;
			@XmlElementName("IdNumber")
			private String idNumber;
			@XmlElementName("ExpiryDate")
			private String expiryDate;
			@XmlElementName("CountryOfIssue")
			private String countryOfIssue;

			/**
			 * @return the identification type
			 */
			public String getIdType() {
				return idType;
			}

			/**
			 * @param idType the identification type to set
			 */
			public void setIdType(String idType) {
				this.idType = idType;
			}

			/**
			 * @return the identification number
			 */
			public String getIdNumber() {
				return idNumber;
			}

			/**
			 * @param idNumber the identification number to set
			 */
			public void setIdNumber(String idNumber) {
				this.idNumber = idNumber;
			}

			/**
			 * @return the expiry date
			 */
			public String getExpiryDate() {
				return expiryDate;
			}

			/**
			 * @param expiryDate the expiry date to set
			 */
			public void setExpiryDate(String expiryDate) {
				this.expiryDate = expiryDate;
			}

			/**
			 * @return the country of issue
			 */
			public String getCountryOfIssue() {
				return countryOfIssue;
			}

			/**
			 * @param countryOfIssue the country of issue to set
			 */
			public void setCountryOfIssue(String countryOfIssue) {
				this.countryOfIssue = countryOfIssue;
			}

			@Override
			public String toString() {
				StringBuilder builder = new StringBuilder();
				builder.append("IdentificationType [idType=").append(idType).append(", idNumber=").append(idNumber)
						.append(", expiryDate=").append(expiryDate).append(", countryOfIssue=").append(countryOfIssue)
						.append("]");
				return builder.toString();
			}
		}
	}

	/**
	 * Represents the details of a load operation.
	 */
	public static class LoadDetails {
		@XmlElementName("ProductCode")
		private String productCode;
		@XmlElementName("LoadAmount")
		private String loadAmount;
		@XmlElementName("BillingAmount")
		private String billingAmount;
		@XmlElementName("LoadCurrency")
		private String loadCurrency;
		@XmlElementName("BillingCurrency")
		private String billingCurrency;

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
		 * @return the load amount
		 */
		public String getLoadAmount() {
			return loadAmount;
		}

		/**
		 * @param loadAmount the load amount to set
		 */
		public void setLoadAmount(String loadAmount) {
			this.loadAmount = loadAmount;
		}

		/**
		 * @return the billing amount
		 */
		public String getBillingAmount() {
			return billingAmount;
		}

		/**
		 * @param billingAmount the billing amount to set
		 */
		public void setBillingAmount(String billingAmount) {
			this.billingAmount = billingAmount;
		}

		/**
		 * @return the load currency
		 */
		public String getLoadCurrency() {
			return loadCurrency;
		}

		/**
		 * @param loadCurrency the load currency to set
		 */
		public void setLoadCurrency(String loadCurrency) {
			this.loadCurrency = loadCurrency;
		}

		/**
		 * @return the billing currency
		 */
		public String getBillingCurrency() {
			return billingCurrency;
		}

		/**
		 * @param billingCurrency the billing currency to set
		 */
		public void setBillingCurrency(String billingCurrency) {
			this.billingCurrency = billingCurrency;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("LoadDetails [productCode=").append(productCode).append(", loadAmount=").append(loadAmount)
					.append(", billingAmount=").append(billingAmount).append(", loadCurrency=").append(loadCurrency)
					.append(", billingCurrency=").append(billingCurrency).append("]");
			return builder.toString();
		}
	}

}
