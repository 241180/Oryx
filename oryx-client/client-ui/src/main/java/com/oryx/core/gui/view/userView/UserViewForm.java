package com.oryx.core.gui.view.userView;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoGridForm;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.layout.AbstractCrudFormLayout;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.view.system.ose.UserViewTypeByTokenProvider;
import com.oryx.remote.webservice.element.view.system.ose.XmlUserView;

@AssoEntity(classType = XmlUserView.class)
@AssoGridForm(classType = UserViewGridForm.class)
@AssoTypeByTokenProvider(classType = UserViewTypeByTokenProvider.class)
public class UserViewForm extends AbstractCrudFormLayout<XmlUserView> {

    public UserViewForm(IModule module) {
        super(module);
    }
}
