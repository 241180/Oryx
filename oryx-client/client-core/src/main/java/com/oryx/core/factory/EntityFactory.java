package com.oryx.core.factory;

import com.oryx.remote.webservice.element.model.bu.billing.XmlAccount;
import com.oryx.remote.webservice.element.model.bu.billing.XmlBill;
import com.oryx.remote.webservice.element.model.bu.billing.XmlBillItem;
import com.oryx.remote.webservice.element.model.bu.billing.XmlInstance;
import com.oryx.remote.webservice.element.model.bu.health.XmlHealthCheck;
import com.oryx.remote.webservice.element.model.bu.health.XmlPatient;
import com.oryx.remote.webservice.element.model.bu.health.XmlRdv;
import com.oryx.remote.webservice.element.model.bu.sale.*;
import com.oryx.remote.webservice.element.model.bu.stock.XmlProductLot;
import com.oryx.remote.webservice.element.model.bu.stock.XmlStockPosition;
import com.oryx.remote.webservice.element.model.system.msg.XmlErrorMessage;
import com.oryx.remote.webservice.element.model.system.msg.XmlTranslation;
import com.oryx.remote.webservice.element.model.system.ose.*;
import com.oryx.remote.webservice.element.model.system.ref.*;
import com.oryx.remote.webservice.element.view.bu.health.XmlPatientView;
import com.oryx.remote.webservice.element.view.system.ose.XmlUserView;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * Created by 241180 on 04/01/2017.
 */

@Component
public class EntityFactory extends AbstractFactory {
    final static Logger logger = Logger.getLogger(EntityFactory.class);

    private com.oryx.remote.webservice.element.model.system.ref.ObjectFactory xmlRefFactory = new com.oryx.remote.webservice.element.model.system.ref.ObjectFactory();
    private com.oryx.remote.webservice.element.model.system.ose.ObjectFactory xmlOseFactory = new com.oryx.remote.webservice.element.model.system.ose.ObjectFactory();
    private com.oryx.remote.webservice.element.model.system.msg.ObjectFactory xmlMsgFactory = new com.oryx.remote.webservice.element.model.system.msg.ObjectFactory();

    private com.oryx.remote.webservice.element.model.bu.billing.ObjectFactory xmlBillingFactory = new com.oryx.remote.webservice.element.model.bu.billing.ObjectFactory();
    private com.oryx.remote.webservice.element.model.bu.stock.ObjectFactory xmlStockFactory = new com.oryx.remote.webservice.element.model.bu.stock.ObjectFactory();
    private com.oryx.remote.webservice.element.model.bu.sale.ObjectFactory xmlSaleFactory = new com.oryx.remote.webservice.element.model.bu.sale.ObjectFactory();
    private com.oryx.remote.webservice.element.model.bu.health.ObjectFactory xmlHealthFactory = new com.oryx.remote.webservice.element.model.bu.health.ObjectFactory();

    private com.oryx.remote.webservice.element.view.system.ose.ObjectFactory xmlOseViewFactory = new com.oryx.remote.webservice.element.view.system.ose.ObjectFactory();
    private com.oryx.remote.webservice.element.view.bu.health.ObjectFactory xmlHealthViewFactory = new com.oryx.remote.webservice.element.view.bu.health.ObjectFactory();

    @Override
    public Object create(Class<?> clazz) {
        //System
        if (clazz == XmlAdress.class) {
            return (Object) xmlRefFactory.createXmlAdress();

        } else if (clazz == XmlState.class) {
            return (Object) xmlRefFactory.createXmlState();

        } else if (clazz == XmlContact.class) {
            return (Object) xmlRefFactory.createXmlContact();

        } else if (clazz == XmlCountry.class) {
            return (Object) xmlRefFactory.createXmlCountry();

        } else if (clazz == XmlMenu.class) {
            return (Object) xmlOseFactory.createXmlMenu();

        } else if (clazz == XmlAnnex.class) {
            return (Object) xmlOseFactory.createXmlAnnex();

        } else if (clazz == XmlPerson.class) {
            return (Object) xmlRefFactory.createXmlPerson();

        } else if (clazz == XmlRoleInfo.class) {
            return (Object) xmlOseFactory.createXmlRoleInfo();

        } else if (clazz == XmlTask.class) {
            return (Object) xmlOseFactory.createXmlTask();

        } else if (clazz == XmlUser.class) {
            return (Object) xmlOseFactory.createXmlUser();

        } else if (clazz == XmlUpgrades.class) {
            return (Object) xmlOseFactory.createXmlUpgrades();

        } else if (clazz == XmlUid.class) {
            return (Object) xmlRefFactory.createXmlUid();

        } else if (clazz == XmlDomain.class) {
            return (Object) xmlOseFactory.createXmlDomain();

        } else if (clazz == XmlFieldProcessParam.class) {
            return (Object) xmlOseFactory.createXmlFieldProcessParam();

        } else if (clazz == XmlParameter.class) {
            return (Object) xmlOseFactory.createXmlParameter();

        } else if (clazz == XmlTranslation.class) {
            return (Object) xmlMsgFactory.createXmlTranslation();

        } else if (clazz == XmlErrorMessage.class) {
            return (Object) xmlMsgFactory.createXmlErrorMessage();

        } else if (clazz == XmlThirdParty.class) {
            return (Object) xmlRefFactory.createXmlThirdParty();

            //Health
        } else if (clazz == XmlRdv.class) {
            return (Object) xmlHealthFactory.createXmlRdv();

        } else if (clazz == XmlHealthCheck.class) {
            return (Object) xmlHealthFactory.createXmlHealthCheck();

        } else if (clazz == XmlPatient.class) {
            return (Object) xmlHealthFactory.createXmlPatient();

            //Billing
        } else if (clazz == XmlBill.class) {
            return (Object) xmlBillingFactory.createXmlBill();

        } else if (clazz == XmlBillItem.class) {
            return (Object) xmlBillingFactory.createXmlBillItem();

        } else if (clazz == XmlAccount.class) {
            return (Object) xmlBillingFactory.createXmlAccount();

        } else if (clazz == XmlInstance.class) {
            return (Object) xmlBillingFactory.createXmlInstance();

            //sale
        } else if (clazz == XmlProduct.class) {
            return (Object) xmlSaleFactory.createXmlProduct();

        } else if (clazz == XmlProductCategory.class) {
            return (Object) xmlSaleFactory.createXmlProductCategory();

        } else if (clazz == XmlCart.class) {
            return (Object) xmlSaleFactory.createXmlCart();

        } else if (clazz == XmlCartItem.class) {
            return (Object) xmlSaleFactory.createXmlCartItem();

        } else if (clazz == XmlShopper.class) {
            return (Object) xmlSaleFactory.createXmlShopper();

        } else if (clazz == XmlBrand.class) {
            return (Object) xmlSaleFactory.createXmlBrand();

            //stock
        } else if (clazz == XmlStockPosition.class) {
            return (Object) xmlStockFactory.createXmlStockPosition();

        } else if (clazz == XmlProductLot.class) {
            return (Object) xmlStockFactory.createXmlProductLot();

            //Views
        } else if (clazz == XmlUserView.class) {
            return (Object) xmlOseViewFactory.createXmlUserView();

        } else if (clazz == XmlPatientView.class) {
            return (Object) xmlHealthViewFactory.createXmlPatientView();

        } else {
            logger.error("EntityFactory does not implement creation rule for " + clazz.getSimpleName());
            return null;
        }
    }
}
