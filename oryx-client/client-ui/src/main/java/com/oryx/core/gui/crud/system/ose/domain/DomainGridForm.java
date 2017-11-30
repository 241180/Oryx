package com.oryx.core.gui.crud.system.ose.domain;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.system.ose.DomainConstantsBundle;
import com.oryx.core.delegate.IDelegate;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.layout.grid.AbstractGrid;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.system.ose.DomainTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.system.ose.XmlDomain;
import com.vaadin.ui.Window;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = DomainConstantsBundle.class)
@AssoEntity(classType = XmlDomain.class)
@AssoTypeByTokenProvider(classType = DomainTypeByTokenProvider.class)
public class DomainGridForm extends AbstractGrid<XmlDomain> {

    public DomainGridForm(IDelegate service, IModule module) {
        super(service, module);

    }

    @Override
    public Window getEditorWindow(IModule module, XmlDomain bean, AbstractEditor.SaveHandler saveHandler) {
        return DomainEditorForm.newInstance(module, bean, saveHandler).getWindow();
    }
}