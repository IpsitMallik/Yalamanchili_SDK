
package com.ottl.soapclient;

import jakarta.xml.bind.annotation.*;
/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="naradaResponse" type="{http://model.api.ycs.com/xsd}NaradaResponse"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "naradaResponse"
})
@XmlRootElement(name = "serviceCallResponse", namespace = "http://services.api.ycs.com")
public class ServiceCallResponse {

    @XmlElement(namespace = "http://services.api.ycs.com", required = true)
    protected NaradaResponse naradaResponse;

    /**
     * Gets the value of the naradaResponse property.
     * 
     * @return
     *     possible object is
     *     {@link NaradaResponse }
     *     
     */
    public NaradaResponse getNaradaResponse() {
        return naradaResponse;
    }

    /**
     * Sets the value of the naradaResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link NaradaResponse }
     *     
     */
    public void setNaradaResponse(NaradaResponse value) {
        this.naradaResponse = value;
    }

}
