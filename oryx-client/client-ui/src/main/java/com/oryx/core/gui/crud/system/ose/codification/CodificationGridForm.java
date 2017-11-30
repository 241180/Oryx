package com.oryx.core.gui.crud.system.ose.codification;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.system.ose.CodificationConstantsBundle;
import com.oryx.core.delegate.IDelegate;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.layout.grid.AbstractGrid;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.system.ose.CodificationTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.system.ose.XmlCodification;
import com.vaadin.ui.Window;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = CodificationConstantsBundle.class)
@AssoEntity(classType = XmlCodification.class)
@AssoTypeByTokenProvider(classType = CodificationTypeByTokenProvider.class)
public class CodificationGridForm extends AbstractGrid<XmlCodification> {

    public CodificationGridForm(IDelegate service, IModule module) {
        super(service, module);

    }

    @Override
    public Window getEditorWindow(IModule module, XmlCodification bean, AbstractEditor.SaveHandler saveHandler) {
        return CodificationEditorForm.newInstance(module, bean, saveHandler).getWindow();
    }
}