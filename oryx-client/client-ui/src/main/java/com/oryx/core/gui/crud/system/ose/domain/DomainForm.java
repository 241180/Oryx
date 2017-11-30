package com.oryx.core.gui.crud.system.ose.domain;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoGridForm;
import com.oryx.core.layout.AbstractCrudFormLayout;
import com.oryx.core.module.IModule;
import com.oryx.remote.webservice.element.model.system.ose.XmlDomain;

@AssoEntity(classType = XmlDomain.class)
@AssoGridForm(classType = DomainGridForm.class)
public class DomainForm extends AbstractCrudFormLayout<XmlDomain> {

    public DomainForm(IModule module) {
        super(module);
    }
}
