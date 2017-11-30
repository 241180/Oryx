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
@WebServiceClient(name = "PatientServices", targetNamespace = "http://enum.element.webservice.remote.oryx.com", wsdlLocation = "http://localhost:8680/oryx-server/PatientService.wsdl")
public class PatientServices
        extends Service {

    private final static URL PATIENTSERVICES_WSDL_LOCATION;
    private final static WebServiceException PATIENTSERVICES_EXCEPTION;
    private final static QName PATIENTSERVICES_QNAME = new QName("http://enum.element.webservice.remote.oryx.com", "PatientServices");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8680/oryx-server/PatientService.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        PATIENTSERVICES_WSDL_LOCATION = url;
        PATIENTSERVICES_EXCEPTION = e;
    }

    public PatientServices() {
        super(__getWsdlLocation(), PATIENTSERVICES_QNAME);
    }

    public PatientServices(WebServiceFeature... features) {
        super(__getWsdlLocation(), PATIENTSERVICES_QNAME, features);
    }

    public PatientServices(URL wsdlLocation) {
        super(wsdlLocation, PATIENTSERVICES_QNAME);
    }

    public PatientServices(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, PATIENTSERVICES_QNAME, features);
    }

    public PatientServices(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public PatientServices(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    private static URL __getWsdlLocation() {
        if (PATIENTSERVICES_EXCEPTION != null) {
            throw PATIENTSERVICES_EXCEPTION;
        }
        return PATIENTSERVICES_WSDL_LOCATION;
    }

    /**
     * @return returns PatientService
     */
    @WebEndpoint(name = "PatientServiceSoap11")
    public PatientService getPatientServiceSoap11() {
        return super.getPort(new QName("http://enum.element.webservice.remote.oryx.com", "PatientServiceSoap11"), PatientService.class);
    }

    /**
     * @param features A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns PatientService
     */
    @WebEndpoint(name = "PatientServiceSoap11")
    public PatientService getPatientServiceSoap11(WebServiceFeature... features) {
        return super.getPort(new QName("http://enum.element.webservice.remote.oryx.com", "PatientServiceSoap11"), PatientService.class, features);
    }

}