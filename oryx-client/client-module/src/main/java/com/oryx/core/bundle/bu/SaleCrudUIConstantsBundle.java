package com.oryx.core.bundle.bu;

import com.oryx.core.annotation.decl.DefaultStringValue;
import com.oryx.core.bundle.common.ICommonConstantBundle;

/**
 * Created by 241180 on 13/01/2017.
 */

@DefaultStringValue("Oryx Application")
public interface SaleCrudUIConstantsBundle extends ICommonConstantBundle {
    //BILLING
    @DefaultStringValue("Product management")
    public String XmlProduct();

    @DefaultStringValue("Product category management")
    public String XmlProductCategory();

    @DefaultStringValue("Cart management")
    public String XmlCart();

    @DefaultStringValue("Cart item management")
    public String XmlCartItem();

    @DefaultStringValue("Shopper management")
    public String XmlShopper();
}
