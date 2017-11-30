package com.oryx.core.gui.crud.system.ref.contact;

import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.system.ref.ContactConstantsBundle;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.system.ref.ContactTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.system.ref.XmlContact;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = ContactConstantsBundle.class)
@AssoTypeByTokenProvider(classType = ContactTypeByTokenProvider.class)
public class ContactEditorForm extends AbstractEditor<XmlContact> {

    public ContactEditorForm(IModule module, XmlContact contact, SaveHandler saveHandler) {
        super(contact, saveHandler, module);
    }

    public static ContactEditorForm newInstance(IModule module, XmlContact contact, SaveHandler saveHandler) {
        return new ContactEditorForm(module, contact, saveHandler);
    }
}