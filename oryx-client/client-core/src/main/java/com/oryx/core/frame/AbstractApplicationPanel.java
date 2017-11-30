package com.oryx.core.frame;

import com.oryx.core.annotation.capable.IBundleCapable;
import com.oryx.core.bundle.common.InformationConstantBundle;
import com.oryx.core.bundle.common.MessageConstantBundle;
import com.oryx.core.bundle.helper.IMessageHelper;
import com.oryx.core.bundle.tools.BundleExtractor;
import com.oryx.core.context.ITaskContext;
import com.oryx.core.gui.ILayout;
import com.oryx.core.gui.ILayoutKey;
import com.oryx.core.gui.enums.EnumLayoutStyle;
import com.oryx.core.helper.CommonServiceHelper;
import com.oryx.core.module.IModule;
import com.oryx.core.module.annotation.capable.IModuleCapable;
import com.oryx.core.parameter.IClientParameterNames;
import com.oryx.core.provider.ITypeByTokenProvider;
import com.vaadin.data.Property;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinSession;
import com.vaadin.shared.ui.combobox.FilteringMode;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.apache.log4j.Logger;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public abstract class AbstractApplicationPanel extends Panel {
    final static Logger logger = Logger.getLogger(AbstractApplicationPanel.class);

    private IModule module;
    private Map<String, TabSheet.Tab> tabMap = new HashMap<>();
    private ILayout activeLayout;
    private VerticalLayout rootLayout;
    private HorizontalLayout menuLayout;
    private ComboBox selectTaskComboBox;
    private MenuBar menuBar;
    private HorizontalLayout tabSheetLayout;
    private TabSheet applicationTabsheet;

    public AbstractApplicationPanel() {
        this.module = IModuleCapable.getInstance(this);
        if (this.module == null) {
            logger.error("No module associated to Application: " + this.getClass().getSimpleName());
        } else {
            if (!this.module.isConfigured()) {
                this.module.configure();
                this.module.initializeServices();
            }
        }
    }

    public MenuBar loadMenuBar() {
        Map<String, MenuBar.MenuItem> menuItemMap = new HashMap<>();
        MenuBar menuBar = null;

        if (ITaskContext.isLoaded()) {
            Map<String /*Name*/, String /*Menu path*/> tasksWithMenuPathMap = ITaskContext.getTasksWithMenuPath();
            if (tasksWithMenuPathMap != null && !tasksWithMenuPathMap.isEmpty()) {
                menuBar = new MenuBar();
                menuBar.setSizeUndefined();
                menuBar.setResponsive(true);

                MenuBar.Command selectCommand = new MenuBar.Command() {
                    @Override
                    public void menuSelected(MenuBar.MenuItem menuItem) {
                        select(menuItem.getText());
                    }
                };

                for (String taskName : tasksWithMenuPathMap.keySet()) {
                    String[] pathItems = null;

                    Boolean loadTaskMenuPathFromClass = Boolean.valueOf(CommonServiceHelper.getParameterService().getValue(UUID.fromString((String) (String) VaadinSession.getCurrent().getAttribute("USER_ID")), IClientParameterNames.TASK_MENU_PATH_FROM_CLASS));
                    if (loadTaskMenuPathFromClass && (tasksWithMenuPathMap.get(taskName) == null || tasksWithMenuPathMap.get(taskName).isEmpty())) {
                        ILayout layout = (ILayout) this.module.getByObjectDescription(ILayoutKey.class, BundleExtractor.getStringValue(IBundleCapable.getBundleInterface(module), taskName));
                        if (layout != null) {
                            tasksWithMenuPathMap.replace(taskName, layout.getTypeByTokenProvider().getClassType(ITypeByTokenProvider.Target.XML_ENTITY).getCanonicalName());
                        }
                    }

                    if (tasksWithMenuPathMap.get(taskName) != null && !tasksWithMenuPathMap.get(taskName).isEmpty()) {
                        pathItems = tasksWithMenuPathMap.get(taskName).split("\\.");
                    }

                    if (pathItems != null && pathItems.length > 0) {
                        MenuBar.MenuItem newItem = null;
                        for (String itemPath : pathItems) {
                            if (newItem == null) {
                                if (menuItemMap.containsKey(itemPath)) {
                                    newItem = menuItemMap.get(itemPath);
                                } else {
                                    newItem = menuBar.addItem(BundleExtractor.getStringValue(IBundleCapable.getBundleInterface(this), itemPath), null, null);
                                    menuItemMap.put(itemPath, newItem);
                                }
                            } else {
                                if (menuItemMap.containsKey(itemPath)) {
                                    newItem = menuItemMap.get(itemPath);
                                } else {
                                    newItem = newItem.addItem(BundleExtractor.getStringValue(IBundleCapable.getBundleInterface(this), itemPath), null, null);
                                    menuItemMap.put(itemPath, newItem);
                                }
                            }
                        }

                        newItem = newItem.addItem(BundleExtractor.getStringValue(IBundleCapable.getBundleInterface(module), taskName), null, selectCommand);

                        Boolean loadOnlyAllowedTasks = Boolean.valueOf(CommonServiceHelper.getParameterService().getValue(UUID.fromString((String) (String) VaadinSession.getCurrent().getAttribute("USER_ID")), IClientParameterNames.ONLY_ALLOWED_TASKS));
                        if (loadOnlyAllowedTasks && !this.module.isObjectAllowedByEntityName(ILayoutKey.class, taskName)) {
                            newItem.setEnabled(false);
                        }
                    }
                }
            }

        }

        return menuBar;
    }

    public void select(String select) {
        this.activeLayout = (ILayout) this.module.getByObjectDescription(ILayoutKey.class, select);
        this.init(null, select);
    }

    public HorizontalLayout getMenuLayout() {
        //Create Menu Layout
        if (menuLayout == null) {
            menuLayout = new HorizontalLayout();
            menuLayout.setResponsive(true);
            menuLayout.setImmediate(true);
            menuLayout.setSizeFull();
            menuLayout.setMargin(false);
            menuLayout.setSpacing(true);
        }

        //Creating MenuBar
        Boolean loadAndAttachMenuBar = Boolean.valueOf(CommonServiceHelper.getParameterService().getValue(UUID.fromString((String) (String) VaadinSession.getCurrent().getAttribute("USER_ID")), IClientParameterNames.SHOW_MENU_BAR));
        if (loadAndAttachMenuBar) {
            if (menuBar == null) {
                menuBar = loadMenuBar();
            }

            if (menuBar != null) {
                menuLayout.addComponent(menuBar);
                menuLayout.setExpandRatio(menuBar, 0.7f);
                menuLayout.setComponentAlignment(menuBar, Alignment.MIDDLE_LEFT);
            } else {
                HorizontalLayout pushLayout = new HorizontalLayout();
                menuLayout.addComponent(pushLayout);
                menuLayout.setExpandRatio(pushLayout, 0.7f);
                menuLayout.setComponentAlignment(pushLayout, Alignment.MIDDLE_LEFT);
            }
        } else {
            HorizontalLayout pushLayout = new HorizontalLayout();
            menuLayout.addComponent(pushLayout);
            menuLayout.setExpandRatio(pushLayout, 0.7f);
            menuLayout.setComponentAlignment(pushLayout, Alignment.MIDDLE_LEFT);
        }

        Boolean hideMenuSelector = Boolean.valueOf(CommonServiceHelper.getParameterService().getValue(UUID.fromString((String) VaadinSession.getCurrent().getAttribute("USER_ID")), IClientParameterNames.HIDE_MENU_SELECTOR));
        if (!hideMenuSelector && selectTaskComboBox == null) {
            Label selectTaskLable = new Label(IMessageHelper.getDefaultString(MessageConstantBundle.class, "operation"));
            selectTaskLable.setResponsive(true);
            selectTaskLable.setImmediate(true);
            selectTaskLable.setSizeUndefined();

            selectTaskComboBox = new ComboBox();
            selectTaskComboBox.setResponsive(true);
            selectTaskComboBox.setImmediate(true);
            selectTaskComboBox.setSizeUndefined();
            selectTaskComboBox.setWidth("100%");
            selectTaskComboBox.setFilteringMode(FilteringMode.CONTAINS);

            Boolean loadOnlyAllowedTasks = Boolean.valueOf(CommonServiceHelper.getParameterService().getValue(UUID.fromString((String) VaadinSession.getCurrent().getAttribute("USER_ID")), IClientParameterNames.ONLY_ALLOWED_TASKS));
            Collection<?> itemIds = this.module.getObjectDesctiptionSet(ILayoutKey.class, loadOnlyAllowedTasks);
            if (itemIds != null) {
                selectTaskComboBox.addItems(itemIds);
            }

            selectTaskComboBox.addValueChangeListener(new Property.ValueChangeListener() {
                @Override
                public void valueChange(Property.ValueChangeEvent event) {
                    select((String) selectTaskComboBox.getValue());
                    selectTaskComboBox.select(null);
                }
            });

            menuLayout.addComponent(selectTaskLable);
            menuLayout.setExpandRatio(selectTaskLable, 0.1f);
            menuLayout.setComponentAlignment(selectTaskLable, Alignment.MIDDLE_RIGHT);

            menuLayout.addComponent(selectTaskComboBox);
            menuLayout.setExpandRatio(selectTaskComboBox, 0.2f);
            menuLayout.setComponentAlignment(selectTaskComboBox, Alignment.MIDDLE_RIGHT);
        }

        return menuLayout;
    }

    public HorizontalLayout getTabSheetLayout() {
        if (tabSheetLayout == null) {
            tabSheetLayout = new HorizontalLayout();
            tabSheetLayout.setImmediate(true);
            tabSheetLayout.setSizeFull();
            tabSheetLayout.setMargin(false);
            tabSheetLayout.setSpacing(true);
        }

        if (applicationTabsheet == null) {
            tabMap.clear();
            applicationTabsheet = new TabSheet();
            applicationTabsheet.setImmediate(true);
            applicationTabsheet.setSizeFull();
            applicationTabsheet.addStyleName("reports");
            applicationTabsheet.addStyleName(ValoTheme.TABSHEET_FRAMED);
            applicationTabsheet.addStyleName(ValoTheme.TABSHEET_EQUAL_WIDTH_TABS);
            applicationTabsheet.addStyleName(ValoTheme.NOTIFICATION_CLOSABLE);
            applicationTabsheet.addStyleName(ValoTheme.BUTTON_ICON_ALIGN_RIGHT);
            applicationTabsheet.setCloseHandler(new TabSheet.CloseHandler() {
                @Override
                public void onTabClose(TabSheet tabsheet,
                                       Component tabContent) {
                    TabSheet.Tab tab = tabsheet.getTab(tabContent);

                    Notification.show(IMessageHelper.composeMsg(IMessageHelper.getDefaultString(InformationConstantBundle.class, "ClosingInfoMsg"), tab.getCaption()));
                    // We need to close it explicitly in the handler
                    tabMap.remove(tab.getCaption());
                    tabsheet.removeTab(tab);
                }
            });

            tabSheetLayout.addComponent(applicationTabsheet);
            tabSheetLayout.setExpandRatio(applicationTabsheet, 1f);
        }

        return tabSheetLayout;
    }

    public void init(VaadinRequest request, String selctedTask) {
        if (rootLayout == null) {
            rootLayout = new VerticalLayout();
            rootLayout.setResponsive(true);
            rootLayout.setImmediate(true);
            rootLayout.setSizeFull();
            rootLayout.setMargin(true);
            rootLayout.setSpacing(true);

            //adding menu
            if (this.menuLayout == null) {
                this.menuLayout = getMenuLayout();
                menuLayout.setSizeFull();
                menuLayout.setResponsive(true);
                rootLayout.addComponent(menuLayout);
                rootLayout.setExpandRatio(menuLayout, 0.06f);
            }

            //adding application tab sheet
            if (this.tabSheetLayout == null) {
                this.tabSheetLayout = getTabSheetLayout();
                tabSheetLayout.setSizeFull();
                tabSheetLayout.setResponsive(true);
                rootLayout.addComponent(tabSheetLayout);
                rootLayout.setExpandRatio(tabSheetLayout, 0.94f);
            }
        }

        if (activeLayout != null && selctedTask != null) {
            if (tabMap.get(selctedTask) != null) {
                applicationTabsheet.setSelectedTab(tabMap.get(selctedTask));
            } else {
                TabSheet.Tab tab = applicationTabsheet.addTab(activeLayout.initialize(request, Grid.SelectionMode.MULTI, EnumLayoutStyle.SEARCH), selctedTask);
                tab.setClosable(true);
                tabMap.put(selctedTask, tab);
                applicationTabsheet.setSelectedTab(tab);
            }
        }

        setContent(rootLayout);
    }
}
