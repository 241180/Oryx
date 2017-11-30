package com.oryx.core.bundle.common;

import com.oryx.core.annotation.decl.DefaultStringValue;

/**
 * Created by SAMI on 25/02/2017.
 */
public interface ActionConstantBundle extends ICommonConstantBundle {
    @DefaultStringValue("Validate")
    public String VALIDATE();

    @DefaultStringValue("Add")
    public String ADD();

    @DefaultStringValue("Delete")
    public String DELETE();

    @DefaultStringValue("Modify")
    public String MODIFY();

    @DefaultStringValue("Cancel")
    public String CANCEL();

    @DefaultStringValue("Update")
    public String UPDATE();

    @DefaultStringValue("Stop")
    public String STOP();

    @DefaultStringValue("Suspend")
    public String SUSPEND();

    @DefaultStringValue("Initialize")
    public String INITIALIZE();

    @DefaultStringValue("Refresh")
    public String REFRESH();

    @DefaultStringValue("Next")
    public String NEXT();

    @DefaultStringValue("Previous")
    public String PREVIOUS();

    @DefaultStringValue("Create")
    public String CREATE();

    @DefaultStringValue("Edit")
    public String EDIT();

    @DefaultStringValue("Filter")
    public String FILTER();
}
