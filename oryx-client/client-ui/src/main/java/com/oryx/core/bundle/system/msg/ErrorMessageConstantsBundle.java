package com.oryx.core.bundle.system.msg;

import com.oryx.core.annotation.decl.DefaultStringValue;
import com.oryx.core.bundle.common.ICommonConstantBundle;

/**
 * Created by 241180 on 13/01/2017.
 */

@DefaultStringValue("Error message details")
public interface ErrorMessageConstantsBundle extends ICommonConstantBundle {
    @DefaultStringValue("Code")
    public String messageCode();

    @DefaultStringValue("Language")
    public String language();

    @DefaultStringValue("Meaning")
    public String meaning();
}
