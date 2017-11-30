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
@WebServiceClient(name = "DomainServices", targetNamespace = "http://enum.element.webservice.remote.oryx.com", wsdlLocation = "http://localhost:8680/oryx-server/DomainService.wsdl")
public class DomainServices
        extends Service {

    private final static URL DOMAINSERVICES_WSDL_LOCATION;
    private final static WebServiceException DOMAINSERVICES_EXCEPTION;
    private final static QName DOMAINSERVICES_QNAME = new QName("http://enum.element.webservice.remote.oryx.com", "DomainServices");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8680/oryx-server/DomainService.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        DOMAINSERVICES_WSDL_LOCATION = url;
        DOMAINSERVICES_EXCEPTION = e;
    }

    public DomainServices() {
        super(__getWsdlLocation(), DOMAINSERVICES_QNAME);
    }

    public DomainServices(WebServiceFeature... features) {
        super(__getWsdlLocation(), DOMAINSERVICES_QNAME, features);
    }

    public DomainServices(URL wsdlLocation) {
        super(wsdlLocation, DOMAINSERVICES_QNAME);
    }

    public DomainServices(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, DOMAINSERVICES_QNAME, features);
    }

    public DomainServices(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public DomainServices(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    private static URL __getWsdlLocation() {
        if (DOMAINSERVICES_EXCEPTION != null) {
            throw DOMAINSERVICES_EXCEPTION;
        }
        return DOMAINSERVICES_WSDL_LOCATION;
    }

    /**
     * @return returns DomainService
     */
    @WebEndpoint(name = "DomainServiceSoap11")
    public DomainService getDomainServiceSoap11() {
        return super.getPort(new QName("http://enum.element.webservice.remote.oryx.com", "DomainServiceSoap11"), DomainService.class);
    }

    /**
     * @param features A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns DomainService
     */
    @WebEndpoint(name = "DomainServiceSoap11")
    public DomainService getDomainServiceSoap11(WebServiceFeature... features) {
        return super.getPort(new QName("http://enum.element.webservice.remote.oryx.com", "DomainServiceSoap11"), DomainService.class, features);
    }

}