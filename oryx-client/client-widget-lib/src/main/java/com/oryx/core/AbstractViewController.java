package com.oryx.core;

import com.oryx.core.annotation.capable.IBundleCapable;
import com.oryx.core.bundle.IBundle;

/**
 * Created by smbarki on 06/12/2017.
 */
public abstract class AbstractViewController implements IViewController {
    private Class<? extends IBundle> constantBundle;
    private IViewContext viewContext;
    private IViewDescriptor viewDescriptor;
    private IViewModel viewModel;

    public AbstractViewController(IViewContext viewContext, IViewDescriptor viewDescriptor, IViewModel viewModel) {
        this.constantBundle = constantBundle;
        this.viewContext = viewContext;
        this.viewDescriptor = viewDescriptor;
        this.viewModel = viewModel;

        initilizeMVC();
    }

    public AbstractViewController(IViewDescriptor viewDescriptor, IViewModel viewModel) {
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

    public IViewDescriptor getViewDescriptor() {
        return viewDescriptor;
    }

    public void setViewDescriptor(IViewDescriptor viewDescriptor) {
        this.viewDescriptor = viewDescriptor;
    }

    public IViewContext getViewContext() {
        return viewContext;
    }

    public void setViewContext(IViewContext viewContext) {
        this.viewContext = viewContext;
    }

    public IViewModel getViewModel() {
        return viewModel;
    }

    public void setViewModel(IViewModel viewModel) {
        this.viewModel = viewModel;
    }
}
