package com.oryx.core.gui.crud.system.ose.codification;

import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.system.ose.CodificationConstantsBundle;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.system.ose.CodificationTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.system.ose.XmlCodification;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = CodificationConstantsBundle.class)
@AssoTypeByTokenProvider(classType = CodificationTypeByTokenProvider.class)
public class CodificationEditorForm extends AbstractEditor<XmlCodification> {

    public CodificationEditorForm(IModule module, XmlCodification codification, SaveHandler saveHandler) {
        super(codification, saveHandler, module);
    }

    public static CodificationEditorForm newInstance(IModule module, XmlCodification codification, SaveHandler saveHandler) {
        return new CodificationEditorForm(module, codification, saveHandler);
    }
}