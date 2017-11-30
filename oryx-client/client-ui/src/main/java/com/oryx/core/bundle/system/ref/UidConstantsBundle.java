package com.oryx.core.bundle.system.ref;

import com.oryx.core.annotation.decl.DefaultStringValue;
import com.oryx.core.bundle.common.ICommonConstantBundle;

/**
 * Created by 241180 on 13/01/2017.
 */

@DefaultStringValue("Uid details")
public interface UidConstantsBundle extends ICommonConstantBundle {
    @DefaultStringValue("Identifier type")
    public String uidType();

    @DefaultStringValue("Social insurance")
    public String SECU();

    @DefaultStringValue("National card")
    public String NIDC();

    @DefaultStringValue("Passport")
    public String PSPT();

    @DefaultStringValue("Unique identifier")
    public String uid();

}
