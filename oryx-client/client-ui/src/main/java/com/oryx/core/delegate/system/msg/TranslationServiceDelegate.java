package com.oryx.core.delegate.system.msg;

import com.oryx.core.annotation.decl.AssoEntityEnum;
import com.oryx.core.annotation.decl.AssoExchangeObjectFactory;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.factory.system.msg.TranslationExchangeObjFactory;
import com.oryx.core.provider.typeByToken.model.system.msg.TranslationTypeByTokenProvider;
import com.oryx.core.service.AbstractCrudService;
import com.oryx.remote.webservice.element._enum.TranslationService;
import com.oryx.remote.webservice.element._enum.TranslationServices;
import com.oryx.remote.webservice.element._enum.XmlEnumObjectType;
import com.oryx.remote.webservice.element.model.system.msg.XmlTranslation;
import com.oryx.remote.webservices.service.translationservice.CrudRequest;
import com.oryx.remote.webservices.service.translationservice.CrudResponse;

import javax.xml.ws.Service;

@AssoEntityEnum(value = XmlEnumObjectType.TRANSLATION)
@AssoTypeByTokenProvider(classType = TranslationTypeByTokenProvider.class)
@AssoExchangeObjectFactory(classType = TranslationExchangeObjFactory.class)
public class TranslationServiceDelegate extends AbstractCrudService<XmlTranslation, TranslationService
        , CrudRequest, CrudResponse> {

    public TranslationServiceDelegate(Service service) {
        super(service);
    }

    @Override
    public TranslationService getWebService() {
        return ((TranslationServices) getService()).getTranslationServiceSoap11();
    }
}
