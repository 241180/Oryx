package com.oryx.core.module.service.sub.model.bu;

import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.CrudServiceConstantsBundle;
import com.oryx.core.delegate.bu.health.HealthCheckServiceDelegate;
import com.oryx.core.delegate.bu.health.PatientServiceDelegate;
import com.oryx.core.delegate.bu.health.RdvServiceDelegate;
import com.oryx.core.module.AbstractServiceModule;
import com.oryx.core.module.IModule;
import com.oryx.remote.webservice.element._enum.HealthCheckServices;
import com.oryx.remote.webservice.element._enum.PatientServices;
import com.oryx.remote.webservice.element._enum.RdvServices;
import com.oryx.remote.webservice.element.model.bu.health.XmlHealthCheck;
import com.oryx.remote.webservice.element.model.bu.health.XmlPatient;
import com.oryx.remote.webservice.element.model.bu.health.XmlRdv;

/**
 * Created by SAMI on 13/03/2017.
 */

@Bundle(classType = CrudServiceConstantsBundle.class)
public class HealthCrudServiceModule extends AbstractServiceModule {

    @Override
    public IModule configure() {
        super.configure();
        this.bindService(XmlRdv.class, RdvServiceDelegate.class, RdvServices.class);
        this.bindService(XmlHealthCheck.class, HealthCheckServiceDelegate.class, HealthCheckServices.class);
        this.bindService(XmlPatient.class, PatientServiceDelegate.class, PatientServices.class);

        return this;
    }
}
