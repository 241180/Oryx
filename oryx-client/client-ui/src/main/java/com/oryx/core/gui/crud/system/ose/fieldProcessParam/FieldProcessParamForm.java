package com.oryx.core.gui.crud.system.ose.fieldProcessParam;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoGridForm;
import com.oryx.core.layout.AbstractCrudFormLayout;
import com.oryx.core.module.IModule;
import com.oryx.remote.webservice.element.model.system.ose.XmlFieldProcessParam;

@AssoEntity(classType = XmlFieldProcessParam.class)
@AssoGridForm(classType = FieldProcessParamGridForm.class)
public class FieldProcessParamForm extends AbstractCrudFormLayout<XmlFieldProcessParam> {

    public FieldProcessParamForm(IModule module) {
        super(module);
    }
}
