package com.oryx.core.gui.crud.bu.sale.cart;

import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.bu.sale.CartConstantsBundle;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.bu.sale.CartTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.bu.sale.XmlCart;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = CartConstantsBundle.class)
@AssoTypeByTokenProvider(classType = CartTypeByTokenProvider.class)
public class CartEditorForm extends AbstractEditor<XmlCart> {

    public CartEditorForm(IModule module, XmlCart cart, SaveHandler saveHandler) {
        super(cart, saveHandler, module);
    }

    public static CartEditorForm newInstance(IModule module, XmlCart cart, SaveHandler saveHandler) {
        return new CartEditorForm(module, cart, saveHandler);
    }
}