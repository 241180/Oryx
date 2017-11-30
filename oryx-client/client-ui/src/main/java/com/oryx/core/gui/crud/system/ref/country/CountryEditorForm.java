package com.oryx.core.gui.crud.system.ref.country;

import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.system.ref.CountryConstantsBundle;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.system.ref.CountryTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.system.ref.XmlCountry;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = CountryConstantsBundle.class)
@AssoTypeByTokenProvider(classType = CountryTypeByTokenProvider.class)
public class CountryEditorForm extends AbstractEditor<XmlCountry> {

    public CountryEditorForm(IModule module, XmlCountry country, SaveHandler saveHandler) {
        super(country, saveHandler, module);
    }

    public static CountryEditorForm newInstance(IModule module, XmlCountry country, SaveHandler saveHandler) {
        return new CountryEditorForm(module, country, saveHandler);
    }
}