package com.oryx.core.gui.view.patientView;

import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.annotation.decl.Custom;
import com.oryx.core.annotation.decl.Tree;
import com.oryx.core.bundle.bu.health.PatientViewConstantsBundle;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.view.bu.health.PatientViewTypeByTokenProvider;
import com.oryx.remote.webservice.element.view.bu.health.XmlPatientView;

/**
 * Created by 241180 on 04/01/2017.
 */
@Custom(html = "xmlpatientview")
@Tree(depth = 1)
@Bundle(classType = PatientViewConstantsBundle.class)
@AssoTypeByTokenProvider(classType = PatientViewTypeByTokenProvider.class)
public class PatientViewEditorForm extends AbstractEditor<XmlPatientView> {

    public PatientViewEditorForm(IModule module, XmlPatientView patientView, SaveHandler saveHandler) {
        super(patientView, saveHandler, module);
    }

    public static PatientViewEditorForm newInstance(IModule module, XmlPatientView patientView, SaveHandler saveHandler) {
        return new PatientViewEditorForm(module, patientView, saveHandler);
    }
}