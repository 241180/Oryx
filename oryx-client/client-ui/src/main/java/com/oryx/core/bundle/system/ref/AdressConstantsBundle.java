package com.oryx.core.bundle.system.ref;

import com.oryx.core.annotation.decl.DefaultStringValue;
import com.oryx.core.bundle.common.ICommonConstantBundle;

/**
 * Created by 241180 on 13/01/2017.
 */

@DefaultStringValue("Adress details")
public interface AdressConstantsBundle extends ICommonConstantBundle {
    @DefaultStringValue("Country")
    public String countryId();

    @DefaultStringValue("State")
    public String stateId();

    @DefaultStringValue("Street")
    public String street();
}
