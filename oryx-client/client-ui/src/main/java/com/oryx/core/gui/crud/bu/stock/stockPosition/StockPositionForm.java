package com.oryx.core.gui.crud.bu.stock.stockPosition;

import com.oryx.core.annotation.decl.AssoEntity;
import com.oryx.core.annotation.decl.AssoGridForm;
import com.oryx.core.layout.AbstractCrudFormLayout;
import com.oryx.core.module.IModule;
import com.oryx.remote.webservice.element.model.bu.stock.XmlStockPosition;

@AssoEntity(classType = XmlStockPosition.class)
@AssoGridForm(classType = StockPositionGridForm.class)
public class StockPositionForm extends AbstractCrudFormLayout<XmlStockPosition> {

    public StockPositionForm(IModule module) {
        super(module);
    }
}
