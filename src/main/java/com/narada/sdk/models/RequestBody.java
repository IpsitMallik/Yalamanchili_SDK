package com.narada.sdk.models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestBody", namespace = "http://model.api.ycs.com/xsd", propOrder = {
    "request"
})
public class RequestBody {

    @XmlElement(namespace = "http://model.api.ycs.com/xsd", required = true)
    protected String request;

    public String getRequest() {
        return request;
    }

    public void setRequest(String value) {
        this.request = value;
    }
}
