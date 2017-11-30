package com.oryx.core.bundle.system.ose;

import com.oryx.core.annotation.decl.DefaultStringValue;
import com.oryx.core.bundle.common.ICommonConstantBundle;

/**
 * Created by 241180 on 13/01/2017.
 */

@DefaultStringValue("Task details")
public interface TaskConstantsBundle extends ICommonConstantBundle {
    @DefaultStringValue("Name")
    public String name();

    @DefaultStringValue("Description")
    public String description();

    @DefaultStringValue("Status")
    public String status();

    @DefaultStringValue("Active")
    public String ACTIVE();

    @DefaultStringValue("Inactive")
    public String INACTIVE();

    @DefaultStringValue("Permission")
    public String permission();

    @DefaultStringValue("Update")
    public String UPDATE();

    @DefaultStringValue("Delete")
    public String DELETE();

    @DefaultStringValue("Create")
    public String CREATE();

    @DefaultStringValue("Select")
    public String SELECT();
}
