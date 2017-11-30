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
@WebServiceClient(name = "BillServices", targetNamespace = "http://enum.element.webservice.remote.oryx.com", wsdlLocation = "http://localhost:8680/oryx-server/BillService.wsdl")
public class BillServices
        extends Service {

    private final static URL BILLSERVICES_WSDL_LOCATION;
    private final static WebServiceException BILLSERVICES_EXCEPTION;
    private final static QName BILLSERVICES_QNAME = new QName("http://enum.element.webservice.remote.oryx.com", "BillServices");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8680/oryx-server/BillService.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        BILLSERVICES_WSDL_LOCATION = url;
        BILLSERVICES_EXCEPTION = e;
    }

    public BillServices() {
        super(__getWsdlLocation(), BILLSERVICES_QNAME);
    }

    public BillServices(WebServiceFeature... features) {
        super(__getWsdlLocation(), BILLSERVICES_QNAME, features);
    }

    public BillServices(URL wsdlLocation) {
        super(wsdlLocation, BILLSERVICES_QNAME);
    }

    public BillServices(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, BILLSERVICES_QNAME, features);
    }

    public BillServices(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public BillServices(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    private static URL __getWsdlLocation() {
        if (BILLSERVICES_EXCEPTION != null) {
            throw BILLSERVICES_EXCEPTION;
        }
        return BILLSERVICES_WSDL_LOCATION;
    }

    /**
     * @return returns BillService
     */
    @WebEndpoint(name = "BillServiceSoap11")
    public BillService getBillServiceSoap11() {
        return super.getPort(new QName("http://enum.element.webservice.remote.oryx.com", "BillServiceSoap11"), BillService.class);
    }

    /**
     * @param features A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns BillService
     */
    @WebEndpoint(name = "BillServiceSoap11")
    public BillService getBillServiceSoap11(WebServiceFeature... features) {
        return super.getPort(new QName("http://enum.element.webservice.remote.oryx.com", "BillServiceSoap11"), BillService.class, features);
    }

}
