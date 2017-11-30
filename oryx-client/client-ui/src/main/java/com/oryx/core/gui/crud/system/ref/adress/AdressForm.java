package com.oryx.core.gui.crud.system.ref.adress;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoGridForm;
import com.oryx.core.layout.AbstractCrudFormLayout;
import com.oryx.core.module.IModule;
import com.oryx.remote.webservice.element.model.system.ref.XmlAdress;

@AssoEntity(classType = XmlAdress.class)
@AssoGridForm(classType = AdressGridForm.class)
public class AdressForm extends AbstractCrudFormLayout<XmlAdress> {

    public AdressForm(IModule module) {
        super(module);
    }
}
