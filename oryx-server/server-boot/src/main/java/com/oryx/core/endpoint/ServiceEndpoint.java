package com.oryx.core.endpoint;

import com.oryx.core.enums.EnumServiceOperation;
import com.oryx.core.provider.ICrudRequestMethodProvider;
import com.oryx.core.security.IUserProvider;
import com.oryx.remote.webservice.element.operation.XmlAuthentification;
import com.oryx.remote.webservice.element.operation.XmlOperationDescIn;
import com.oryx.remote.webservice.element.operation.XmlOperationDescOut;

import java.lang.reflect.InvocationTargetException;

/**
 * The Class PersonService.
 */

public abstract class ServiceEndpoint<E, Q, R, QD extends XmlOperationDescIn, RD extends XmlOperationDescOut> extends AbstractServiceEndpoint<E, Q, R, QD, RD> {
    @Override
    public EnumServiceOperation getRequestOperation(QD xmlOperationDescIn) {
        return EnumServiceOperation.valueOf(xmlOperationDescIn.getOperation().name());
    }

    @Override
    public boolean isSessionValid(Q request) {
        return IUserProvider.isConnected(getSessionToken(request));
    }

    @Override
    public String getSessionToken(Q request) {
        if (request != null) {
            try {
                XmlAuthentification xmlAuthentification = (XmlAuthentification) ICrudRequestMethodProvider.GET_AUTH_METHOD(request.getClass()).invoke(request);
                return xmlAuthentification != null ? xmlAuthentification.getAccesskey() : null;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}