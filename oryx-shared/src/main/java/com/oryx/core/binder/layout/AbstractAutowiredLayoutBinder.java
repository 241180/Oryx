package com.oryx.core.binder.layout;

import com.oryx.core.binder.AbstractAutowiredBinder;
import com.oryx.core.binder.IBoundableKey;
import com.oryx.core.binder.IBoundableObject;
import com.oryx.core.binder.delegate.IDelegateBinder;
import com.oryx.core.gui.ILayout;
import com.oryx.core.gui.ILayoutKey;
import com.oryx.core.provider.ITypeByTokenProvider;
import org.apache.log4j.Logger;

/**
 * Created by smbarki on 31/03/2017.
 */

public abstract class AbstractAutowiredLayoutBinder extends AbstractAutowiredBinder implements IDelegateBinder {
    final static Logger logger = Logger.getLogger(AbstractAutowiredLayoutBinder.class);

    @Override
    public Class<? extends IBoundableKey> getKeyClassType() {
        return ILayoutKey.class;
    }

    @Override
    public Class<?> getObjectClassType(IBoundableObject boundable) {
        return ((ILayout) boundable).getTypeByTokenProvider().getClassType(ITypeByTokenProvider.Target.XML_ENTITY);
    }
}
