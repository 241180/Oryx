package com.oryx.core.gui.crud.system.ose.codification;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoGridForm;
import com.oryx.core.layout.AbstractCrudFormLayout;
import com.oryx.core.module.IModule;
import com.oryx.remote.webservice.element.model.system.ose.XmlCodification;


@AssoEntity(classType = XmlCodification.class)
@AssoGridForm(classType = CodificationGridForm.class)
public class CodificationForm extends AbstractCrudFormLayout<XmlCodification> {

    public CodificationForm(IModule module) {
        super(module);
    }

}
