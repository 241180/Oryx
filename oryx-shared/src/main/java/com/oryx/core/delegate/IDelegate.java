package com.oryx.core.delegate;

import com.oryx.core.binder.IBoundableObject;
import com.oryx.core.provider.ITypeByTokenProvider;

/**
 * Created by smbarki on 10/08/2017.
 */
public interface IDelegate extends IBoundableObject {
    public ITypeByTokenProvider getTypeByTokenProvider();
}
