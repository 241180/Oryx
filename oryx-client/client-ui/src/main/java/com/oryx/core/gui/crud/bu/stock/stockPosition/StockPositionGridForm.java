package com.oryx.core.gui.crud.bu.stock.stockPosition;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.bu.stock.StockPositionConstantsBundle;
import com.oryx.core.delegate.IDelegate;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.layout.grid.AbstractGrid;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.typeByToken.model.bu.stock.StockPositionTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.bu.stock.XmlStockPosition;
import com.vaadin.ui.Window;

/**
 * Created by 241180 on 04/01/2017.
 */
@Bundle(classType = StockPositionConstantsBundle.class)
@AssoEntity(classType = XmlStockPosition.class)
@AssoTypeByTokenProvider(classType = StockPositionTypeByTokenProvider.class)
public class StockPositionGridForm extends AbstractGrid<XmlStockPosition> {

    public StockPositionGridForm(IDelegate service, IModule module) {
        super(service, module);
    }

    @Override
    public Window getEditorWindow(IModule module, XmlStockPosition bean, AbstractEditor.SaveHandler saveHandler) {
        return StockPositionEditorForm.newInstance(module, bean, saveHandler).getWindow();
    }
}