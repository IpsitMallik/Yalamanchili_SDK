package com.narada.sdk.models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestHeader", namespace = "http://model.api.ycs.com/xsd", propOrder = {
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

    @XmlElement(namespace = "http://model.api.ycs.com/xsd", required = true)
    protected String apiKey;

    @XmlElement(namespace = "http://model.api.ycs.com/xsd", required = true)
    protected String apiPasswd;

    @XmlElement(namespace = "http://model.api.ycs.com/xsd", required = true)
    protected String apiUserId;

    @XmlElement(namespace = "http://model.api.ycs.com/xsd", required = true)
    protected String channelType;

    @XmlElement(namespace = "http://model.api.ycs.com/xsd", required = true)
    protected String clientId;

    @XmlElement(namespace = "http://model.api.ycs.com/xsd", required = true)
    protected String msgRefNo;

    @XmlElement(namespace = "http://model.api.ycs.com/xsd", required = true)
    protected String msgTimeStamp;

    @XmlElement(namespace = "http://model.api.ycs.com/xsd")
    protected String sessionKey;

    @XmlElement(namespace = "http://model.api.ycs.com/xsd")
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
