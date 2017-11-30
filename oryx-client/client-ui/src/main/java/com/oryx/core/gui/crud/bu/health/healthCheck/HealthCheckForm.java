package com.oryx.core.gui.crud.bu.health.healthCheck;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoGridForm;
import com.oryx.core.layout.AbstractCrudFormLayout;
import com.oryx.core.module.IModule;
import com.oryx.remote.webservice.element.model.bu.health.XmlHealthCheck;

@AssoEntity(classType = XmlHealthCheck.class)
@AssoGridForm(classType = HealthCheckGridForm.class)
public class HealthCheckForm extends AbstractCrudFormLayout<XmlHealthCheck> {

    public HealthCheckForm(IModule module) {
        super(module);
    }
}
