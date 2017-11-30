package com.oryx.remote.service.entry.binder.bu;

import com.oryx.core.binder.delegate.AbstractAutowiredDelegateBinder;
import com.oryx.core.service.bu.billing.AccountServiceDelegate;
import com.oryx.core.service.bu.billing.BillItemServiceDelegate;
import com.oryx.core.service.bu.billing.BillServiceDelegate;
import com.oryx.core.service.bu.billing.InstanceServiceDelegate;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by smbarki on 31/03/2017.
 */

@Service
public class BillingDelegateBinder extends AbstractAutowiredDelegateBinder {
    final static Logger logger = Logger.getLogger(BillingDelegateBinder.class);

    @Autowired
    private BillServiceDelegate billServiceDelegate;
    @Autowired
    private BillItemServiceDelegate billItemServiceDelegate;
    @Autowired
    private AccountServiceDelegate accountServiceDelegate;
    @Autowired
    private InstanceServiceDelegate instanceServiceDelegate;
}
