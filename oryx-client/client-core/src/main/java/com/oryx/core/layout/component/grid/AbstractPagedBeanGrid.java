package com.oryx.core.layout.component.grid;

import com.oryx.core.bundle.IBundle;
import com.oryx.core.bundle.common.MessageConstantBundle;
import com.oryx.core.bundle.helper.IMessageHelper;
import com.oryx.core.bundle.tools.BundleExtractor;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.IEntityMethodProvider;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.apache.log4j.Logger;
import org.springframework.util.CollectionUtils;
import org.vaadin.teemusa.gridextensions.pagedcontainer.PageChangeEvent;
import org.vaadin.teemusa.gridextensions.pagedcontainer.PageChangeListener;
import org.vaadin.teemusa.gridextensions.pagedcontainer.PagedContainer;
import org.vaadin.viritin.button.MButton;
import org.vaadin.viritin.fields.MTextField;

import javax.xml.datatype.XMLGregorianCalendar;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * Created by smbarki on 07/04/2017.
 */
public abstract class AbstractPagedBeanGrid<B> implements IBeanGrid<B> {
    final static Logger logger = Logger.getLogger(AbstractPagedBeanGrid.class);

    private B bean;
    private BeanGrid beanGrid;
    private PagedContainer.PagingControls pagingControls;
    private PagedContainer pagedContainer;
    private BeanItemContainer<B> beanContainer;
    private Class<? extends IBundle> constantBundle;
    private List<String> displayedFields;
    private List<String> hiddenFields;
    private List<String> mandatoryFields;
    private List<String> readOnlyFields;
    private Grid.SelectionMode defaultSelectionMode = Grid.SelectionMode.MULTI;
    private Alignment defaultAlignment = Alignment.MIDDLE_LEFT;
    private Component rootLayout;

    public AbstractPagedBeanGrid(B bean, Class<? extends IBundle> constantBundle) {
        this.constantBundle = constantBundle;
        this.bean = bean;
        beanContainer = new BeanItemContainer<B>((Class<? super B>) bean.getClass());
    }

    public List<String> getDisplayedFields() {
        return displayedFields;
    }

    public void setDisplayedFields(List<String> displayedFields) {
        this.displayedFields = displayedFields;
    }

    public List<String> getHiddenFields() {
        return hiddenFields;
    }

    public void setHiddenFields(List<String> hiddenFields) {
        this.hiddenFields = hiddenFields;
    }

    public List<String> getMandatoryFields() {
        return mandatoryFields;
    }

    public void setMandatoryFields(List<String> mandatoryFields) {
        this.mandatoryFields = mandatoryFields;
    }

    public List<String> getReadOnlyFields() {
        return readOnlyFields;
    }

    public void setReadOnlyFields(List<String> readOnlyFields) {
        this.readOnlyFields = readOnlyFields;
    }

    @Override
    public VerticalLayout buildBeanTableLayout() {
        if (rootLayout == null) {
            rootLayout = new VerticalLayout();
            ((VerticalLayout) rootLayout).setSpacing(false);
            ((VerticalLayout) rootLayout).setMargin(false);
            ((VerticalLayout) rootLayout).setSizeFull();

            this.beanGrid = new BeanGrid(this.bean, this.beanContainer, this.constantBundle);
            this.beanGrid.setColumns(getDisplayableColumns(this.bean.getClass()).toArray());
            this.beanGrid.setSelectionMode(this.defaultSelectionMode);

            //buid grid layout
            ((VerticalLayout) rootLayout).addComponent(this.beanGrid);
            ((VerticalLayout) rootLayout).setExpandRatio(this.beanGrid, 1.0f);

            //build grid page controls
            HorizontalLayout controlsLayout = buildPagingControlsLayout();
            ((VerticalLayout) rootLayout).addComponent(new Panel(controlsLayout));
        }
        return ((VerticalLayout) rootLayout);
    }

