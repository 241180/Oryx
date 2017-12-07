package com.oryx.core.mvc.sheet.bean;

import com.oryx.core.mvc.sheet.AbstractSheetController;

/**
 * Created by SAMI on 07/12/2017.
 */
public abstract class BeanSheetController<E> extends AbstractSheetController<E> implements IBeanSheetController<E> {
    public BeanSheetController(IBeanSheetContext<E> viewContext, IBeanSheetDescriptor<E> viewDescriptor, IBeanSheetModel<E> viewModel) {
        super(viewContext, viewDescriptor, viewModel);
    }

    public BeanSheetController(IBeanSheetDescriptor<E> viewDescriptor, IBeanSheetModel<E> viewModel) {
        super(viewDescriptor, viewModel);
    }
}
