package com.oryx.core.view.bu.health;

import com.oryx.core.annotation.decl.GenEntityEnumeration;
import com.oryx.core.annotation.decl.GenTypeByTokenProvider;
import com.oryx.core.model.system.ref.Country;
import com.oryx.core.model.system.ref.State;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;
import java.util.UUID;

/**
 * Created by 241180 on 09/01/2017.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlPatientView", namespace = "http://health.bu.view.element.webservice.remote.oryx.com")
@GenTypeByTokenProvider(extendType = "com.oryx.core.provider.TypeByTokenProvider")
@GenEntityEnumeration
public class PatientView {
    private String patientCode;
    //private XmlEnumLanguage language;

    //Person
    private String defaultUid;
    private String firstName;
    private String lastName;
    //private XmlEnumCivility civility;
    //private XmlEnumGender gender;
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

    /*public static XmlPatient getXmlPatient(PatientView xmlPatientView){
        XmlPatient xmlPatient = new XmlPatient();
        //xmlPatient.setEmail(xmlPatientView.getEmail());
        return xmlPatient;
    }*/

    /*public static XmlPerson getXmlPerson(PatientView xmlPatientView){
        XmlPerson xmlPerson = new XmlPerson();
        xmlPerson.setDefaultUid(xmlPatientView.getDefaultUid());
        xmlPerson.setFirstName(xmlPatientView.getFirstName());
        xmlPerson.setLastName(xmlPatientView.getLastName());
        xmlPerson.setDefaultPhoneNumber(xmlPatientView.getPhoneNumber1());
        xmlPerson.setCivility(xmlPatientView.getCivility());
        xmlPerson.setGender(xmlPatientView.getGender());
        xmlPerson.setLanguage(xmlPatientView.getLanguage());
        xmlPerson.setBirthDate(xmlPatientView.getBirthDate());
        return xmlPerson;
    }*/
}