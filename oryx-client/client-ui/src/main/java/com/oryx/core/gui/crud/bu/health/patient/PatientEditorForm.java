package com.oryx.core.gui.crud.bu.health.patient;

import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.bu.health.PatientConstantsBundle;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.bu.health.PatientTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.bu.health.XmlPatient;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = PatientConstantsBundle.class)
@AssoTypeByTokenProvider(classType = PatientTypeByTokenProvider.class)
public class PatientEditorForm extends AbstractEditor<XmlPatient> {

    public PatientEditorForm(IModule module, XmlPatient patient, SaveHandler saveHandler) {
        super(patient, saveHandler, module);
    }

    public static PatientEditorForm newInstance(IModule module, XmlPatient patient, SaveHandler saveHandler) {
        return new PatientEditorForm(module, patient, saveHandler);
    }
}