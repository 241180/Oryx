package com.oryx.remote.service.entry.endpoint.crud.namespace;

/**
 * Created by 241180 on 06/03/2017.
 */
public interface TargetNameSpace {
    static final String CRUD_REQUEST_LOCAL_PORT = "crudRequest";

    static final String TARGET_NAMESPACE_BASE = "http://com/oryx/remote/webservices/service/";

    //system
    static final String TARGET_NAMESPACE_PERSON = TARGET_NAMESPACE_BASE + "personservice";
    static final String TARGET_NAMESPACE_USER = TARGET_NAMESPACE_BASE + "userservice";
    static final String TARGET_NAMESPACE_ADRESS = TARGET_NAMESPACE_BASE + "adressservice";
    static final String TARGET_NAMESPACE_STATE = TARGET_NAMESPACE_BASE + "stateservice";
    static final String TARGET_NAMESPACE_CONTACT = TARGET_NAMESPACE_BASE + "contactservice";
    static final String TARGET_NAMESPACE_COUNTRY = TARGET_NAMESPACE_BASE + "countryservice";
    static final String TARGET_NAMESPACE_ERROR_MESSAGE = TARGET_NAMESPACE_BASE + "errormessageservice";
    static final String TARGET_NAMESPACE_TRANSLATION = TARGET_NAMESPACE_BASE + "translationservice";
    static final String TARGET_NAMESPACE_MENU = TARGET_NAMESPACE_BASE + "menuservice";
    static final String TARGET_NAMESPACE_ROLE_INFO = TARGET_NAMESPACE_BASE + "roleinfoservice";
    static final String TARGET_NAMESPACE_TASK = TARGET_NAMESPACE_BASE + "taskservice";
    static final String TARGET_NAMESPACE_UPGRADES = TARGET_NAMESPACE_BASE + "upgradesservice";
    static final String TARGET_NAMESPACE_UID = TARGET_NAMESPACE_BASE + "uidservice";
    static final String TARGET_NAMESPACE_ANNEX = TARGET_NAMESPACE_BASE + "annexservice";
    static final String TARGET_NAMESPACE_PARAMETER = TARGET_NAMESPACE_BASE + "parameterservice";
    static final String TARGET_NAMESPACE_CODIFICATION = TARGET_NAMESPACE_BASE + "codificationservice";
    static final String TARGET_NAMESPACE_FIELD_PROCESS_PARAM = TARGET_NAMESPACE_BASE + "fieldprocessparamservice";
    static final String TARGET_NAMESPACE_DOMAIN = TARGET_NAMESPACE_BASE + "domainservice";
    static final String TARGET_NAMESPACE_THIRD_PARTY = TARGET_NAMESPACE_BASE + "thirdpartyservice";

    //health
    static final String TARGET_NAMESPACE_RDV = TARGET_NAMESPACE_BASE + "rdvservice";
    static final String TARGET_NAMESPACE_HEALTH_CHECK = TARGET_NAMESPACE_BASE + "healthcheckservice";
    static final String TARGET_NAMESPACE_PATIENT = TARGET_NAMESPACE_BASE + "patientservice";

    //billing
    static final String TARGET_NAMESPACE_BILL = TARGET_NAMESPACE_BASE + "billservice";
    static final String TARGET_NAMESPACE_BILL_ITEM = TARGET_NAMESPACE_BASE + "billitemservice";
    static final String TARGET_NAMESPACE_ACCOUNT = TARGET_NAMESPACE_BASE + "accountservice";
    static final String TARGET_NAMESPACE_INSTANCE = TARGET_NAMESPACE_BASE + "instanceservice";

    //sale
    static final String TARGET_NAMESPACE_PRODUCT = TARGET_NAMESPACE_BASE + "productservice";
    static final String TARGET_NAMESPACE_PRODUCT_CATEGORY = TARGET_NAMESPACE_BASE + "productcategoryservice";
    static final String TARGET_NAMESPACE_BRAND = TARGET_NAMESPACE_BASE + "brandservice";
    static final String TARGET_NAMESPACE_CART = TARGET_NAMESPACE_BASE + "cartservice";
    static final String TARGET_NAMESPACE_CART_ITEM = TARGET_NAMESPACE_BASE + "cartitemservice";
    static final String TARGET_NAMESPACE_SHOPPER = TARGET_NAMESPACE_BASE + "shopperservice";

    //stock
    static final String TARGET_NAMESPACE_STOCK_POSITION = TARGET_NAMESPACE_BASE + "stockpositionservice";
    static final String TARGET_NAMESPACE_PRODUCT_LOT = TARGET_NAMESPACE_BASE + "productlotservice";
}
