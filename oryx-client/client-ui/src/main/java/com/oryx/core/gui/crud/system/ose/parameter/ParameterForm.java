package com.oryx.core.gui.crud.system.ose.parameter;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoGridForm;
import com.oryx.core.layout.AbstractCrudFormLayout;
import com.oryx.core.module.IModule;
import com.oryx.remote.webservice.element.model.system.ose.XmlParameter;


@AssoEntity(classType = XmlParameter.class)
@AssoGridForm(classType = ParameterGridForm.class)
public class ParameterForm extends AbstractCrudFormLayout<XmlParameter> {

    public ParameterForm(IModule module) {
        super(module);
    }
}
