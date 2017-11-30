package com.oryx.core.gui.crud.bu.health.patient;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.bu.health.PatientConstantsBundle;
import com.oryx.core.delegate.IDelegate;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.layout.grid.AbstractGrid;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.bu.health.PatientTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.bu.health.XmlPatient;
import com.vaadin.ui.Window;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = PatientConstantsBundle.class)
@AssoEntity(classType = XmlPatient.class)
@AssoTypeByTokenProvider(classType = PatientTypeByTokenProvider.class)
public class PatientGridForm extends AbstractGrid<XmlPatient> {

    public PatientGridForm(IDelegate service, IModule module) {
        super(service, module);
    }

    @Override
    public Window getEditorWindow(IModule module, XmlPatient bean, AbstractEditor.SaveHandler saveHandler) {
        return PatientEditorForm.newInstance(module, bean, saveHandler).getWindow();
    }
}