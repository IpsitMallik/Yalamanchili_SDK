
package com.narada.sdk.models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "responseBody", namespace = "http://model.api.ycs.com/xsd", propOrder = { "response", "responseCode",
		"responseText" })
public class ResponseBody {

	@XmlElement(namespace = "http://model.api.ycs.com/xsd", required = true)
	protected String response;
	@XmlElement(namespace = "http://model.api.ycs.com/xsd", required = true)
	protected String responseCode;
	@XmlElement(namespace = "http://model.api.ycs.com/xsd", required = true)
	protected String responseText;

	/**
	 * Gets the value of the response property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getResponse() {
		return response;
	}

	/**
	 * Sets the value of the response property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setResponse(String value) {
		this.response = value;
	}

	/**
	 * Gets the value of the responseCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getResponseCode() {
		return responseCode;
	}

	/**
	 * Sets the value of the responseCode property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setResponseCode(String value) {
		this.responseCode = value;
	}

	/**
	 * Gets the value of the responseText property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getResponseText() {
		return responseText;
	}

	/**
	 * Sets the value of the responseText property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setResponseText(String value) {
		this.responseText = value;
	}

}
