
package com.ottl.soapclient;

import jakarta.xml.bind.annotation.*;
/**
 * <p>Java class for NaradaRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NaradaRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="requestBody" type="{http://model.api.ycs.com/xsd}RequestBody"/&gt;
 *         &lt;element name="requestHeader" type="{http://model.api.ycs.com/xsd}RequestHeader"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NaradaRequest", propOrder = {
    "requestBody",
    "requestHeader"
})
public class NaradaRequest {

    @XmlElement(required = true)
    protected RequestBody requestBody;
    @XmlElement(required = true)
    protected RequestHeader requestHeader;

    /**
     * Gets the value of the requestBody property.
     * 
     * @return
     *     possible object is
     *     {@link RequestBody }
     *     
     */
    public RequestBody getRequestBody() {
        return requestBody;
    }

    /**
     * Sets the value of the requestBody property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestBody }
     *     
     */
    public void setRequestBody(RequestBody value) {
        this.requestBody = value;
    }

    /**
     * Gets the value of the requestHeader property.
     * 
     * @return
     *     possible object is
     *     {@link RequestHeader }
     *     
     */
    public RequestHeader getRequestHeader() {
        return requestHeader;
    }

    /**
     * Sets the value of the requestHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestHeader }
     *     
     */
    public void setRequestHeader(RequestHeader value) {
        this.requestHeader = value;
    }

}
