package com.oryx.core.gui.crud.bu.billing.Instance;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoGridForm;
import com.oryx.core.layout.AbstractCrudFormLayout;
import com.oryx.core.module.IModule;
import com.oryx.remote.webservice.element.model.bu.billing.XmlInstance;

@AssoEntity(classType = XmlInstance.class)
@AssoGridForm(classType = InstanceGridForm.class)
public class InstanceForm extends AbstractCrudFormLayout<XmlInstance> {

    public InstanceForm(IModule module) {
        super(module);
    }
}
