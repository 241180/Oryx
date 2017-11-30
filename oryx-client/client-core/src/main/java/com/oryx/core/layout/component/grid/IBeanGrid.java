package com.oryx.core.layout.component.grid;

import com.oryx.core.layout.component.IBeanGridView;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import org.vaadin.teemusa.gridextensions.pagedcontainer.PageChangeEvent;

import java.util.List;

/**
 * Created by smbarki on 07/04/2017.
 */
public interface IBeanGrid<B> extends IBeanGridView<B> {
    public List<B> getBeans();

    public VerticalLayout buildBeanTableLayout();

    public HorizontalLayout buildPagingControlsLayout();

    public void refreshGridRows();

    public Grid.SelectionMode getDefaultSelectionMode();

    public void setDefaultSelectionMode(Grid.SelectionMode defaultSelectionMode);

    public void gridPageCountChange(PageChangeEvent event);

    public void gridPageChange(PageChangeEvent event);
}
