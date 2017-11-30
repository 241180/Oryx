package com.oryx.core.bundle.common;

import com.oryx.core.annotation.decl.DefaultStringValue;

/**
 * Created by SAMI on 25/02/2017.
 */
public interface SqlConstantBundle extends ICommonConstantBundle {
    @DefaultStringValue("Code d'erreur null")
    public String NULL_ERROR_CODE();

    @DefaultStringValue("Violation de contrainte")
    public String CONSTRAINT_VIOLATION();
}
