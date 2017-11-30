package com.oryx.core.gui.crud.bu.sale.shopper;

import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.bu.sale.ShopperConstantsBundle;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.bu.sale.ShopperTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.bu.sale.XmlShopper;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = ShopperConstantsBundle.class)
@AssoTypeByTokenProvider(classType = ShopperTypeByTokenProvider.class)
public class ShopperEditorForm extends AbstractEditor<XmlShopper> {

    public ShopperEditorForm(IModule module, XmlShopper shopper, SaveHandler saveHandler) {
        super(shopper, saveHandler, module);
    }

    public static ShopperEditorForm newInstance(IModule module, XmlShopper shopper, SaveHandler saveHandler) {
        return new ShopperEditorForm(module, shopper, saveHandler);
    }
}