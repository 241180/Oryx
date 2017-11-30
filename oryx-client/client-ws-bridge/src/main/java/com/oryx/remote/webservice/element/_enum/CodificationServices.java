package com.oryx.remote.webservice.element._enum;

import javax.xml.namespace.QName;
import javax.xml.ws.*;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10
 * Generated source version: 2.2
 */
@WebServiceClient(name = "CodificationServices", targetNamespace = "http://enum.element.webservice.remote.oryx.com", wsdlLocation = "http://localhost:8680/oryx-server/CodificationService.wsdl")
public class CodificationServices
        extends Service {

    private final static URL CODIFICATIONSERVICES_WSDL_LOCATION;
    private final static WebServiceException CODIFICATIONSERVICES_EXCEPTION;
    private final static QName CODIFICATIONSERVICES_QNAME = new QName("http://enum.element.webservice.remote.oryx.com", "CodificationServices");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8680/oryx-server/CodificationService.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CODIFICATIONSERVICES_WSDL_LOCATION = url;
        CODIFICATIONSERVICES_EXCEPTION = e;
    }

    public CodificationServices() {
        super(__getWsdlLocation(), CODIFICATIONSERVICES_QNAME);
    }

    public CodificationServices(WebServiceFeature... features) {
        super(__getWsdlLocation(), CODIFICATIONSERVICES_QNAME, features);
    }

    public CodificationServices(URL wsdlLocation) {
        super(wsdlLocation, CODIFICATIONSERVICES_QNAME);
    }

    public CodificationServices(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CODIFICATIONSERVICES_QNAME, features);
    }

    public CodificationServices(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CodificationServices(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    private static URL __getWsdlLocation() {
        if (CODIFICATIONSERVICES_EXCEPTION != null) {
            throw CODIFICATIONSERVICES_EXCEPTION;
        }
        return CODIFICATIONSERVICES_WSDL_LOCATION;
    }

    /**
     * @return returns CodificationService
     */
    @WebEndpoint(name = "CodificationServiceSoap11")
    public CodificationService getCodificationServiceSoap11() {
        return super.getPort(new QName("http://enum.element.webservice.remote.oryx.com", "CodificationServiceSoap11"), CodificationService.class);
    }

    /**
     * @param features A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns CodificationService
     */
    @WebEndpoint(name = "CodificationServiceSoap11")
    public CodificationService getCodificationServiceSoap11(WebServiceFeature... features) {
        return super.getPort(new QName("http://enum.element.webservice.remote.oryx.com", "CodificationServiceSoap11"), CodificationService.class, features);
    }

}
