package com.oryx.core.gui.crud.system.ref.adress;

import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.system.ref.AdressConstantsBundle;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.system.ref.AdressTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.system.ref.XmlAdress;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = AdressConstantsBundle.class)
@AssoTypeByTokenProvider(classType = AdressTypeByTokenProvider.class)
public class AdressEditorForm extends AbstractEditor<XmlAdress> {

    public AdressEditorForm(IModule module, XmlAdress adress, SaveHandler saveHandler) {
        super(adress, saveHandler, module);
    }

    public static AdressEditorForm newInstance(IModule module, XmlAdress adress, SaveHandler saveHandler) {
        return new AdressEditorForm(module, adress, saveHandler);
    }
}