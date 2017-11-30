package com.oryx.core.delegate.system.ref;

import com.oryx.core.delegate.IDelegate;
import com.oryx.core.provider.ITypeByTokenProvider;
import com.oryx.remote.webservice.element._enum.AuthenticationService;
import com.oryx.remote.webservice.element._enum.AuthenticationServices;
import com.oryx.remote.webservice.element.model.system.ose.XmlUser;
import com.oryx.remote.webservices.service.authenticationservice.AuthenticationRequest;
import com.oryx.remote.webservices.service.authenticationservice.AuthenticationResponse;
import com.vaadin.server.VaadinSession;

import javax.xml.ws.Service;

public class AuthenticationServiceDelegate implements IDelegate {

    public AuthenticationServiceDelegate(Service service) {
        super();
    }

    public AuthenticationServiceDelegate() {
        super();
    }

    private AuthenticationService getWebService() {
        return (new AuthenticationServices()).getAuthenticationServiceSoap11();
    }

    public XmlUser authenticate(String login, String password, String sessionToken) {
        AuthenticationRequest authenticationRequest = new AuthenticationRequest();
        authenticationRequest.setLogin(login);
        authenticationRequest.setPassword(password);
        authenticationRequest.setSessionToken(sessionToken);
        AuthenticationResponse authenticationResponse = getWebService().authentication(authenticationRequest);
        VaadinSession.getCurrent().setAttribute("USER_ID", authenticationResponse.getUser() != null ? authenticationResponse.getUser().getId() : null);
        VaadinSession.getCurrent().setAttribute("DOMAIN", authenticationResponse.getUser() != null ? authenticationResponse.getUser().getDomainScope() : null);
        return authenticationResponse.getUser();
    }

    public XmlUser authenticate(String sessionToken) {
        AuthenticationRequest authenticationRequest = new AuthenticationRequest();
        authenticationRequest.setSessionToken(sessionToken);
        AuthenticationResponse authenticationResponse = getWebService().authentication(authenticationRequest);
        return authenticationResponse.getUser();
    }

    @Override
    public ITypeByTokenProvider getTypeByTokenProvider() {
        return null;
    }
}
