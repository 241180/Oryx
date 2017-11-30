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
@WebServiceClient(name = "AccountServices", targetNamespace = "http://enum.element.webservice.remote.oryx.com", wsdlLocation = "http://localhost:8680/oryx-server/AccountService.wsdl")
public class AccountServices
        extends Service {

    private final static URL ACCOUNTSERVICES_WSDL_LOCATION;
    private final static WebServiceException ACCOUNTSERVICES_EXCEPTION;
    private final static QName ACCOUNTSERVICES_QNAME = new QName("http://enum.element.webservice.remote.oryx.com", "AccountServices");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8680/oryx-server/AccountService.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        ACCOUNTSERVICES_WSDL_LOCATION = url;
        ACCOUNTSERVICES_EXCEPTION = e;
    }

    public AccountServices() {
        super(__getWsdlLocation(), ACCOUNTSERVICES_QNAME);
    }

    public AccountServices(WebServiceFeature... features) {
        super(__getWsdlLocation(), ACCOUNTSERVICES_QNAME, features);
    }

    public AccountServices(URL wsdlLocation) {
        super(wsdlLocation, ACCOUNTSERVICES_QNAME);
    }

    public AccountServices(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, ACCOUNTSERVICES_QNAME, features);
    }

    public AccountServices(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AccountServices(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    private static URL __getWsdlLocation() {
        if (ACCOUNTSERVICES_EXCEPTION != null) {
            throw ACCOUNTSERVICES_EXCEPTION;
        }
        return ACCOUNTSERVICES_WSDL_LOCATION;
    }

    /**
     * @return returns AccountService
     */
    @WebEndpoint(name = "AccountServiceSoap11")
    public AccountService getAccountServiceSoap11() {
        return super.getPort(new QName("http://enum.element.webservice.remote.oryx.com", "AccountServiceSoap11"), AccountService.class);
    }

    /**
     * @param features A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns AccountService
     */
    @WebEndpoint(name = "AccountServiceSoap11")
    public AccountService getAccountServiceSoap11(WebServiceFeature... features) {
        return super.getPort(new QName("http://enum.element.webservice.remote.oryx.com", "AccountServiceSoap11"), AccountService.class, features);
    }

}
