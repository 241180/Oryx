package com.oryx.core.gui.crud.system.ose.menu;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.system.ose.MenuConstantsBundle;
import com.oryx.core.delegate.IDelegate;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.layout.grid.AbstractGrid;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.system.ose.MenuTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.system.ose.XmlMenu;
import com.vaadin.ui.Window;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = MenuConstantsBundle.class)
@AssoEntity(classType = XmlMenu.class)
@AssoTypeByTokenProvider(classType = MenuTypeByTokenProvider.class)
public class MenuGridForm extends AbstractGrid<XmlMenu> {

    public MenuGridForm(IDelegate service, IModule module) {
        super(service, module);

    }

    @Override
    public Window getEditorWindow(IModule module, XmlMenu bean, AbstractEditor.SaveHandler saveHandler) {
        return MenuEditorForm.newInstance(module, bean, saveHandler).getWindow();
    }
}