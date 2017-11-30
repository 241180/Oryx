package com.oryx.core.bundle.system.ose;

import com.oryx.core.annotation.decl.DefaultStringValue;
import com.oryx.core.bundle.common.ICommonConstantBundle;

/**
 * Created by 241180 on 13/01/2017.
 */
@DefaultStringValue("Menu details")
public interface MenuConstantsBundle extends ICommonConstantBundle {
    @DefaultStringValue("Name")
    public String name();

    @DefaultStringValue("Description")
    public String description();

    @DefaultStringValue("status")
    public String status();

    @DefaultStringValue("Active")
    public String ACTIVE();

    @DefaultStringValue("Inactive")
    public String INACTIVE();

    @DefaultStringValue("Task Set")
    public String taskSet();

    @DefaultStringValue("Task Ids")
    public String taskIds();
}
