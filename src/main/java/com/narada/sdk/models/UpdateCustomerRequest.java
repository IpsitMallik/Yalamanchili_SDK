package com.narada.sdk.models;

import java.util.List;

import com.narada.sdk.utilities.XmlElementName;

public class UpdateCustomerRequest {
	@XmlElementName("TxnRefNo")
	private String txnRefNo;
	@XmlElementName("ProxyNumber")
	private String proxyNumber;
	@XmlElementName("CustomerInfo")
	private CustomerInfo customerInfo;

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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UpdateCustomerRequest [txnRefNo=").append(txnRefNo).append(", proxyNumber=").append(proxyNumber)
				.append(", customerInfo=").append(customerInfo).append("]");
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
		@XmlElementName("MobileNumber")
		private String mobileNumber;
		@XmlElementName("EmailAddress")
		private String emailAddress;
		@XmlElementName("Address")
		private Address address;
		@XmlElementName("MailAddress")
		private MailAddress mailAddress;
		@XmlElementName("IdentificationType")
		private List<IdentificationType> identificationTypes;

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
		public List<IdentificationType> getIdentificationTypes() {
			return identificationTypes;
		}

		/**
		 * @param identificationTypes the list of identification types to set
		 */
		public void setIdentificationTypes(List<IdentificationType> identificationTypes) {
			this.identificationTypes = identificationTypes;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("CustomerInfo [title=").append(title).append(", firstName=").append(firstName)
					.append(", lastName=").append(lastName).append(", dob=").append(dob).append(", mobileNumber=")
					.append(mobileNumber).append(", emailAddress=").append(emailAddress).append(", address=")
					.append(address).append(", mailAddress=").append(mailAddress).append(", identificationTypes=")
					.append(identificationTypes).append("]");
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
			@XmlElementName("IssueDate")
			private String issueDate;
			@XmlElementName("ExpiryDate")
			private String expiryDate;
			@XmlElementName("CountryOfIssue")
			private String countryOfIssue;
			@XmlElementName("IDImage")
			private String idImage;
			@XmlElementName("IDImageName")
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
			 * @return the idImage
			 */
			public String getIDImage() {
				return idImage;
			}

			/**
			 * @param idImage the idImage to set
			 */
			public void setIDImage(String idImage) {
				this.idImage = idImage;
			}

			/**
			 * @return the idImageName
			 */
			public String getIDImageName() {
				return idImageName;
			}

			/**
			 * @param idImageName the idImageName to set
			 */
			public void setIDImageName(String idImageName) {
				this.idImageName = idImageName;
			}

			@Override
			public String toString() {
				StringBuilder builder = new StringBuilder();
				builder.append("IdentificationType [idType=").append(idType).append(", idNumber=").append(idNumber)
						.append(", issueDate=").append(issueDate).append(", expiryDate=").append(expiryDate)
						.append(", countryOfIssue=").append(countryOfIssue).append(", idImage=").append(idImage)
						.append(", idImageName=").append(idImageName).append("]");
				return builder.toString();
			}
		}
	}
}
