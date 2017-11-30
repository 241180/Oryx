package com.oryx.remote.service.entry.factory.model;

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

public class ModelFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.oryx.remote.webservice.element.model
     */
    public ModelFactory() {
    }

    /**
     * Create an instance of {@link Bill }
     */
    public Bill createBill() {
        return new Bill();
    }

    /**
     * Create an instance of {@link Bill }
     */
    public BillItem createBillItem() {
        return new BillItem();
    }

    /**
     * Create an instance of {@link Bill }
     */
    public Account createAccount() {
        return new Account();
    }

    /**
     * Create an instance of {@link Instance }
     */
    public Instance createInstance() {
        return new Instance();
    }

    /**
     * Create an instance of {@link HealthCheck }
     */
    public HealthCheck createHealthCheck() {
        return new HealthCheck();
    }

    /**
     * Create an instance of {@link Rdv }
     */
    public Rdv createRdv() {
        return new Rdv();
    }

    /**
     * Create an instance of {@link Patient }
     */
    public Patient createPatient() {
        return new Patient();
    }

    /**
     * Create an instance of {@link Person }
     */
    public Person createPerson() {
        return new Person();
    }

    /**
     * Create an instance of {@link State }
     */
    public State createState() {
        return new State();
    }

    /**
     * Create an instance of {@link Country }
     */
    public Country createCountry() {
        return new Country();
    }

    /**
     * Create an instance of {@link Adress }
     */
    public Adress createAdress() {
        return new Adress();
    }

    /**
     * Create an instance of {@link Uid }
     */
    public Uid createUid() {
        return new Uid();
    }

    /**
     * Create an instance of {@link Contact }
     */
    public Contact createContact() {
        return new Contact();
    }

    /**
     * Create an instance of {@link ErrorMessage }
     */
    public ErrorMessage createErrorMessage() {
        return new ErrorMessage();
    }

    /**
     * Create an instance of {@link Translation }
     */
    public Translation createTranslation() {
        return new Translation();
    }

    /**
     * Create an instance of {@link Annex }
     */
    public Annex createAnnex() {
        return new Annex();
    }

    /**
     * Create an instance of {@link Parameter }
     */
    public Parameter createParameter() {
        return new Parameter();
    }

    /**
     * Create an instance of {@link Codification }
     */
    public Codification createCodification() {
        return new Codification();
    }

    /**
     * Create an instance of {@link Domain }
     */
    public Domain createDomain() {
        return new Domain();
    }

    /**
     * Create an instance of {@link FieldProcessParam }
     */
    public FieldProcessParam createFieldProcessParam() {
        return new FieldProcessParam();
    }

    /**
     * Create an instance of {@link Menu }
     */
    public Menu createMenu() {
        return new Menu();
    }

    /**
     * Create an instance of {@link Task }
     */
    public Task createTask() {
        return new Task();
    }

    /**
     * Create an instance of {@link RoleInfo }
     */
    public RoleInfo createRoleInfo() {
        return new RoleInfo();
    }

    /**
     * Create an instance of {@link Upgrades }
     */
    public Upgrades createUpgrades() {
        return new Upgrades();
    }

    /**
     * Create an instance of {@link User }
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link ThirdParty }
     */
    public ThirdParty createThirdParty() {
        return new ThirdParty();
    }

    /**
     * Create an instance of {@link ThirdParty }
     */
    public Product createProduct() {
        return new Product();
    }

    /**
     * Create an instance of {@link Brand }
     */
    public Brand createBrand() {
        return new Brand();
    }

    /**
     * Create an instance of {@link ProductCategory }
     */
    public ProductCategory createProductCategory() {
        return new ProductCategory();
    }

    /**
     * Create an instance of {@link Cart }
     */
    public Cart createCart() {
        return new Cart();
    }

    /**
     * Create an instance of {@link CartItem }
     */
    public CartItem createCartItem() {
        return new CartItem();
    }

    /**
     * Create an instance of {@link Shopper }
     */
    public Shopper createShopper() {
        return new Shopper();
    }

    /**
     * Create an instance of {@link ProductLot }
     */
    public ProductLot createProductLot() {
        return new ProductLot();
    }

    /**
     * Create an instance of {@link StockPosition }
     */
    public StockPosition createStockPosition() {
        return new StockPosition();
    }
}