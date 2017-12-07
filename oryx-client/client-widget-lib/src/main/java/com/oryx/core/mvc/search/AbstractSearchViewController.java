package com.oryx.core.mvc.search;

import com.oryx.core.mvc.view.AbstractViewController;
import com.oryx.core.mvc.view.IViewContext;
import com.oryx.core.mvc.view.IViewDescriptor;
import com.oryx.core.mvc.view.IViewModel;

/**
 * Created by SAMI on 07/12/2017.
 */
public abstract class AbstractSearchViewController<E> extends AbstractViewController<E> implements ISearchViewController<E>{
    public AbstractSearchViewController(ISearchViewContext<E> viewContext, ISearchViewDescriptor<E> viewDescriptor, ISearchViewModel<E> viewModel) {
        super(viewContext, viewDescriptor, viewModel);
    }

    public AbstractSearchViewController(ISearchViewDescriptor<E> viewDescriptor, ISearchViewModel<E> viewModel) {
        super(viewDescriptor, viewModel);
    }
}
