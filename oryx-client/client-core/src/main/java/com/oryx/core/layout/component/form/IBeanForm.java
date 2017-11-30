package com.oryx.core.layout.component.form;

import com.oryx.core.layout.component.IBeanView;

/**
 * Created by smbarki on 07/04/2017.
 */
public interface IBeanForm<B> extends IBeanView<B> {
    public void setEditable(boolean editable);

    public void setEnabled(boolean enabled);
}
