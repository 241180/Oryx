package com.oryx.core.gui.view.patientView;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoGridForm;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.layout.AbstractCrudFormLayout;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.view.bu.health.PatientViewTypeByTokenProvider;
import com.oryx.remote.webservice.element.view.bu.health.XmlPatientView;

@AssoEntity(classType = XmlPatientView.class)
@AssoGridForm(classType = PatientViewGridForm.class)
@AssoTypeByTokenProvider(classType = PatientViewTypeByTokenProvider.class)
public class PatientViewForm extends AbstractCrudFormLayout<XmlPatientView> {

    public PatientViewForm(IModule module) {
        super(module);
    }
}
