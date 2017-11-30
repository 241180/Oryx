package com.oryx.core.module.service.sub.model.bu;

import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.CrudServiceConstantsBundle;
import com.oryx.core.delegate.bu.stock.ProductLotServiceDelegate;
import com.oryx.core.delegate.bu.stock.StockPositionServiceDelegate;
import com.oryx.core.module.AbstractServiceModule;
import com.oryx.core.module.IModule;
import com.oryx.remote.webservice.element._enum.ProductLotServices;
import com.oryx.remote.webservice.element._enum.StockPositionServices;
import com.oryx.remote.webservice.element.model.bu.stock.XmlProductLot;
import com.oryx.remote.webservice.element.model.bu.stock.XmlStockPosition;

/**
 * Created by SAMI on 13/03/2017.
 */

@Bundle(classType = CrudServiceConstantsBundle.class)
public class StockCrudServiceModule extends AbstractServiceModule {

    @Override
    public IModule configure() {
        super.configure();
        this.bindService(XmlProductLot.class, ProductLotServiceDelegate.class, ProductLotServices.class);
        this.bindService(XmlStockPosition.class, StockPositionServiceDelegate.class, StockPositionServices.class);

        return this;
    }
}
