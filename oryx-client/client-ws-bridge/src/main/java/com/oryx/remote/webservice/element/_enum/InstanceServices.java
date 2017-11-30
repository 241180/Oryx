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
@WebServiceClient(name = "InstanceServices", targetNamespace = "http://enum.element.webservice.remote.oryx.com", wsdlLocation = "http://localhost:8680/oryx-server/InstanceService.wsdl")
public class InstanceServices
        extends Service {

    private final static URL INSTANCESERVICES_WSDL_LOCATION;
    private final static WebServiceException INSTANCESERVICES_EXCEPTION;
    private final static QName INSTANCESERVICES_QNAME = new QName("http://enum.element.webservice.remote.oryx.com", "InstanceServices");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8680/oryx-server/InstanceService.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        INSTANCESERVICES_WSDL_LOCATION = url;
        INSTANCESERVICES_EXCEPTION = e;
    }

    public InstanceServices() {
        super(__getWsdlLocation(), INSTANCESERVICES_QNAME);
    }

    public InstanceServices(WebServiceFeature... features) {
        super(__getWsdlLocation(), INSTANCESERVICES_QNAME, features);
    }

    public InstanceServices(URL wsdlLocation) {
        super(wsdlLocation, INSTANCESERVICES_QNAME);
    }

    public InstanceServices(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, INSTANCESERVICES_QNAME, features);
    }

    public InstanceServices(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public InstanceServices(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    private static URL __getWsdlLocation() {
        if (INSTANCESERVICES_EXCEPTION != null) {
            throw INSTANCESERVICES_EXCEPTION;
        }
        return INSTANCESERVICES_WSDL_LOCATION;
    }

    /**
     * @return returns InstanceService
     */
    @WebEndpoint(name = "InstanceServiceSoap11")
    public InstanceService getInstanceServiceSoap11() {
        return super.getPort(new QName("http://enum.element.webservice.remote.oryx.com", "InstanceServiceSoap11"), InstanceService.class);
    }

    /**
     * @param features A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns InstanceService
     */
    @WebEndpoint(name = "InstanceServiceSoap11")
    public InstanceService getInstanceServiceSoap11(WebServiceFeature... features) {
        return super.getPort(new QName("http://enum.element.webservice.remote.oryx.com", "InstanceServiceSoap11"), InstanceService.class, features);
    }

}