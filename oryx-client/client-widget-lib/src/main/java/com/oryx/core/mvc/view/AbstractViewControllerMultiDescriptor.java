package com.oryx.core.mvc.view;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smbarki on 06/12/2017.
 */
public abstract class AbstractViewControllerMultiDescriptor<E> extends AbstractViewController<E> {
    private List<IViewDescriptor> viewDescriptorList;

    public AbstractViewControllerMultiDescriptor(IViewContext<E> viewContext, IViewModel<E> viewModel, IViewDescriptor<E>... viewDescriptors) {
        super(viewContext, null, viewModel);
        this.viewDescriptorList = new ArrayList<IViewDescriptor>();
        for(IViewDescriptor viewDescriptor:viewDescriptors){
            if (viewDescriptor != null){
                this.viewDescriptorList.add(viewDescriptor);
            }
        }
    }

    public AbstractViewControllerMultiDescriptor(IViewModel<E> viewModel, IViewDescriptor<E>... viewDescriptors) {
        this(null, viewModel, viewDescriptors);
    }
}
