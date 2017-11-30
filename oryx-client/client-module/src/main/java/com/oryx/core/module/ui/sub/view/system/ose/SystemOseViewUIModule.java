package com.oryx.core.module.ui.sub.view.system.ose;

import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.ViewConstantsBundle;
import com.oryx.core.gui.report.testReport;
import com.oryx.core.gui.view.patientView.PatientViewForm;
import com.oryx.core.gui.view.userView.UserViewForm;
import com.oryx.core.module.AbstractLayoutModule;
import com.oryx.core.module.ILayoutModule;
import com.oryx.remote.webservice.element.view.bu.health.XmlPatientView;
import com.oryx.remote.webservice.element.view.system.ose.XmlUserView;

import java.util.Date;

/**
 * Created by SAMI on 13/03/2017.
 */

@Bundle(classType = ViewConstantsBundle.class)
public class SystemOseViewUIModule extends AbstractLayoutModule {

    @Override
    public ILayoutModule configure() {
        this.bindFormLayout(XmlUserView.class, UserViewForm.class);
        this.bindFormLayout(XmlPatientView.class, PatientViewForm.class);
        this.bindFormLayout(Date.class, testReport.class);

        return this;
    }
}
