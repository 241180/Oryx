package com.oryx.core.gui.crud.bu.sale.shopper;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.bu.sale.ShopperConstantsBundle;
import com.oryx.core.delegate.IDelegate;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.layout.grid.AbstractGrid;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.bu.sale.ShopperTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.bu.sale.XmlShopper;
import com.vaadin.ui.Window;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = ShopperConstantsBundle.class)
@AssoEntity(classType = XmlShopper.class)
@AssoTypeByTokenProvider(classType = ShopperTypeByTokenProvider.class)
public class ShopperGridForm extends AbstractGrid<XmlShopper> {

    public ShopperGridForm(IDelegate service, IModule module) {
        super(service, module);
    }

    @Override
    public Window getEditorWindow(IModule module, XmlShopper bean, AbstractEditor.SaveHandler saveHandler) {
        return ShopperEditorForm.newInstance(module, bean, saveHandler).getWindow();
    }
}