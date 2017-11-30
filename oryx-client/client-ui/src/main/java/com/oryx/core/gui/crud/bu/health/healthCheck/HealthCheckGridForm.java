package com.oryx.core.gui.crud.bu.health.healthCheck;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.bu.health.HealthCheckConstantsBundle;
import com.oryx.core.delegate.IDelegate;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.layout.grid.AbstractGrid;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.bu.health.HealthCheckTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.bu.health.XmlHealthCheck;
import com.vaadin.ui.Window;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = HealthCheckConstantsBundle.class)
@AssoEntity(classType = XmlHealthCheck.class)
@AssoTypeByTokenProvider(classType = HealthCheckTypeByTokenProvider.class)
public class HealthCheckGridForm extends AbstractGrid<XmlHealthCheck> {

    public HealthCheckGridForm(IDelegate service, IModule module) {
        super(service, module);
    }

    @Override
    public Window getEditorWindow(IModule module, XmlHealthCheck bean, AbstractEditor.SaveHandler saveHandler) {
        return HealthCheckEditorForm.newInstance(module, bean, saveHandler).getWindow();
    }
}