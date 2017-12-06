package com.oryx.core;

import com.oryx.core.annotation.capable.IBundleCapable;
import com.oryx.core.bundle.IBundle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smbarki on 06/12/2017.
 */
public abstract class AbstractViewControllerMultiDescriptor extends AbstractViewController {
    private List<IViewDescriptor> viewDescriptorList;

    public AbstractViewControllerMultiDescriptor(IViewContext viewContext, IViewModel viewModel, IViewDescriptor... viewDescriptors) {
        super(viewContext, null, viewModel);
        this.viewDescriptorList = new ArrayList<IViewDescriptor>();
        for(IViewDescriptor viewDescriptor:viewDescriptors){
            if (viewDescriptor != null){
                this.viewDescriptorList.add(viewDescriptor);
            }
        }
    }

    public AbstractViewControllerMultiDescriptor(IViewModel viewModel, IViewDescriptor... viewDescriptors) {
        this(null, viewModel, viewDescriptors);
    }
}
