package com.oryx.core.layout.component.grid;

import com.oryx.core.bundle.IBundle;
import com.oryx.core.layout.CrudFormContext;

/**
 * Created by smbarki on 07/04/2017.
 */
public class PagedBeanGrid<B> extends AbstractPagedBeanGrid<B> {
    public PagedBeanGrid(CrudFormContext context, B bean, Class<? extends IBundle> bundleClass) {
        super(bean, bundleClass);

        this.setDisplayedFields(context.displayedFields);
        this.setHiddenFields(context.hiddenFields);
        this.setMandatoryFields(context.mandatoryFields);
        this.setReadOnlyFields(context.readOnlyFields);
    }
}
