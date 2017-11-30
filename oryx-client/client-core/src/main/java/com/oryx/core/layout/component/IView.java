package com.oryx.core.layout.component;

import com.oryx.core.module.IModule;
import com.vaadin.ui.*;

/**
 * Created by smbarki on 10/04/2017.
 */
public interface IView<B> {
    public void buildLayoutWithComponents(AbstractLayout layout, UI ui, IModule module);

    public void buildCustomLayoutWithComponents(CustomLayout layout, UI ui, IModule module);

    public VerticalLayout getVerticalLayout(UI ui, IModule module);

    public HorizontalLayout getHorizontalLayout(UI ui, IModule module);

    public FormLayout getFormLayout(UI ui, IModule module);

    public GridLayout getGridLayout(UI ui, IModule module);

    public CustomLayout getCustomLayout(UI ui, IModule module, String customHtml);

    public void setDefaultComponentAlignment(Alignment defaultAlignment);
}
