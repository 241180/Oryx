package com.oryx.core.gui.crud.bu.sale.cartItem;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoGridForm;
import com.oryx.core.layout.AbstractCrudFormLayout;
import com.oryx.core.module.IModule;
import com.oryx.remote.webservice.element.model.bu.sale.XmlCartItem;

@AssoEntity(classType = XmlCartItem.class)
@AssoGridForm(classType = CartItemGridForm.class)
public class CartItemForm extends AbstractCrudFormLayout<XmlCartItem> {

    public CartItemForm(IModule module) {
        super(module);
    }
}
