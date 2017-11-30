package com.oryx.core.gui.crud.system.ose.roleInfo;

import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.system.ose.RoleInfoConstantsBundle;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.system.ose.RoleInfoTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.system.ose.XmlRoleInfo;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = RoleInfoConstantsBundle.class)
@AssoTypeByTokenProvider(classType = RoleInfoTypeByTokenProvider.class)
public class RoleInfoEditorForm extends AbstractEditor<XmlRoleInfo> {

    public RoleInfoEditorForm(IModule module, XmlRoleInfo roleInfo, SaveHandler saveHandler) {
        super(roleInfo, saveHandler, module);
    }

    public static RoleInfoEditorForm newInstance(IModule module, XmlRoleInfo roleInfo, SaveHandler saveHandler) {
        return new RoleInfoEditorForm(module, roleInfo, saveHandler);
    }
}