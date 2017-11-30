package com.oryx.core.binder.delegate;

import com.oryx.core.binder.AbstractAutowiredBinder;
import com.oryx.core.binder.IBoundableKey;
import com.oryx.core.binder.IBoundableObject;
import com.oryx.core.delegate.IDelegate;
import com.oryx.core.delegate.IDelegateKey;
import com.oryx.core.provider.ITypeByTokenProvider;
import org.apache.log4j.Logger;

/**
 * Created by smbarki on 31/03/2017.
 */

public abstract class AbstractAutowiredDelegateBinder extends AbstractAutowiredBinder implements IDelegateBinder {
    final static Logger logger = Logger.getLogger(AbstractAutowiredDelegateBinder.class);

    @Override
    public Class<? extends IBoundableKey> getKeyClassType() {
        return IDelegateKey.class;
    }

    @Override
    public Class<? extends IDelegate> getObjectClassType(IBoundableObject boundable) {
        return ((IDelegate) boundable).getTypeByTokenProvider().getClassType(ITypeByTokenProvider.Target.XML_ENTITY);
    }
}
