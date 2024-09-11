
package com.narada.sdk.api_client;

import com.narada.sdk.models.Echo;
import com.narada.sdk.models.EchoResponse;
import com.narada.sdk.models.NaradaRequest;
import com.narada.sdk.models.NaradaResponse;
import com.narada.sdk.models.RequestBody;
import com.narada.sdk.models.RequestHeader;
import com.narada.sdk.models.ResponseBody;
import com.narada.sdk.models.ResponseHeader;
import com.narada.sdk.models.ServiceCall;
import com.narada.sdk.models.ServiceCallResponse;

import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.narada.sdk.models
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link NaradaRequest }
     * 
     */
    public NaradaRequest createNaradaRequest() {
        return new NaradaRequest();
    }

    /**
     * Create an instance of {@link RequestBody }
     * 
     */
    public RequestBody createRequestBody() {
        return new RequestBody();
    }

    /**
     * Create an instance of {@link RequestHeader }
     * 
     */
    public RequestHeader createRequestHeader() {
        return new RequestHeader();
    }

    /**
     * Create an instance of {@link NaradaResponse }
     * 
     */
    public NaradaResponse createNaradaResponse() {
        return new NaradaResponse();
    }

    /**
     * Create an instance of {@link ResponseBody }
     * 
     */
    public ResponseBody createResponseBody() {
        return new ResponseBody();
    }

    /**
     * Create an instance of {@link ResponseHeader }
     * 
     */
    public ResponseHeader createResponseHeader() {
        return new ResponseHeader();
    }

    /**
     * Create an instance of {@link ServiceCall }
     * 
     */
    public ServiceCall createServiceCall() {
        return new ServiceCall();
    }

    /**
     * Create an instance of {@link ServiceCallResponse }
     * 
     */
    public ServiceCallResponse createServiceCallResponse() {
        return new ServiceCallResponse();
    }

    /**
     * Create an instance of {@link Echo }
     * 
     */
    public Echo createEcho() {
        return new Echo();
    }

    /**
     * Create an instance of {@link EchoResponse }
     * 
     */
    public EchoResponse createEchoResponse() {
        return new EchoResponse();
    }

}
