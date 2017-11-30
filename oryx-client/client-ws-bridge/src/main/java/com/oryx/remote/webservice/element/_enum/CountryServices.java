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
@WebServiceClient(name = "CountryServices", targetNamespace = "http://enum.element.webservice.remote.oryx.com", wsdlLocation = "http://localhost:8680/oryx-server/CountryService.wsdl")
public class CountryServices
        extends Service {

    private final static URL COUNTRYSERVICES_WSDL_LOCATION;
    private final static WebServiceException COUNTRYSERVICES_EXCEPTION;
    private final static QName COUNTRYSERVICES_QNAME = new QName("http://enum.element.webservice.remote.oryx.com", "CountryServices");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8680/oryx-server/CountryService.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        COUNTRYSERVICES_WSDL_LOCATION = url;
        COUNTRYSERVICES_EXCEPTION = e;
    }

    public CountryServices() {
        super(__getWsdlLocation(), COUNTRYSERVICES_QNAME);
    }

    public CountryServices(WebServiceFeature... features) {
        super(__getWsdlLocation(), COUNTRYSERVICES_QNAME, features);
    }

    public CountryServices(URL wsdlLocation) {
        super(wsdlLocation, COUNTRYSERVICES_QNAME);
    }

    public CountryServices(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, COUNTRYSERVICES_QNAME, features);
    }

    public CountryServices(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CountryServices(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    private static URL __getWsdlLocation() {
        if (COUNTRYSERVICES_EXCEPTION != null) {
            throw COUNTRYSERVICES_EXCEPTION;
        }
        return COUNTRYSERVICES_WSDL_LOCATION;
    }

    /**
     * @return returns CountryService
     */
    @WebEndpoint(name = "CountryServiceSoap11")
    public CountryService getCountryServiceSoap11() {
        return super.getPort(new QName("http://enum.element.webservice.remote.oryx.com", "CountryServiceSoap11"), CountryService.class);
    }

    /**
     * @param features A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns CountryService
     */
    @WebEndpoint(name = "CountryServiceSoap11")
    public CountryService getCountryServiceSoap11(WebServiceFeature... features) {
        return super.getPort(new QName("http://enum.element.webservice.remote.oryx.com", "CountryServiceSoap11"), CountryService.class, features);
    }

}
