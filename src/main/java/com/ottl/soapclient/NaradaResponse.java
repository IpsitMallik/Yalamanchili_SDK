
package com.ottl.soapclient;

import jakarta.xml.bind.annotation.*;
/**
 * <p>Java class for NaradaResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NaradaResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="responseBody" type="{http://model.api.ycs.com/xsd}ResponseBody"/&gt;
 *         &lt;element name="responseHeader" type="{http://model.api.ycs.com/xsd}ResponseHeader"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NaradaResponse", propOrder = {
    "responseBody",
    "responseHeader"
})
public class NaradaResponse {

    @XmlElement(required = true)
    protected ResponseBody responseBody;
    @XmlElement(required = true)
    protected ResponseHeader responseHeader;

    /**
     * Gets the value of the responseBody property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseBody }
     *     
     */
    public ResponseBody getResponseBody() {
        return responseBody;
    }

    /**
     * Sets the value of the responseBody property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseBody }
     *     
     */
    public void setResponseBody(ResponseBody value) {
        this.responseBody = value;
    }

    /**
     * Gets the value of the responseHeader property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseHeader }
     *     
     */
    public ResponseHeader getResponseHeader() {
        return responseHeader;
    }

    /**
     * Sets the value of the responseHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseHeader }
     *     
     */
    public void setResponseHeader(ResponseHeader value) {
        this.responseHeader = value;
    }

}
