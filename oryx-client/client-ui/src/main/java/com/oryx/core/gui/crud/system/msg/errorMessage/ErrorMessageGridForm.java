package com.oryx.core.gui.crud.system.msg.errorMessage;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.system.msg.ErrorMessageConstantsBundle;
import com.oryx.core.delegate.IDelegate;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.layout.grid.AbstractGrid;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.system.msg.ErrorMessageTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.system.msg.XmlErrorMessage;
import com.vaadin.ui.Window;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = ErrorMessageConstantsBundle.class)
@AssoEntity(classType = XmlErrorMessage.class)
@AssoTypeByTokenProvider(classType = ErrorMessageTypeByTokenProvider.class)
public class ErrorMessageGridForm extends AbstractGrid<XmlErrorMessage> {

    public ErrorMessageGridForm(IDelegate service, IModule module) {
        super(service, module);

    }

    @Override
    public Window getEditorWindow(IModule module, XmlErrorMessage bean, AbstractEditor.SaveHandler saveHandler) {
        return ErrorMessageEditorForm.newInstance(module, bean, saveHandler).getWindow();
    }
}