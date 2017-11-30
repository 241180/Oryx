package com.oryx.core.gui.crud.bu.health.patient;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoGridForm;
import com.oryx.core.layout.AbstractCrudFormLayout;
import com.oryx.core.module.IModule;
import com.oryx.remote.webservice.element.model.bu.health.XmlPatient;

@AssoEntity(classType = XmlPatient.class)
@AssoGridForm(classType = PatientGridForm.class)
public class PatientForm extends AbstractCrudFormLayout<XmlPatient> {

    public PatientForm(IModule module) {
        super(module);
    }
}
