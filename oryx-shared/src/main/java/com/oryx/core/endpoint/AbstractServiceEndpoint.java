package com.oryx.core.endpoint;

import com.oryx.core.binder.delegate.CrudDelegateHelper;
import com.oryx.core.enums.EnumServiceOperation;
import com.oryx.core.helper.CommonServiceHelper;
import com.oryx.core.message.ErrorMessageProvider;
import com.oryx.core.message.Errors;
import com.oryx.core.parameter.ICommonParameterNames;
import com.oryx.core.provider.*;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.UUID;

public abstract class AbstractServiceEndpoint<E, Q, R, QD, RD> //
        extends ServiceEndpointComponentConstructor<Q, R, QD> //
        implements IServiceEndPoint<Q, R, QD> {

    final static Logger logger = Logger.getLogger(AbstractServiceEndpoint.class);

    @Override
    public abstract EnumServiceOperation getRequestOperation(QD xmlOperationDescIn);

    @Override
    public R superCrudOperation(Q request) {
        R response = (R) getExchangeObjectFactory().create(getTypeByTokenProvider().getClassType(ITypeByTokenProvider.Target.CRUD_RESPONSE));
        RD xmlServiceResponse = (RD) getExchangeObjectFactory().create(getTypeByTokenProvider().getClassType(ITypeByTokenProvider.Target.RESPONSE_DESC));
        QD xmlOperationDescIn = null; //(QD) getExchangeObjectFactory().create(getTypeByTokenProvider().getClassType(ITypeByTokenProvider.Target.REQUEST_DESC));


        try {
            //Set generic response
            ICrudResponseMethodProvider.SET_RESPONSE_METHOD(response.getClass(), getTypeByTokenProvider().getClassType(ITypeByTokenProvider.Target.RESPONSE_DESC))
                    .invoke(response, xmlServiceResponse);

            //Get Response object List
            List<E> objectListResponse = (List<E>) ICrudRequestMethodProvider.GET_OBJECT_METHOD(response.getClass()).invoke(response);

            //check if user session is valid
            Boolean sessionValidationEnabled = Boolean.valueOf(CommonServiceHelper.getParameterService().getValue((ICommonParameterNames.SESSION_VALIDATION_ENABLED)));
            if (sessionValidationEnabled && isSessionValid(request)) {
                Object resp = ICrudResponseMethodProvider.GET_RESPONSE_METHOD(response.getClass()).invoke(response);
                IOpeDescInMethodProvider.SET_RESP_MSG_METHOD(resp.getClass(), String.class).invoke(resp, ErrorMessageProvider.getMessage(Errors.INVALID_USER_SESSION));
                IOpeDescOutMethodProvider.SET_RESP_ERR_CODE_METHOD(resp.getClass(), Integer.class).invoke(resp, Errors.INVALID_USER_SESSION);

                logger.error("INVALID_USER_SESSION");
                return response;
            }

            //Get generic request
            xmlOperationDescIn = (QD) ICrudRequestMethodProvider.GET_REQUEST_METHOD(request.getClass()).invoke(request);

            BeanUtils.copyProperties(xmlServiceResponse, xmlOperationDescIn);

            //Get Sent Object List
            List<E> objectListRequest = (List<E>) ICrudRequestMethodProvider.GET_OBJECT_METHOD(request.getClass()).invoke(request);

            EnumServiceOperation operation = getRequestOperation(xmlOperationDescIn);
            switch (operation) {
                //FETCH
                case FETCH_ALL: {
                    objectListResponse.addAll(CrudDelegateHelper.findAll(getTypeByTokenProvider().getClassType(ITypeByTokenProvider.Target.XML_ENTITY)));
                }
                break;
                case FETCH_BY_ID: {
                    objectListResponse.addAll(CrudDelegateHelper.findAll(getTypeByTokenProvider().getClassType(ITypeByTokenProvider.Target.XML_ENTITY)));
                }
                break;
                case FETCH_BY_CRITERIA: {
                    for (Object entity : objectListRequest) {
                        objectListResponse.addAll(CrudDelegateHelper.findByCriteria(entity));
                    }
                }
                break;

                //CRUD
                case CREATE: {
                    for (Object entity : objectListRequest) {
                        objectListResponse.add((E) CrudDelegateHelper.create(entity));
                    }
                }
                break;
                case UPDATE: {
                    for (Object entity : objectListRequest) {
                        objectListResponse.add((E) CrudDelegateHelper.update(entity));
                    }
                }
                break;
                case DELETE: {
                    for (Object entity : objectListRequest) {
                        String getId = (String) IEntityMethodProvider.GET_ID_METHOD(entity.getClass()).invoke(entity);
                        if (getId != null && !getId.isEmpty()) {
                            UUID id = UUID.fromString(getId);
                            objectListResponse.add((E) CrudDelegateHelper.delete(entity.getClass(), id));
                        }
                    }
                }
                break;
            }


        } catch (EnumConstantNotPresentException e) {
            try {
                Object resp = ICrudResponseMethodProvider.GET_RESPONSE_METHOD(response.getClass()).invoke(response);
                IOpeDescInMethodProvider.SET_RESP_MSG_METHOD(resp.getClass(), String.class).invoke(resp, e.getMessage());
                IOpeDescOutMethodProvider.SET_RESP_ERR_CODE_METHOD(resp.getClass(), Integer.class).invoke(resp, Errors.INVALID_ENUM_VALUE);
                e.printStackTrace();
            } catch (IllegalAccessException e1) {
                e1.printStackTrace();
            } catch (InvocationTargetException e1) {
                e.printStackTrace();
            }
            logger.error(e);
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            try {
                Object resp = ICrudResponseMethodProvider.GET_RESPONSE_METHOD(response.getClass()).invoke(response);
                Throwable lastCause = e;
                while (lastCause.getCause() != null) lastCause = lastCause.getCause();
                IOpeDescInMethodProvider.SET_RESP_MSG_METHOD(resp.getClass(), String.class).invoke(resp, lastCause.getMessage());
                IOpeDescOutMethodProvider.SET_RESP_ERR_CODE_METHOD(resp.getClass(), Integer.class).invoke(resp, Errors.CONSTRAINT_VIOLATION);
                e.printStackTrace();
            } catch (IllegalAccessException e1) {
                e1.printStackTrace();
            } catch (InvocationTargetException e1) {
                e1.printStackTrace();
            }
            logger.error(e);
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            try {
                Object resp = ICrudResponseMethodProvider.GET_RESPONSE_METHOD(response.getClass()).invoke(response);
                IOpeDescInMethodProvider.SET_RESP_MSG_METHOD(resp.getClass(), String.class).invoke(resp, e.getMessage());
                IOpeDescOutMethodProvider.SET_RESP_ERR_CODE_METHOD(resp.getClass(), Integer.class).invoke(resp, Errors.INVALID_OPERATION);
                e.printStackTrace();
            } catch (IllegalAccessException e1) {
                e1.printStackTrace();
            } catch (InvocationTargetException e1) {
                e.printStackTrace();
            }
            logger.error(e);
            e.printStackTrace();
        } catch (Exception e) {
            try {
                Object resp = ICrudResponseMethodProvider.GET_RESPONSE_METHOD(response.getClass()).invoke(response);
                IOpeDescInMethodProvider.SET_RESP_MSG_METHOD(resp.getClass(), String.class).invoke(resp, e.getMessage());
                IOpeDescOutMethodProvider.SET_RESP_ERR_CODE_METHOD(resp.getClass(), Integer.class).invoke(resp, Errors.UNKNOWN_ERROR);
                e.printStackTrace();
            } catch (IllegalAccessException e1) {
                e1.printStackTrace();
            } catch (InvocationTargetException e1) {
                e.printStackTrace();
            }
            logger.error(e);
            e.printStackTrace();
        }

        return response;
    }
}