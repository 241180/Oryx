package com.oryx.core.layout.grid;

import com.oryx.core.annotation.capable.IAssoEntityCapable;
import com.oryx.core.annotation.capable.IBundleCapable;
import com.oryx.core.annotation.capable.ITypeByTokenCapable;
import com.oryx.core.bundle.common.ActionConstantBundle;
import com.oryx.core.bundle.tools.BundleExtractor;
import com.oryx.core.gui.enums.EnumLayoutStyle;
import com.oryx.core.helper.CommonServiceHelper;
import com.oryx.core.layout.CrudFormContext;
import com.oryx.core.layout.component.IBeanView;
import com.oryx.core.layout.component.button.ButtonView;
import com.oryx.core.layout.component.button.EnumButtonAction;
import com.oryx.core.layout.component.button.IButtonView;
import com.oryx.core.layout.component.form.BeanForm;
import com.oryx.core.layout.component.form.IBeanForm;
import com.oryx.core.layout.component.grid.IBeanGrid;
import com.oryx.core.layout.component.grid.PagedBeanGrid;
import com.oryx.core.module.IModule;
import com.oryx.core.parameter.IClientParameterNames;
import com.oryx.core.provider.ITypeByTokenProvider;
import com.vaadin.server.Sizeable;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.*;
import org.apache.log4j.Logger;
import org.vaadin.viritin.components.DisclosurePanel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

/**
 * Created by 241180 on 05/01/2017.
 */
public abstract class AbstractGridLayout<B> implements IGridLayout<B> {
    final static Logger logger = Logger.getLogger(AbstractGridLayout.class);

    private IButtonView buttonView;
    private IBeanForm<B> filterFormView;
    private IBeanGrid<B> gridView;
    private List<String> displayedFields;
    private List<String> hiddenFields;
    private List<String> mandatoryFields;
    private List<String> readOnlyFields;
    private List<String> filterFields;
    private ITypeByTokenProvider typeByTokenProvider;
    private VerticalLayout rootLayout;
    ;

    public AbstractGridLayout(IModule module) {
        B bean = (B) IAssoEntityCapable.getInstance(this);
        Class<B> beanType = (Class<B>) IAssoEntityCapable.getClassType(this);

        CrudFormContext columnContext = new CrudFormContext(this.getDisplayedFields(), this.getHhiddenFields(), this.getMmandatoryFields(), this.getRreadOnlyFields(), this.getfilterFields());
        this.filterFormView = new BeanForm<B>(columnContext, bean, IBundleCapable.getBundleInterface(this), 1, false, false);
        this.gridView = new PagedBeanGrid<B>(columnContext, bean, IBundleCapable.getBundleInterface(this));
    }


    @Override
    public void setConsultStyle() {
        if (this.buttonView != null) {
            this.buttonView.enableButton(EnumButtonAction.REFRESH, true);
            this.buttonView.enableButton(EnumButtonAction.CREATE, false);
            this.buttonView.enableButton(EnumButtonAction.EDIT, false);
            this.buttonView.enableButton(EnumButtonAction.DELETE, false);
            this.buttonView.enableButton(EnumButtonAction.FILTER, true);
        }
    }

    @Override
    public void setSearchStyle() {
        if (this.buttonView != null) {
            this.buttonView.enableButton(EnumButtonAction.REFRESH, true);
            this.buttonView.enableButton(EnumButtonAction.CREATE, true);
            this.buttonView.enableButton(EnumButtonAction.EDIT, true);
            this.buttonView.enableButton(EnumButtonAction.DELETE, true);
            this.buttonView.enableButton(EnumButtonAction.FILTER, true);
        }
    }

    @Override
    public void setLayoutStyle(EnumLayoutStyle style) {
        if (style == EnumLayoutStyle.CONSULT) {
            setConsultStyle();
        } else {
            setSearchStyle();
        }
    }

    public ITypeByTokenProvider getTypeByTokenProvider() {
        if (typeByTokenProvider != null)
            return typeByTokenProvider;

        typeByTokenProvider = ITypeByTokenCapable.getInstance(this);
        return typeByTokenProvider;
    }

    @Override
    public void setSelectionMode(Grid.SelectionMode selectionMode) {
        this.gridView.setDefaultSelectionMode(selectionMode);
    }

    public abstract String getFormTitle();

    @Override
    public void buildLayoutWithComponents(AbstractLayout layout, UI ui, IModule module) {
    }

    @Override
    public void buildCustomLayoutWithComponents(CustomLayout layout, UI ui, IModule module) {

    }

