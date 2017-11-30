package com.oryx.remote.service.entry.binder.bu;

import com.oryx.core.binder.delegate.AbstractAutowiredDelegateBinder;
import com.oryx.core.service.bu.stock.ProductLotServiceDelegate;
import com.oryx.core.service.bu.stock.StockPositionServiceDelegate;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by smbarki on 31/03/2017.
 */

@Service
public class StockDelegateBinder extends AbstractAutowiredDelegateBinder {
    final static Logger logger = Logger.getLogger(StockDelegateBinder.class);

    @Autowired
    private ProductLotServiceDelegate productLotServiceDelegate;

    @Autowired
    private StockPositionServiceDelegate stockPositionServiceDelegate;
}
