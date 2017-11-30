package com.oryx.core.module.ui.sub.model.system.ref;

import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.CrudUIConstantsBundle;
import com.oryx.core.gui.crud.system.ref.adress.AdressForm;
import com.oryx.core.gui.crud.system.ref.contact.ContactForm;
import com.oryx.core.gui.crud.system.ref.country.CountryForm;
import com.oryx.core.gui.crud.system.ref.person.PersonForm;
import com.oryx.core.gui.crud.system.ref.state.StateForm;
import com.oryx.core.gui.crud.system.ref.thirdParty.ThirdPartyForm;
import com.oryx.core.gui.crud.system.ref.uid.UidForm;
import com.oryx.core.module.AbstractLayoutModule;
import com.oryx.core.module.ILayoutModule;
import com.oryx.remote.webservice.element.model.system.ref.*;

/**
 * Created by SAMI on 13/03/2017.
 */

@Bundle(classType = CrudUIConstantsBundle.class)
public class SystemRefCrudUIModule extends AbstractLayoutModule {

    @Override
    public ILayoutModule configure() {
        this.bindFormLayout(XmlAdress.class, AdressForm.class);
        this.bindFormLayout(XmlContact.class, ContactForm.class);
        this.bindFormLayout(XmlCountry.class, CountryForm.class);
        this.bindFormLayout(XmlPerson.class, PersonForm.class);
        this.bindFormLayout(XmlState.class, StateForm.class);
        this.bindFormLayout(XmlThirdParty.class, ThirdPartyForm.class);
        this.bindFormLayout(XmlUid.class, UidForm.class);

        return this;
    }
}
