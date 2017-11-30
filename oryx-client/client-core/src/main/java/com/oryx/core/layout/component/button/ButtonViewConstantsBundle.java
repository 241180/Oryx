package com.oryx.core.layout.component.button;

import com.oryx.core.annotation.decl.DefaultStringValue;
import com.oryx.core.bundle.common.ICommonConstantBundle;

/**
 * Created by 241180 on 13/01/2017.
 */

public interface ButtonViewConstantsBundle extends ICommonConstantBundle {
    @DefaultStringValue("Refresh")
    public String REFRESH();

    @DefaultStringValue("Create")
    public String CREATE();

    @DefaultStringValue("Edit")
    public String EDIT();

    @DefaultStringValue("Delete")
    public String DELETE();

    @DefaultStringValue("Filter")
    public String FILTER();

    @DefaultStringValue("Validate")
    public String VALIDATE();

    @DefaultStringValue("Reset")
    public String RESET();

    @DefaultStringValue("Cancel")
    public String CANCEL();
}
