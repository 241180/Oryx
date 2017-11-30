package com.oryx.core.delegate;

import com.oryx.core.binder.IBoundableKey;
import com.oryx.core.provider.ITypeByTokenProvider;

/**
 * Created by smbarki on 10/08/2017.
 */
public interface IDelegateKey extends IBoundableKey {
    public ITypeByTokenProvider getTypeByTokenProvider();
}
