package com.oryx.core.gui.crud.bu.sale.product;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.bu.sale.ProductConstantsBundle;
import com.oryx.core.delegate.IDelegate;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.layout.grid.AbstractGrid;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.bu.sale.ProductTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.bu.sale.XmlProduct;
import com.vaadin.ui.Window;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = ProductConstantsBundle.class)
@AssoEntity(classType = XmlProduct.class)
@AssoTypeByTokenProvider(classType = ProductTypeByTokenProvider.class)
public class ProductGridForm extends AbstractGrid<XmlProduct> {

    public ProductGridForm(IDelegate service, IModule module) {
        super(service, module);
    }

    @Override
    public Window getEditorWindow(IModule module, XmlProduct bean, AbstractEditor.SaveHandler saveHandler) {
        return ProductEditorForm.newInstance(module, bean, saveHandler).getWindow();
    }
}