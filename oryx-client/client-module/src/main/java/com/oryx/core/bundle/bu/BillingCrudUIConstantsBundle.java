package com.oryx.core.bundle.bu;

import com.oryx.core.annotation.decl.DefaultStringValue;
import com.oryx.core.bundle.common.ICommonConstantBundle;

/**
 * Created by 241180 on 13/01/2017.
 */

@DefaultStringValue("Oryx Application")
public interface BillingCrudUIConstantsBundle extends ICommonConstantBundle {
    //BILLING
    @DefaultStringValue("Bill management")
    public String XmlBill();

    @DefaultStringValue("Instance management")
    public String XmlInstance();

    @DefaultStringValue("Bill Item management")
    public String XmlBillItem();

    @DefaultStringValue("Account management")
    public String XmlAccount();
}
