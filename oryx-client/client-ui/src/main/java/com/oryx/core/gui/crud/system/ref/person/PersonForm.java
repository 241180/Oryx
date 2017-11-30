package com.oryx.core.gui.crud.system.ref.person;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoGridForm;
import com.oryx.core.layout.AbstractCrudFormLayout;
import com.oryx.core.module.IModule;
import com.oryx.remote.webservice.element.model.system.ref.XmlPerson;

@AssoEntity(classType = XmlPerson.class)
@AssoGridForm(classType = PersonGridForm.class)
public class PersonForm extends AbstractCrudFormLayout<XmlPerson> {

    public PersonForm(IModule module) {
        super(module);
    }
}
