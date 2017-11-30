package com.oryx.core.gui.crud.system.ref.person;

import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.system.ref.PersonConstantsBundle;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.system.ref.PersonTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.system.ref.XmlPerson;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = PersonConstantsBundle.class)
@AssoTypeByTokenProvider(classType = PersonTypeByTokenProvider.class)
public class PersonEditorForm extends AbstractEditor<XmlPerson> {

    public PersonEditorForm(IModule module, XmlPerson person, SaveHandler saveHandler) {
        super(person, saveHandler, module);
    }

    public static PersonEditorForm newInstance(IModule module, XmlPerson person, SaveHandler saveHandler) {
        return new PersonEditorForm(module, person, saveHandler);
    }
}