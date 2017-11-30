package com.oryx.core.gui.crud.system.ref.state;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoGridForm;
import com.oryx.core.layout.AbstractCrudFormLayout;
import com.oryx.core.module.IModule;
import com.oryx.remote.webservice.element.model.system.ref.XmlState;

@AssoEntity(classType = XmlState.class)
@AssoGridForm(classType = StateGridForm.class)
public class StateForm extends AbstractCrudFormLayout<XmlState> {

    public StateForm(IModule module) {
        super(module);
    }
}
