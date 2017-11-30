package com.oryx.core.gui.crud.system.ref.contact;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoGridForm;
import com.oryx.core.layout.AbstractCrudFormLayout;
import com.oryx.core.module.IModule;
import com.oryx.remote.webservice.element.model.system.ref.XmlContact;

@AssoEntity(classType = XmlContact.class)
@AssoGridForm(classType = ContactGridForm.class)
public class ContactForm extends AbstractCrudFormLayout<XmlContact> {

    public ContactForm(IModule module) {
        super(module);
    }
}
