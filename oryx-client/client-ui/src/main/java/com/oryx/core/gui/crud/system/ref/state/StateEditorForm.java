package com.oryx.core.gui.crud.system.ref.state;

import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.system.ref.StateConstantsBundle;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.system.ref.StateTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.system.ref.XmlState;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = StateConstantsBundle.class)
@AssoTypeByTokenProvider(classType = StateTypeByTokenProvider.class)
public class StateEditorForm extends AbstractEditor<XmlState> {

    public StateEditorForm(IModule module, XmlState state, SaveHandler saveHandler) {
        super(state, saveHandler, module);
    }

    public static StateEditorForm newInstance(IModule module, XmlState state, SaveHandler saveHandler) {
        return new StateEditorForm(module, state, saveHandler);
    }
}