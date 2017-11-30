package com.oryx.core.gui;

import com.oryx.core.binder.IBoundableObject;
import com.oryx.core.gui.enums.EnumLayoutStyle;
import com.oryx.core.provider.ITypeByTokenProvider;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by smbarki on 10/08/2017.
 */
public interface ILayout extends IBoundableObject {
    public VerticalLayout initializeRootLayout(VaadinRequest request, Component view);

    public VerticalLayout initialize(VaadinRequest request, Grid.SelectionMode selectMode, EnumLayoutStyle style);

    public VerticalLayout initialize(VaadinRequest request, EnumLayoutStyle style);

    public VerticalLayout initialize(VaadinRequest request, Grid.SelectionMode selectMode, Component component);

    public ITypeByTokenProvider getTypeByTokenProvider();

    public String getCustomHtmlFile();
}
