package com.oryx.core.gui.crud.bu.billing.Instance;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.bu.billing.InstanceConstantsBundle;
import com.oryx.core.delegate.IDelegate;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.layout.grid.AbstractGrid;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.bu.billing.InstanceTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.bu.billing.XmlInstance;
import com.vaadin.ui.Window;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = InstanceConstantsBundle.class)
@AssoEntity(classType = XmlInstance.class)
@AssoTypeByTokenProvider(classType = InstanceTypeByTokenProvider.class)
public class InstanceGridForm extends AbstractGrid<XmlInstance> {

    public InstanceGridForm(IDelegate service, IModule module) {
        super(service, module);
    }

    @Override
    public Window getEditorWindow(IModule module, XmlInstance bean, AbstractEditor.SaveHandler saveHandler) {
        return InstanceEditorForm.newInstance(module, bean, saveHandler).getWindow();
    }
}