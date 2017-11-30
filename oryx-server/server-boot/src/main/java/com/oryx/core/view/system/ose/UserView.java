package com.oryx.core.view.system.ose;

import com.oryx.core.annotation.decl.GenEntityEnumeration;
import com.oryx.core.annotation.decl.GenTypeByTokenProvider;
import com.oryx.core.model.system.ref.Country;
import com.oryx.core.model.system.ref.State;
import com.oryx.remote.webservice.element._enum.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;
import java.util.UUID;

/**
 * Created by 241180 on 09/01/2017.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlUserView", namespace = "http://ose.system.view.element.webservice.remote.oryx.com")
@GenTypeByTokenProvider(extendType = "com.oryx.core.provider.TypeByTokenProvider")
@GenEntityEnumeration
public class UserView {
    private String userCode;
    private String userLogin;
    private String userPassword;
    private XmlEnumLanguage language;
    private XmlEnumUserRole role;
    private XmlEnumStatus status;
    private Date startDate;
    private Date endDate;

    //Person
    private String defaultUid;
    private String firstName;
    private String lastName;
    private XmlEnumCivility civility;
    private XmlEnumGender gender;
    private Date birthDate;

    //birthPlace
    private State birthCity;
    private UUID birthCityId;
    private Country birthCountry;
    private UUID birthCountryId;

    //Adress
    private String adressStreet;
    private State adressCity;
    private UUID adressCityId;
    private Country adressCountry;
    private UUID adressCountryId;

    //Contact
    private String phoneNumber_1;
    private String phoneNumber_2;
    private String email;
}