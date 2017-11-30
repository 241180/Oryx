package com.oryx.core.bundle;

import com.oryx.core.annotation.decl.DefaultStringValue;
import com.oryx.core.bundle.bu.*;

/**
 * Created by 241180 on 13/01/2017.
 */

@DefaultStringValue("Oryx Application")
public interface CrudUIConstantsBundle extends SystemCrudUIConstantsBundle //
        , SaleCrudUIConstantsBundle
        , StockCrudUIConstantsBundle
        , HealthCrudUIConstantsBundle //
        , BillingCrudUIConstantsBundle {
}
