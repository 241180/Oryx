package com.oryx.core.gui.view.userView;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.annotation.decl.Principal;
import com.oryx.core.bundle.system.ref.UserViewConstantsBundle;
import com.oryx.core.delegate.IDelegate;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.layout.grid.AbstractGrid;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.view.system.ose.UserViewTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.system.ose.XmlUser;
import com.oryx.remote.webservice.element.view.system.ose.XmlUserView;
import com.vaadin.ui.Window;

/**
 * Created by 241180 on 04/01/2017.
 */
@Principal(classType = XmlUser.class)
@Bundle(classType = UserViewConstantsBundle.class)
@AssoEntity(classType = XmlUserView.class)
@AssoTypeByTokenProvider(classType = UserViewTypeByTokenProvider.class)
public class UserViewGridForm extends AbstractGrid<XmlUserView> {

    public UserViewGridForm(IDelegate service, IModule module) {
        super(service, module);

    }

    @Override
    public Window getEditorWindow(IModule module, XmlUserView bean, AbstractEditor.SaveHandler saveHandler) {
        return UserViewEditorForm.newInstance(module, bean, saveHandler).getWindow();
    }
}