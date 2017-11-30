package com.oryx.core.gui.crud.system.msg.translation;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoGridForm;
import com.oryx.core.layout.AbstractCrudFormLayout;
import com.oryx.core.module.IModule;
import com.oryx.remote.webservice.element.model.system.msg.XmlTranslation;

@AssoEntity(classType = XmlTranslation.class)
@AssoGridForm(classType = TranslationGridForm.class)
public class TranslationForm extends AbstractCrudFormLayout<XmlTranslation> {

    public TranslationForm(IModule module) {
        super(module);
    }

}
