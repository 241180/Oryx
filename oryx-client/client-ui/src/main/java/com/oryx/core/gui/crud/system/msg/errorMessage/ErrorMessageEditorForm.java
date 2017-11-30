package com.oryx.core.gui.crud.system.msg.errorMessage;

import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.system.msg.ErrorMessageConstantsBundle;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.system.msg.ErrorMessageTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.system.msg.XmlErrorMessage;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = ErrorMessageConstantsBundle.class)
@AssoTypeByTokenProvider(classType = ErrorMessageTypeByTokenProvider.class)
public class ErrorMessageEditorForm extends AbstractEditor<XmlErrorMessage> {

    public ErrorMessageEditorForm(IModule module, XmlErrorMessage errorMessage, SaveHandler saveHandler) {
        super(errorMessage, saveHandler, module);
    }

    public static ErrorMessageEditorForm newInstance(IModule module, XmlErrorMessage errorMessage, SaveHandler saveHandler) {
        return new ErrorMessageEditorForm(module, errorMessage, saveHandler);
    }
}