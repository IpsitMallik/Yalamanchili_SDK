package com.narada.sdk.api_client;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.xml.ws.WebEndpoint;
import jakarta.xml.ws.WebServiceClient;
import jakarta.xml.ws.WebServiceFeature;
import jakarta.xml.ws.Service;

/**
 * This class was generated by Apache CXF 4.0.5
 * 2024-08-02T17:35:10.635+05:30
 * Generated source version: 4.0.5
 *
 */
@WebServiceClient(name = "NaradaApiService", wsdlLocation = "classpath:NaradaApiService.wsdl", targetNamespace = "http://services.api.ycs.com")
public class NaradaApiService extends Service {

    public static final URL WSDL_LOCATION;

    public static final QName SERVICE = new QName("http://services.api.ycs.com", "NaradaApiService");
    public static final QName NaradaApiServiceHttpEndpoint = new QName("http://services.api.ycs.com",
            "NaradaApiServiceHttpEndpoint");
    public static final QName NaradaApiServiceHttpSoap11Endpoint = new QName("http://services.api.ycs.com",
            "NaradaApiServiceHttpSoap11Endpoint");
    public static final QName NaradaApiServiceHttpSoap12Endpoint = new QName("http://services.api.ycs.com",
            "NaradaApiServiceHttpSoap12Endpoint");
    static {
        URL url = null;
        try {
            // url =
            // NaradaApiService.class.getClassLoader().getResource("NaradaApiService.wsdl");
            url = Thread.currentThread().getContextClassLoader().getResource("NaradaApiService.wsdl");
        } catch (Exception e) {
            java.util.logging.Logger.getLogger(NaradaApiService.class.getName())
                    .log(java.util.logging.Level.INFO,
                            "Can not initialize the default wsdl");
        }
        WSDL_LOCATION = url;
        if (WSDL_LOCATION == null) {
            System.out.println("WSDL not found in classpath!");
        } else {
            System.out.println("WSDL found at: " + WSDL_LOCATION);
        }
    }

    public NaradaApiService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public NaradaApiService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public NaradaApiService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public NaradaApiService(WebServiceFeature... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public NaradaApiService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public NaradaApiService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *         returns NaradaApiServicePortType
     */
    @WebEndpoint(name = "NaradaApiServiceHttpEndpoint")
    public NaradaApiServicePortType getNaradaApiServiceHttpEndpoint() {
        return super.getPort(NaradaApiServiceHttpEndpoint, NaradaApiServicePortType.class);
    }

    /**
     *
     * @param features
     *                 A list of {@link jakarta.xml.ws.WebServiceFeature} to
     *                 configure on the proxy. Supported features not in the
     *                 <code>features</code> parameter will have their default
     *                 values.
     * @return
     *         returns NaradaApiServicePortType
     */
    @WebEndpoint(name = "NaradaApiServiceHttpEndpoint")
    public NaradaApiServicePortType getNaradaApiServiceHttpEndpoint(WebServiceFeature... features) {
        return super.getPort(NaradaApiServiceHttpEndpoint, NaradaApiServicePortType.class, features);
    }

    /**
     *
     * @return
     *         returns NaradaApiServicePortType
     */
    @WebEndpoint(name = "NaradaApiServiceHttpSoap11Endpoint")
    public NaradaApiServicePortType getNaradaApiServiceHttpSoap11Endpoint() {
        return super.getPort(NaradaApiServiceHttpSoap11Endpoint, NaradaApiServicePortType.class);
    }

    /**
     *
     * @param features
     *                 A list of {@link jakarta.xml.ws.WebServiceFeature} to
     *                 configure on the proxy. Supported features not in the
     *                 <code>features</code> parameter will have their default
     *                 values.
     * @return
     *         returns NaradaApiServicePortType
     */
    @WebEndpoint(name = "NaradaApiServiceHttpSoap11Endpoint")
    public NaradaApiServicePortType getNaradaApiServiceHttpSoap11Endpoint(WebServiceFeature... features) {
        return super.getPort(NaradaApiServiceHttpSoap11Endpoint, NaradaApiServicePortType.class, features);
    }

    /**
     *
     * @return
     *         returns NaradaApiServicePortType
     */
    @WebEndpoint(name = "NaradaApiServiceHttpSoap12Endpoint")
    public NaradaApiServicePortType getNaradaApiServiceHttpSoap12Endpoint() {
        return super.getPort(NaradaApiServiceHttpSoap12Endpoint, NaradaApiServicePortType.class);
    }

    /**
     *
     * @param features
     *                 A list of {@link jakarta.xml.ws.WebServiceFeature} to
     *                 configure on the proxy. Supported features not in the
     *                 <code>features</code> parameter will have their default
     *                 values.
     * @return
     *         returns NaradaApiServicePortType
     */
    @WebEndpoint(name = "NaradaApiServiceHttpSoap12Endpoint")
    public NaradaApiServicePortType getNaradaApiServiceHttpSoap12Endpoint(WebServiceFeature... features) {
        return super.getPort(NaradaApiServiceHttpSoap12Endpoint, NaradaApiServicePortType.class, features);
    }

}
