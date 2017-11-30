package com.oryx.core.gui.crud.system.ose.parameter;

import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.system.ose.ParameterConstantsBundle;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.system.ose.ParameterTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.system.ose.XmlParameter;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = ParameterConstantsBundle.class)
@AssoTypeByTokenProvider(classType = ParameterTypeByTokenProvider.class)
public class ParameterEditorForm extends AbstractEditor<XmlParameter> {

    public ParameterEditorForm(IModule module, XmlParameter parameter, SaveHandler saveHandler) {
        super(parameter, saveHandler, module);
    }

    public static ParameterEditorForm newInstance(IModule module, XmlParameter parameter, SaveHandler saveHandler) {
        return new ParameterEditorForm(module, parameter, saveHandler);
    }
}