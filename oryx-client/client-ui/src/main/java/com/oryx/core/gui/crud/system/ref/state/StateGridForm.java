package com.oryx.core.gui.crud.system.ref.state;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.system.ref.StateConstantsBundle;
import com.oryx.core.delegate.IDelegate;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.layout.grid.AbstractGrid;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.system.ref.StateTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.system.ref.XmlState;
import com.vaadin.ui.Window;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = StateConstantsBundle.class)
@AssoEntity(classType = XmlState.class)
@AssoTypeByTokenProvider(classType = StateTypeByTokenProvider.class)
public class StateGridForm extends AbstractGrid<XmlState> {

    public StateGridForm(IDelegate service, IModule module) {
        super(service, module);

    }

    @Override
    public Window getEditorWindow(IModule module, XmlState bean, AbstractEditor.SaveHandler saveHandler) {
        return StateEditorForm.newInstance(module, bean, saveHandler).getWindow();
    }
}