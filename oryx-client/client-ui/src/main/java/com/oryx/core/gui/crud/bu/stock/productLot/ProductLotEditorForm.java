package com.oryx.core.gui.crud.bu.stock.productLot;

import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.bu.stock.ProductLotConstantsBundle;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.bu.stock.ProductLotTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.bu.stock.XmlProductLot;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = ProductLotConstantsBundle.class)
@AssoTypeByTokenProvider(classType = ProductLotTypeByTokenProvider.class)
public class ProductLotEditorForm extends AbstractEditor<XmlProductLot> {

    public ProductLotEditorForm(IModule module, XmlProductLot productLot, SaveHandler saveHandler) {
        super(productLot, saveHandler, module);
    }

    public static ProductLotEditorForm newInstance(IModule module, XmlProductLot productLot, SaveHandler saveHandler) {
        return new ProductLotEditorForm(module, productLot, saveHandler);
    }
}