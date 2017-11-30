package com.oryx.core.gui.crud.system.ose.menu;

import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.system.ose.MenuConstantsBundle;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.system.ose.MenuTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.system.ose.XmlMenu;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = MenuConstantsBundle.class)
@AssoTypeByTokenProvider(classType = MenuTypeByTokenProvider.class)
public class MenuEditorForm extends AbstractEditor<XmlMenu> {

    public MenuEditorForm(IModule module, XmlMenu menu, SaveHandler saveHandler) {
        super(menu, saveHandler, module);
    }

    public static MenuEditorForm newInstance(IModule module, XmlMenu menu, SaveHandler saveHandler) {
        return new MenuEditorForm(module, menu, saveHandler);
    }
}