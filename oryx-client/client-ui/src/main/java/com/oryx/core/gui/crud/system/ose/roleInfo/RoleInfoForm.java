package com.oryx.core.gui.crud.system.ose.roleInfo;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoGridForm;
import com.oryx.core.layout.AbstractCrudFormLayout;
import com.oryx.core.module.IModule;
import com.oryx.remote.webservice.element.model.system.ose.XmlRoleInfo;

@AssoEntity(classType = XmlRoleInfo.class)
@AssoGridForm(classType = RoleInfoGridForm.class)
public class RoleInfoForm extends AbstractCrudFormLayout<XmlRoleInfo> {

    public RoleInfoForm(IModule module) {
        super(module);
    }
}
