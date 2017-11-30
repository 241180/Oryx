package com.oryx.core.gui.crud.bu.sale.cart;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.bu.sale.CartConstantsBundle;
import com.oryx.core.delegate.IDelegate;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.layout.grid.AbstractGrid;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.bu.sale.CartTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.bu.sale.XmlCart;
import com.vaadin.ui.Window;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = CartConstantsBundle.class)
@AssoEntity(classType = XmlCart.class)
@AssoTypeByTokenProvider(classType = CartTypeByTokenProvider.class)
public class CartGridForm extends AbstractGrid<XmlCart> {

    public CartGridForm(IDelegate service, IModule module) {
        super(service, module);
    }

    @Override
    public Window getEditorWindow(IModule module, XmlCart bean, AbstractEditor.SaveHandler saveHandler) {
        return CartEditorForm.newInstance(module, bean, saveHandler).getWindow();
    }
}