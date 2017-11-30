package com.oryx.core.gui.crud.bu.sale.cartItem;

import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.bu.sale.CartItemConstantsBundle;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.bu.sale.CartItemTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.bu.sale.XmlCartItem;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = CartItemConstantsBundle.class)
@AssoTypeByTokenProvider(classType = CartItemTypeByTokenProvider.class)
public class CartItemEditorForm extends AbstractEditor<XmlCartItem> {

    public CartItemEditorForm(IModule module, XmlCartItem cartItem, SaveHandler saveHandler) {
        super(cartItem, saveHandler, module);
    }

    public static CartItemEditorForm newInstance(IModule module, XmlCartItem cartItem, SaveHandler saveHandler) {
        return new CartItemEditorForm(module, cartItem, saveHandler);
    }
}