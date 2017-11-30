package com.oryx.core.gui.crud.bu.sale.product;

import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.bu.sale.ProductConstantsBundle;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.bu.sale.ProductTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.bu.sale.XmlProduct;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = ProductConstantsBundle.class)
@AssoTypeByTokenProvider(classType = ProductTypeByTokenProvider.class)
public class ProductEditorForm extends AbstractEditor<XmlProduct> {

    public ProductEditorForm(IModule module, XmlProduct product, SaveHandler saveHandler) {
        super(product, saveHandler, module);
    }

    public static ProductEditorForm newInstance(IModule module, XmlProduct product, SaveHandler saveHandler) {
        return new ProductEditorForm(module, product, saveHandler);
    }
}