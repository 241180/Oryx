package com.oryx.core.gui.crud.system.ose.user;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.system.ose.UserConstantsBundle;
import com.oryx.core.delegate.IDelegate;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.layout.grid.AbstractGrid;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.system.ose.UserTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.system.ose.XmlUser;
import com.vaadin.ui.Window;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = UserConstantsBundle.class)
@AssoEntity(classType = XmlUser.class)
@AssoTypeByTokenProvider(classType = UserTypeByTokenProvider.class)
public class UserGridForm extends AbstractGrid<XmlUser> {

    public UserGridForm(IDelegate service, IModule module) {
        super(service, module);

    }

    @Override
    public Window getEditorWindow(IModule module, XmlUser bean, AbstractEditor.SaveHandler saveHandler) {
        return UserEditorForm.newInstance(module, bean, saveHandler).getWindow();
    }
}