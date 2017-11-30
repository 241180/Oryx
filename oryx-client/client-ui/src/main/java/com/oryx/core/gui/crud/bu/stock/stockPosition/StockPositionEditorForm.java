package com.oryx.core.gui.crud.bu.stock.stockPosition;

import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.bu.stock.StockPositionConstantsBundle;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.bu.stock.StockPositionTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.bu.stock.XmlStockPosition;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = StockPositionConstantsBundle.class)
@AssoTypeByTokenProvider(classType = StockPositionTypeByTokenProvider.class)
public class StockPositionEditorForm extends AbstractEditor<XmlStockPosition> {

    public StockPositionEditorForm(IModule module, XmlStockPosition stockPosition, SaveHandler saveHandler) {
        super(stockPosition, saveHandler, module);
    }

    public static StockPositionEditorForm newInstance(IModule module, XmlStockPosition stockPosition, SaveHandler saveHandler) {
        return new StockPositionEditorForm(module, stockPosition, saveHandler);
    }
}