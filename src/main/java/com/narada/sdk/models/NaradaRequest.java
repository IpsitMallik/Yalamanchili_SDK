package com.narada.sdk.models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NaradaRequest", propOrder = {
    "requestBody",
	"requestHeader"
})
@XmlRootElement(name = "NaradaRequest", namespace = "http://services.api.ycs.com")
public class NaradaRequest {

    @XmlElement(name = "requestHeader", namespace = "http://model.api.ycs.com/xsd", required = true)
    protected RequestHeader requestHeader;

    @XmlElement(name = "requestBody", namespace = "http://model.api.ycs.com/xsd", required = true)
    protected RequestBody requestBody;

    public RequestHeader getRequestHeader() {
        return requestHeader;
    }

    public void setRequestHeader(RequestHeader requestHeader) {
        this.requestHeader = requestHeader;
    }

    public RequestBody getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(RequestBody requestBody) {
        this.requestBody = requestBody;
    }
}
