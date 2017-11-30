package com.oryx.core.gui.crud.system.ose.annex;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.system.ose.AnnexConstantsBundle;
import com.oryx.core.delegate.IDelegate;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.layout.grid.AbstractGrid;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.system.ose.AnnexTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.system.ose.XmlAnnex;
import com.vaadin.ui.Window;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = AnnexConstantsBundle.class)
@AssoEntity(classType = XmlAnnex.class)
@AssoTypeByTokenProvider(classType = AnnexTypeByTokenProvider.class)
public class AnnexGridForm extends AbstractGrid<XmlAnnex> {

    public AnnexGridForm(IDelegate service, IModule module) {
        super(service, module);

    }

    @Override
    public Window getEditorWindow(IModule module, XmlAnnex bean, AbstractEditor.SaveHandler saveHandler) {
        return AnnexEditorForm.newInstance(module, bean, saveHandler).getWindow();
    }
}