package com.oryx.core.delegate.system.ose;

import com.oryx.core.annotation.decl.AssoEntityEnum;
import com.oryx.core.annotation.decl.AssoExchangeObjectFactory;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.factory.system.ose.TaskExchangeObjFactory;
import com.oryx.core.provider.typeByToken.model.system.ose.TaskTypeByTokenProvider;
import com.oryx.core.service.AbstractCrudService;
import com.oryx.remote.webservice.element._enum.TaskService;
import com.oryx.remote.webservice.element._enum.TaskServices;
import com.oryx.remote.webservice.element._enum.XmlEnumObjectType;
import com.oryx.remote.webservice.element.model.system.ose.XmlTask;
import com.oryx.remote.webservices.service.taskservice.CrudRequest;
import com.oryx.remote.webservices.service.taskservice.CrudResponse;

import javax.xml.ws.Service;

@AssoEntityEnum(value = XmlEnumObjectType.TASK)
@AssoTypeByTokenProvider(classType = TaskTypeByTokenProvider.class)
@AssoExchangeObjectFactory(classType = TaskExchangeObjFactory.class)
public class TaskServiceDelegate extends AbstractCrudService<XmlTask, TaskService
        , CrudRequest, CrudResponse> {

    public TaskServiceDelegate(Service service) {
        super(service);
    }

    @Override
    public TaskService getWebService() {
        return ((TaskServices) getService()).getTaskServiceSoap11();
    }
}
