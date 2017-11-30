package com.oryx.core.binder.layout;

import com.oryx.core.binder.IBinderHelper;
import com.oryx.core.gui.ILayout;
import com.oryx.core.gui.ILayoutKey;

/**
 * Created by smbarki on 31/03/2017.
 */
public interface ILayoutBinder {

    public static void bind(Class<?> entityClass, ILayout layout) {
        IBinderHelper.bind(ILayoutKey.class, entityClass, layout);
    }

    public static ILayout getByClassType(Class<?> entityClass) {
        return (ILayout) IBinderHelper.getObject(ILayoutKey.class, entityClass);
    }
}
