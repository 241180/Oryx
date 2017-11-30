package com.oryx.core.bundle;

import com.oryx.core.annotation.decl.DefaultStringValue;
import com.oryx.core.bundle.common.ICommonConstantBundle;

/**
 * Created by 241180 on 13/01/2017.
 */

@DefaultStringValue("Oryx Application")
public interface CrudServiceConstantsBundle extends ICommonConstantBundle {
    @DefaultStringValue("Adress service")
    public String XmlAdress();

    @DefaultStringValue("Contact service")
    public String XmlContact();

    @DefaultStringValue("Country service")
    public String XmlCountry();

    @DefaultStringValue("Error service")
    public String XmlErrorMessage();

    @DefaultStringValue("Menu service")
    public String XmlMenu();

    @DefaultStringValue("Person service")
    public String XmlPerson();

    @DefaultStringValue("Role service")
    public String XmlRoleInfo();

    @DefaultStringValue("City Management")
    public String XmlState();

    @DefaultStringValue("Task service")
    public String XmlTask();

    @DefaultStringValue("Unique identifier service")
    public String XmlUid();

    @DefaultStringValue("Domain service")
    public String XmlDomain();

    @DefaultStringValue("Upgrade service")
    public String XmlUpgrades();

    @DefaultStringValue("User service")
    public String XmlUser();

    @DefaultStringValue("Translation service")
    public String XmlTranslation();

    @DefaultStringValue("Index service")
    public String XmlAnnex();

    @DefaultStringValue("Parameter service")
    public String XmlFieldProcessParam();

    @DefaultStringValue("Codification service")
    public String XmlCodification();

    @DefaultStringValue("Rdv service")
    public String XmlRdv();

    @DefaultStringValue("Authentication service")
    public String IAuthentication();

    @DefaultStringValue("Parameter service")
    public String XmlParameter();

    @DefaultStringValue("ThirdParty service")
    public String XmlThirdParty();

    @DefaultStringValue("Patient service")
    public String XmlPatient();

    @DefaultStringValue("Health check service")
    public String XmlHealthCheck();

    @DefaultStringValue("Bill service")
    public String XmlBill();

    @DefaultStringValue("Instance service")
    public String XmlInstance();
}
