package com.oryx.remote.webservice.element._enum;

import com.oryx.remote.webservices.service.countryservice.CrudRequest;
import com.oryx.remote.webservices.service.countryservice.CrudResponse;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10
 * Generated source version: 2.2
 */
@WebService(name = "CountryService", targetNamespace = "http://enum.element.webservice.remote.oryx.com")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
        com.oryx.remote.webservice.element.model.ObjectFactory.class,
        com.oryx.remote.webservice.element.model.system.ref.ObjectFactory.class,
        com.oryx.remote.webservice.element.operation.ObjectFactory.class,
        com.oryx.remote.webservices.service.countryservice.ObjectFactory.class,
        com.oryx.remote.webservice.element._enum.ObjectFactory.class
})
public interface CountryService {


    /**
     * @param crudRequest
     * @return returns com.oryx.remote.webservices.service.countryservice.CrudResponse
     */
    @WebMethod
    @WebResult(name = "crudResponse", targetNamespace = "http://com/oryx/remote/webservices/service/countryservice", partName = "crudResponse")
    public CrudResponse crud(
            @WebParam(name = "crudRequest", targetNamespace = "http://com/oryx/remote/webservices/service/countryservice", partName = "crudRequest")
                    CrudRequest crudRequest);

}
