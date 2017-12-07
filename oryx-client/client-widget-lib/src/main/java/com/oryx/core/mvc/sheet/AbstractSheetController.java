package com.oryx.core.mvc.sheet;

import com.oryx.core.mvc.view.AbstractViewController;

/**
 * Created by SAMI on 07/12/2017.
 */
public abstract class AbstractSheetController<E> extends AbstractViewController<E> implements ISheetController<E> {
    public AbstractSheetController(ISheetContext<E> viewContext, ISheetDescriptor<E> viewDescriptor, ISheetModel<E> viewModel) {
        super(viewContext, viewDescriptor, viewModel);
    }

    public AbstractSheetController(ISheetDescriptor<E> viewDescriptor, ISheetModel<E> viewModel) {
        super(viewDescriptor, viewModel);
    }
}
