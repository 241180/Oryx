package com.oryx.core.layout.component.form;

import com.oryx.core.bundle.IBundle;
import com.oryx.core.layout.CrudFormContext;

/**
 * Created by smbarki on 07/04/2017.
 */
public class BeanForm<B> extends AbstractBeanForm<B> {
    public BeanForm(CrudFormContext context, B bean, Class<? extends IBundle> bundleClass, int depth, boolean applyRadOnly, boolean applyMonadatory) {
        super(bean, bundleClass, depth, applyRadOnly, applyMonadatory);

        this.setDisplayedFields(context.displayedFields);
        this.setHiddenFields(context.hiddenFields);
        this.setMandatoryFields(context.mandatoryFields);
        this.setReadOnlyFields(context.readOnlyFields);
    }
}
