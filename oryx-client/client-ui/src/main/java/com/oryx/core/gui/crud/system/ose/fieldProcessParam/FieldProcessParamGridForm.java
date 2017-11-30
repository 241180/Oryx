package com.oryx.core.gui.crud.system.ose.fieldProcessParam;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.system.ose.FieldProcessParamConstantsBundle;
import com.oryx.core.delegate.IDelegate;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.layout.grid.AbstractGrid;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.system.ose.FieldProcessParamTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.system.ose.XmlFieldProcessParam;
import com.vaadin.ui.Window;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = FieldProcessParamConstantsBundle.class)
@AssoEntity(classType = XmlFieldProcessParam.class)
@AssoTypeByTokenProvider(classType = FieldProcessParamTypeByTokenProvider.class)
public class FieldProcessParamGridForm extends AbstractGrid<XmlFieldProcessParam> {

    public FieldProcessParamGridForm(IDelegate service, IModule module) {
        super(service, module);

    }

    @Override
    public Window getEditorWindow(IModule module, XmlFieldProcessParam bean, AbstractEditor.SaveHandler saveHandler) {
        return FieldProcessParamEditorForm.newInstance(module, bean, saveHandler).getWindow();
    }
}