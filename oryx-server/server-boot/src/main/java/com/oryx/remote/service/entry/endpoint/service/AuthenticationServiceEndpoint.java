package com.oryx.remote.service.entry.endpoint.service;

import com.oryx.core.binder.delegate.CrudDelegateHelper;
import com.oryx.core.parameter.IServerParameterNames;
import com.oryx.core.security.IUserProvider;
import com.oryx.remote.service.entry.endpoint.service.namespace.TargetNameSpace;
import com.oryx.remote.webservice.element._enum.XmlEnumStatus;
import com.oryx.remote.webservice.element._enum.XmlEnumUserRole;
import com.oryx.remote.webservice.element.model.system.ose.XmlUser;
import com.oryx.remote.webservices.service.authenticationservice.AuthenticationRequest;
import com.oryx.remote.webservices.service.authenticationservice.AuthenticationResponse;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import com.oryx.Crypter;
import com.oryx.KeyczarFileReader;
import com.oryx.exceptions.KeyczarException;
import com.oryx.interfaces.KeyczarReader;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * The Class AuthenticationService.
 */
@Endpoint
public class AuthenticationServiceEndpoint {

    final static Logger logger = Logger.getLogger(AuthenticationServiceEndpoint.class);

    @PayloadRoot(localPart = TargetNameSpace.SERVICE_REQUEST_LOCAL_PORT, namespace = TargetNameSpace.TARGET_NAMESPACE_AUTHENTICATION)
    public
    @ResponsePayload
    AuthenticationResponse authenticate(@RequestPayload AuthenticationRequest request) throws InvocationTargetException, IllegalAccessException {
        AuthenticationResponse response = new AuthenticationResponse();

        //TODO To be removed
        XmlUser userDefault = new XmlUser();
        userDefault.setUserLogin("admin");
        try {
            List<XmlUser> userList = CrudDelegateHelper.findByCriteria(userDefault);
            if (CollectionUtils.isEmpty(userList)) {
                userDefault.setEmail("admin@oryx.com");
                userDefault.setUserLogin("admin");
                userDefault.setUserPassword("admin");
                userDefault.setRole(XmlEnumUserRole.ROLE_ADMIN);
                userDefault.setStatus(XmlEnumStatus.ACTIVE);
                CrudDelegateHelper.create(userDefault);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //

        if (request != null && ((request.getLogin() != null && request.getPassword() != null) || request.getSessionToken() != null)) {
            XmlUser xmlUser = null;
            if (request.getSessionToken() != null && IUserProvider.isConnected(request.getSessionToken())) {
                xmlUser = IUserProvider.getUserBySessionToken(request.getSessionToken());
            } else {
                XmlUser userCritria = new XmlUser();
                userCritria.setUserLogin(request.getLogin());
                List<XmlUser> users = CrudDelegateHelper.findByCriteria(userCritria);
                if (users != null && users.size() == 1) {
                    xmlUser = users.get(0);

                    try {
                        KeyczarReader reader = new KeyczarFileReader(IServerParameterNames.ENCRIPTION_DIR);
                        Crypter crypter = new Crypter(reader);
                        String decrypted = crypter.decrypt(xmlUser.getUserPassword());

                        if (decrypted.equals(request.getPassword())) {
                            if (xmlUser.getStatus() == XmlEnumStatus.ACTIVE) {
                                try {
                                    GregorianCalendar c = new GregorianCalendar();
                                    c.setTime(new Date());
                                    xmlUser.setLastConnection(DatatypeFactory.newInstance().newXMLGregorianCalendar(c));
                                    CrudDelegateHelper.update(xmlUser);
                                } catch (IllegalAccessException e) {
                                    e.printStackTrace();
                                } catch (DatatypeConfigurationException e) {
                                    e.printStackTrace();
                                }

                                IUserProvider.addUser(xmlUser, request.getSessionToken());
                            } else {
                                xmlUser = null;
                            }
                        } else {
                            xmlUser = null;
                        }
                    } catch (KeyczarException e) {
                        e.printStackTrace();
                    }
                }
            }

            if (xmlUser != null) {
                response.setUser(xmlUser);
            }
        }

        return response;
    }
}