package com.oryx.core.model;

/**
 * Created by 241180 on 26/01/2017.
 */

public interface SchemaConstantName extends ComSchemaConstantName {
    //Table - System
    public static final String T_PARAMETER = "T_PARAMETER";
    public static final String T_PERSON_UID = "T_PERSON_UID";
    public static final String T_MODEL = "T_MODEL";
    public static final String T_MENU = "T_MENU";
    public static final String T_TASK = "T_TASK";
    public static final String T_ASSO_MENU_TASK = "T_ASSO_MENU_TASK";
    public static final String T_ASSO_ROLE_MENU = "T_ASSO_ROLE_MENU";
    public static final String T_ASSO_USER_ROLE = "T_ASSO_USER_ROLE";
    public static final String T_ASSO_PERSON_CONTACT = "T_ASSO_PERSON_CONTACT";
    public static final String T_ASSO_PERSON_ADRESS = "T_ASSO_PERSON_ADRESS";
    public static final String T_ASSO_THIRD_PARTY_CONTACT = "T_ASSO_THIRD_PARTY_CONTACT";
    public static final String T_ASSO_THIRD_PARTY_ADRESS = "T_ASSO_THIRD_PARTY_ADRESS";
    public static final String T_USER = "T_USER";
    public static final String T_PATIENT = "T_PATIENT";
    public static final String T_ROLE_INFO = "T_ROLE_INFO";
    public static final String T_PERSON = "T_PERSON";
    public static final String T_ADDRESS = "T_ADDRESS";
    public static final String T_ERROR_MESSAGE = "T_ERROR_MESSAGE";
    public static final String T_TRANSLATION = "T_TRANSLATION";
    public static final String T_CONTACT = "T_CONTACT";
    public static final String T_STATE = "T_STATE";
    public static final String T_COUNTRY = "T_COUNTRY";
    public static final String T_UPGRADES = "T_UPGRADES";
    public static final String T_FIELD_PROCESS_PARAM = "T_FIELD_PROCESS_PARAM";
    public static final String T_CODIFICATION = "T_CODIFICATION";
    public static final String T_ANNEX = "T_ANNEX";
    public static final String T_DOMAIN = "T_DOMAIN";
    public static final String T_THIRD_PARTY = "T_THIRD_PARTY";

    //Table - Health
    public static final String T_RDV = "T_RDV";
    public static final String T_HEALTH_CHECK = "T_HEALTH_CHECK";

    //Table - billing
    public static final String T_ACCOUNT = "T_ACCOUNT";
    public static final String T_BILL = "T_BILL";
    public static final String T_BILL_ITEM = "T_BILL_ITEM";
    public static final String T_INSTANCE = "T_INSTANCE";

    //Table - sale
    public static final String T_PRODUCT = "T_PRODUCT";
    public static final String T_PRODUCT_CATEGORY = "T_PRODUCT_CATEGORY";
    public static final String T_BRAND = "T_BRAND";
    public static final String T_CART = "T_CART";
    public static final String T_CART_ITEM = "T_CART_ITEM";
    public static final String T_SHOPPER = "T_SHOPPER";
    public static final String T_STOCK_POSITION = "T_STOCK_POSITION";

