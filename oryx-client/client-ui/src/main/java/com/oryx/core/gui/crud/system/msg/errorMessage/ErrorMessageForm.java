package com.oryx.core.gui.crud.system.msg.errorMessage;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoGridForm;
import com.oryx.core.layout.AbstractCrudFormLayout;
import com.oryx.core.module.IModule;
import com.oryx.remote.webservice.element.model.system.msg.XmlErrorMessage;

@AssoEntity(classType = XmlErrorMessage.class)
@AssoGridForm(classType = ErrorMessageGridForm.class)
public class ErrorMessageForm extends AbstractCrudFormLayout<XmlErrorMessage> {

    public ErrorMessageForm(IModule module) {
        super(module);
    }
}