    public HorizontalLayout buildPagingControlsLayout() {
        HorizontalLayout controlsLayout = new HorizontalLayout();
        controlsLayout.setResponsive(true);
        controlsLayout.setMargin(false);

        this.pagedContainer = new PagedContainer(this.beanContainer);
        this.beanGrid.setContainerDataSource(this.pagedContainer);
        this.pagingControls = pagedContainer.getPagingControls(); //.setGrid(this.beanGrid);

        MTextField pageTextField = new MTextField();
        pageTextField.setEnabled(false);
        pageTextField.addStyleName("align-center");
        pagingControls.addPageChangeListener(new PageChangeListener() {
            @Override
            public void pageCountChange(PageChangeEvent event) {
                if (event.getPageCount() > 0) {
                    gridPageCountChange(event);
                    pageTextField.setValue(IMessageHelper.getDefaultString(MessageConstantBundle.class, "page") + " " + String.valueOf(event.getPage() + 1) + " / " + String.valueOf(event.getPageCount()));
                }
            }

            @Override
            public void pageChange(PageChangeEvent event) {
                if (event.getPageCount() > 0) {
                    gridPageChange(event);
                    pageTextField.setValue(IMessageHelper.getDefaultString(MessageConstantBundle.class, "page") + " " + String.valueOf(event.getPage() + 1) + " / " + String.valueOf(event.getPageCount()));
                }
            }
        });
        HorizontalLayout pages = new HorizontalLayout();
        pages.setMargin(false);
        pages.setSpacing(false);

        MButton fastBackWardBtn = new MButton(FontAwesome.FAST_BACKWARD, e -> {
            if (pagingControls.getPageCount() > 0) {
                pagingControls.setPage(0);
            }
        });
        fastBackWardBtn.setSizeFull();
        fastBackWardBtn.addStyleName(ValoTheme.BUTTON_PRIMARY);
        fastBackWardBtn.addStyleName(ValoTheme.BUTTON_SMALL);
        pages.addComponent(fastBackWardBtn);

        MButton backWardBtn = new MButton(FontAwesome.BACKWARD, e -> pagingControls.previousPage());
        backWardBtn.setSizeFull();
        backWardBtn.addStyleName(ValoTheme.BUTTON_PRIMARY);
        backWardBtn.addStyleName(ValoTheme.BUTTON_SMALL);
        pages.addComponent(backWardBtn);

        pages.addComponent(pageTextField);

        MButton forWardBtn = new MButton(FontAwesome.FORWARD, e -> pagingControls.nextPage());
        forWardBtn.setSizeFull();
        forWardBtn.addStyleName(ValoTheme.BUTTON_PRIMARY);
        forWardBtn.addStyleName(ValoTheme.BUTTON_SMALL);
        pages.addComponent(forWardBtn);

        MButton fastForWardBtn = new MButton(FontAwesome.FAST_FORWARD, e -> {
            if (pagingControls.getPageCount() > 0) {
                pagingControls.setPage(pagingControls.getPageCount() - 1);
            }
        });
        fastForWardBtn.setSizeFull();
        fastForWardBtn.addStyleName(ValoTheme.BUTTON_PRIMARY);
        fastForWardBtn.addStyleName(ValoTheme.BUTTON_SMALL);
        pages.addComponent(fastForWardBtn);

        controlsLayout.addComponents(pages);
        controlsLayout.setWidth(100.0F, Sizeable.Unit.PERCENTAGE);
        controlsLayout.setHeightUndefined();
        controlsLayout.setComponentAlignment(pages, Alignment.BOTTOM_CENTER);

        return controlsLayout;
    }

    @Override
    public void buildLayoutWithComponents(AbstractLayout layout, UI ui, IModule module) {
        layout.addComponent(buildBeanTableLayout());
    }

    @Override
    public void buildCustomLayoutWithComponents(CustomLayout layout, UI ui, IModule module) {
        layout.addComponent(buildBeanTableLayout());
    }

    @Override
    public VerticalLayout getVerticalLayout(UI ui, IModule module) {
        VerticalLayout layout = new VerticalLayout();
        layout.setDefaultComponentAlignment(this.defaultAlignment);
        layout.setSizeFull();
        layout.setSpacing(true);
        layout.setMargin(false);
        buildLayoutWithComponents(layout, ui, module);
        return layout;
    }

    @Override
    public HorizontalLayout getHorizontalLayout(UI ui, IModule module) {
        HorizontalLayout layout = new HorizontalLayout();
        layout.setDefaultComponentAlignment(this.defaultAlignment);
        layout.setSizeFull();
        layout.setSpacing(false);
        layout.setMargin(false);
        buildLayoutWithComponents(layout, ui, module);
        return layout;
    }

    @Override
    public FormLayout getFormLayout(UI ui, IModule module) {
        FormLayout layout = new FormLayout();
        layout.setDefaultComponentAlignment(this.defaultAlignment);
        layout.setSpacing(true);
        layout.setMargin(false);
        layout.setSizeFull();
        buildLayoutWithComponents(layout, ui, module);
        return layout;
    }

    @Override
    public CustomLayout getCustomLayout(UI ui, IModule module, String customHtml) {
        if (customHtml == null) {
            customHtml = this.bean.getClass().getSimpleName().toLowerCase();
        }
        CustomLayout layout = new CustomLayout(customHtml);
        layout.setSizeFull();
        buildLayoutWithComponents(layout, ui, module);
        return layout;
    }

