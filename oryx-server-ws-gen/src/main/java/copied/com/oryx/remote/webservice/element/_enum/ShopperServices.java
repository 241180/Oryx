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
@WebServiceClient(name = "ShopperServices", targetNamespace = "http://enum.element.webservice.remote.oryx.com", wsdlLocation = "http://localhost:8680/oryx-server/ShopperService.wsdl")
public class ShopperServices
        extends Service {

    private final static URL SHOPPERSERVICES_WSDL_LOCATION;
    private final static WebServiceException SHOPPERSERVICES_EXCEPTION;
    private final static QName SHOPPERSERVICES_QNAME = new QName("http://enum.element.webservice.remote.oryx.com", "ShopperServices");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8680/oryx-server/ShopperService.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SHOPPERSERVICES_WSDL_LOCATION = url;
        SHOPPERSERVICES_EXCEPTION = e;
    }

    public ShopperServices() {
        super(__getWsdlLocation(), SHOPPERSERVICES_QNAME);
    }

    public ShopperServices(WebServiceFeature... features) {
        super(__getWsdlLocation(), SHOPPERSERVICES_QNAME, features);
    }

    public ShopperServices(URL wsdlLocation) {
        super(wsdlLocation, SHOPPERSERVICES_QNAME);
    }

    public ShopperServices(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SHOPPERSERVICES_QNAME, features);
    }

    public ShopperServices(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ShopperServices(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    private static URL __getWsdlLocation() {
        if (SHOPPERSERVICES_EXCEPTION != null) {
            throw SHOPPERSERVICES_EXCEPTION;
        }
        return SHOPPERSERVICES_WSDL_LOCATION;
    }

    /**
     * @return returns ShopperService
     */
    @WebEndpoint(name = "ShopperServiceSoap11")
    public ShopperService getShopperServiceSoap11() {
        return super.getPort(new QName("http://enum.element.webservice.remote.oryx.com", "ShopperServiceSoap11"), ShopperService.class);
    }

    /**
     * @param features A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns ShopperService
     */
    @WebEndpoint(name = "ShopperServiceSoap11")
    public ShopperService getShopperServiceSoap11(WebServiceFeature... features) {
        return super.getPort(new QName("http://enum.element.webservice.remote.oryx.com", "ShopperServiceSoap11"), ShopperService.class, features);
    }

}
