package com.oryx.core.bundle.system.ref;

import com.oryx.core.annotation.decl.DefaultStringValue;
import com.oryx.core.annotation.decl.FieldStyle;
import com.oryx.core.bundle.common.ICommonConstantBundle;

/**
 * Created by 241180 on 13/01/2017.
 */

@DefaultStringValue("Country details")
public interface CountryConstantsBundle extends ICommonConstantBundle {

    @FieldStyle(readOnly = true)
    @DefaultStringValue("Code")
    public String code();

    @DefaultStringValue("Name")
    public String name();

    @DefaultStringValue("Political capital")
    public String polCapitalId();

    @DefaultStringValue("Economical Capital")
    public String ecoCapitalId();
}
