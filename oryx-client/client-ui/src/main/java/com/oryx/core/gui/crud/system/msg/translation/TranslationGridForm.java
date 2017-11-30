package com.oryx.core.gui.crud.system.msg.translation;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.system.msg.TranslationConstantsBundle;
import com.oryx.core.delegate.IDelegate;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.layout.grid.AbstractGrid;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.system.msg.TranslationTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.system.msg.XmlTranslation;
import com.vaadin.ui.Window;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = TranslationConstantsBundle.class)
@AssoEntity(classType = XmlTranslation.class)
@AssoTypeByTokenProvider(classType = TranslationTypeByTokenProvider.class)
public class TranslationGridForm extends AbstractGrid<XmlTranslation> {

    public TranslationGridForm(IDelegate service, IModule module) {
        super(service, module);

    }

    @Override
    public Window getEditorWindow(IModule module, XmlTranslation bean, AbstractEditor.SaveHandler saveHandler) {
        return TranslationEditorForm.newInstance(module, bean, saveHandler).getWindow();
    }
}