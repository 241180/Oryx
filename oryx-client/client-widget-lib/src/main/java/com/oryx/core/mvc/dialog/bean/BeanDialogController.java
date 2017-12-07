package com.oryx.core.mvc.dialog.bean;

import com.oryx.core.mvc.dialog.AbstractDialogController;
import com.oryx.core.mvc.view.AbstractViewController;

/**
 * Created by SAMI on 07/12/2017.
 */
public abstract class BeanDialogController<E> extends AbstractDialogController<E> implements IBeanDialogController<E> {
    public BeanDialogController(IBeanDialogContext<E> viewContext, IBeanDialogDescriptor<E> viewDescriptor, IBeanDialogModel<E> viewModel) {
        super(viewContext, viewDescriptor, viewModel);
    }

    public BeanDialogController(IBeanDialogDescriptor<E> viewDescriptor, IBeanDialogModel<E> viewModel) {
        super(viewDescriptor, viewModel);
    }
}
