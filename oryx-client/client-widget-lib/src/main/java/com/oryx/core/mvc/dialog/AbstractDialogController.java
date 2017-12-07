package com.oryx.core.mvc.dialog;

import com.oryx.core.mvc.view.*;

/**
 * Created by SAMI on 07/12/2017.
 */
public abstract class AbstractDialogController<E> extends AbstractViewController<E> implements IDialogController<E>{
    public AbstractDialogController(IDialogContext<E> viewContext, IDialogDescriptor<E> viewDescriptor, IDialogModel<E> viewModel) {
        super(viewContext, viewDescriptor, viewModel);
    }

    public AbstractDialogController(IDialogDescriptor<E> viewDescriptor, IDialogModel<E> viewModel) {
        super(viewDescriptor, viewModel);
    }
}
