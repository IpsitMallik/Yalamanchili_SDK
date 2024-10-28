package com.ottl.model;

import com.ottl.utils.XmlElementName;

public class CorporateRegistrationRequest {
	@XmlElementName("TxnRefNo")
	private String txnRefNo;

	@XmlElementName("CorpNameOne")
	private String corpNameOne;

	@XmlElementName("CorpNameTwo")
	private String corpNameTwo;

	@XmlElementName("CorpNameThree")
	private String corpNameThree;

	@XmlElementName("StreetName")
	private String streetName;

	@XmlElementName("City")
	private String city;

	@XmlElementName("Country")
	private String country;

	@XmlElementName("PostalCode")
	private String postalCode;

	@XmlElementName("CorporateId")
	private String corporateId;

	@XmlElementName("CrmId")
	private String crmId;

	@XmlElementName("CorporateLoginId")
	private String corporateLoginId;

	@XmlElementName("EnterpriseId")
	private String enterpriseId;

	@XmlElementName("TaxNumber")
	private String taxNumber;

	@XmlElementName("PrintName")
	private String printName;

	@XmlElementName("Optional1")
	private String optional1;

	@XmlElementName("Optional2")
	private String optional2;

	@XmlElementName("Optional3")
	private String optional3;

	@XmlElementName("CorporateContact")
	private CorporateContact corporateContact;

	@XmlElementName("Corporate")
	private Corporate corporate;

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
	 * @return the corporate name 1
	 */
	public String getCorpNameOne() {
		return corpNameOne;
	}

	/**
	 * @param corpNameOne the corporate name 1 to set
	 */
	public void setCorpNameOne(String corpNameOne) {
		this.corpNameOne = corpNameOne;
	}

	/**
	 * @return the corporate name 2
	 */
	public String getCorpNameTwo() {
		return corpNameTwo;
	}

	/**
	 * @param corpNameTwo the corporate name 2 to set
	 */
	public void setCorpNameTwo(String corpNameTwo) {
		this.corpNameTwo = corpNameTwo;
	}

	/**
	 * @return the corporate name 3
	 */
	public String getCorpNameThree() {
		return corpNameThree;
	}

	/**
	 * @param corpNameThree the corporate name 3 to set
	 */
	public void setCorpNameThree(String corpNameThree) {
		this.corpNameThree = corpNameThree;
	}

	/**
	 * @return the street name
	 */
	public String getStreetName() {
		return streetName;
	}

