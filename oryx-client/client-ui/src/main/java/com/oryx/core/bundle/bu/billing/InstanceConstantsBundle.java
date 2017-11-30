package com.oryx.core.bundle.bu.billing;

import com.oryx.core.annotation.decl.DefaultStringValue;
import com.oryx.core.bundle.common.ICommonConstantBundle;

/**
 * Created by 241180 on 13/01/2017.
 */

@DefaultStringValue("Instance details")
public interface InstanceConstantsBundle extends ICommonConstantBundle {
    @DefaultStringValue("Instance")
    public String XmlInstance();
}
