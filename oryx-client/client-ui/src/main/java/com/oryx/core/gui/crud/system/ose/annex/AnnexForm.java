package com.oryx.core.gui.crud.system.ose.annex;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoGridForm;
import com.oryx.core.layout.AbstractCrudFormLayout;
import com.oryx.core.module.IModule;
import com.oryx.remote.webservice.element.model.system.ose.XmlAnnex;


@AssoEntity(classType = XmlAnnex.class)
@AssoGridForm(classType = AnnexGridForm.class)
public class AnnexForm extends AbstractCrudFormLayout<XmlAnnex> {

    public AnnexForm(IModule module) {
        super(module);
    }
}
