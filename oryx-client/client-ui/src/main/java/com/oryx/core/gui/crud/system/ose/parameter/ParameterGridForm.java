package com.oryx.core.gui.crud.system.ose.parameter;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.system.ose.ParameterConstantsBundle;
import com.oryx.core.delegate.IDelegate;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.layout.grid.AbstractGrid;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.system.ose.ParameterTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.system.ose.XmlParameter;
import com.vaadin.ui.Window;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = ParameterConstantsBundle.class)
@AssoEntity(classType = XmlParameter.class)
@AssoTypeByTokenProvider(classType = ParameterTypeByTokenProvider.class)
public class ParameterGridForm extends AbstractGrid<XmlParameter> {

    public ParameterGridForm(IDelegate service, IModule module) {
        super(service, module);

    }

    @Override
    public Window getEditorWindow(IModule module, XmlParameter bean, AbstractEditor.SaveHandler saveHandler) {
        return ParameterEditorForm.newInstance(module, bean, saveHandler).getWindow();
    }
}