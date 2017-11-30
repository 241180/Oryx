package com.oryx.core.module.service.sub.model.system.ref;

import com.oryx.core.annotation.decl.Bundle;
import com.oryx.core.bundle.CrudServiceConstantsBundle;
import com.oryx.core.delegate.system.ref.*;
import com.oryx.core.module.AbstractServiceModule;
import com.oryx.core.module.IModule;
import com.oryx.remote.webservice.element._enum.*;
import com.oryx.remote.webservice.element.model.system.ref.*;

/**
 * Created by SAMI on 13/03/2017.
 */

@Bundle(classType = CrudServiceConstantsBundle.class)
public class SystemRefCrudServiceModule extends AbstractServiceModule {

    @Override
    public IModule configure() {
        super.configure();
        this.bindService(XmlAdress.class, AdressServiceDelegate.class, AdressServices.class);
        this.bindService(XmlContact.class, ContactServiceDelegate.class, ContactServices.class);
        this.bindService(XmlCountry.class, CountryServiceDelegate.class, CountryServices.class);
        this.bindService(XmlPerson.class, PersonServiceDelegate.class, PersonServices.class);
        this.bindService(XmlState.class, StateServiceDelegate.class, StateServices.class);
        this.bindService(XmlThirdParty.class, ThirdPartyServiceDelegate.class, ThirdPartyServices.class);
        this.bindService(XmlUid.class, UidServiceDelegate.class, UidServices.class);


        return this;
    }
}
