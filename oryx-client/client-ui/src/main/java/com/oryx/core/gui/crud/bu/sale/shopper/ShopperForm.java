package com.oryx.core.gui.crud.bu.sale.shopper;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoGridForm;
import com.oryx.core.layout.AbstractCrudFormLayout;
import com.oryx.core.module.IModule;
import com.oryx.remote.webservice.element.model.bu.sale.XmlShopper;

@AssoEntity(classType = XmlShopper.class)
@AssoGridForm(classType = ShopperGridForm.class)
public class ShopperForm extends AbstractCrudFormLayout<XmlShopper> {

    public ShopperForm(IModule module) {
        super(module);
    }
}
