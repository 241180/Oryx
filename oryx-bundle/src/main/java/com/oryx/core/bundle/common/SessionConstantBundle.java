package com.oryx.core.bundle.common;

import com.oryx.core.annotation.decl.DefaultStringValue;

/**
 * Created by SAMI on 25/02/2017.
 */
public interface SessionConstantBundle extends ICommonConstantBundle {
    @DefaultStringValue("Invalid user session")
    public String INVALID_USER_SESSION();

}
