package com.oryx.core.gui.crud.system.ref.contact;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.system.ref.ContactConstantsBundle;
import com.oryx.core.delegate.IDelegate;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.layout.grid.AbstractGrid;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.system.ref.ContactTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.system.ref.XmlContact;
import com.vaadin.ui.Window;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = ContactConstantsBundle.class)
@AssoEntity(classType = XmlContact.class)
@AssoTypeByTokenProvider(classType = ContactTypeByTokenProvider.class)
public class ContactGridForm extends AbstractGrid<XmlContact> {

    public ContactGridForm(IDelegate service, IModule module) {
        super(service, module);

    }

    @Override
    public Window getEditorWindow(IModule module, XmlContact bean, AbstractEditor.SaveHandler saveHandler) {
        return ContactEditorForm.newInstance(module, bean, saveHandler).getWindow();
    }
}