package com.oryx.core.delegate.bu.billing;

import com.oryx.core.annotation.decl.AssoEntityEnum;
import com.oryx.core.annotation.decl.AssoExchangeObjectFactory;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.factory.bu.billing.BillItemExchangeObjFactory;
import com.oryx.core.provider.typeByToken.model.bu.billing.BillItemTypeByTokenProvider;
import com.oryx.core.service.AbstractCrudService;
import com.oryx.remote.webservice.element._enum.BillItemService;
import com.oryx.remote.webservice.element._enum.BillItemServices;
import com.oryx.remote.webservice.element._enum.XmlEnumObjectType;
import com.oryx.remote.webservice.element.model.bu.billing.XmlBillItem;
import com.oryx.remote.webservices.service.billitemservice.CrudRequest;
import com.oryx.remote.webservices.service.billitemservice.CrudResponse;

import javax.xml.ws.Service;

@AssoEntityEnum(value = XmlEnumObjectType.BILLITEM)
@AssoTypeByTokenProvider(classType = BillItemTypeByTokenProvider.class)
@AssoExchangeObjectFactory(classType = BillItemExchangeObjFactory.class)
public class BillItemServiceDelegate extends AbstractCrudService<XmlBillItem, BillItemService
        , CrudRequest, CrudResponse> {

    public BillItemServiceDelegate(Service service) {
        super(service);
    }

    @Override
    public BillItemService getWebService() {
        return ((BillItemServices) getService()).getBillItemServiceSoap11();
    }
}
