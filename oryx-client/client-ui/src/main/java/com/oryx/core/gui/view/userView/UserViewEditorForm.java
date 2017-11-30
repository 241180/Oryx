package com.oryx.core.gui.view.userView;

import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.annotation.decl.Custom;
import com.oryx.core.annotation.decl.Tree;
import com.oryx.core.bundle.system.ref.UserViewConstantsBundle;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.view.system.ose.UserViewTypeByTokenProvider;
import com.oryx.remote.webservice.element.view.system.ose.XmlUserView;

/**
 * Created by 241180 on 04/01/2017.
 */
@Custom(html = "xmluserview")
@Tree(depth = 1)
@Bundle(classType = UserViewConstantsBundle.class)
@AssoTypeByTokenProvider(classType = UserViewTypeByTokenProvider.class)
public class UserViewEditorForm extends AbstractEditor<XmlUserView> {

    public UserViewEditorForm(IModule module, XmlUserView userView, SaveHandler saveHandler) {
        super(userView, saveHandler, module);
    }

    public static UserViewEditorForm newInstance(IModule module, XmlUserView userView, SaveHandler saveHandler) {
        return new UserViewEditorForm(module, userView, saveHandler);
    }
}