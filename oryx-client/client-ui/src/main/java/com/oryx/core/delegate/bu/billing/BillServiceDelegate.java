package com.oryx.core.delegate.bu.billing;

import com.oryx.core.annotation.decl.AssoEntityEnum;
import com.oryx.core.annotation.decl.AssoExchangeObjectFactory;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.factory.bu.billing.BillExchangeObjFactory;
import com.oryx.core.provider.typeByToken.model.bu.billing.BillTypeByTokenProvider;
import com.oryx.core.service.AbstractCrudService;
import com.oryx.remote.webservice.element._enum.BillService;
import com.oryx.remote.webservice.element._enum.BillServices;
import com.oryx.remote.webservice.element._enum.XmlEnumObjectType;
import com.oryx.remote.webservice.element.model.bu.billing.XmlBill;
import com.oryx.remote.webservices.service.billservice.CrudRequest;
import com.oryx.remote.webservices.service.billservice.CrudResponse;

import javax.xml.ws.Service;

@AssoEntityEnum(value = XmlEnumObjectType.BILL)
@AssoTypeByTokenProvider(classType = BillTypeByTokenProvider.class)
@AssoExchangeObjectFactory(classType = BillExchangeObjFactory.class)
public class BillServiceDelegate extends AbstractCrudService<XmlBill, BillService
        , CrudRequest, CrudResponse> {

    public BillServiceDelegate(Service service) {
        super(service);
    }

    @Override
    public BillService getWebService() {
        return ((BillServices) getService()).getBillServiceSoap11();
    }
}
