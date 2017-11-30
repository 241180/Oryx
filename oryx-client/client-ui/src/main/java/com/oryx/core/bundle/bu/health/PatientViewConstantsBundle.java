package com.oryx.core.bundle.bu.health;

import com.oryx.core.annotation.decl.DefaultStringValue;
import com.oryx.core.bundle.common.ICommonConstantBundle;

/**
 * Created by 241180 on 13/01/2017.
 */

@DefaultStringValue("User view details")
public interface PatientViewConstantsBundle extends ICommonConstantBundle {

    @DefaultStringValue("Code")
    public String userCode();

    @DefaultStringValue("Login")
    public String userLogin();

    @DefaultStringValue("Password")
    public String userPassword();

    @DefaultStringValue("language")
    public String language();

    @DefaultStringValue("Spanish")
    public String SPA();

    @DefaultStringValue("Frensh")
    public String FRA();

    @DefaultStringValue("English")
    public String ENG();

    @DefaultStringValue("Deutch")
    public String DEU();

    @DefaultStringValue("Italian")
    public String ITA();

    @DefaultStringValue("Arabic")
    public String ARA();

    @DefaultStringValue("Role")
    public String role();

    @DefaultStringValue("User")
    public String ROLE_USER();

    @DefaultStringValue("Admin")
    public String ROLE_ADMIN();

    @DefaultStringValue("Status")
    public String status();

    @DefaultStringValue("Inactive")
    public String INACTIVE();

    @DefaultStringValue("Active")
    public String ACTIVE();

    @DefaultStringValue("Activation start date")
    public String startDate();

    @DefaultStringValue("Activation end date")
    public String endDate();

    @DefaultStringValue("Identifier")
    public String defaultUid();

    @DefaultStringValue("Civility")
    public String civility();

    @DefaultStringValue("Single")
    public String SINGLE();

    @DefaultStringValue("Married")
    public String MARRIED();

    @DefaultStringValue("Gender")
    public String gender();

    @DefaultStringValue("Female")
    public String FEMALE();

    @DefaultStringValue("Male")
    public String MALE();

    @DefaultStringValue("Birth date")
    public String birthDate();

    @DefaultStringValue("Birth city")
    public String birthCityId();

    @DefaultStringValue("Birth country")
    public String birthCountryId();

    @DefaultStringValue("Adress")
    public String adressStreet();

    @DefaultStringValue("Adress city")
    public String adressCityId();

    @DefaultStringValue("Adress country")
    public String adressCountryId();

    @DefaultStringValue("Email")
    public String email();

    @DefaultStringValue("Phone 1")
    public String phoneNumber1();

    @DefaultStringValue("Phone 2")
    public String phoneNumber2();

    @DefaultStringValue("Prename")
    public String firstName();

    @DefaultStringValue("Name")
    public String lastName();
}
