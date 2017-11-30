package com.oryx.core.gui.crud.bu.health.rdv;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoGridForm;
import com.oryx.core.layout.AbstractCrudFormLayout;
import com.oryx.core.module.IModule;
import com.oryx.remote.webservice.element.model.bu.health.XmlRdv;

@AssoEntity(classType = XmlRdv.class)
@AssoGridForm(classType = RdvGridForm.class)
public class RdvForm extends AbstractCrudFormLayout<XmlRdv> {

    public RdvForm(IModule module) {
        super(module);
    }
}
