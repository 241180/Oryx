package com.oryx.core.delegate.system.ose;

import com.oryx.core.annotation.decl.AssoEntityEnum;
import com.oryx.core.annotation.decl.AssoExchangeObjectFactory;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.factory.system.ose.AnnexExchangeObjFactory;
import com.oryx.core.provider.typeByToken.model.system.ose.AnnexTypeByTokenProvider;
import com.oryx.core.service.AbstractCrudService;
import com.oryx.remote.webservice.element._enum.AnnexService;
import com.oryx.remote.webservice.element._enum.AnnexServices;
import com.oryx.remote.webservice.element._enum.XmlEnumObjectType;
import com.oryx.remote.webservice.element.model.system.ose.XmlAnnex;
import com.oryx.remote.webservices.service.annexservice.CrudRequest;
import com.oryx.remote.webservices.service.annexservice.CrudResponse;

import javax.xml.ws.Service;

@AssoEntityEnum(value = XmlEnumObjectType.ANNEX)
@AssoTypeByTokenProvider(classType = AnnexTypeByTokenProvider.class)
@AssoExchangeObjectFactory(classType = AnnexExchangeObjFactory.class)
public class AnnexServiceDelegate extends AbstractCrudService<XmlAnnex, AnnexService
        , CrudRequest, CrudResponse> {

    public AnnexServiceDelegate(Service service) {
        super(service);
    }

    @Override
    public AnnexService getWebService() {
        return ((AnnexServices) getService()).getAnnexServiceSoap11();
    }
}
