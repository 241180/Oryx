package com.oryx.core.dashboard.view.crud;

import com.oryx.core.dashboard.event.DashboardEventBus;
import com.oryx.core.dashboard.view.crud.frame.CrudPanel;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Responsive;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public final class CrudView extends Panel implements View {

    private final VerticalLayout root;

    public CrudView() {
        addStyleName("crud");
        setSizeFull();
        DashboardEventBus.register(this);

        root = new VerticalLayout();
        root.setSizeFull();
        root.setMargin(false);
        root.setSpacing(true);
        setContent(root);

        Responsive.makeResponsive(root);

        CrudPanel panel = new CrudPanel();

        panel.setSizeFull();
        panel.init(null, null);
        root.addComponent(panel);
        root.setExpandRatio(panel, 1);
    }

    @Override
    public void enter(final ViewChangeEvent event) {

    }
}
