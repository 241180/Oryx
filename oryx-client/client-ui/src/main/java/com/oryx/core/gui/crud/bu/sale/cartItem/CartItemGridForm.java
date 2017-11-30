package com.oryx.core.gui.crud.bu.sale.cartItem;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.bu.sale.CartItemConstantsBundle;
import com.oryx.core.delegate.IDelegate;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.layout.grid.AbstractGrid;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.bu.sale.CartItemTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.bu.sale.XmlCartItem;
import com.vaadin.ui.Window;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = CartItemConstantsBundle.class)
@AssoEntity(classType = XmlCartItem.class)
@AssoTypeByTokenProvider(classType = CartItemTypeByTokenProvider.class)
public class CartItemGridForm extends AbstractGrid<XmlCartItem> {

    public CartItemGridForm(IDelegate service, IModule module) {
        super(service, module);
    }

    @Override
    public Window getEditorWindow(IModule module, XmlCartItem bean, AbstractEditor.SaveHandler saveHandler) {
        return CartItemEditorForm.newInstance(module, bean, saveHandler).getWindow();
    }
}