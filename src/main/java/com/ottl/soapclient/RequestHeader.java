
package com.ottl.soapclient;

import jakarta.xml.bind.annotation.*;
/**
 * <p>Java class for RequestHeader complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RequestHeader"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="apiKey" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="apiPasswd" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="apiUserId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="channelType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="clientId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="msgRefNo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="msgTimeStamp" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="sessionKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="token" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestHeader", propOrder = {
    "apiKey",
    "apiPasswd",
    "apiUserId",
    "channelType",
    "clientId",
    "msgRefNo",
    "msgTimeStamp",
    "sessionKey",
    "token"
})
public class RequestHeader {

    @XmlElement(required = true)
    protected String apiKey;
    @XmlElement(required = true)
    protected String apiPasswd;
    @XmlElement(required = true)
    protected String apiUserId;
    @XmlElement(required = true)
    protected String channelType;
    @XmlElement(required = true)
    protected String clientId;
    @XmlElement(required = true)
    protected String msgRefNo;
    @XmlElement(required = true)
    protected String msgTimeStamp;
    protected String sessionKey;
    protected String token;

    /**
     * Gets the value of the apiKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApiKey() {
        return apiKey;
    }

    /**
     * Sets the value of the apiKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApiKey(String value) {
        this.apiKey = value;
    }

    /**
     * Gets the value of the apiPasswd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApiPasswd() {
        return apiPasswd;
    }

    /**
     * Sets the value of the apiPasswd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApiPasswd(String value) {
        this.apiPasswd = value;
    }

    /**
     * Gets the value of the apiUserId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApiUserId() {
        return apiUserId;
    }

    /**
     * Sets the value of the apiUserId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApiUserId(String value) {
        this.apiUserId = value;
    }

    /**
     * Gets the value of the channelType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChannelType() {
        return channelType;
    }

    /**
     * Sets the value of the channelType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChannelType(String value) {
        this.channelType = value;
    }

    /**
     * Gets the value of the clientId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * Sets the value of the clientId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientId(String value) {
        this.clientId = value;
    }

    /**
     * Gets the value of the msgRefNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgRefNo() {
        return msgRefNo;
    }

    /**
     * Sets the value of the msgRefNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgRefNo(String value) {
        this.msgRefNo = value;
    }

    /**
     * Gets the value of the msgTimeStamp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgTimeStamp() {
        return msgTimeStamp;
    }

    /**
     * Sets the value of the msgTimeStamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgTimeStamp(String value) {
        this.msgTimeStamp = value;
    }

    /**
     * Gets the value of the sessionKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSessionKey() {
        return sessionKey;
    }

    /**
     * Sets the value of the sessionKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSessionKey(String value) {
        this.sessionKey = value;
    }

    /**
     * Gets the value of the token property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets the value of the token property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToken(String value) {
        this.token = value;
    }

}
