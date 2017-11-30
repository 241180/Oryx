package com.oryx.core.layout.component;

import com.oryx.core.annotation.capable.IBundleCapable;

import java.util.Collection;

/**
 * Created by smbarki on 10/04/2017.
 */
public interface IBeanView<B> extends IView<B>, IBundleCapable {
    public B getBean();

    public Collection<B> getBeans();

    public void editBean();

    public void createBean();

    public void fetchBeans();

    public void deleteBean();

    public void deleteBeans();

    public void fetchBeansByCriteria();
}
