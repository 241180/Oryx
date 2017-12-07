package com.oryx.core.mvc.view;

import com.oryx.core.annotation.capable.IBundleCapable;
import com.oryx.core.bundle.IBundle;

/**
 * Created by smbarki on 06/12/2017.
 */
public abstract class AbstractViewController<E> implements IViewController<E> {
    private Class<? extends IBundle> constantBundle;
    private IViewContext<E> viewContext;
    private IViewDescriptor<E> viewDescriptor;
    private IViewModel<E> viewModel;

    public AbstractViewController(IViewContext<E> viewContext, IViewDescriptor<E> viewDescriptor, IViewModel<E> viewModel) {
        this.constantBundle = constantBundle;
        this.viewContext = viewContext;
        this.viewDescriptor = viewDescriptor;
        this.viewModel = viewModel;

        initilizeMVC();
    }

    public AbstractViewController(IViewDescriptor<E> viewDescriptor, IViewModel<E> viewModel) {
        this(null, viewDescriptor, viewModel);
    }

    private void initilizeMVC() {
        if (this.viewContext != null) this.viewContext.setController(this);
        if (this.viewDescriptor != null) this.viewDescriptor.setController(this);
        if (this.viewModel != null) this.viewModel.setController(this);
    }

    public Class<? extends IBundle> getConstantBundle() {
        if (constantBundle != null) {
            this.constantBundle = IBundleCapable.getBundleInterface(this);
        }

        return constantBundle;
    }

    public void setConstantBundle(Class<? extends IBundle> constantBundle) {
        this.constantBundle = constantBundle;
    }

    public IViewDescriptor<E> getViewDescriptor() {
        return viewDescriptor;
    }

    public void setViewDescriptor(IViewDescriptor<E> viewDescriptor) {
        this.viewDescriptor = viewDescriptor;
    }

    public IViewContext<E> getViewContext() {
        return viewContext;
    }

    public void setViewContext(IViewContext<E> viewContext) {
        this.viewContext = viewContext;
    }

    public IViewModel<E> getViewModel() {
        return viewModel;
    }

    public void setViewModel(IViewModel<E> viewModel) {
        this.viewModel = viewModel;
    }
}
