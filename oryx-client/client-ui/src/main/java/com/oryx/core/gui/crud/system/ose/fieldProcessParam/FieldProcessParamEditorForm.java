package com.oryx.core.gui.crud.system.ose.fieldProcessParam;

import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.system.ose.FieldProcessParamConstantsBundle;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.system.ose.FieldProcessParamTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.system.ose.XmlFieldProcessParam;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = FieldProcessParamConstantsBundle.class)
@AssoTypeByTokenProvider(classType = FieldProcessParamTypeByTokenProvider.class)
public class FieldProcessParamEditorForm extends AbstractEditor<XmlFieldProcessParam> {

    public FieldProcessParamEditorForm(IModule module, XmlFieldProcessParam fieldProcessParam, SaveHandler saveHandler) {
        super(fieldProcessParam, saveHandler, module);
    }

    public static FieldProcessParamEditorForm newInstance(IModule module, XmlFieldProcessParam fieldProcessParam, SaveHandler saveHandler) {
        return new FieldProcessParamEditorForm(module, fieldProcessParam, saveHandler);
    }
}