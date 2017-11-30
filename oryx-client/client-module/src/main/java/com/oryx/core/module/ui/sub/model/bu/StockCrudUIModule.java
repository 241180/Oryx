package com.oryx.core.module.ui.sub.model.bu;

import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.CrudUIConstantsBundle;
import com.oryx.core.gui.crud.bu.stock.productLot.ProductLotForm;
import com.oryx.core.gui.crud.bu.stock.stockPosition.StockPositionForm;
import com.oryx.core.module.AbstractLayoutModule;
import com.oryx.core.module.ILayoutModule;
import com.oryx.remote.webservice.element.model.bu.stock.XmlProductLot;
import com.oryx.remote.webservice.element.model.bu.stock.XmlStockPosition;

/**
 * Created by SAMI on 13/03/2017.
 */

@Bundle(classType = CrudUIConstantsBundle.class)
public class StockCrudUIModule extends AbstractLayoutModule {

    @Override
    public ILayoutModule configure() {
        this.bindFormLayout(XmlProductLot.class, ProductLotForm.class);
        this.bindFormLayout(XmlStockPosition.class, StockPositionForm.class);

        return this;
    }
}
