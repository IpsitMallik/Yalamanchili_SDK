
package com.narada.sdk.models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


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
 *         &lt;element name="naradaRequest" type="{http://model.api.ycs.com/xsd}NaradaRequest"/&gt;
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
    "naradaRequest"
})
@XmlRootElement(name = "serviceCall", namespace = "http://services.api.ycs.com")
public class ServiceCall {

    @XmlElement(namespace = "http://services.api.ycs.com", required = true)
    protected NaradaRequest naradaRequest;

    /**
     * Gets the value of the naradaRequest property.
     * 
     * @return
     *     possible object is
     *     {@link NaradaRequest }
     *     
     */
    public NaradaRequest getNaradaRequest() {
        return naradaRequest;
    }

    /**
     * Sets the value of the naradaRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link NaradaRequest }
     *     
     */
    public void setNaradaRequest(NaradaRequest value) {
        this.naradaRequest = value;
    }

}
