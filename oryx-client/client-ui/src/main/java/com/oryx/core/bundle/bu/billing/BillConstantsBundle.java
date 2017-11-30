package com.oryx.core.bundle.bu.billing;

import com.oryx.core.annotation.decl.DefaultStringValue;
import com.oryx.core.bundle.common.ICommonConstantBundle;

/**
 * Created by 241180 on 13/01/2017.
 */

@DefaultStringValue("Bill details")
public interface BillConstantsBundle extends ICommonConstantBundle {
    @DefaultStringValue("Bill")
    public String XmlBill();
}
