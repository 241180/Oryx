package com.oryx.core.gui.view.patientView;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.annotation.decl.Principal;
import com.oryx.core.bundle.bu.health.PatientViewConstantsBundle;
import com.oryx.core.delegate.IDelegate;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.layout.grid.AbstractGrid;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.view.bu.health.PatientViewTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.bu.health.XmlPatient;
import com.oryx.remote.webservice.element.view.bu.health.XmlPatientView;
import com.vaadin.ui.Window;

/**
 * Created by 241180 on 04/01/2017.
 */
@Principal(classType = XmlPatient.class)
@Bundle(classType = PatientViewConstantsBundle.class)
@AssoEntity(classType = XmlPatientView.class)
@AssoTypeByTokenProvider(classType = PatientViewTypeByTokenProvider.class)
public class PatientViewGridForm extends AbstractGrid<XmlPatientView> {

    public PatientViewGridForm(IDelegate service, IModule module) {
        super(service, module);

    }

    @Override
    public Window getEditorWindow(IModule module, XmlPatientView bean, AbstractEditor.SaveHandler saveHandler) {
        return PatientViewEditorForm.newInstance(module, bean, saveHandler).getWindow();
    }
}