	/**
	 * @param streetName the street name to set
	 */
	public void setStreetName(String streetName) {
		this.streetName = streetName;
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
	 * @return the CRM ID
	 */
	public String getCrmId() {
		return crmId;
	}

	/**
	 * @param crmId the CRM ID to set
	 */
	public void setCrmId(String crmId) {
		this.crmId = crmId;
	}

	/**
	 * @return the corporate login ID
	 */
	public String getCorporateLoginId() {
		return corporateLoginId;
	}

	/**
	 * @param corporateLoginId the corporate login ID to set
	 */
	public void setCorporateLoginId(String corporateLoginId) {
		this.corporateLoginId = corporateLoginId;
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
	 * @return the tax number
	 */
	public String getTaxNumber() {
		return taxNumber;
	}

	/**
	 * @param taxNumber the tax number to set
	 */
	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}

	/**
	 * @return the print name
	 */
	public String getPrintName() {
		return printName;
	}

	/**
	 * @param printName the print name to set
	 */
	public void setPrintName(String printName) {
		this.printName = printName;
	}

	/**
	 * @return optional1
	 */
	public String getOptional1() {
		return optional1;
	}

	/**
	 * @param optional1 the optional1 to set
	 */
	public void setOptional1(String optional1) {
		this.optional1 = optional1;
	}

	/**
	 * @return optional2
	 */
	public String getOptional2() {
		return optional2;
	}

	/**
	 * @param optional2 the optional2 to set
	 */
	public void setOptional2(String optional2) {
		this.optional2 = optional2;
	}

	/**
	 * @return optional3
	 */
	public String getOptional3() {
		return optional3;
	}

	/**
	 * @param optional3 the optional3 to set
	 */
	public void setOptional3(String optional3) {
		this.optional3 = optional3;
	}

	/**
	 * @return the corporate contact details
	 */
	public CorporateContact getCorporateContact() {
		return corporateContact;
	}

	/**
	 * @param corporateContact the corporate contact details to set
	 */
	public void setCorporateContact(CorporateContact corporateContact) {
		this.corporateContact = corporateContact;
	}

	/**
	 * @return the corporate details
	 */
	public Corporate getCorporate() {
		return corporate;
	}

	/**
	 * @param corporate the corporate details to set
	 */
	public void setCorporate(Corporate corporate) {
		this.corporate = corporate;
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
		builder.append("CorporateRegistrationRequest [txnRefNo=").append(txnRefNo).append(", corpNameOne=")
				.append(corpNameOne).append(", corpNameTwo=").append(corpNameTwo).append(", corpNameThree=")
				.append(corpNameThree).append(", streetName=").append(streetName).append(", city=").append(city)
				.append(", country=").append(country).append(", postalCode=").append(postalCode)
				.append(", corporateId=").append(corporateId).append(", crmId=").append(crmId)
				.append(", corporateLoginId=").append(corporateLoginId).append(", enterpriseId=").append(enterpriseId)
				.append(", taxNumber=").append(taxNumber).append(", printName=").append(printName)
				.append(", optional1=").append(optional1).append(", optional2=").append(optional2)
				.append(", optional3=").append(optional3).append(", corporateContact=").append(corporateContact)
				.append(", corporate=").append(corporate).append(", loadDetails=").append(loadDetails).append("]");
		return builder.toString();
	}

	public static class CorporateContact {

		@XmlElementName("Gender")
		private String gender;

		@XmlElementName("Title")
		private String title;

		@XmlElementName("FirstName")
		private String firstName;

		@XmlElementName("LastName")
		private String lastName;

		@XmlElementName("MailAddress")
		private String mailAddress;

		@XmlElementName("OfficePhone")
		private String officePhone;

		@XmlElementName("ResidentPhone")
		private String residentPhone;

		@XmlElementName("Mobile")
		private String mobile;

		@XmlElementName("Fax")
		private String fax;

		@XmlElementName("Suburb")
		private String suburb;

		@XmlElementName("City")
		private String city;

		@XmlElementName("State")
		private String state;

		@XmlElementName("Country")
		private String country;

		@XmlElementName("EmailId")
		private String emailId;

		@XmlElementName("PostalCode")
		private String postalCode;

		// Getters and Setters with JavaDocs

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
		 * @return the mail address
		 */
		public String getMailAddress() {
			return mailAddress;
		}

		/**
		 * @param mailAddress the mail address to set
		 */
		public void setMailAddress(String mailAddress) {
			this.mailAddress = mailAddress;
		}

		/**
		 * @return the office phone
		 */
		public String getOfficePhone() {
			return officePhone;
		}

		/**
		 * @param officePhone the office phone to set
		 */
		public void setOfficePhone(String officePhone) {
			this.officePhone = officePhone;
		}

		/**
		 * @return the resident phone
		 */
		public String getResidentPhone() {
			return residentPhone;
		}

		/**
		 * @param residentPhone the resident phone to set
		 */
		public void setResidentPhone(String residentPhone) {
			this.residentPhone = residentPhone;
		}

		/**
		 * @return the mobile number
		 */
		public String getMobile() {
			return mobile;
		}

		/**
		 * @param mobile the mobile number to set
		 */
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}

		/**
		 * @return the fax
		 */
		public String getFax() {
			return fax;
		}

		/**
		 * @param fax the fax to set
		 */
		public void setFax(String fax) {
			this.fax = fax;
		}

		/**
		 * @return the suburb
		 */
		public String getSuburb() {
			return suburb;
		}

		/**
		 * @param suburb the suburb to set
		 */
		public void setSuburb(String suburb) {
			this.suburb = suburb;
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
		 * @return the email id
		 */
		public String getEmailId() {
			return emailId;
		}

		/**
		 * @param emailId the email id to set
		 */
		public void setEmailId(String emailId) {
			this.emailId = emailId;
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

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("CorporateContact [gender=").append(gender).append(", title=").append(title)
					.append(", firstName=").append(firstName).append(", lastName=").append(lastName)
					.append(", mailAddress=").append(mailAddress).append(", officePhone=").append(officePhone)
					.append(", residentPhone=").append(residentPhone).append(", mobile=").append(mobile)
					.append(", fax=").append(fax).append(", suburb=").append(suburb).append(", city=").append(city)
					.append(", state=").append(state).append(", country=").append(country).append(", emailId=")
					.append(emailId).append(", postalCode=").append(postalCode).append("]");
			return builder.toString();
		}

	}

	public static class Corporate {
		@XmlElementName("Branch")
		private Branch branch;

		/**
		 * @return Branch
		 */
		public Branch getBranch() {
			return branch;
		}

		/**
		 * @param branch set Branch object
		 */
		public void setBranch(Branch branch) {
			this.branch = branch;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Corporate [branch=").append(branch).append("]");
			return builder.toString();
		}

		public static class Branch {
			@XmlElementName("CorpBrNmOne")
			private String corpBrNmOne;

			@XmlElementName("CorpBrNmTwo")
			private String corpBrNmTwo;

			@XmlElementName("CorpBrNmThree")
			private String corpBrNmThree;

			@XmlElementName("BranchCode")
			private String branchCode;

			@XmlElementName("BranchLoginId")
			private String branchLoginId;

			@XmlElementName("ContactDetails")
			private ContactDetails contactDetails;

			/**
			 * @return Corporate Branch Name 1 (Mandatory)
			 */
			public String getCorpBrNmOne() {
				return corpBrNmOne;
			}

			/**
			 * @param corpBrNmOne Set Corporate Branch Name 1
			 */
			public void setCorpBrNmOne(String corpBrNmOne) {
				this.corpBrNmOne = corpBrNmOne;
			}

			/**
			 * @return Corporate Branch Name 2 (Optional)
			 */
			public String getCorpBrNmTwo() {
				return corpBrNmTwo;
			}

			/**
			 * @param corpBrNmTwo Set Corporate Branch Name 2
			 */
			public void setCorpBrNmTwo(String corpBrNmTwo) {
				this.corpBrNmTwo = corpBrNmTwo;
			}

			/**
			 * @return Corporate Branch Name 3 (Optional)
			 */
			public String getCorpBrNmThree() {
				return corpBrNmThree;
			}

			/**
			 * @param corpBrNmThree Set Corporate Branch Name 3
			 */
			public void setCorpBrNmThree(String corpBrNmThree) {
				this.corpBrNmThree = corpBrNmThree;
			}

			/**
			 * @return Branch Code (Optional)
			 */
			public String getBranchCode() {
				return branchCode;
			}

			/**
			 * @param branchCode Set Branch Code
			 */
			public void setBranchCode(String branchCode) {
				this.branchCode = branchCode;
			}

			/**
			 * @return Branch Login Id (Mandatory)
			 */
			public String getBranchLoginId() {
				return branchLoginId;
			}

			/**
			 * @param branchLoginId Set Branch Login Id
			 */
			public void setBranchLoginId(String branchLoginId) {
				this.branchLoginId = branchLoginId;
			}

			/**
			 * @return contactDetails
			 */
			public ContactDetails getContactDetails() {
				return contactDetails;
			}

			/**
			 * @param contactDetails Set contactDetails
			 */
			public void setContactDetails(ContactDetails contactDetails) {
				this.contactDetails = contactDetails;
			}

			@Override
			public String toString() {
				StringBuilder builder = new StringBuilder();
				builder.append("Branch [corpBrNmOne=").append(corpBrNmOne).append(", corpBrNmTwo=").append(corpBrNmTwo)
						.append(", corpBrNmThree=").append(corpBrNmThree).append(", branchCode=").append(branchCode)
						.append(", branchLoginId=").append(branchLoginId).append(", contactDetails=")
						.append(contactDetails).append("]");
				return builder.toString();
			}

			public static class ContactDetails {

				@XmlElementName("Gender")
				private String gender;

				@XmlElementName("Title")
				private String title;

				@XmlElementName("FirstName")
				private String firstName;

				@XmlElementName("LastName")
				private String lastName;

				@XmlElementName("MailAddress")
				private String mailAddress;

				@XmlElementName("OfficePhone")
				private String officePhone;

				@XmlElementName("ResidentPhone")
				private String residentPhone;

				@XmlElementName("Mobile")
				private String mobile;

				@XmlElementName("Fax")
				private String fax;

				@XmlElementName("Suburb")
				private String suburb;

				@XmlElementName("City")
				private String city;

				@XmlElementName("State")
				private String state;

				@XmlElementName("Country")
				private String country;

				@XmlElementName("EmailId")
				private String emailId;

				@XmlElementName("PostalCode")
				private String postalCode;

				/** @return Gender */
				public String getGender() {
					return gender;
				}

				/** @param gender Set Gender */
				public void setGender(String gender) {
					this.gender = gender;
				}

				/** @return Title */
				public String getTitle() {
					return title;
				}

				/** @param title Set Title */
				public void setTitle(String title) {
					this.title = title;
				}

				/** @return First Name */
				public String getFirstName() {
					return firstName;
				}

				/** @param firstName Set First Name */
				public void setFirstName(String firstName) {
					this.firstName = firstName;
				}

				/** @return Last Name */
				public String getLastName() {
					return lastName;
				}

				/** @param lastName Set Last Name */
				public void setLastName(String lastName) {
					this.lastName = lastName;
				}

				/** @return Mailing Address */
				public String getMailAddress() {
					return mailAddress;
				}

				/** @param mailAddress Set Mailing Address */
				public void setMailAddress(String mailAddress) {
					this.mailAddress = mailAddress;
				}

				/** @return Office Phone */
				public String getOfficePhone() {
					return officePhone;
				}

				/** @param officePhone Set Office Phone */
				public void setOfficePhone(String officePhone) {
					this.officePhone = officePhone;
				}

				/** @return Resident Phone */
				public String getResidentPhone() {
					return residentPhone;
				}

				/** @param residentPhone Set Resident Phone */
				public void setResidentPhone(String residentPhone) {
					this.residentPhone = residentPhone;
				}

				/** @return Mobile */
				public String getMobile() {
					return mobile;
				}

				/** @param mobile Set Mobile */
				public void setMobile(String mobile) {
					this.mobile = mobile;
				}

				/** @return Fax */
				public String getFax() {
					return fax;
				}

				/** @param fax Set Fax */
				public void setFax(String fax) {
					this.fax = fax;
				}

				/** @return Suburb */
				public String getSuburb() {
					return suburb;
				}

				/** @param suburb Set Suburb */
				public void setSuburb(String suburb) {
					this.suburb = suburb;
				}

				/** @return City */
				public String getCity() {
					return city;
				}

				/** @param city Set City */
				public void setCity(String city) {
					this.city = city;
				}

				/** @return State */
				public String getState() {
					return state;
				}

				/** @param state Set State */
				public void setState(String state) {
					this.state = state;
				}

				/** @return Country */
				public String getCountry() {
					return country;
				}

				/** @param country Set Country */
				public void setCountry(String country) {
					this.country = country;
				}

				/** @return Email ID */
				public String getEmailId() {
					return emailId;
				}

				/** @param emailId Set Email ID */
				public void setEmailId(String emailId) {
					this.emailId = emailId;
				}

				/** @return Postal Code */
				public String getPostalCode() {
					return postalCode;
				}

				/** @param postalCode Set Postal Code */
				public void setPostalCode(String postalCode) {
					this.postalCode = postalCode;
				}

				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder();
					builder.append("ContactDetails [gender=").append(gender).append(", title=").append(title)
							.append(", firstName=").append(firstName).append(", lastName=").append(lastName)
							.append(", mailAddress=").append(mailAddress).append(", officePhone=").append(officePhone)
							.append(", residentPhone=").append(residentPhone).append(", mobile=").append(mobile)
							.append(", fax=").append(fax).append(", suburb=").append(suburb).append(", city=")
							.append(city).append(", state=").append(state).append(", country=").append(country)
							.append(", emailId=").append(emailId).append(", postalCode=").append(postalCode)
							.append("]");
					return builder.toString();
				}

			}
		}
	}

