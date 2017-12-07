package com.oryx.core.mvc.search.bean;

import com.oryx.core.mvc.search.AbstractSearchViewController;
import com.oryx.core.mvc.view.AbstractViewController;

/**
 * Created by SAMI on 07/12/2017.
 */
public abstract class BeanSearchViewController<E> extends AbstractSearchViewController<E> implements IBeanSearchViewController<E> {
    public BeanSearchViewController(IBeanSearchViewContext<E> viewContext, IBeanSearchViewDescriptor<E> viewDescriptor, IBeanSearchViewModel<E> viewModel) {
        super(viewContext, viewDescriptor, viewModel);
    }

    public BeanSearchViewController(IBeanSearchViewDescriptor<E> viewDescriptor, IBeanSearchViewModel<E> viewModel) {
        super(viewDescriptor, viewModel);
    }
}
