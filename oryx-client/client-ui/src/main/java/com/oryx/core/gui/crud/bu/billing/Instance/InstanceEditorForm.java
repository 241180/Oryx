package com.oryx.core.gui.crud.bu.billing.Instance;

import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.bu.billing.InstanceConstantsBundle;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.bu.billing.InstanceTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.bu.billing.XmlInstance;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = InstanceConstantsBundle.class)
@AssoTypeByTokenProvider(classType = InstanceTypeByTokenProvider.class)
public class InstanceEditorForm extends AbstractEditor<XmlInstance> {

    public InstanceEditorForm(IModule module, XmlInstance instance, SaveHandler saveHandler) {
        super(instance, saveHandler, module);
    }

    public static InstanceEditorForm newInstance(IModule module, XmlInstance instance, SaveHandler saveHandler) {
        return new InstanceEditorForm(module, instance, saveHandler);
    }
}