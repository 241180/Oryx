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
@WebServiceClient(name = "BrandServices", targetNamespace = "http://enum.element.webservice.remote.oryx.com", wsdlLocation = "http://localhost:8680/oryx-server/BrandService.wsdl")
public class BrandServices
        extends Service {

    private final static URL BRANDSERVICES_WSDL_LOCATION;
    private final static WebServiceException BRANDSERVICES_EXCEPTION;
    private final static QName BRANDSERVICES_QNAME = new QName("http://enum.element.webservice.remote.oryx.com", "BrandServices");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8680/oryx-server/BrandService.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        BRANDSERVICES_WSDL_LOCATION = url;
        BRANDSERVICES_EXCEPTION = e;
    }

    public BrandServices() {
        super(__getWsdlLocation(), BRANDSERVICES_QNAME);
    }

    public BrandServices(WebServiceFeature... features) {
        super(__getWsdlLocation(), BRANDSERVICES_QNAME, features);
    }

    public BrandServices(URL wsdlLocation) {
        super(wsdlLocation, BRANDSERVICES_QNAME);
    }

    public BrandServices(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, BRANDSERVICES_QNAME, features);
    }

    public BrandServices(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public BrandServices(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    private static URL __getWsdlLocation() {
        if (BRANDSERVICES_EXCEPTION != null) {
            throw BRANDSERVICES_EXCEPTION;
        }
        return BRANDSERVICES_WSDL_LOCATION;
    }

    /**
     * @return returns BrandService
     */
    @WebEndpoint(name = "BrandServiceSoap11")
    public BrandService getBrandServiceSoap11() {
        return super.getPort(new QName("http://enum.element.webservice.remote.oryx.com", "BrandServiceSoap11"), BrandService.class);
    }

    /**
     * @param features A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns BrandService
     */
    @WebEndpoint(name = "BrandServiceSoap11")
    public BrandService getBrandServiceSoap11(WebServiceFeature... features) {
        return super.getPort(new QName("http://enum.element.webservice.remote.oryx.com", "BrandServiceSoap11"), BrandService.class, features);
    }

}