    @Override
    public GridLayout getGridLayout(UI ui, IModule module) {
        GridLayout layout = new GridLayout();
        layout.setDefaultComponentAlignment(this.defaultAlignment);
        layout.setSpacing(true);
        layout.setMargin(false);
        layout.setSizeFull();
        buildLayoutWithComponents(layout, ui, module);
        return layout;
    }

    @Override
    public void setDefaultComponentAlignment(Alignment defaultAlignment) {
        this.defaultAlignment = defaultAlignment;
    }

    public Grid.SelectionMode getDefaultSelectionMode() {
        return defaultSelectionMode;
    }

    public void setDefaultSelectionMode(Grid.SelectionMode defaultSelectionMode) {
        this.defaultSelectionMode = defaultSelectionMode;
        this.beanGrid.setSelectionMode(this.defaultSelectionMode);
    }

    private void aplyColumnHeaderTranslation(Grid grid, Class<? extends IBundle> bundle) {
        if (bundle != null) {
            for (Grid.Column col : this.beanGrid.getColumns()) {
                col.setHeaderCaption(BundleExtractor.getStringValue(bundle, (String) col.getPropertyId()));
            }
        }
    }

    public List<String> getDisplayableColumns(Class<?> classType) {
        List<String> visibleColumns = new ArrayList<>();
        for (java.lang.reflect.Field field : classType.getDeclaredFields()) {
            if (field.getType() == String.class //
                    || field.getType() == Boolean.class //
                    || field.getType() == Integer.class //
                    || field.getType() == Double.class //
                    || field.getType() == Date.class //
                    || field.getType() == XMLGregorianCalendar.class //
                    || (field.getType() instanceof Class && ((Class<?>) field.getType()).isEnum())
                    )

                if (this.displayedFields != null && this.displayedFields.size() > 0) {
                    if (!this.displayedFields.contains(field.getName())) {
                        visibleColumns.add(field.getName());
                    }
                } else if (this.hiddenFields != null && this.hiddenFields.size() > 0) {
                    if (!this.hiddenFields.contains(field.getName())) {
                        visibleColumns.add(field.getName());
                    }
                } else {
                    visibleColumns.add(field.getName());
                }
        }

        return visibleColumns;
    }

    @Override
    public B getBean() {
        Collection values = beanGrid.getSelectedRows();
        if (values.size() >= 1) {
            Iterator it = values.iterator();
            while (it.hasNext()) {
                return (B) it.next();
            }
        }
        return null;
    }


    @Override
    public void refreshGridRows() {
        if (this.beanGrid != null) {
            this.beanGrid.refreshAllRows();
        }
    }

    @Override
    public void removeBean(B bean) {
        if (this.beanContainer != null) {
            this.beanContainer.removeItem(bean);
        }
    }

    @Override
    public void clearContainer() {
        if (this.beanContainer != null) {
            if (this.pagingControls.getPageCount() > 0) {
                this.pagingControls.setPage(0);
            }
            this.beanContainer.removeAllItems();
        }
    }

    @Override
    public void addBean(B bean) {
        if (bean != null) {
            this.beanContainer.addBean(bean);
        }
    }

    @Override
    public void addBeans(Collection<B> beans) {
        if (!CollectionUtils.isEmpty(beans)) {
            this.beanContainer.addAll(beans);
        }
    }

    @Override
    public List<B> getBeans() {
        Collection values = beanGrid.getSelectedRows();
        if (!CollectionUtils.isEmpty(values)) {
            return new ArrayList<B>(values);
        }

        return null;
    }

    @Override
    public void selectRowById(UUID id) {
        for (Object item : beanContainer.getItemIds()) {
            try {
                String getId = (String) IEntityMethodProvider.GET_ID_METHOD(item.getClass()).invoke(item);
                if (getId != null && !getId.isEmpty()) {
                    UUID identifier = UUID.fromString(getId);
                    if (identifier != null && identifier.equals(id)) {
                        beanGrid.select(item);
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void selectRowsById(UUID... ids) {
        for (Object item : beanContainer.getItemIds()) {
            try {
                UUID identifier = (UUID) IEntityMethodProvider.GET_ID_METHOD(item.getClass()).invoke(item);
                if (identifier != null) {
                    for (UUID id : ids) {
                        if (identifier.equals(id)) {
                            beanGrid.select(item);
                        }
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void selectRowByObject(B bean) {

    }

    @Override
    public void selectRowsByObject(B... beans) {

    }

    @Override
    public void editBean() {

    }

    @Override
    public void createBean() {

    }

    @Override
    public void fetchBeans() {

    }


    @Override
    public void deleteBean() {

    }

    @Override
    public void deleteBeans() {

    }

    @Override
    public void fetchBeansByCriteria() {

    }

    @Override
    public void gridPageCountChange(PageChangeEvent event) {

    }

    @Override
    public void gridPageChange(PageChangeEvent event) {

    }
}