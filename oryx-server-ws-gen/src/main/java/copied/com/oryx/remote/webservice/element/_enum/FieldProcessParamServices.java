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
@WebServiceClient(name = "FieldProcessParamServices", targetNamespace = "http://enum.element.webservice.remote.oryx.com", wsdlLocation = "http://localhost:8680/oryx-server/FieldProcessParamService.wsdl")
public class FieldProcessParamServices
        extends Service {

    private final static URL FIELDPROCESSPARAMSERVICES_WSDL_LOCATION;
    private final static WebServiceException FIELDPROCESSPARAMSERVICES_EXCEPTION;
    private final static QName FIELDPROCESSPARAMSERVICES_QNAME = new QName("http://enum.element.webservice.remote.oryx.com", "FieldProcessParamServices");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8680/oryx-server/FieldProcessParamService.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        FIELDPROCESSPARAMSERVICES_WSDL_LOCATION = url;
        FIELDPROCESSPARAMSERVICES_EXCEPTION = e;
    }

    public FieldProcessParamServices() {
        super(__getWsdlLocation(), FIELDPROCESSPARAMSERVICES_QNAME);
    }

    public FieldProcessParamServices(WebServiceFeature... features) {
        super(__getWsdlLocation(), FIELDPROCESSPARAMSERVICES_QNAME, features);
    }

    public FieldProcessParamServices(URL wsdlLocation) {
        super(wsdlLocation, FIELDPROCESSPARAMSERVICES_QNAME);
    }

    public FieldProcessParamServices(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, FIELDPROCESSPARAMSERVICES_QNAME, features);
    }

    public FieldProcessParamServices(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public FieldProcessParamServices(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    private static URL __getWsdlLocation() {
        if (FIELDPROCESSPARAMSERVICES_EXCEPTION != null) {
            throw FIELDPROCESSPARAMSERVICES_EXCEPTION;
        }
        return FIELDPROCESSPARAMSERVICES_WSDL_LOCATION;
    }

    /**
     * @return returns FieldProcessParamService
     */
    @WebEndpoint(name = "FieldProcessParamServiceSoap11")
    public FieldProcessParamService getFieldProcessParamServiceSoap11() {
        return super.getPort(new QName("http://enum.element.webservice.remote.oryx.com", "FieldProcessParamServiceSoap11"), FieldProcessParamService.class);
    }

    /**
     * @param features A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns FieldProcessParamService
     */
    @WebEndpoint(name = "FieldProcessParamServiceSoap11")
    public FieldProcessParamService getFieldProcessParamServiceSoap11(WebServiceFeature... features) {
        return super.getPort(new QName("http://enum.element.webservice.remote.oryx.com", "FieldProcessParamServiceSoap11"), FieldProcessParamService.class, features);
    }

}