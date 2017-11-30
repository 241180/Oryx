package com.oryx.core.gui.crud.bu.stock.productLot;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoGridForm;
import com.oryx.core.layout.AbstractCrudFormLayout;
import com.oryx.core.module.IModule;
import com.oryx.remote.webservice.element.model.bu.stock.XmlProductLot;

@AssoEntity(classType = XmlProductLot.class)
@AssoGridForm(classType = ProductLotGridForm.class)
public class ProductLotForm extends AbstractCrudFormLayout<XmlProductLot> {

    public ProductLotForm(IModule module) {
        super(module);
    }
}
