package com.oryx.core.bundle.common;

import com.oryx.core.annotation.decl.DefaultStringValue;

/**
 * Created by SAMI on 25/02/2017.
 */
public interface ErrorConstantBundle extends ICommonConstantBundle {
    @DefaultStringValue("Coud not save entity:\n %1 \n %2")
    public String SaveEntityErrorMsg();

    @DefaultStringValue("%1 must be filled in!")
    public String RequiredFieldMsg();

    @DefaultStringValue("Commit failed, operation could not be performed")
    public String CommitFailed();

    @DefaultStringValue("Selection is empty, please select an item")
    public String SelectionIsEmpty();
}
