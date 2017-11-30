package com.oryx.core.layout.grid;

import com.oryx.core.gui.enums.EnumLayoutStyle;
import com.oryx.core.layout.component.IBeanGridView;
import com.vaadin.ui.Grid;

/**
 * Created by 241180 on 16/01/2017.
 */
public interface IGridLayout<B> extends IBeanGridView<B> {
    public void setSelectionMode(Grid.SelectionMode selectionMode);

    public void setLayoutStyle(EnumLayoutStyle style);

    public void setConsultStyle();

    public void setSearchStyle();
}