	public static class LoadDetails {

		@XmlElementName("ProductAssigned")
		private String productAssigned;

		@XmlElementName("InvoiceLevel")
		private String invoiceLevel;

		@XmlElementName("PrefundingPrdCode")
		private String prefundingPrdCode;

		@XmlElementName("OverrideCode")
		private String overrideCode;

		/** @return ProductAssigned */
		public String getProductAssigned() {
			return productAssigned;
		}

		/** @param productAssigned Set ProductAssigned */
		public void setProductAssigned(String productAssigned) {
			this.productAssigned = productAssigned;
		}

		/** @return InvoiceLevel */
		public String getInvoiceLevel() {
			return invoiceLevel;
		}

		/** @param invoiceLevel Set InvoiceLevel */
		public void setInvoiceLevel(String invoiceLevel) {
			this.invoiceLevel = invoiceLevel;
		}

		/** @return PrefundingPrdCode */
		public String getPrefundingPrdCode() {
			return prefundingPrdCode;
		}

		/** @param prefundingPrdCode Set PrefundingPrdCode */
		public void setPrefundingPrdCode(String prefundingPrdCode) {
			this.prefundingPrdCode = prefundingPrdCode;
		}

		/** @return OverrideCode */
		public String getOverrideCode() {
			return overrideCode;
		}

		/** @param overrideCode Set OverrideCode */
		public void setOverrideCode(String overrideCode) {
			this.overrideCode = overrideCode;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("LoadDetails [productAssigned=").append(productAssigned).append(", invoiceLevel=")
					.append(invoiceLevel).append(", prefundingPrdCode=").append(prefundingPrdCode)
					.append(", overrideCode=").append(overrideCode).append("]");
			return builder.toString();
		}
	}

}
