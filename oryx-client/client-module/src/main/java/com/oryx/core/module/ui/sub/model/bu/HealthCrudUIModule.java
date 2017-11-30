package com.oryx.core.module.ui.sub.model.bu;

import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.CrudUIConstantsBundle;
import com.oryx.core.gui.crud.bu.health.healthCheck.HealthCheckForm;
import com.oryx.core.gui.crud.bu.health.patient.PatientForm;
import com.oryx.core.gui.crud.bu.health.rdv.RdvForm;
import com.oryx.core.module.AbstractLayoutModule;
import com.oryx.core.module.ILayoutModule;
import com.oryx.remote.webservice.element.model.bu.health.XmlHealthCheck;
import com.oryx.remote.webservice.element.model.bu.health.XmlPatient;
import com.oryx.remote.webservice.element.model.bu.health.XmlRdv;

/**
 * Created by SAMI on 13/03/2017.
 */

@Bundle(classType = CrudUIConstantsBundle.class)
public class HealthCrudUIModule extends AbstractLayoutModule {

    @Override
    public ILayoutModule configure() {
        this.bindFormLayout(XmlRdv.class, RdvForm.class);
        this.bindFormLayout(XmlHealthCheck.class, HealthCheckForm.class);
        this.bindFormLayout(XmlPatient.class, PatientForm.class);
        return this;
    }
}
