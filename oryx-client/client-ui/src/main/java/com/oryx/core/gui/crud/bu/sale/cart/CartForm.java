package com.oryx.core.gui.crud.bu.sale.cart;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoGridForm;
import com.oryx.core.layout.AbstractCrudFormLayout;
import com.oryx.core.module.IModule;
import com.oryx.remote.webservice.element.model.bu.sale.XmlCart;

@AssoEntity(classType = XmlCart.class)
@AssoGridForm(classType = CartGridForm.class)
public class CartForm extends AbstractCrudFormLayout<XmlCart> {

    public CartForm(IModule module) {
        super(module);
    }
}
