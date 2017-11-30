package com.oryx.core.delegate.system.ose;

import com.oryx.core.annotation.decl.AssoEntityEnum;
import com.oryx.core.annotation.decl.AssoExchangeObjectFactory;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.factory.system.ose.UpgradesExchangeObjFactory;
import com.oryx.core.provider.typeByToken.model.system.ose.UpgradesTypeByTokenProvider;
import com.oryx.core.service.AbstractCrudService;
import com.oryx.remote.webservice.element._enum.UpgradesService;
import com.oryx.remote.webservice.element._enum.UpgradesServices;
import com.oryx.remote.webservice.element._enum.XmlEnumObjectType;
import com.oryx.remote.webservice.element.model.system.ose.XmlUpgrades;
import com.oryx.remote.webservices.service.upgradesservice.CrudRequest;
import com.oryx.remote.webservices.service.upgradesservice.CrudResponse;

import javax.xml.ws.Service;

@AssoEntityEnum(value = XmlEnumObjectType.UPGRADES)
@AssoTypeByTokenProvider(classType = UpgradesTypeByTokenProvider.class)
@AssoExchangeObjectFactory(classType = UpgradesExchangeObjFactory.class)
public class UpgradesServiceDelegate extends AbstractCrudService<XmlUpgrades, UpgradesService
        , CrudRequest, CrudResponse> {

    public UpgradesServiceDelegate(Service service) {
        super(service);
    }

    @Override
    public UpgradesService getWebService() {
        return ((UpgradesServices) getService()).getUpgradesServiceSoap11();
    }
}
