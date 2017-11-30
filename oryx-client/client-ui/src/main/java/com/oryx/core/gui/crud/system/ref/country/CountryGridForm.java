package com.oryx.core.gui.crud.system.ref.country;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.system.ref.CountryConstantsBundle;
import com.oryx.core.delegate.IDelegate;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.layout.grid.AbstractGrid;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.system.ref.CountryTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.system.ref.XmlCountry;
import com.vaadin.ui.Window;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = CountryConstantsBundle.class)
@AssoEntity(classType = XmlCountry.class)
@AssoTypeByTokenProvider(classType = CountryTypeByTokenProvider.class)
public class CountryGridForm extends AbstractGrid<XmlCountry> {

    public CountryGridForm(IDelegate service, IModule module) {
        super(service, module);

    }

    @Override
    public Window getEditorWindow(IModule module, XmlCountry bean, AbstractEditor.SaveHandler saveHandler) {
        return CountryEditorForm.newInstance(module, bean, saveHandler).getWindow();
    }
}