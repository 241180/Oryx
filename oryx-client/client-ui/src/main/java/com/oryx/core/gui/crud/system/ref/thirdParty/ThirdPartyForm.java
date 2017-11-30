package com.oryx.core.gui.crud.system.ref.thirdParty;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoGridForm;
import com.oryx.core.layout.AbstractCrudFormLayout;
import com.oryx.core.module.IModule;
import com.oryx.remote.webservice.element.model.system.ref.XmlThirdParty;

@AssoEntity(classType = XmlThirdParty.class)
@AssoGridForm(classType = ThirdPartyGridForm.class)
public class ThirdPartyForm extends AbstractCrudFormLayout<XmlThirdParty> {

    public ThirdPartyForm(IModule module) {
        super(module);
    }
}
