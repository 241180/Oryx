package com.oryx.core.delegate.bu.billing;

import com.oryx.core.annotation.decl.AssoEntityEnum;
import com.oryx.core.annotation.decl.AssoExchangeObjectFactory;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.factory.bu.billing.AccountExchangeObjFactory;
import com.oryx.core.provider.typeByToken.model.bu.billing.AccountTypeByTokenProvider;
import com.oryx.core.service.AbstractCrudService;
import com.oryx.remote.webservice.element._enum.AccountService;
import com.oryx.remote.webservice.element._enum.AccountServices;
import com.oryx.remote.webservice.element._enum.XmlEnumObjectType;
import com.oryx.remote.webservice.element.model.bu.billing.XmlAccount;
import com.oryx.remote.webservices.service.accountservice.CrudRequest;
import com.oryx.remote.webservices.service.accountservice.CrudResponse;

import javax.xml.ws.Service;

@AssoEntityEnum(value = XmlEnumObjectType.ACCOUNT)
@AssoTypeByTokenProvider(classType = AccountTypeByTokenProvider.class)
@AssoExchangeObjectFactory(classType = AccountExchangeObjFactory.class)
public class AccountServiceDelegate extends AbstractCrudService<XmlAccount, AccountService
        , CrudRequest, CrudResponse> {

    public AccountServiceDelegate(Service service) {
        super(service);
    }

    @Override
    public AccountService getWebService() {
        return ((AccountServices) getService()).getAccountServiceSoap11();
    }
}
