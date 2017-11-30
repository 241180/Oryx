package com.oryx.core.bundle;

import com.oryx.core.annotation.decl.DefaultStringValue;
import com.oryx.core.bundle.common.ICommonConstantBundle;

/**
 * Created by 241180 on 13/01/2017.
 */

@DefaultStringValue("Oryx web application")
public interface ApplicationConstantsBundle extends ICommonConstantBundle {
    @DefaultStringValue("Operation Type")
    public String operation();
}
