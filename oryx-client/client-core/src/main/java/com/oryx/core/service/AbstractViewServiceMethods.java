package com.oryx.core.service;

import com.oryx.core.provider.ICrudRequestMethodProvider;
import com.oryx.core.provider.ICrudResponseMethodProvider;
import com.oryx.core.provider.IServiceMethodProvider;
import com.oryx.core.provider.ITypeByTokenProvider;
import com.oryx.remote.webservice.element._enum.XmlEnumObjectType;
import com.oryx.remote.webservice.element._enum.XmlEnumServiceOperation;
import com.oryx.remote.webservice.element.operation.ObjectFactory;
import com.oryx.remote.webservice.element.operation.XmlOperationDescIn;
import com.oryx.remote.webservice.element.operation.XmlOperationDescOut;

import javax.xml.ws.Service;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public abstract class AbstractViewServiceMethods<B, S, CQ, CR> extends AbstractServiceAnnotationDiscovery<B, S> {

    private OperationContext operationContext = new OperationContext();

    public AbstractViewServiceMethods(Service service) {
        super(service);
    }

    @Override
    public List<B> getResponseBeans() {
        return this.operationContext != null ? this.operationContext.getResponseBeans() : null;
    }

    @Override
    public List<B> getRequestBeans() {
        return this.operationContext != null ? this.operationContext.getRequestBeans() : null;
    }

    @Override
    public String getResponseMessage() {
        return this.operationContext != null ? this.operationContext.getResponseMessage() : null;
    }

    @Override
    public Integer getResponseErrCode() {
        return this.operationContext != null ? this.operationContext.getResponseErrCode() : null;
    }

    @Override
    public void create(B bean) {
        if (this.operationContext != null) {
            this.operationContext.prepareOperationRequest();
            this.operationContext.setOperation(XmlEnumServiceOperation.CREATE);
            this.operationContext.setObjectType(getEnumObjectType());
            this.operationContext.getRequestBeans().add(bean);
            this.operationContext.executeAndSetResult();
        }
    }

    @Override
    public void create(List<B> beans) {
        if (this.operationContext != null) {
            this.operationContext.prepareOperationRequest();
            this.operationContext.setOperation(XmlEnumServiceOperation.CREATE);
            this.operationContext.setObjectType(getEnumObjectType());
            for (B bean : beans) {
                this.operationContext.getRequestBeans().add(bean);
            }
            this.operationContext.executeAndSetResult();
        }
    }

    @Override
    public void update(B bean) {
        if (this.operationContext != null) {
            this.operationContext.prepareOperationRequest();
            this.operationContext.setOperation(XmlEnumServiceOperation.UPDATE);
            this.operationContext.setObjectType(getEnumObjectType());
            this.operationContext.getRequestBeans().add(bean);
            this.operationContext.executeAndSetResult();
        }
    }

    @Override
    public void delete(B bean) {
        if (this.operationContext != null) {
            this.operationContext.prepareOperationRequest();
            this.operationContext.setOperation(XmlEnumServiceOperation.DELETE);
            this.operationContext.setObjectType(getEnumObjectType());
            this.operationContext.getRequestBeans().add(bean);
            this.operationContext.executeAndSetResult();
        }
    }

    public void delete(List<B> beans) {
        if (this.operationContext != null) {
            this.operationContext.prepareOperationRequest();
            this.operationContext.setOperation(XmlEnumServiceOperation.DELETE);
            this.operationContext.setObjectType(getEnumObjectType());
            for (B bean : beans) {
                this.operationContext.getRequestBeans().add(bean);
            }
            this.operationContext.executeAndSetResult();
        }
    }

    @Override
    public List<B> findAll() {
        if (this.operationContext != null) {
            this.operationContext.prepareOperationRequest();
            this.operationContext.setOperation(XmlEnumServiceOperation.FETCH_ALL);
            this.operationContext.setObjectType(getEnumObjectType());
            this.operationContext.executeAndSetResult();
        }

        return operationContext.getResponseBeans();
    }

    @Override
    public List<B> findByCriteria(B bean) {
        if (this.operationContext != null) {
            this.operationContext.prepareOperationRequest();
            this.operationContext.setOperation(XmlEnumServiceOperation.FETCH_BY_CRITERIA);
            this.operationContext.setObjectType(getEnumObjectType());
            this.operationContext.getRequestBeans().add(bean);
            this.operationContext.executeAndSetResult();
        }

        return operationContext.getResponseBeans();
    }

    class OperationContext {
        private S service;
        private CQ request;
        private CR response;
        private XmlOperationDescIn xmlOperationDescIn;
        private XmlOperationDescOut xmlOperationDescOut;
        private List<B> requestBeans;
        private List<B> responseBeans;

        public void setOperation(XmlEnumServiceOperation value) {
            this.xmlOperationDescIn.setOperation(value);
        }

        public void setObjectType(XmlEnumObjectType value) {
            this.xmlOperationDescIn.setObjectType(value);
        }

        public List<B> getRequestBeans() {
            return this.requestBeans;
        }

        public List<B> getResponseBeans() {
            return this.responseBeans;
        }

        public String getResponseMessage() {
            return this.xmlOperationDescOut != null ? this.xmlOperationDescOut.getMsg() : null;
        }

        public Integer getResponseErrCode() {
            return this.xmlOperationDescOut != null ? this.xmlOperationDescOut.getErrCode() : null;
        }

        public void prepareOperationRequest() {
            if (this.requestBeans != null)
                this.requestBeans.clear();

            if (this.responseBeans != null)
                this.responseBeans.clear();

            if (this.service == null)
                this.service = getWebService();

            //Create Query packet
            this.request = (CQ) (getExchangeObjectFactory()).create(getTypeByTokenProvider().getClassType(ITypeByTokenProvider.Target.CRUD_REQUEST));

            //Create Query Description
            if (this.xmlOperationDescIn == null)
                this.xmlOperationDescIn = (new ObjectFactory().createXmlOperationDescIn());

            try {
                ICrudRequestMethodProvider.SET_REQUEST_METHOD(this.request.getClass(), XmlOperationDescIn.class).invoke(this.request, this.xmlOperationDescIn);
                this.requestBeans = (List<B>) ICrudRequestMethodProvider.GET_OBJECT_METHOD(this.request.getClass()).invoke(this.request);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        public void executeAndSetResult() {
            try {
                this.response = (CR) IServiceMethodProvider.VIEW_OPERATION_METHOD(this.service.getClass(), getTypeByTokenProvider().getClassType(ITypeByTokenProvider.Target.CRUD_REQUEST)).invoke(this.service, request);
                this.responseBeans = (List<B>) ICrudRequestMethodProvider.GET_OBJECT_METHOD(response.getClass()).invoke(response);
                this.xmlOperationDescOut = (XmlOperationDescOut) ICrudResponseMethodProvider.GET_RESPONSE_METHOD(response.getClass()).invoke(response);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
