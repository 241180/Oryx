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
@WebServiceClient(name = "PatientViewServices", targetNamespace = "http://enum.element.webservice.remote.oryx.com", wsdlLocation = "http://localhost:8680/oryx-server/PatientViewService.wsdl")
public class PatientViewServices
        extends Service {

    private final static URL PATIENTVIEWSERVICES_WSDL_LOCATION;
    private final static WebServiceException PATIENTVIEWSERVICES_EXCEPTION;
    private final static QName PATIENTVIEWSERVICES_QNAME = new QName("http://enum.element.webservice.remote.oryx.com", "PatientViewServices");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8680/oryx-server/PatientViewService.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        PATIENTVIEWSERVICES_WSDL_LOCATION = url;
        PATIENTVIEWSERVICES_EXCEPTION = e;
    }

    public PatientViewServices() {
        super(__getWsdlLocation(), PATIENTVIEWSERVICES_QNAME);
    }

    public PatientViewServices(WebServiceFeature... features) {
        super(__getWsdlLocation(), PATIENTVIEWSERVICES_QNAME, features);
    }

    public PatientViewServices(URL wsdlLocation) {
        super(wsdlLocation, PATIENTVIEWSERVICES_QNAME);
    }

    public PatientViewServices(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, PATIENTVIEWSERVICES_QNAME, features);
    }

    public PatientViewServices(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public PatientViewServices(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    private static URL __getWsdlLocation() {
        if (PATIENTVIEWSERVICES_EXCEPTION != null) {
            throw PATIENTVIEWSERVICES_EXCEPTION;
        }
        return PATIENTVIEWSERVICES_WSDL_LOCATION;
    }

    /**
     * @return returns PatientViewService
     */
    @WebEndpoint(name = "PatientViewServiceSoap11")
    public PatientViewService getPatientViewServiceSoap11() {
        return super.getPort(new QName("http://enum.element.webservice.remote.oryx.com", "PatientViewServiceSoap11"), PatientViewService.class);
    }

    /**
     * @param features A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns PatientViewService
     */
    @WebEndpoint(name = "PatientViewServiceSoap11")
    public PatientViewService getPatientViewServiceSoap11(WebServiceFeature... features) {
        return super.getPort(new QName("http://enum.element.webservice.remote.oryx.com", "PatientViewServiceSoap11"), PatientViewService.class, features);
    }

}
