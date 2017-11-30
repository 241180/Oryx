package com.oryx.core.module.service.sub.view.system.ose;

import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.ViewServiceConstantsBundle;
import com.oryx.core.delegate.bu.health.PatientViewServiceDelegate;
import com.oryx.core.delegate.system.ose.view.UserViewServiceDelegate;
import com.oryx.core.module.AbstractServiceModule;
import com.oryx.core.module.IModule;
import com.oryx.remote.webservice.element._enum.PatientViewServices;
import com.oryx.remote.webservice.element._enum.UserViewServices;
import com.oryx.remote.webservice.element.view.bu.health.XmlPatientView;
import com.oryx.remote.webservice.element.view.system.ose.XmlUserView;

/**
 * Created by SAMI on 13/03/2017.
 */

@Bundle(classType = ViewServiceConstantsBundle.class)
public class SystemOseViewServiceModule extends AbstractServiceModule {

    @Override
    public IModule configure() {
        super.configure();
        this.bindService(XmlUserView.class, UserViewServiceDelegate.class, UserViewServices.class);
        this.bindService(XmlPatientView.class, PatientViewServiceDelegate.class, PatientViewServices.class);

        return this;
    }
}
