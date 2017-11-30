package com.oryx.core.gui.crud.system.ref.uid;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoGridForm;
import com.oryx.core.layout.AbstractCrudFormLayout;
import com.oryx.core.module.IModule;
import com.oryx.remote.webservice.element.model.system.ref.XmlUid;

@AssoEntity(classType = XmlUid.class)
@AssoGridForm(classType = UidGridForm.class)
public class UidForm extends AbstractCrudFormLayout<XmlUid> {

    public UidForm(IModule module) {
        super(module);
    }
}
