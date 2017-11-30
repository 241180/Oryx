package com.oryx.core.gui.crud.system.ose.annex;

import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.system.ose.AnnexConstantsBundle;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.system.ose.AnnexTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.system.ose.XmlAnnex;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = AnnexConstantsBundle.class)
@AssoTypeByTokenProvider(classType = AnnexTypeByTokenProvider.class)
public class AnnexEditorForm extends AbstractEditor<XmlAnnex> {

    public AnnexEditorForm(IModule module, XmlAnnex annex, SaveHandler saveHandler) {
        super(annex, saveHandler, module);
    }

    public static AnnexEditorForm newInstance(IModule module, XmlAnnex annex, SaveHandler saveHandler) {
        return new AnnexEditorForm(module, annex, saveHandler);
    }
}