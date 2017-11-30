package com.oryx.core.gui.crud.system.ose.menu;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoGridForm;
import com.oryx.core.layout.AbstractCrudFormLayout;
import com.oryx.core.module.IModule;
import com.oryx.remote.webservice.element.model.system.ose.XmlMenu;

@AssoEntity(classType = XmlMenu.class)
@AssoGridForm(classType = MenuGridForm.class)
public class MenuForm extends AbstractCrudFormLayout<XmlMenu> {

    public MenuForm(IModule module) {
        super(module);
    }

}
