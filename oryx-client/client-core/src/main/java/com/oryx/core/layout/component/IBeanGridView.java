package com.oryx.core.layout.component;

import java.util.Collection;
import java.util.UUID;

/**
 * Created by smbarki on 10/04/2017.
 */
public interface IBeanGridView<B> extends IBeanView<B> {
    public void addBean(B bean);

    public void addBeans(Collection<B> beans);

    public void clearContainer();

    public void removeBean(B bean);

    public void selectRowById(UUID id);

    public void selectRowsById(UUID... ids);

    public void selectRowByObject(B bean);

    public void selectRowsByObject(B... beans);

    public void refreshGridRows();
}
