package com.oryx.core.gui.crud.bu.sale.productCategory;

import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.bu.sale.ProductCategoryConstantsBundle;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.bu.sale.ProductCategoryTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.bu.sale.XmlProductCategory;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = ProductCategoryConstantsBundle.class)
@AssoTypeByTokenProvider(classType = ProductCategoryTypeByTokenProvider.class)
public class ProductCategoryEditorForm extends AbstractEditor<XmlProductCategory> {

    public ProductCategoryEditorForm(IModule module, XmlProductCategory productCategory, SaveHandler saveHandler) {
        super(productCategory, saveHandler, module);
    }

    public static ProductCategoryEditorForm newInstance(IModule module, XmlProductCategory productCategory, SaveHandler saveHandler) {
        return new ProductCategoryEditorForm(module, productCategory, saveHandler);
    }
}