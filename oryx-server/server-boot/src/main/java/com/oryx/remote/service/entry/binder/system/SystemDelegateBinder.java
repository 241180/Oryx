package com.oryx.remote.service.entry.binder.system;

import com.oryx.core.binder.delegate.AbstractAutowiredDelegateBinder;
import com.oryx.core.service.system.msg.ErrorMessageServiceDelegate;
import com.oryx.core.service.system.msg.TranslationServiceDelegate;
import com.oryx.core.service.system.ose.*;
import com.oryx.core.service.system.ref.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by smbarki on 31/03/2017.
 */

@Service
public class SystemDelegateBinder extends AbstractAutowiredDelegateBinder {
    final static Logger logger = Logger.getLogger(SystemDelegateBinder.class);

    @Autowired
    private ErrorMessageServiceDelegate errorMessageServiceDelegate;
    @Autowired
    private TranslationServiceDelegate translationServiceDelegate;
    @Autowired
    private AnnexServiceDelegate annexServiceDelegate;
    @Autowired
    private ParameterServiceDelegate parameterServiceDelegate;
    @Autowired
    private CodificationServiceDelegate codificationServiceDelegate;
    @Autowired
    private FieldProcessParamServiceDelegate fieldProcessParamServiceDelegate;
    @Autowired
    private MenuServiceDelegate menuServiceDelegate;
    @Autowired
    private RoleInfoServiceDelegate roleInfoServiceDelegate;
    @Autowired
    private TaskServiceDelegate taskServiceDelegate;
    @Autowired
    private UpgradesServiceDelegate upgradesServiceDelegate;
    @Autowired
    private UserServiceDelegate userServiceDelegate;
    @Autowired
    private AdressServiceDelegate adressServiceDelegate;
    @Autowired
    private ContactServiceDelegate contactServiceDelegate;
    @Autowired
    private CountryServiceDelegate countryServiceDelegate;
    @Autowired
    private PersonServiceDelegate personServiceDelegate;
    @Autowired
    private StateServiceDelegate stateServiceDelegate;
    @Autowired
    private UidServiceDelegate uidServiceDelegate;
    @Autowired
    private DomainServiceDelegate domainServiceDelegate;
    @Autowired
    private ThirdPartyServiceDelegate thirdPartyServiceDelegate;

    /*
    @Override
    public Class<? extends IBindable> getKeyClassType() {
        return IDelegate.class;
    }

    @Override
    public Class<?> getObjectClassType(IBindable boundable) {
        return ((ICrudDelegate) boundable).getTypeByTokenProvider().getClassType(ITypeByTokenProvider.Target.XML_ENTITY);
    }
    */
}
