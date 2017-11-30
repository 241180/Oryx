package com.oryx.remote.webservice.element._enum;

import com.oryx.remote.webservices.service.authenticationservice.AuthenticationRequest;
import com.oryx.remote.webservices.service.authenticationservice.AuthenticationResponse;

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
@WebService(name = "AuthenticationService", targetNamespace = "http://enum.element.webservice.remote.oryx.com")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
        com.oryx.remote.webservice.element.model.ObjectFactory.class,
        com.oryx.remote.webservice.element.model.system.ose.ObjectFactory.class,
        com.oryx.remote.webservice.element.model.system.ref.ObjectFactory.class,
        com.oryx.remote.webservice.element.operation.ObjectFactory.class,
        com.oryx.remote.webservices.service.authenticationservice.ObjectFactory.class,
        com.oryx.remote.webservice.element._enum.ObjectFactory.class
})
public interface AuthenticationService {


    /**
     * @param authenticationRequest
     * @return returns com.oryx.remote.webservices.service.authenticationservice.AuthenticationResponse
     */
    @WebMethod
    @WebResult(name = "authenticationResponse", targetNamespace = "http://com/oryx/remote/webservices/service/authenticationservice", partName = "authenticationResponse")
    public AuthenticationResponse authentication(
            @WebParam(name = "authenticationRequest", targetNamespace = "http://com/oryx/remote/webservices/service/authenticationservice", partName = "authenticationRequest")
                    AuthenticationRequest authenticationRequest);

}
