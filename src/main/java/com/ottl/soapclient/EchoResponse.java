
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
 *         &lt;element name="echoResp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "echoResp"
})
@XmlRootElement(name = "echoResponse", namespace = "http://services.api.ycs.com")
public class EchoResponse {

    @XmlElement(namespace = "http://services.api.ycs.com")
    protected String echoResp;

    /**
     * Gets the value of the echoResp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEchoResp() {
        return echoResp;
    }

    /**
     * Sets the value of the echoResp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEchoResp(String value) {
        this.echoResp = value;
    }

}
