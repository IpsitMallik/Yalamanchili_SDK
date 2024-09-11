package com.narada.sdk.models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NaradaResponse", namespace = "http://services.api.ycs.com", propOrder = {
    "responseBody",
	"responseHeader"
})
@XmlRootElement(name = "NaradaResponse", namespace = "http://services.api.ycs.com")
public class NaradaResponse {

    @XmlElement(name = "responseHeader", namespace = "http://model.api.ycs.com/xsd", required = true)
    protected ResponseHeader responseHeader;

    @XmlElement(name = "responseBody", namespace = "http://model.api.ycs.com/xsd", required = true)
    protected ResponseBody responseBody;

    public ResponseHeader getResponseHeader() {
        return responseHeader;
    }

    public void setResponseHeader(ResponseHeader responseHeader) {
        this.responseHeader = responseHeader;
    }

    public ResponseBody getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(ResponseBody responseBody) {
        this.responseBody = responseBody;
    }
}
