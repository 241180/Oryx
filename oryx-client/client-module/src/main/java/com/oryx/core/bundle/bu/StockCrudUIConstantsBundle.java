package com.oryx.core.bundle.bu;

import com.oryx.core.annotation.decl.DefaultStringValue;
import com.oryx.core.bundle.common.ICommonConstantBundle;

/**
 * Created by 241180 on 13/01/2017.
 */

@DefaultStringValue("Oryx Application")
public interface StockCrudUIConstantsBundle extends ICommonConstantBundle {
    //BILLING
    @DefaultStringValue("Product lot management")
    public String XmlProductLot();

    @DefaultStringValue("stock position management")
    public String XmlStockPosition();
}
