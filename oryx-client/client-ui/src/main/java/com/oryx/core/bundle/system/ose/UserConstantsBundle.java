package com.oryx.core.bundle.system.ose;

import com.oryx.core.annotation.decl.DefaultStringValue;
import com.oryx.core.annotation.decl.FieldStyle;
import com.oryx.core.bundle.common.ICommonConstantBundle;

/**
 * Created by 241180 on 13/01/2017.
 */

@DefaultStringValue("User details")
public interface UserConstantsBundle extends ICommonConstantBundle {
    @DefaultStringValue("User")
    public String XmlUser();

    @FieldStyle(readOnly = true)
    @DefaultStringValue("Code")
    public String userCode();

    @FieldStyle(textLength = 32, mandatory = true)
    @DefaultStringValue("Email")
    public String email();

    @FieldStyle(textLength = 12, mandatory = true)
    @DefaultStringValue("Login")
    public String userLogin();

    @FieldStyle(textLength = 16, mandatory = true)
    @DefaultStringValue("Password")
    public String userPassword();

    @DefaultStringValue("Language")
    public String language();

    @DefaultStringValue("Last connection")
    public String lastConnection();

    @FieldStyle(mandatory = true)
    @DefaultStringValue("Role")
    public String role();

    @FieldStyle(mandatory = true)
    @DefaultStringValue("Status")
    public String status();

    @DefaultStringValue("Linked person")
    public String personId();

    @DefaultStringValue("Roles/permissions")
    public String roleIds();

    @DefaultStringValue("Roles/permissions")
    public String roleSet();

    //role
    @DefaultStringValue("Administrator")
    public String ROLE_ADMIN();

    @DefaultStringValue("User")
    public String ROLE_USER();

    //Status
    @DefaultStringValue("Active")
    public String ACTIVE();

    @DefaultStringValue("Inactive")
    public String INACTIVE();
}
