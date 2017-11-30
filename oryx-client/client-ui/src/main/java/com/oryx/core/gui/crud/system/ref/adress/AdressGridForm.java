package com.oryx.core.gui.crud.system.ref.adress;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.system.ref.AdressConstantsBundle;
import com.oryx.core.delegate.IDelegate;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.layout.grid.AbstractGrid;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.system.ref.AdressTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.system.ref.XmlAdress;
import com.vaadin.ui.Window;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = AdressConstantsBundle.class)
@AssoEntity(classType = XmlAdress.class)
@AssoTypeByTokenProvider(classType = AdressTypeByTokenProvider.class)
public class AdressGridForm extends AbstractGrid<XmlAdress> {

    public AdressGridForm(IDelegate service, IModule module) {
        super(service, module);
    }

    @Override
    public Window getEditorWindow(IModule module, XmlAdress bean, AbstractEditor.SaveHandler saveHandler) {
        return AdressEditorForm.newInstance(module, bean, saveHandler).getWindow();
    }
}