package com.oryx.core.gui.crud.system.ose.upgrades;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoGridForm;
import com.oryx.core.layout.AbstractCrudFormLayout;
import com.oryx.core.module.IModule;
import com.oryx.remote.webservice.element.model.system.ose.XmlUpgrades;

@AssoEntity(classType = XmlUpgrades.class)
@AssoGridForm(classType = UpgradesGridForm.class)
public class UpgradesForm extends AbstractCrudFormLayout<XmlUpgrades> {

    public UpgradesForm(IModule module) {
        super(module);
    }
}
