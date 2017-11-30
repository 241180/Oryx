package com.oryx.core.module.service.sub.model.bu;

import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.CrudServiceConstantsBundle;
import com.oryx.core.delegate.bu.sale.*;
import com.oryx.core.module.AbstractServiceModule;
import com.oryx.core.module.IModule;
import com.oryx.remote.webservice.element._enum.*;
import com.oryx.remote.webservice.element.model.bu.sale.*;

/**
 * Created by SAMI on 13/03/2017.
 */

@Bundle(classType = CrudServiceConstantsBundle.class)
public class SaleCrudServiceModule extends AbstractServiceModule {

    @Override
    public IModule configure() {
        super.configure();
        this.bindService(XmlCart.class, CartServiceDelegate.class, CartServices.class);
        this.bindService(XmlCartItem.class, CartItemServiceDelegate.class, CartItemServices.class);
        this.bindService(XmlProduct.class, ProductServiceDelegate.class, ProductServices.class);
        this.bindService(XmlProductCategory.class, ProductCategoryServiceDelegate.class, ProductCategoryServices.class);
        this.bindService(XmlShopper.class, ShopperServiceDelegate.class, ShopperServices.class);

        return this;
    }
}
