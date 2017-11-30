package com.oryx.core.gui.crud.system.msg.translation;

import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.system.msg.TranslationConstantsBundle;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.system.msg.TranslationTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.system.msg.XmlTranslation;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = TranslationConstantsBundle.class)
@AssoTypeByTokenProvider(classType = TranslationTypeByTokenProvider.class)
public class TranslationEditorForm extends AbstractEditor<XmlTranslation> {

    public TranslationEditorForm(IModule module, XmlTranslation translation, SaveHandler saveHandler) {
        super(translation, saveHandler, module);
    }

    public static TranslationEditorForm newInstance(IModule module, XmlTranslation translation, SaveHandler saveHandler) {
        return new TranslationEditorForm(module, translation, saveHandler);
    }
}