package com.oryx.core.bundle.bu;

import com.oryx.core.annotation.decl.DefaultStringValue;
import com.oryx.core.bundle.common.ICommonConstantBundle;

/**
 * Created by 241180 on 13/01/2017.
 */

@DefaultStringValue("Oryx Application")
public interface SystemCrudUIConstantsBundle extends ICommonConstantBundle {
    //SYSTEM
    @DefaultStringValue("Adress management")
    public String XmlAdress();

    @DefaultStringValue("Contact management")
    public String XmlContact();

    @DefaultStringValue("Country management")
    public String XmlCountry();

    @DefaultStringValue("Error management")
    public String XmlErrorMessage();

    @DefaultStringValue("Menu management")
    public String XmlMenu();

    @DefaultStringValue("Person management")
    public String XmlPerson();

    @DefaultStringValue("Role management")
    public String XmlRoleInfo();

    @DefaultStringValue("City Management")
    public String XmlState();

    @DefaultStringValue("Task management")
    public String XmlTask();

    @DefaultStringValue("Unique identifier management")
    public String XmlUid();

    @DefaultStringValue("Domain management")
    public String XmlDomain();

    @DefaultStringValue("Upgrade management")
    public String XmlUpgrades();

    @DefaultStringValue("User management")
    public String XmlUser();

    @DefaultStringValue("Translation management")
    public String XmlTranslation();

    @DefaultStringValue("Index management")
    public String XmlAnnex();

    @DefaultStringValue("Field/Process parameter management")
    public String XmlFieldProcessParam();

    @DefaultStringValue("Parameter management")
    public String XmlParameter();

    @DefaultStringValue("Codification management")
    public String XmlCodification();

    @DefaultStringValue("Third party management")
    public String XmlThirdParty();
}
