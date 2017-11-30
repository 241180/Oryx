package com.oryx.core.bundle.common;

import com.oryx.core.annotation.decl.DefaultStringValue;

/**
 * Created by SAMI on 25/02/2017.
 */
public interface InformationConstantBundle extends ICommonConstantBundle {
    @DefaultStringValue("Retrieved %1 instance of %2.")
    public String RetrievedInfoMsg();

    @DefaultStringValue("Deleted %1 instance of %2.")
    public String DeletedInfoMsg();

    @DefaultStringValue("Created %1 instance of %2.")
    public String CreatedInfoMsg();

    @DefaultStringValue("Updated %1 instance of %2.")
    public String UpdatedInfoMsg();

    @DefaultStringValue("Closing %1.")
    public String ClosingInfoMsg();

    @DefaultStringValue("No objects to be processed.")
    public String NoObjectToBeProcessed();

    @DefaultStringValue("No filter model provided.")
    public String NoFilterModelProvided();
}
