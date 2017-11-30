package com.oryx.core.gui.crud.bu.sale.product;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoGridForm;
import com.oryx.core.layout.AbstractCrudFormLayout;
import com.oryx.core.module.IModule;
import com.oryx.remote.webservice.element.model.bu.sale.XmlProduct;

@AssoEntity(classType = XmlProduct.class)
@AssoGridForm(classType = ProductGridForm.class)
public class ProductForm extends AbstractCrudFormLayout<XmlProduct> {

    public ProductForm(IModule module) {
        super(module);
    }
}
