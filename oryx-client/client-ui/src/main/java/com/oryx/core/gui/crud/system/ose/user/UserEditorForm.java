package com.oryx.core.gui.crud.system.ose.user;

import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.system.ose.UserConstantsBundle;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.system.ose.UserTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.system.ose.XmlUser;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = UserConstantsBundle.class)
@AssoTypeByTokenProvider(classType = UserTypeByTokenProvider.class)
public class UserEditorForm extends AbstractEditor<XmlUser> {

    private static final String[] HIDDEN_FIELDS = {"lastConnection"};

    public UserEditorForm(IModule module, XmlUser user, SaveHandler saveHandler) {
        super(user, saveHandler, module);
    }

    public static UserEditorForm newInstance(IModule module, XmlUser user, SaveHandler saveHandler) {
        return new UserEditorForm(module, user, saveHandler);
    }
}