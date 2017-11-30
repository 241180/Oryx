package com.oryx.core.gui.crud.bu.sale.productCategory;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoGridForm;
import com.oryx.core.layout.AbstractCrudFormLayout;
import com.oryx.core.module.IModule;
import com.oryx.remote.webservice.element.model.bu.sale.XmlProductCategory;

@AssoEntity(classType = XmlProductCategory.class)
@AssoGridForm(classType = ProductCategoryGridForm.class)
public class ProductCategoryForm extends AbstractCrudFormLayout<XmlProductCategory> {

    public ProductCategoryForm(IModule module) {
        super(module);
    }
}
