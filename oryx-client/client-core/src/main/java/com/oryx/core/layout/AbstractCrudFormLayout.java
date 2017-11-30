package com.oryx.core.layout;

import com.oryx.core.annotation.capable.IAssoEntityCapable;
import com.oryx.core.annotation.capable.ICustomCapable;
import com.oryx.core.annotation.capable.IGridFormCapable;
import com.oryx.core.annotation.capable.ITypeByTokenCapable;
import com.oryx.core.delegate.IDelegate;
import com.oryx.core.delegate.IDelegateKey;
import com.oryx.core.gui.enums.EnumLayoutStyle;
import com.oryx.core.layout.grid.IGridLayout;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.ITypeByTokenProvider;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.apache.log4j.Logger;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

/**
 * Created by smbarki on 14/04/2017.
 */
public abstract class AbstractCrudFormLayout<B> implements IFormLayout<B> {
    final static Logger logger = Logger.getLogger(AbstractCrudFormLayout.class);

    private VerticalLayout rootLayout;
    private IModule module;
    private IGridLayout gridFormView;
    private IDelegate serviceDelegate;
    private ITypeByTokenProvider typeByTokenProvider;

    public AbstractCrudFormLayout(IModule module) {
        this.module = module;
        Class<B> entityClass = (Class<B>) IAssoEntityCapable.getClassType(this);

        this.serviceDelegate = (IDelegate) module.getBoundObject(IDelegateKey.class, entityClass);
        if (this.serviceDelegate == null) {
            logger.error("No service bound for " + entityClass.getSimpleName());
        }
    }

    @Override
    public VerticalLayout initialize(VaadinRequest request, EnumLayoutStyle style) {
        Component layout = null;

        if (this.gridFormView == null) {
            IGridLayout gridForm = IGridFormCapable.getInstance(this, this.serviceDelegate, this.module);
            gridForm.setLayoutStyle(style);
            setGridFormView(gridForm);
        }

        if (getCustomHtmlFile() != null) {
            layout = this.gridFormView.getCustomLayout(UI.getCurrent(), this.module, getCustomHtmlFile());
        } else {
            layout = this.gridFormView.getVerticalLayout(UI.getCurrent(), this.module);
        }
        this.gridFormView.setLayoutStyle(style);
        return initializeRootLayout(request, layout);
    }

    @Override
    public ITypeByTokenProvider getTypeByTokenProvider() {
        if (typeByTokenProvider != null)
            return typeByTokenProvider;

        typeByTokenProvider = ITypeByTokenCapable.getInstance(this);
        return typeByTokenProvider;
    }

    public IModule getApplicationModule() {
        return module;
    }

    public IGridLayout getGridFormView() {
        return gridFormView;
    }

    public void setGridFormView(IGridLayout gridFormView) {
        this.gridFormView = gridFormView;
    }

    public IDelegate getServiceDelegate() {
        return this.serviceDelegate;
    }

    private void initLayoutPreferences(VerticalLayout layout) {
        if (layout != null) {
            layout.setSizeFull();
            layout.setMargin(false);
            layout.setSpacing(true);
        }
    }

    @Override
    public VerticalLayout initializeRootLayout(VaadinRequest request, Component view) {
        if (rootLayout == null) {
            rootLayout = new VerticalLayout();
            rootLayout.addComponent(view);
        }

        initLayoutPreferences(rootLayout);
        return rootLayout;
    }

    @Override
    public VerticalLayout initialize(VaadinRequest request, Grid.SelectionMode selectMode, EnumLayoutStyle style) {
        rootLayout = initialize(request, style);
        if (this.gridFormView != null)
            this.gridFormView.setSelectionMode(selectMode);
        return rootLayout;
    }

    @Override
    public VerticalLayout initialize(VaadinRequest request, Grid.SelectionMode selectMode, Component component) {
        rootLayout = initialize(request, EnumLayoutStyle.SEARCH);
        if (this.gridFormView != null)
            this.gridFormView.setSelectionMode(selectMode);
        return rootLayout;
    }

    @Override
    public void setSelectedValues(UUID... ids) {
        if (this.gridFormView != null)
            this.gridFormView.selectRowsById(ids);
    }

    @Override
    public B getSelectedValue() {
        if (this.gridFormView != null)
            return (B) this.gridFormView.getBean();
        else
            return null;
    }

    @Override
    public void setSelectedValue(UUID id) {
        if (this.gridFormView != null)
            this.gridFormView.selectRowById(id);
    }

    @Override
    public Collection<B> getSelectedValues() {
        if (this.gridFormView != null)
            return (Collection<B>) this.gridFormView.getBeans();
        else
            return null;
    }

    @Override
    public void setSelectedValues(List<UUID> ids) {
        if (this.gridFormView != null) {
            for (UUID id : ids) {
                this.gridFormView.selectRowById(id);
            }
        }
    }

    @Override
    public void refresh() {
        if (this.gridFormView != null) {
            this.gridFormView.fetchBeans();
        }
    }

    public String getCustomHtmlFile() {
        return ICustomCapable.getHtmlFileName(this);
    }
}
