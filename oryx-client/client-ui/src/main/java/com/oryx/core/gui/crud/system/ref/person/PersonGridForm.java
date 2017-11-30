package com.oryx.core.gui.crud.system.ref.person;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.system.ref.PersonConstantsBundle;
import com.oryx.core.delegate.IDelegate;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.layout.grid.AbstractGrid;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.system.ref.PersonTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.system.ref.XmlPerson;
import com.vaadin.ui.Window;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = PersonConstantsBundle.class)
@AssoEntity(classType = XmlPerson.class)
@AssoTypeByTokenProvider(classType = PersonTypeByTokenProvider.class)
public class PersonGridForm extends AbstractGrid<XmlPerson> {

    public PersonGridForm(IDelegate service, IModule module) {
        super(service, module);
    }

    @Override
    public Window getEditorWindow(IModule module, XmlPerson bean, AbstractEditor.SaveHandler saveHandler) {
        return PersonEditorForm.newInstance(module, bean, saveHandler).getWindow();
    }
}