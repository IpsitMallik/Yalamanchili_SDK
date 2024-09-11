package com.narada.sdk.models;

import com.narada.sdk.utilities.XmlElementName;

import java.util.List;

/**
 * Represents a response containing card details.
 */
public class CardDetailResponse {

	@XmlElementName("TxnRefNo")
	private String txnRefNo;

	@XmlElementName("ProxyNumber")
	private String proxyNumber;

	@XmlElementName("CardStatus")
	private String cardStatus;

	@XmlElementName("ExpiryDate")
	private String expiryDate;

	@XmlElementName("NameOnCard")
	private String nameOnCard;

	@XmlElementName("CustomerInfo")
	private CustomerInfo customerInfo;

	@XmlElementName("ProductInfo")
	private List<ProductInfo> productInfo;

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
	 * @return the card status
	 */
	public String getCardStatus() {
		return cardStatus;
	}

	/**
	 * @param cardStatus the card status to set
	 */
	public void setCardStatus(String cardStatus) {
		this.cardStatus = cardStatus;
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
	 * @return the name on card
	 */
	public String getNameOnCard() {
		return nameOnCard;
	}

	/**
	 * @param nameOnCard the name on card to set
	 */
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
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
	 * @return the product information
	 */
	public List<ProductInfo> getProductInfo() {
		return productInfo;
	}

	/**
	 * @param productInfo the product information to set
	 */
	public void setProductInfo(List<ProductInfo> productInfo) {
		this.productInfo = productInfo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CardDetailResponse[").append("txnRefNo=").append(txnRefNo).append(", proxyNumber=")
				.append(proxyNumber).append(", cardStatus=").append(cardStatus).append(", expiryDate=")
				.append(expiryDate).append(", nameOnCard=").append(nameOnCard).append(", customerInfo=")
				.append(customerInfo).append(", productInfo=").append(productInfo).append(']');
		return builder.toString();
	}

	/**
	 * Represents customer information.
	 */
	public static class CustomerInfo {

		@XmlElementName("Title")
		private String title;

		@XmlElementName("FirstName")
		private String firstName;

		@XmlElementName("MiddleName")
		private String middleName;

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

		@XmlElementName("Nationality")
		private String nationality;

		@XmlElementName("MotherName")
		private String motherName;

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
		 * @return the middle name
		 */
		public String getMiddleName() {
			return middleName;
		}

		/**
		 * @param middleName the middle name to set
		 */
		public void setMiddleName(String middleName) {
			this.middleName = middleName;
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
		 * @return the nationality
		 */
		public String getNationality() {
			return nationality;
		}

		/**
		 * @param nationality the nationality to set
		 */
		public void setNationality(String nationality) {
			this.nationality = nationality;
		}

		/**
		 * @return the mother's name
		 */
		public String getMotherName() {
			return motherName;
		}

		/**
		 * @param motherName the mother's name to set
		 */
		public void setMotherName(String motherName) {
			this.motherName = motherName;
		}

		/**
		 * @return the address
		 */
		public Address getAddress() {
			return address;
		}

		/**
		 * @param Address the address to set
		 */
		public void setAddress(Address address) {
			this.address = address;
		}

		/**
		 * @return the mail address
		 */
		public MailAddress getMailAddress() {
			return mailAddress;
		}

		/**
		 * @param mailAddress the mail address to set
		 */
		public void setMailAddress(MailAddress mailAddress) {
			this.mailAddress = mailAddress;
		}

		/**
		 * @return the identification types
		 */
		public List<IdentificationType> getIdentificationType() {
			return identificationType;
		}

		/**
		 * @param identificationTypes the identification types to set
		 */
		public void setIdentificationTypes(List<IdentificationType> identificationTypes) {
			this.identificationType = identificationTypes;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("CustomerInfo[").append("title=").append(title).append(", firstName=").append(firstName)
					.append(", middleName=").append(middleName).append(", lastName=").append(lastName).append(", dob=")
					.append(dob).append(", gender=").append(gender).append(", mobileNumber=").append(mobileNumber)
					.append(", emailAddress=").append(emailAddress).append(", nationality=").append(nationality)
					.append(", motherName=").append(motherName).append(", residenceAddress=").append(address)
					.append(", mailAddress=").append(mailAddress).append(", identificationTypes=")
					.append(identificationType).append(']');
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
			 * @return the home number
			 */
			public String getHomeNumber() {
				return homeNumber;
			}

			/**
			 * @param homeNumber the home number to set
			 */
			public void seHomeNumber(String homeNumber) {
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
		 * Represents an address.
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
			 * @return the work number
			 */
			public String getWorkNumber() {
				return workNumber;
			}

			/**
			 * @param workNumber the work number to set
			 */
			public void setWorkNumber(String workNumber) {
				this.workNumber = workNumber;
			}

			/**
			 * @return the extension
			 */
			public String getExtension() {
				return extension;
			}

			/**
			 * @param extension the extension to set
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

			@XmlElementName("IssueDate")
			private String issueDate;

			@XmlElementName("ExpiryDate")
			private String expiryDate;

			@XmlElementName("CountryOfIssue")
			private String countryOfIssue;

			@XmlElementName("IdImage")
			private String idImage;

			@XmlElementName("IdImageName")
			private String idImageName;

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
			 * @return the issue date
			 */
			public String getIssueDate() {
				return issueDate;
			}

			/**
			 * @param issueDate the issue date to set
			 */
			public void setIssueDate(String issueDate) {
				this.issueDate = issueDate;
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

			/**
			 * @return the identification image
			 */
			public String getIdImage() {
				return idImage;
			}

			/**
			 * @param idImage the identification image to set
			 */
			public void setIdImage(String idImage) {
				this.idImage = idImage;
			}

			/**
			 * @return the identification image name
			 */
			public String getIdImageName() {
				return idImageName;
			}

			/**
			 * @param idImageName the identification image name to set
			 */
			public void setIdImageName(String idImageName) {
				this.idImageName = idImageName;
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
	 * Represents product information.
	 */
	public static class ProductInfo {

		@XmlElementName("Amount")
		private String amount;

		@XmlElementName("ProductCode")
		private String productCode;

		@XmlElementName("Currency")
		private String currency;

		@XmlElementName("CampaignCode")
		private String campaignCode;

		/**
		 * @return the amount
		 */
		public String getAmount() {
			return amount;
		}

		/**
		 * @param amount the amount to set
		 */
		public void setAmount(String amount) {
			this.amount = amount;
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
		 * @return the currency
		 */
		public String getCurrency() {
			return currency;
		}

		/**
		 * @param currency the currency to set
		 */
		public void setCurrency(String currency) {
			this.currency = currency;
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

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("ProductInfo [amount=").append(amount).append(", productCode=").append(productCode)
					.append(", currency=").append(currency).append(", campaignCode=").append(campaignCode).append("]");
			return builder.toString();
		}
	}
}
