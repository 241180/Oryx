package com.oryx.core.bundle.common;

import com.oryx.core.annotation.decl.DefaultStringValue;

/**
 * Created by SAMI on 25/02/2017.
 */
public interface MessageConstantBundle extends ICommonConstantBundle {
    @DefaultStringValue("Page")
    public String page();

    @DefaultStringValue("Operation")
    public String operation();
}
