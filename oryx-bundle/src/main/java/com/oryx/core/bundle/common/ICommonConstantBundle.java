package com.oryx.core.bundle.common;

import com.oryx.core.annotation.decl.DefaultStringValue;
import com.oryx.core.annotation.decl.FieldStyle;
import com.oryx.core.bundle.IBundle;

/**
 * Created by SAMI on 24/02/2017.
 */
public interface ICommonConstantBundle extends IBundle {

    @FieldStyle(readOnly = true)
    @DefaultStringValue("Code")
    public String code();
}