    //Column
    public static final String T_PHONE_NUMBER = "PHONE_NUMBER";
    public static final String T_NAME = "NAME";
    public static final String T_MENU_PATH = "MENU_PATH";
    public static final String T_COUNTRY_NAME = "COUNTRY_NAME";
    public static final String T_UID_TYPE = "TYPE";
    public static final String T_UID_VALUE = "VALUE";
    public static final String T_FIRST_NAME = "FIRST_NAME";
    public static final String T_SECOND_NAME = "SECOND_NAME";
    public static final String T_LAST_NAME = "LAST_NAME";
    public static final String T_GENDER = "GENDER";
    public static final String T_CONTACT_TYPE = "TYPE";
    public static final String T_CONTACT_VALUE = "VALUE";
    public static final String T_BIRTH_DATE = "BIRTH_DATE";
    public static final String T_CIVILITY = "CIVILITY";
    public static final String T_ADDRESS_ID = "ADRESS_ID";
    public static final String T_LOGIN = "LOGIN";
    public static final String T_EMAIL = "EMAIL";
    public static final String T_USER_ENABLED = "ENABLED";
    public static final String T_USER_PASSWORD = "PASSWORD";
    public static final String T_START_DATE = "START_DATE";
    public static final String T_END_DATE = "END_DATE";
    public static final String T_LAST_CONNECTION = "LAST_CONNECTION";
    public static final String T_USER_ROLE = "USER_ROLE";
    public static final String T_ROLE_CODE = "ROLE_CODE";
    public static final String T_STATUS = "STATUS";
    public static final String T_REASON = "REASON";
    public static final String T_ROLE_NAME = "ROLE_NAME";
    public static final String T_DESCRIPTION = "DESCRIPTION";
    public static final String T_REFERENCE = "REFERENCE";
    public static final String T_PROCESS_CODE = "PROCESS_CODE";
    public static final String T_FIELD_CODE = "FIELD_CODE";
    public static final String T_PROCESS_REF = "PROCESS_REF";
    public static final String T_PROCESS_TYPE = "PROCESS_TYPE";
    public static final String T_PROCESS_RESULT = "PROCESS_RESULT";
    public static final String T_STREET = "STREET";
    public static final String T_LATITUDE = "LATITUDE";
    public static final String T_LONGITUDE = "LONGITUDE";
    public static final String T_ALTITUDE = "ALTITUDE";
    public static final String T_STATE_ID = "STATE_ID";
    public static final String T_BIRTH_STATE_ID = "BIRTH_STATE_ID";
    public static final String T_COUNTRY_ID = "COUNTRY_ID";
    public static final String T_POSTAL_CODE = "POSTAL_CODE";
    public static final String T_POL_CAPITAL_ID = "POL_CAPITAL_ID";
    public static final String T_ECO_CAPITAL_ID = "ECO_CAPITAL_ID";
    public static final String T_PERSON_ID = "PERSON_ID";
    public static final String T_PRODUCT_ID = "PRODUCT_ID";
    public static final String T_BRAND_ID = "BRAND_ID";
    public static final String T_CATEGORY_ID = "CATEGORY_ID";
    public static final String T_THIRD_PARTY_ID = "THIRD_PARTY_ID";
    public static final String T_HOST_ID = "HOST_ID";
    public static final String T_GUEST_ID = "GUEST_ID";
    public static final String T_TASK_ID = "TASK_ID";
    public static final String T_MENU_ID = "MENU_ID";
    public static final String T_CONTACT_ID = "CONTACT_ID";
    public static final String T_ADRESS_ID = "ADRESS_ID";
    public static final String T_ROLE_ID = "ROLE_ID";
    public static final String T_USER_ID = "USER_ID";
    public static final String T_SOFTWARE_VERSION = "SOFTWARE_VERSION";
    public static final String T_SERVER_CODE = "SERVER_CODE";
    public static final String T_EXTERNAL_CODE = "EXTERNAL_CODE";
    public static final String T_INTERNAL_CODE = "INTERNAL_CODE";
    public static final String T_STAT_DATE = "STAT_DATE";
    public static final String T_ANNEX_CODE = "CODE";
    public static final String T_DOMAIN_CODE = "CODE";
    public static final String T_LANGUAGE_CODE = "LANGUAGE_CODE";
    public static final String T_TEXT = "TEXT";
    public static final String T_TEXT_TRANSLATION = "TRANSLATION";
    public static final String T_ANNEX_VALUE = "VALUE";
    public static final String T_PARAMETER_VALUE = "VALUE";
    public static final String T_ANNEX_REFERENCE = "REFERENCE";
    public static final String T_PARAMETER_REFERENCE = "REFERENCE";
    public static final String T_DOMAIN_REFERENCE = "REFERENCE";
    public static final String T_RDV_DATE = "RDV_DATE";
    public static final String T_RDV_DURATION = "RDV_DURATION";
    public static final String T_AMOUNT = "AMOUNT";
    public static final String T_GROSS_AMOUNT = "GROSS_AMOUNT";
    public static final String T_TAX = "TAX";
    public static final String T_CALCULATION_DATE = "CALCULATION_DATE";
    public static final String T_ISSUE_DATE = "ISSUE_DATE";
    public static final String T_DUE_DATE = "DUE_DATE";
    public static final String T_EXPIRY_DATE = "EXPIRY_DATE";
    public static final String T_DELIVERY_DATE = "DELIVERY_DATE";
    public static final String T_PICKUP_DATE = "PICKUP_DATE";
    public static final String T_STOCK_IN_DATE = "STOCK_IN_DATE";
    public static final String T_STOCK_OUT_DATE = "STOCK_OUT_DATE";
    public static final String T_SETTLEMENT_DATE = "SETTLEMENT_DATE";
    public static final String T_QUANTITY = "QUANTITY";
    public static final String T_UNIT_PRICE = "UNIT_PRICE";
    public static final String T_DISCOUNT = "DISCOUNT";
    public static final String T_BILL_ID = "BILL_ID";
    public static final String T_ACTIVTION_DATE = "ACTIVTION_DATE";
    public static final String T_DEACTIVTION_DATE = "DEACTIVTION_DATE";
    public static final String T_BILL_STATUS = "BILL_STATUS";
    public static final String T_CART_STATUS = "CART_STATUS";
    public static final String T_CART_ID = "CART_ID";
}
