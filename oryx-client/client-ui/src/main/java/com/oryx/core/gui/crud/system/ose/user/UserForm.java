package com.oryx.core.gui.crud.system.ose.user;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoGridForm;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.layout.AbstractCrudFormLayout;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.system.ose.UserTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.system.ose.XmlUser;

@AssoEntity(classType = XmlUser.class)
@AssoGridForm(classType = UserGridForm.class)
@AssoTypeByTokenProvider(classType = UserTypeByTokenProvider.class)
public class UserForm extends AbstractCrudFormLayout<XmlUser> {

    public UserForm(IModule module) {
        super(module);
    }
}
