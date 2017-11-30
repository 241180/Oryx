package com.oryx.core.gui.crud.bu.stock.productLot;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.bu.stock.ProductLotConstantsBundle;
import com.oryx.core.delegate.IDelegate;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.layout.grid.AbstractGrid;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.bu.stock.ProductLotTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.bu.stock.XmlProductLot;
import com.vaadin.ui.Window;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = ProductLotConstantsBundle.class)
@AssoEntity(classType = XmlProductLot.class)
@AssoTypeByTokenProvider(classType = ProductLotTypeByTokenProvider.class)
public class ProductLotGridForm extends AbstractGrid<XmlProductLot> {

    public ProductLotGridForm(IDelegate service, IModule module) {
        super(service, module);
    }

    @Override
    public Window getEditorWindow(IModule module, XmlProductLot bean, AbstractEditor.SaveHandler saveHandler) {
        return ProductLotEditorForm.newInstance(module, bean, saveHandler).getWindow();
    }
}