package com.narada.sdk.api_client;

import com.narada.sdk.models.NaradaRequest;
import com.narada.sdk.models.NaradaResponse;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.ws.Action;
import jakarta.xml.ws.RequestWrapper;
import jakarta.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 4.0.5
 * 2024-08-02T17:35:10.495+05:30
 * Generated source version: 4.0.5
 *
 */
@WebService(targetNamespace = "http://services.api.ycs.com", name = "NaradaApiServicePortType")
@XmlSeeAlso({ObjectFactory.class})
public interface NaradaApiServicePortType {

    @WebMethod(action = "urn:echo")
    @Action(input = "urn:echo", output = "urn:echoResponse")
    @RequestWrapper(localName = "echo", targetNamespace = "http://services.api.ycs.com", className = "com.narada.sdk.models.Echo")
    @ResponseWrapper(localName = "echoResponse", targetNamespace = "http://services.api.ycs.com", className = "com.narada.sdk.models.EchoResponse")
    @WebResult(name = "echoResp", targetNamespace = "http://services.api.ycs.com")
    public String echo(

        @WebParam(name = "echoReq", targetNamespace = "http://services.api.ycs.com")
        String echoReq
    );

    @WebMethod(action = "urn:serviceCall")
    @Action(input = "urn:serviceCall", output = "urn:serviceCallResponse")
    @RequestWrapper(localName = "serviceCall", targetNamespace = "http://services.api.ycs.com", className = "com.narada.sdk.models.ServiceCall")
    @ResponseWrapper(localName = "serviceCallResponse", targetNamespace = "http://services.api.ycs.com", className = "com.narada.sdk.models.ServiceCallResponse")
    @WebResult(name = "naradaResponse", targetNamespace = "http://services.api.ycs.com")
    public NaradaResponse serviceCall(

        @WebParam(name = "naradaRequest", targetNamespace = "http://services.api.ycs.com")
        NaradaRequest naradaRequest
    );
}
