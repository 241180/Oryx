package com.oryx.core.gui.crud.system.ose.task;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoGridForm;
import com.oryx.core.layout.AbstractCrudFormLayout;
import com.oryx.core.module.IModule;
import com.oryx.remote.webservice.element.model.system.ose.XmlTask;

@AssoEntity(classType = XmlTask.class)
@AssoGridForm(classType = TaskGridForm.class)
public class TaskForm extends AbstractCrudFormLayout<XmlTask> {

    public TaskForm(IModule module) {
        super(module);
    }

}
