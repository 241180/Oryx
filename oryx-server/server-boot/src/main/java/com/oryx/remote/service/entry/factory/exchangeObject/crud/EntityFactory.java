package com.oryx.remote.service.entry.factory.exchangeObject.crud;

import com.oryx.core.factory.AbstractFactory;
import com.oryx.core.model.bu.billing.Account;
import com.oryx.core.model.bu.billing.Bill;
import com.oryx.core.model.bu.billing.BillItem;
import com.oryx.core.model.bu.billing.Instance;
import com.oryx.core.model.bu.health.HealthCheck;
import com.oryx.core.model.bu.health.Patient;
import com.oryx.core.model.bu.health.Rdv;
import com.oryx.core.model.bu.sale.*;
import com.oryx.core.model.bu.stock.ProductLot;
import com.oryx.core.model.bu.stock.StockPosition;
import com.oryx.core.model.system.msg.ErrorMessage;
import com.oryx.core.model.system.msg.Translation;
import com.oryx.core.model.system.ose.*;
import com.oryx.core.model.system.ref.*;
import com.oryx.core.view.system.ose.UserView;
import com.oryx.remote.service.entry.factory.model.ModelFactory;
import com.oryx.remote.service.entry.factory.model.ViewFactory;
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
    private com.oryx.remote.webservice.element.model.bu.health.ObjectFactory xmlHealthFactory = new com.oryx.remote.webservice.element.model.bu.health.ObjectFactory();
    private com.oryx.remote.webservice.element.model.bu.sale.ObjectFactory xmlSaleFactory = new com.oryx.remote.webservice.element.model.bu.sale.ObjectFactory();
    private com.oryx.remote.webservice.element.model.bu.stock.ObjectFactory xmlStockFactory = new com.oryx.remote.webservice.element.model.bu.stock.ObjectFactory();

    private com.oryx.remote.webservice.element.view.system.ose.ObjectFactory xmlViewFactory = new com.oryx.remote.webservice.element.view.system.ose.ObjectFactory();

    private ModelFactory modelFactory = new ModelFactory();
    private ViewFactory viewFactory = new ViewFactory();

    @Override
    public Object create(Class<?> clazz) {
        //System
        if (clazz == XmlAnnex.class) {
            return (Object) xmlOseFactory.createXmlAnnex();
        } else if (clazz == Annex.class) {
            return (Object) modelFactory.createAnnex();

        } else if (clazz == XmlParameter.class) {
            return (Object) xmlOseFactory.createXmlParameter();
        } else if (clazz == Parameter.class) {
            return (Object) modelFactory.createParameter();

        } else if (clazz == XmlFieldProcessParam.class) {
            return (Object) xmlOseFactory.createXmlFieldProcessParam();
        } else if (clazz == FieldProcessParam.class) {
            return (Object) modelFactory.createFieldProcessParam();

        } else if (clazz == XmlAdress.class) {
            return (Object) xmlRefFactory.createXmlAdress();
        } else if (clazz == Adress.class) {
            return (Object) modelFactory.createAdress();

        } else if (clazz == XmlState.class) {
            return (Object) xmlRefFactory.createXmlState();
        } else if (clazz == State.class) {
            return (Object) modelFactory.createState();

        } else if (clazz == XmlContact.class) {
            return (Object) xmlRefFactory.createXmlContact();
        } else if (clazz == Contact.class) {
            return (Object) modelFactory.createContact();

        } else if (clazz == XmlCountry.class) {
            return (Object) xmlRefFactory.createXmlCountry();
        } else if (clazz == Country.class) {
            return (Object) modelFactory.createCountry();

        } else if (clazz == XmlMenu.class) {
            return (Object) xmlOseFactory.createXmlMenu();
        } else if (clazz == Menu.class) {
            return (Object) modelFactory.createMenu();

        } else if (clazz == XmlPerson.class) {
            return (Object) xmlRefFactory.createXmlPerson();
        } else if (clazz == Person.class) {
            return (Object) modelFactory.createPerson();

        } else if (clazz == XmlRoleInfo.class) {
            return (Object) xmlOseFactory.createXmlRoleInfo();
        } else if (clazz == RoleInfo.class) {
            return (Object) modelFactory.createRoleInfo();

        } else if (clazz == XmlTask.class) {
            return (Object) xmlOseFactory.createXmlTask();
        } else if (clazz == Task.class) {
            return (Object) modelFactory.createTask();

        } else if (clazz == XmlUser.class) {
            return (Object) xmlOseFactory.createXmlUser();
        } else if (clazz == User.class) {
            return (Object) modelFactory.createUser();

        } else if (clazz == XmlUpgrades.class) {
            return (Object) xmlOseFactory.createXmlUpgrades();
        } else if (clazz == Upgrades.class) {
            return (Object) modelFactory.createUpgrades();

        } else if (clazz == XmlUid.class) {
            return (Object) xmlRefFactory.createXmlUid();
        } else if (clazz == Uid.class) {
            return (Object) modelFactory.createUid();

        } else if (clazz == XmlDomain.class) {
            return (Object) xmlOseFactory.createXmlDomain();
        } else if (clazz == Domain.class) {
            return (Object) modelFactory.createDomain();

        } else if (clazz == XmlTranslation.class) {
            return (Object) xmlMsgFactory.createXmlTranslation();
        } else if (clazz == Translation.class) {
            return (Object) modelFactory.createTranslation();

        } else if (clazz == XmlErrorMessage.class) {
            return (Object) xmlMsgFactory.createXmlErrorMessage();
        } else if (clazz == ErrorMessage.class) {
            return (Object) modelFactory.createErrorMessage();

        } else if (clazz == XmlThirdParty.class) {
            return (Object) xmlRefFactory.createXmlThirdParty();
        } else if (clazz == ThirdParty.class) {
            return (Object) modelFactory.createThirdParty();

            //Health
        } else if (clazz == XmlRdv.class) {
            return (Object) xmlHealthFactory.createXmlRdv();
        } else if (clazz == Rdv.class) {
            return (Object) modelFactory.createRdv();

        } else if (clazz == XmlHealthCheck.class) {
            return (Object) xmlHealthFactory.createXmlHealthCheck();
        } else if (clazz == HealthCheck.class) {
            return (Object) modelFactory.createHealthCheck();

        } else if (clazz == XmlPatient.class) {
            return (Object) xmlHealthFactory.createXmlPatient();
        } else if (clazz == Patient.class) {
            return (Object) modelFactory.createPatient();

            //Billing
        } else if (clazz == XmlBill.class) {
            return (Object) xmlBillingFactory.createXmlBill();
        } else if (clazz == Bill.class) {
            return (Object) modelFactory.createBill();

        } else if (clazz == XmlBillItem.class) {
            return (Object) xmlBillingFactory.createXmlBillItem();
        } else if (clazz == BillItem.class) {
            return (Object) modelFactory.createBillItem();

        } else if (clazz == XmlAccount.class) {
            return (Object) xmlBillingFactory.createXmlAccount();
        } else if (clazz == Account.class) {
            return (Object) modelFactory.createAccount();

        } else if (clazz == XmlInstance.class) {
            return (Object) xmlBillingFactory.createXmlInstance();
        } else if (clazz == Instance.class) {
            return (Object) modelFactory.createInstance();

            //Sale
        } else if (clazz == XmlProduct.class) {
            return (Object) xmlSaleFactory.createXmlProduct();
        } else if (clazz == Product.class) {
            return (Object) modelFactory.createProduct();

        } else if (clazz == XmlBrand.class) {
            return (Object) xmlSaleFactory.createXmlBrand();
        } else if (clazz == Brand.class) {
            return (Object) modelFactory.createBrand();

        } else if (clazz == XmlProductCategory.class) {
            return (Object) xmlSaleFactory.createXmlProductCategory();
        } else if (clazz == ProductCategory.class) {
            return (Object) modelFactory.createProductCategory();

        } else if (clazz == XmlCart.class) {
            return (Object) xmlSaleFactory.createXmlCart();
        } else if (clazz == Cart.class) {
            return (Object) modelFactory.createCart();

        } else if (clazz == XmlCartItem.class) {
            return (Object) xmlSaleFactory.createXmlCartItem();
        } else if (clazz == CartItem.class) {
            return (Object) modelFactory.createCartItem();

        } else if (clazz == XmlShopper.class) {
            return (Object) xmlSaleFactory.createXmlShopper();
        } else if (clazz == Shopper.class) {
            return (Object) modelFactory.createShopper();

            //Sale
        } else if (clazz == XmlProductLot.class) {
            return (Object) xmlStockFactory.createXmlProductLot();
        } else if (clazz == ProductLot.class) {
            return (Object) modelFactory.createProductLot();

        } else if (clazz == XmlStockPosition.class) {
            return (Object) xmlStockFactory.createXmlStockPosition();
        } else if (clazz == StockPosition.class) {
            return (Object) modelFactory.createStockPosition();

            //Views
        } else if (clazz == XmlUserView.class) {
            return (Object) xmlViewFactory.createXmlUserView();
        } else if (clazz == UserView.class) {
            return (Object) viewFactory.createUserView();

        } else {
            logger.error("EntityFactory does not implement creation rule for " + clazz.getSimpleName());
            return null;
        }
    }
}
