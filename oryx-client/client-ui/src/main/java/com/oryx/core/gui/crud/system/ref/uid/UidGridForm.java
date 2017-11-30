package com.oryx.core.gui.crud.system.ref.uid;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.system.ref.UidConstantsBundle;
import com.oryx.core.delegate.IDelegate;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.layout.grid.AbstractGrid;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.system.ref.UidTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.system.ref.XmlUid;
import com.vaadin.ui.Window;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = UidConstantsBundle.class)
@AssoEntity(classType = XmlUid.class)
@AssoTypeByTokenProvider(classType = UidTypeByTokenProvider.class)
public class UidGridForm extends AbstractGrid<XmlUid> {

    public UidGridForm(IDelegate service, IModule module) {
        super(service, module);

    }

    @Override
    public Window getEditorWindow(IModule module, XmlUid bean, AbstractEditor.SaveHandler saveHandler) {
        return UidEditorForm.newInstance(module, bean, saveHandler).getWindow();
    }
}