    @Override
    public VerticalLayout getVerticalLayout(UI ui, IModule module) {
        if (rootLayout == null) {
            List<IBeanView> views = new ArrayList<>();
            views.add(this);

            Boolean crudOpeBtnWithNoCaption = Boolean.valueOf(CommonServiceHelper.getParameterService().getValue(UUID.fromString((String) VaadinSession.getCurrent().getAttribute("USER_ID")), IClientParameterNames.CRUD_BTN_WITH_NO_CAPTION));
            this.buttonView = new ButtonView(!crudOpeBtnWithNoCaption, views, EnumButtonAction.REFRESH
                    , EnumButtonAction.CREATE
                    , EnumButtonAction.EDIT
                    , EnumButtonAction.DELETE
                    , EnumButtonAction.FILTER);
            this.buttonView.setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);

            Panel buttonBanel;
            DisclosurePanel filterPanel;

            Panel gridPanel = new Panel(this.gridView.getVerticalLayout(UI.getCurrent(), module));

            rootLayout = new VerticalLayout();

            rootLayout.setSizeFull();
            rootLayout.setMargin(true);
            rootLayout.setSpacing(true);

            rootLayout.setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);
            buttonBanel = new Panel(this.buttonView.getHorizontalLayout(UI.getCurrent(), module));
            rootLayout.addComponent(buttonBanel);
            filterPanel = new DisclosurePanel(BundleExtractor.getStringValue(ActionConstantBundle.class, "FILTER"), new Panel(this.filterFormView.getHorizontalLayout(UI.getCurrent(), module)));
            filterPanel.setWidth(100.0F, Sizeable.Unit.PERCENTAGE);
            filterPanel.setMargin(false);
            filterPanel.setResponsive(true);
            rootLayout.addComponent(filterPanel);
            gridPanel.setSizeFull();

            rootLayout.addComponent(gridPanel);
            rootLayout.setExpandRatio(gridPanel, 1);
        }

        return rootLayout;
    }

    @Override
    public HorizontalLayout getHorizontalLayout(UI ui, IModule module) {
        return null;
    }

    @Override
    public FormLayout getFormLayout(UI ui, IModule module) {
        return null;
    }

    @Override
    public CustomLayout getCustomLayout(UI ui, IModule module, String customHtml) {
        return null;
    }

    @Override
    public GridLayout getGridLayout(UI ui, IModule module) {
        return null;
    }

    @Override
    public void setDefaultComponentAlignment(Alignment defaultAlignment) {

    }

    public B getSlectedBean() {
        if (this.gridView != null)
            return this.gridView.getBean();
        else
            return null;
    }

    public List<B> getSlectedBeans() {
        if (this.gridView != null)
            return this.gridView.getBeans();
        else
            return null;
    }

    public B getFilterBean() {
        if (this.filterFormView != null)
            return this.filterFormView.getBean();
        else
            return null;
    }

    public void clearContainer() {
        if (this.gridView != null) {
            this.gridView.clearContainer();
        }
    }

    public void removeBean(B bean) {
        if (this.gridView != null && bean != null) {
            this.gridView.removeBean(bean);
        }
    }

    public void addBean(B bean) {
        if (this.gridView != null && bean != null) {
            this.gridView.addBean(bean);
        }
    }

    public void refreshGridRows() {
        if (this.gridView != null) {
            this.gridView.refreshGridRows();
        }
    }

    public void addBeans(Collection<B> beans) {
        if (this.gridView != null && beans != null) {
            this.gridView.addBeans(beans);
        }
    }

    @Override
    public void selectRowById(UUID id) {
        if (this.gridView != null) {
            this.gridView.selectRowById(id);
        }
    }

    @Override
    public void selectRowsById(UUID... ids) {
        if (this.gridView != null) {
            this.gridView.selectRowsById(ids);
        }
    }

    @Override
    public void selectRowByObject(B bean) {
        if (this.gridView != null) {
            this.gridView.selectRowByObject(bean);
        }
    }

    @Override
    public void selectRowsByObject(B... beans) {

    }

    public List<String> getDisplayedFields() {
        if (displayedFields != null)
            return displayedFields;
        displayedFields = CrudFormContext.getFieldValue(this, CrudFormContext.DISPLAYED_FIELDS);
        return displayedFields;
    }

    public List<String> getHhiddenFields() {
        if (hiddenFields != null)
            return hiddenFields;
        hiddenFields = CrudFormContext.getFieldValue(this, CrudFormContext.HIDDEN_FIELDS);
        return hiddenFields;
    }

    public List<String> getMmandatoryFields() {
        if (mandatoryFields != null)
            return mandatoryFields;
        mandatoryFields = CrudFormContext.getFieldValue(this, CrudFormContext.MANDATORY_FIELDS);
        return mandatoryFields;
    }

    public List<String> getRreadOnlyFields() {
        if (readOnlyFields != null)
            return readOnlyFields;
        readOnlyFields = CrudFormContext.getFieldValue(this, CrudFormContext.READ_ONLY_FIELDS);
        return readOnlyFields;
    }

    public List<String> getfilterFields() {
        if (filterFields != null)
            return filterFields;
        filterFields = CrudFormContext.getFieldValue(this, CrudFormContext.FILTER_FIELDS);
        return filterFields;
    }
}
