package com.oryx.core.layout;

import com.oryx.core.gui.ILayout;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

/**
 * Created by smbarki on 14/04/2017.
 */
public interface IFormLayout<B> extends ILayout {
    public B getSelectedValue();

    public void setSelectedValue(UUID id);

    public Collection<B> getSelectedValues();

    public void setSelectedValues(UUID... ids);

    public void setSelectedValues(List<UUID> ids);

    public void refresh();
}
