package com.oryx.core.gui.crud.bu.sale.productCategory;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.bu.sale.ProductCategoryConstantsBundle;
import com.oryx.core.delegate.IDelegate;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.layout.grid.AbstractGrid;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.bu.sale.ProductCategoryTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.bu.sale.XmlProductCategory;
import com.vaadin.ui.Window;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = ProductCategoryConstantsBundle.class)
@AssoEntity(classType = XmlProductCategory.class)
@AssoTypeByTokenProvider(classType = ProductCategoryTypeByTokenProvider.class)
public class ProductCategoryGridForm extends AbstractGrid<XmlProductCategory> {

    public ProductCategoryGridForm(IDelegate service, IModule module) {
        super(service, module);
    }

    @Override
    public Window getEditorWindow(IModule module, XmlProductCategory bean, AbstractEditor.SaveHandler saveHandler) {
        return ProductCategoryEditorForm.newInstance(module, bean, saveHandler).getWindow();
    }
}