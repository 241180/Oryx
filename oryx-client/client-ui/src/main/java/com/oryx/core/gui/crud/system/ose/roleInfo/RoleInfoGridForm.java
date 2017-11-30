package com.oryx.core.gui.crud.system.ose.roleInfo;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.system.ose.RoleInfoConstantsBundle;
import com.oryx.core.delegate.IDelegate;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.layout.grid.AbstractGrid;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.system.ose.RoleInfoTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.system.ose.XmlRoleInfo;
import com.vaadin.ui.Window;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = RoleInfoConstantsBundle.class)
@AssoEntity(classType = XmlRoleInfo.class)
@AssoTypeByTokenProvider(classType = RoleInfoTypeByTokenProvider.class)
public class RoleInfoGridForm extends AbstractGrid<XmlRoleInfo> {

    public RoleInfoGridForm(IDelegate service, IModule module) {
        super(service, module);

    }

    @Override
    public Window getEditorWindow(IModule module, XmlRoleInfo bean, AbstractEditor.SaveHandler saveHandler) {
        return RoleInfoEditorForm.newInstance(module, bean, saveHandler).getWindow();
    }
}