package com.oryx.remote.webservice.element._enum;

import com.oryx.remote.webservices.service.annexservice.CrudRequest;
import com.oryx.remote.webservices.service.annexservice.CrudResponse;

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
@WebService(name = "AnnexService", targetNamespace = "http://enum.element.webservice.remote.oryx.com")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
        com.oryx.remote.webservice.element.model.ObjectFactory.class,
        com.oryx.remote.webservice.element.model.system.ose.ObjectFactory.class,
        com.oryx.remote.webservice.element.model.system.ref.ObjectFactory.class,
        com.oryx.remote.webservice.element.operation.ObjectFactory.class,
        com.oryx.remote.webservices.service.annexservice.ObjectFactory.class,
        com.oryx.remote.webservice.element._enum.ObjectFactory.class
})
public interface AnnexService {


    /**
     * @param crudRequest
     * @return returns com.oryx.remote.webservices.service.annexservice.CrudResponse
     */
    @WebMethod
    @WebResult(name = "crudResponse", targetNamespace = "http://com/oryx/remote/webservices/service/annexservice", partName = "crudResponse")
    public CrudResponse crud(
            @WebParam(name = "crudRequest", targetNamespace = "http://com/oryx/remote/webservices/service/annexservice", partName = "crudRequest")
                    CrudRequest crudRequest);

}