package com.oryx.core.binder;

import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;

/**
 * Created by smbarki on 31/03/2017.
 */

public abstract class AbstractBinder implements IBinder {
    final static Logger logger = Logger.getLogger(AbstractBinder.class);

    @Override
    @PostConstruct
    public final void mainConfigure() {
        configure();
    }
}
