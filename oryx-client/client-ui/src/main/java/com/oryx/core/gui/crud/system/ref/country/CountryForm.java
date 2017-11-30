package com.oryx.core.gui.crud.system.ref.country;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoGridForm;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.layout.AbstractCrudFormLayout;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.system.ref.CountryTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.system.ref.XmlCountry;

@AssoEntity(classType = XmlCountry.class)
@AssoGridForm(classType = CountryGridForm.class)
@AssoTypeByTokenProvider(classType = CountryTypeByTokenProvider.class)
public class CountryForm extends AbstractCrudFormLayout<XmlCountry> {

    public CountryForm(IModule module) {
        super(module);
    }
}
