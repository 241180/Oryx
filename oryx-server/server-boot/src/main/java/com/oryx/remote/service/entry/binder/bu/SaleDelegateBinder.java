package com.oryx.remote.service.entry.binder.bu;

import com.oryx.core.binder.delegate.AbstractAutowiredDelegateBinder;
import com.oryx.core.service.bu.sale.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by smbarki on 31/03/2017.
 */

@Service
public class SaleDelegateBinder extends AbstractAutowiredDelegateBinder {
    final static Logger logger = Logger.getLogger(SaleDelegateBinder.class);

    @Autowired
    private ProductServiceDelegate productServiceDelegate;

    @Autowired
    private ProductCategoryServiceDelegate productCategoryServiceDelegate;

    @Autowired
    private BrandServiceDelegate brandServiceDelegate;

    @Autowired
    private CartServiceDelegate cartServiceDelegate;

    @Autowired
    private CartItemServiceDelegate cartItemServiceDelegate;

    @Autowired
    private ShopperServiceDelegate shopperServiceDelegate;
}
