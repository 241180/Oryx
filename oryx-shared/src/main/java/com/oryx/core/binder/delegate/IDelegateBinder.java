package com.oryx.core.binder.delegate;

import com.oryx.core.binder.IBinderHelper;
import com.oryx.core.delegate.IDelegate;
import com.oryx.core.delegate.IDelegateKey;

/**
 * Created by smbarki on 31/03/2017.
 */
public interface IDelegateBinder {

    public static void bind(Class<?> entityClass, IDelegate delegate) {
        IBinderHelper.bind(IDelegateKey.class, entityClass, delegate);
    }

    public static IDelegate getByClassType(Class<?> entityClass) {
        return (IDelegate) IBinderHelper.getObject(IDelegateKey.class, entityClass);
    }
}
