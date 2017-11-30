package com.oryx.core.gui.crud.bu.health.rdv;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.bu.health.RdvConstantsBundle;
import com.oryx.core.delegate.IDelegate;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.layout.grid.AbstractGrid;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.bu.health.RdvTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.bu.health.XmlRdv;
import com.vaadin.ui.Window;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = RdvConstantsBundle.class)
@AssoEntity(classType = XmlRdv.class)
@AssoTypeByTokenProvider(classType = RdvTypeByTokenProvider.class)
public class RdvGridForm extends AbstractGrid<XmlRdv> {

    public RdvGridForm(IDelegate service, IModule module) {
        super(service, module);
    }

    @Override
    public Window getEditorWindow(IModule module, XmlRdv bean, AbstractEditor.SaveHandler saveHandler) {
        return RdvEditorForm.newInstance(module, bean, saveHandler).getWindow();
    }
}