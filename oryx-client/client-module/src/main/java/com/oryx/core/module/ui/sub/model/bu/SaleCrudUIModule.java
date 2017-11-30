package com.oryx.core.module.ui.sub.model.bu;

import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.CrudUIConstantsBundle;
import com.oryx.core.gui.crud.bu.sale.cart.CartForm;
import com.oryx.core.gui.crud.bu.sale.cartItem.CartItemForm;
import com.oryx.core.gui.crud.bu.sale.product.ProductForm;
import com.oryx.core.gui.crud.bu.sale.productCategory.ProductCategoryForm;
import com.oryx.core.gui.crud.bu.sale.shopper.ShopperForm;
import com.oryx.core.module.AbstractLayoutModule;
import com.oryx.core.module.ILayoutModule;
import com.oryx.remote.webservice.element.model.bu.sale.*;

/**
 * Created by SAMI on 13/03/2017.
 */

@Bundle(classType = CrudUIConstantsBundle.class)
public class SaleCrudUIModule extends AbstractLayoutModule {

    @Override
    public ILayoutModule configure() {
        this.bindFormLayout(XmlProduct.class, ProductForm.class);
        this.bindFormLayout(XmlProductCategory.class, ProductCategoryForm.class);
        this.bindFormLayout(XmlCart.class, CartForm.class);
        this.bindFormLayout(XmlCartItem.class, CartItemForm.class);
        this.bindFormLayout(XmlShopper.class, ShopperForm.class);

        return this;
    }
}
