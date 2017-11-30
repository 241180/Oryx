package com.oryx.core.gui.crud.bu.health.rdv;

import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.bu.health.RdvConstantsBundle;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.bu.health.RdvTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.bu.health.XmlRdv;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = RdvConstantsBundle.class)
@AssoTypeByTokenProvider(classType = RdvTypeByTokenProvider.class)
public class RdvEditorForm extends AbstractEditor<XmlRdv> {

    public RdvEditorForm(IModule module, XmlRdv rdv, SaveHandler saveHandler) {
        super(rdv, saveHandler, module);
    }

    public static RdvEditorForm newInstance(IModule module, XmlRdv rdv, SaveHandler saveHandler) {
        return new RdvEditorForm(module, rdv, saveHandler);
    }
}