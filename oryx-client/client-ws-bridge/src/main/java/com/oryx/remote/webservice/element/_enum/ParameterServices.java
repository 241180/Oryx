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
@WebServiceClient(name = "ParameterServices", targetNamespace = "http://enum.element.webservice.remote.oryx.com", wsdlLocation = "http://localhost:8680/oryx-server/ParameterService.wsdl")
public class ParameterServices
        extends Service {

    private final static URL PARAMETERSERVICES_WSDL_LOCATION;
    private final static WebServiceException PARAMETERSERVICES_EXCEPTION;
    private final static QName PARAMETERSERVICES_QNAME = new QName("http://enum.element.webservice.remote.oryx.com", "ParameterServices");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8680/oryx-server/ParameterService.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        PARAMETERSERVICES_WSDL_LOCATION = url;
        PARAMETERSERVICES_EXCEPTION = e;
    }

    public ParameterServices() {
        super(__getWsdlLocation(), PARAMETERSERVICES_QNAME);
    }

    public ParameterServices(WebServiceFeature... features) {
        super(__getWsdlLocation(), PARAMETERSERVICES_QNAME, features);
    }

    public ParameterServices(URL wsdlLocation) {
        super(wsdlLocation, PARAMETERSERVICES_QNAME);
    }

    public ParameterServices(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, PARAMETERSERVICES_QNAME, features);
    }

    public ParameterServices(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ParameterServices(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    private static URL __getWsdlLocation() {
        if (PARAMETERSERVICES_EXCEPTION != null) {
            throw PARAMETERSERVICES_EXCEPTION;
        }
        return PARAMETERSERVICES_WSDL_LOCATION;
    }

    /**
     * @return returns ParameterService
     */
    @WebEndpoint(name = "ParameterServiceSoap11")
    public ParameterService getParameterServiceSoap11() {
        return super.getPort(new QName("http://enum.element.webservice.remote.oryx.com", "ParameterServiceSoap11"), ParameterService.class);
    }

    /**
     * @param features A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns ParameterService
     */
    @WebEndpoint(name = "ParameterServiceSoap11")
    public ParameterService getParameterServiceSoap11(WebServiceFeature... features) {
        return super.getPort(new QName("http://enum.element.webservice.remote.oryx.com", "ParameterServiceSoap11"), ParameterService.class, features);
    }

}
