package com.oryx.core.gui.crud.bu.health.healthCheck;

import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.bu.health.HealthCheckConstantsBundle;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.bu.health.HealthCheckTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.bu.health.XmlHealthCheck;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = HealthCheckConstantsBundle.class)
@AssoTypeByTokenProvider(classType = HealthCheckTypeByTokenProvider.class)
public class HealthCheckEditorForm extends AbstractEditor<XmlHealthCheck> {

    public HealthCheckEditorForm(IModule module, XmlHealthCheck healthcheck, SaveHandler saveHandler) {
        super(healthcheck, saveHandler, module);
    }

    public static HealthCheckEditorForm newInstance(IModule module, XmlHealthCheck healthcheck, SaveHandler saveHandler) {
        return new HealthCheckEditorForm(module, healthcheck, saveHandler);
    }
}