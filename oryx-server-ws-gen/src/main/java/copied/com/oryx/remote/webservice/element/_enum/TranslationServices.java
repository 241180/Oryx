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
@WebServiceClient(name = "TranslationServices", targetNamespace = "http://enum.element.webservice.remote.oryx.com", wsdlLocation = "http://localhost:8680/oryx-server/TranslationService.wsdl")
public class TranslationServices
        extends Service {

    private final static URL TRANSLATIONSERVICES_WSDL_LOCATION;
    private final static WebServiceException TRANSLATIONSERVICES_EXCEPTION;
    private final static QName TRANSLATIONSERVICES_QNAME = new QName("http://enum.element.webservice.remote.oryx.com", "TranslationServices");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8680/oryx-server/TranslationService.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        TRANSLATIONSERVICES_WSDL_LOCATION = url;
        TRANSLATIONSERVICES_EXCEPTION = e;
    }

    public TranslationServices() {
        super(__getWsdlLocation(), TRANSLATIONSERVICES_QNAME);
    }

    public TranslationServices(WebServiceFeature... features) {
        super(__getWsdlLocation(), TRANSLATIONSERVICES_QNAME, features);
    }

    public TranslationServices(URL wsdlLocation) {
        super(wsdlLocation, TRANSLATIONSERVICES_QNAME);
    }

    public TranslationServices(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, TRANSLATIONSERVICES_QNAME, features);
    }

    public TranslationServices(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TranslationServices(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    private static URL __getWsdlLocation() {
        if (TRANSLATIONSERVICES_EXCEPTION != null) {
            throw TRANSLATIONSERVICES_EXCEPTION;
        }
        return TRANSLATIONSERVICES_WSDL_LOCATION;
    }

    /**
     * @return returns TranslationService
     */
    @WebEndpoint(name = "TranslationServiceSoap11")
    public TranslationService getTranslationServiceSoap11() {
        return super.getPort(new QName("http://enum.element.webservice.remote.oryx.com", "TranslationServiceSoap11"), TranslationService.class);
    }

    /**
     * @param features A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns TranslationService
     */
    @WebEndpoint(name = "TranslationServiceSoap11")
    public TranslationService getTranslationServiceSoap11(WebServiceFeature... features) {
        return super.getPort(new QName("http://enum.element.webservice.remote.oryx.com", "TranslationServiceSoap11"), TranslationService.class, features);
    }

}
