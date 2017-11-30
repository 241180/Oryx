package com.oryx.core.bundle.system.ref;

import com.oryx.core.annotation.decl.DefaultStringValue;
import com.oryx.core.bundle.common.ICommonConstantBundle;

/**
 * Created by 241180 on 13/01/2017.
 */

@DefaultStringValue("Person details")
public interface PersonConstantsBundle extends ICommonConstantBundle {
    @DefaultStringValue("Person")
    public String XmlPerson();

    @DefaultStringValue("Identificateur unique")
    public String uid();

    @DefaultStringValue("Prenom")
    public String firstName();

    @DefaultStringValue("Nom")
    public String lastName();

    @DefaultStringValue("État civil")
    public String civility();

    @DefaultStringValue("Genre")
    public String gender();

    @DefaultStringValue("Date de naissance")
    public String birthDate();

    @DefaultStringValue("Lieu de naissance")
    public String birthPlaceId();

    @DefaultStringValue("Adresse")
    public String adressIds();

    @DefaultStringValue("Liste des identificateurs unique")
    public String uidIds();

    @DefaultStringValue("Liste des contacts")
    public String contactIds();

    @DefaultStringValue("Married")
    public String MARRIED();

    @DefaultStringValue("Single")
    public String SINGLE();

    @DefaultStringValue("Male")
    public String MALE();

    @DefaultStringValue("Female")
    public String FEMALE();

    @DefaultStringValue("Liste des adresses")
    public String adressSet();

    @DefaultStringValue("Liste des identificateur")
    public String uidSet();

    @DefaultStringValue("Liste des contacts")
    public String contactSet();


    @DefaultStringValue("Phone number")
    public String defaultPhoneNumber();

    @DefaultStringValue("Unique identifier")
    public String defaultUid();
}
