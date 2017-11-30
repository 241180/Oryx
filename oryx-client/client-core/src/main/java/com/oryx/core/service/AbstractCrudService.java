package com.oryx.core.service;

import com.oryx.core.provider.ICrudRequestMethodProvider;
import com.oryx.core.provider.ICrudResponseMethodProvider;
import com.oryx.core.provider.IServiceMethodProvider;
import com.oryx.core.provider.ITypeByTokenProvider;
import com.oryx.remote.webservice.element._enum.XmlEnumObjectType;
import com.oryx.remote.webservice.element._enum.XmlEnumServiceOperation;
import com.oryx.remote.webservice.element.operation.ObjectFactory;
import com.oryx.remote.webservice.element.operation.XmlAuthentification;
import com.oryx.remote.webservice.element.operation.XmlOperationDescIn;
import com.oryx.remote.webservice.element.operation.XmlOperationDescOut;
import com.vaadin.server.VaadinSession;

import javax.xml.ws.Service;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public abstract class AbstractCrudService<B, S, CQ, CR> extends AbstractServiceAnnotationDiscovery<B, S> {

    public static ObjectFactory objectFactory = new ObjectFactory();

    private OperationContext operationContext = new OperationContext();

    public AbstractCrudService(Service service) {
        super(service);
    }

    @Override
    public List<B> getResponseBeans() {
        return this.operationContext.getResponseBeans();
    }

    @Override
    public List<B> getRequestBeans() {
        return this.operationContext.getRequestBeans();
    }

    @Override
    public String getResponseMessage() {
        return this.operationContext.getResponseMessage();
    }

    @Override
    public Integer getResponseErrCode() {
        return this.operationContext.getResponseErrCode();
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
        private XmlAuthentification xmlAuthentification;
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
            return this.xmlOperationDescOut.getMsg();
        }

        public Integer getResponseErrCode() {
            return this.xmlOperationDescOut.getErrCode();
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

            //create authentication info
            if (this.xmlAuthentification == null) {
                XmlAuthentification xmlAuthentification = objectFactory.createXmlAuthentification();
                xmlAuthentification.setAccesskey(VaadinSession.getCurrent().getCsrfToken());
                xmlAuthentification.setDomainCode((String) VaadinSession.getCurrent().getAttribute("DOMAIN"));
            }

            //Create Query Description
            if (this.xmlOperationDescIn == null) {
                this.xmlOperationDescIn = objectFactory.createXmlOperationDescIn();
            }

            try {
                ICrudRequestMethodProvider.SET_REQUEST_METHOD(this.request.getClass(), XmlOperationDescIn.class).invoke(this.request, this.xmlOperationDescIn);
                ICrudRequestMethodProvider.SET_AUTH_METHOD(this.request.getClass(), XmlAuthentification.class).invoke(this.request, this.xmlAuthentification);
                this.requestBeans = (List<B>) ICrudRequestMethodProvider.GET_OBJECT_METHOD(this.request.getClass()).invoke(this.request);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        public void executeAndSetResult() {
            try {
                this.response = (CR) IServiceMethodProvider.CRUD_OPERATION_METHOD(this.service.getClass(), getTypeByTokenProvider().getClassType(ITypeByTokenProvider.Target.CRUD_REQUEST)).invoke(this.service, request);
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
