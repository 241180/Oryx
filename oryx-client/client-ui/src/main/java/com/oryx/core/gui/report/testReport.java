package com.oryx.core.gui.report;

import com.oryx.core.annotation.capable.IBundleCapable;
import com.oryx.core.annotation.capable.ICustomCapable;
import com.oryx.core.annotation.capable.ITypeByTokenCapable;
import com.oryx.core.annotation.decl.AssoTypeByTokenProvider;
import com.oryx.core.bundle.IBundle;
import com.oryx.core.bundle.common.ErrorConstantBundle;
import com.oryx.core.bundle.helper.IMessageHelper;
import com.oryx.core.bundle.tools.BundleExtractor;
import com.oryx.core.converter.XMLGregorianCalendarDateConverter;
import com.oryx.core.delegate.IDelegate;
import com.oryx.core.gui.ILayout;
import com.oryx.core.gui.enums.EnumLayoutStyle;
import com.oryx.core.layout.consult.ConsultWindow;
import com.oryx.core.module.IModule;
import com.oryx.core.option.IEnumUtils;
import com.oryx.core.provider.ITypeByTokenProvider;
import com.oryx.core.provider.typeByToken.model.bu.billing.BillTypeByTokenProvider;
import com.oryx.remote.webservice.element.model.system.ref.XmlPerson;
import com.vaadin.data.Validator;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.apache.log4j.Logger;
import org.dussan.vaadin.dcharts.DCharts;
import org.dussan.vaadin.dcharts.base.elements.XYaxis;
import org.dussan.vaadin.dcharts.data.DataSeries;
import org.dussan.vaadin.dcharts.data.Ticks;
import org.dussan.vaadin.dcharts.metadata.renderers.AxisRenderers;
import org.dussan.vaadin.dcharts.metadata.renderers.SeriesRenderers;
import org.dussan.vaadin.dcharts.options.Axes;
import org.dussan.vaadin.dcharts.options.Highlighter;
import org.dussan.vaadin.dcharts.options.Options;
import org.dussan.vaadin.dcharts.options.SeriesDefaults;
import org.vaadin.viritin.button.MButton;
import org.vaadin.viritin.fields.EmailField;
import org.vaadin.viritin.fields.IntegerField;
import org.vaadin.viritin.layouts.MGridLayout;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.*;

/**
 * Created by smbarki on 15/09/2017.
 */

@AssoTypeByTokenProvider(classType = BillTypeByTokenProvider.class)
public class testReport<B> implements ILayout {
    final static Logger logger = Logger.getLogger(testReport.class);

    private IModule module;
    private IDelegate serviceDelegate;
    private Class<? extends IBundle> constantBundle;
    private BeanFieldGroup<XmlPerson> binder = null;

    private XmlPerson bean = new XmlPerson();
    private Map<String, AbstractField> fieldsMap = new HashMap<>();
    private boolean applyMandatory;
    private boolean applyReadOnly;

    private List<String> displayedFields;
    private List<String> hiddenFields;
    private List<String> mandatoryFields;
    private List<String> readOnlyFields;
    private List<String> filterFields;

    public testReport(IModule module) {
        this.module = module;
        this.constantBundle = IBundleCapable.getBundleInterface(this);
        this.binder = new BeanFieldGroup<XmlPerson>((Class<XmlPerson>) this.bean.getClass());
        this.binder.setItemDataSource((XmlPerson) bean);
        /*Class<?> entityClass = (Class<?>) IAssoEntityCapable.getClassType(this);
        this.serviceDelegate = (IDelegate) module.getBoundObject(IDelegate.class, entityClass);
        if (this.serviceDelegate == null) {
            logger.error("No service bound for " + entityClass.getSimpleName());
        }*/
    }


    public VerticalLayout initializeRootLayout(VaadinRequest request, Component view) {
        final VerticalLayout layout = new VerticalLayout();
        DataSeries dataSeries = new DataSeries()
                .add(1, 5, 8, 2, 3);

        SeriesDefaults seriesDefaults = new SeriesDefaults()
                .setRenderer(SeriesRenderers.BAR);

        Axes axes = new Axes()
                .addAxis(
                        new XYaxis().setRenderer(AxisRenderers.CATEGORY)
                                .setTicks(new Ticks()
                                        .add("a", "b", "c", "d", "e")));

        Highlighter highlighter = new Highlighter()
                .setShow(false);

        Options options = new Options()
                .setSeriesDefaults(seriesDefaults)
                .setAxes(axes)
                .setHighlighter(highlighter);

        DCharts chart = new DCharts()
                .setDataSeries(dataSeries)
                .setOptions(options)
                .show();
        layout.addComponent(chart);
        return layout;
    }


    public VerticalLayout initialize(VaadinRequest request, Grid.SelectionMode selectMode, EnumLayoutStyle style) {
        final VerticalLayout layout = new VerticalLayout();
        DataSeries dataSeries = new DataSeries()
                .add(1, 5, 8, 2, 3);

        SeriesDefaults seriesDefaults = new SeriesDefaults()
                .setRenderer(SeriesRenderers.PIE);

        Axes axes = new Axes()
                .addAxis(
                        new XYaxis().setRenderer(AxisRenderers.CATEGORY)
                                .setTicks(new Ticks()
                                        .add("a", "b", "c", "d", "e")));

        Highlighter highlighter = new Highlighter()
                .setShow(false);

        Options options = new Options()
                .setSeriesDefaults(seriesDefaults)
                .setAxes(axes)
                .setHighlighter(highlighter);

        DCharts chart = new DCharts()
                .setDataSeries(dataSeries)
                .setOptions(options)
                .show();
        layout.addComponent(chart);
        return layout;
    }


    public VerticalLayout initialize(VaadinRequest request, EnumLayoutStyle style) {
        final VerticalLayout layout = new VerticalLayout();
        DataSeries dataSeries = new DataSeries()
                .add(1, 5, 8, 2, 3);

        SeriesDefaults seriesDefaults = new SeriesDefaults()
                .setRenderer(SeriesRenderers.BAR);

        Axes axes = new Axes()
                .addAxis(
                        new XYaxis().setRenderer(AxisRenderers.CATEGORY)
                                .setTicks(new Ticks()
                                        .add("a", "b", "c", "d", "e")));

        Highlighter highlighter = new Highlighter()
                .setShow(false);

        Options options = new Options()
                .setSeriesDefaults(seriesDefaults)
                .setAxes(axes)
                .setHighlighter(highlighter);

        DCharts chart = new DCharts()
                .setDataSeries(dataSeries)
                .setOptions(options)
                .show();
        layout.addComponent(chart);
        return layout;
    }


    public VerticalLayout initialize(VaadinRequest request, Grid.SelectionMode selectMode, Component component) {
        final VerticalLayout layout = new VerticalLayout();
        DataSeries dataSeries = new DataSeries()
                .add(1, 5, 8, 2, 3);

        SeriesDefaults seriesDefaults = new SeriesDefaults()
                .setRenderer(SeriesRenderers.BAR);

        Axes axes = new Axes()
                .addAxis(
                        new XYaxis().setRenderer(AxisRenderers.CATEGORY)
                                .setTicks(new Ticks()
                                        .add("a", "b", "c", "d", "e")));

        Highlighter highlighter = new Highlighter()
                .setShow(false);

        Options options = new Options()
                .setSeriesDefaults(seriesDefaults)
                .setAxes(axes)
                .setHighlighter(highlighter);

        DCharts chart = new DCharts()
                .setDataSeries(dataSeries)
                .setOptions(options)
                .show();
        layout.addComponent(chart);
        return layout;
    }


    public ITypeByTokenProvider getTypeByTokenProvider() {
        return ITypeByTokenCapable.getInstance(this);
    }

    public List<java.lang.reflect.Field> getAllBeanFields() {
        List<java.lang.reflect.Field> visibleFields = null;
        for (java.lang.reflect.Field field : this.bean.getClass().getDeclaredFields()) {
            if (visibleFields == null) {
                visibleFields = new ArrayList<>();
            }

            visibleFields.add(field);
        }

        return visibleFields;
    }

    public List<java.lang.reflect.Field> getDisplayableFields(List<String> displayedColumns, List<String> hiddenColumns) {
        if (displayedColumns == null && hiddenColumns == null)
            return getAllBeanFields();
        else {
            if (displayedColumns != null && displayedColumns.size() > 0) {
                List<java.lang.reflect.Field> visibleFields = new ArrayList<>();
                for (java.lang.reflect.Field field : this.bean.getClass().getDeclaredFields()) {
                    if (displayedColumns.contains(field.getName())) {
                        visibleFields.add(field);
                    }
                }
                return visibleFields;
            } else if (hiddenColumns != null && hiddenColumns.size() > 0) {
                List<java.lang.reflect.Field> visibleFields = new ArrayList<>();
                for (java.lang.reflect.Field field : this.bean.getClass().getDeclaredFields()) {
                    if (!hiddenColumns.contains(field.getName())) {
                        visibleFields.add(field);
                    }
                }
                return visibleFields;
            }
        }
        return null;
    }

    public boolean isBoundableField(java.lang.reflect.Field field) {
        if (field.getType() == String.class
                || field.getType() == Date.class
                || field.getType() == XMLGregorianCalendar.class
                || field.getType() == Integer.class
                || field.getType() == Double.class
                || field.getType() == Boolean.class
                || field.getType() == List.class
                || (field.getType() instanceof Class && ((Class<?>) field.getType()).isEnum())) {
            return true;
        }

        return false;
    }

    public GridLayout getGridLayout(UI ui, IModule module) {
        MGridLayout layout = new MGridLayout(4, bean.getClass().getDeclaredFields().length);

        layout.setSpacing(true);
        layout.setSizeUndefined();
        layout.setMargin(false);
        String componentLabel = null;
        AbstractField component = null;
        java.lang.reflect.Field identifiable = null;

        int row = 0;
        for (java.lang.reflect.Field field : getDisplayableFields(this.displayedFields, this.hiddenFields)) {
            if (isBoundableField(field)) {
                componentLabel = BundleExtractor.getStringValue(constantBundle, field.getName());
                Boolean readOnly = BundleExtractor.isReadOnly(constantBundle, field.getName());
                Boolean mandatory = BundleExtractor.isMandatory(constantBundle, field.getName());
                Integer length = BundleExtractor.getLength(constantBundle, field.getName());
                component = null;
                identifiable = null;

                if (field.getType() == String.class && !field.getName().endsWith("Id")) {
                    if (field.getName().toUpperCase().contains("LOGIN")) {
                        component = new TextField();
                        //component.setIcon(FontAwesome.USER);
                        component.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);

                    } else if (field.getName().toUpperCase().contains("PASSWORD")) {
                        component = new PasswordField();
                        //component.setIcon(FontAwesome.KEY);
                        component.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
                    } else if (field.getName().toUpperCase().contains("EMAIL")) {
                        component = new EmailField();
                        //component.setIcon(FontAwesome.ENVELOPE);
                        component.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
                    } else if (field.getName().toUpperCase().endsWith("TEXTAREA")) {
                        component = new TextArea();
                    } else {
                        component = new TextField();
                    }
                } else if (field.getType() == Date.class) {
                    component = new DateField();
                    if (field.getName().endsWith("Time")) {
                        ((DateField) component).setResolution(Resolution.MINUTE);
                    }
                } else if (field.getType() == XMLGregorianCalendar.class) {
                    component = new DateField();
                    if (field.getName().endsWith("Time")) {
                        ((DateField) component).setResolution(Resolution.MINUTE);
                    }
                    component.setConverter(new XMLGregorianCalendarDateConverter());
                } else if (field.getType() == Integer.class || field.getType() == String.class) {
                    if (field.getType() == Integer.class) {
                        component = new IntegerField();

                    } else if (field.getType() == String.class) {
                        component = new TextField();
                    }
                    if (field.getName().endsWith("Id")) {
                        try {
                            identifiable = bean.getClass().getDeclaredField(field.getName().replace("Id", ""));
                        } catch (NoSuchFieldException e) {
                            logger.warn(e.getCause().getMessage());
                            //e.printStackTrace();
                        }
                    }
                } else if (field.getType() == List.class) {
                    if (field.getName().endsWith("Ids")) {
                        try {
                            component = new ListSelect();
                            component.setSizeFull();
                            field.setAccessible(true);
                            if (binder.getItemDataSource() != null && binder.getItemDataSource().getBean() != null) {
                                List<Integer> ids = (List<Integer>) field.get(binder.getItemDataSource().getBean());
                                if (ids != null && ids.size() > 0) {
                                    ((ListSelect) component).addItems(ids);
                                }
                            }
                            identifiable = bean.getClass().getDeclaredField(field.getName().replace("Ids", "Set"));
                        } catch (NoSuchFieldException e) {
                            logger.warn(e.getCause().getMessage());
                            //e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                } else if (field.getType() == Double.class) {
                    component = new TextField();
                    component.addValidator(new DoubleValidator());
                } else if (field.getType() == Boolean.class) {
                    component = new CheckBox();
                } else if (field.getType() instanceof Class && ((Class<?>) field.getType()).isEnum()) {
                    component = new ComboBox();
                    ((ComboBox) component).addItems(IEnumUtils.asOptionList(field.getType()));
                    for (Object id : ((ComboBox) component).getItemIds()) {
                        ((ComboBox) component).setItemCaption(id, BundleExtractor.getStringValue(constantBundle, id.toString()));
                    }
                }

                if (component != null) {
                    if (this.mandatoryFields != null && this.mandatoryFields.contains(field.getName())) {
                        component.setImmediate(true);
                        component.setRequired(true);
                        component.setRequiredError(IMessageHelper.composeMsg(IMessageHelper.getDefaultString(ErrorConstantBundle.class, "RequiredFieldMsg"), componentLabel));
                    } else if (applyMandatory) {
                        component.setImmediate(mandatory);
                        component.setRequired(mandatory);
                        component.setRequiredError(IMessageHelper.composeMsg(IMessageHelper.getDefaultString(ErrorConstantBundle.class, "RequiredFieldMsg"), componentLabel));
                    }

                    component.setId(field.getName());
                    this.binder.bind(component, field.getName());

                    if (component.getValue() == null) {
                        component.clear();
                    }

                    if (this.readOnlyFields != null && this.readOnlyFields.contains(field.getName())) {
                        component.setReadOnly(true);
                    } else if (applyReadOnly) {
                        component.setReadOnly(readOnly);
                    }

                    if (AbstractTextField.class.isAssignableFrom(component.getClass())) {
                        ((AbstractTextField) component).setMaxLength(length);
                    }

                    Label label = new Label(componentLabel);
                    layout.addComponent(label, 1, row);
                    layout.setComponentAlignment(label, Alignment.MIDDLE_RIGHT);
                    if (identifiable != null) {
                        component.setData(identifiable);
                        layout.addComponent(component, 2, row);
                        this.fieldsMap.put(componentLabel, component);
                        MButton selectButton = new MButton(FontAwesome.LIST, clickEvent -> {
                            java.lang.reflect.Field fieldData = (java.lang.reflect.Field) ((AbstractField) clickEvent.getButton().getData()).getData();
                            if (fieldData != null) {
                                Grid.SelectionMode selectMode = (fieldData.getType() == List.class ? Grid.SelectionMode.MULTI : Grid.SelectionMode.SINGLE);
                                ConsultWindow selectWindow = new ConsultWindow(UI.getCurrent(), module, fieldData, selectMode);
                                selectWindow.setIdFieled((AbstractField) clickEvent.getButton().getData());
                                selectWindow.Show();
                            }
                        });
                        selectButton.setData(component);

                        layout.addComponent(selectButton, 3, row);
                    } else {
                        layout.addComponent(component, 2, row);
                        this.fieldsMap.put(componentLabel, component);
                    }

                    row++;
                }
            }
        }

        return layout;
    }


    public void buildLayoutWithComponents(AbstractLayout layout, UI ui, IModule module) {
        String componentLabel = null;
        AbstractField component = null;
        java.lang.reflect.Field identifiable = null;
        for (java.lang.reflect.Field field : getDisplayableFields(this.displayedFields, this.hiddenFields)) {
            if (isBoundableField(field)) {
                componentLabel = BundleExtractor.getStringValue(constantBundle, field.getName());
                Boolean readOnly = BundleExtractor.isReadOnly(constantBundle, field.getName());
                Boolean mandatory = BundleExtractor.isMandatory(constantBundle, field.getName());
                Integer length = BundleExtractor.getLength(constantBundle, field.getName());
                component = null;
                identifiable = null;
                if (field.getType() == String.class && !field.getName().endsWith("Id")) {
                    if (field.getName().toUpperCase().contains("LOGIN")) {
                        component = new TextField(componentLabel);
                        component.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
                        component.setIcon(FontAwesome.USER);
                    } else if (field.getName().toUpperCase().contains("PASSWORD")) {
                        component = new PasswordField(componentLabel);
                        component.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
                        component.setIcon(FontAwesome.KEY);
                    } else if (field.getName().toUpperCase().contains("EMAIL")) {
                        component = new EmailField(componentLabel);
                        component.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
                        component.setIcon(FontAwesome.ENVELOPE);
                    } else if (field.getName().toUpperCase().endsWith("TEXTAREA")) {
                        component = new TextArea(componentLabel);
                    } else {
                        component = new TextField(componentLabel);
                    }
                } else if (field.getType() == Date.class) {
                    component = new DateField(componentLabel);
                    if (field.getName().endsWith("Time")) {
                        ((DateField) component).setResolution(Resolution.MINUTE);
                    }
                } else if (field.getType() == XMLGregorianCalendar.class) {
                    component = new DateField(componentLabel);
                    if (field.getName().endsWith("Time")) {
                        ((DateField) component).setResolution(Resolution.MINUTE);
                    }
                    component.setConverter(new XMLGregorianCalendarDateConverter());
                } else if (field.getType() == Integer.class || field.getType() == String.class) {
                    if (field.getType() == Integer.class) {
                        component = new IntegerField(componentLabel);
                    } else if (field.getType() == String.class) {
                        component = new TextField(componentLabel);
                    }
                    if (field.getName().endsWith("Id")) {
                        try {
                            identifiable = bean.getClass().getDeclaredField(field.getName().replace("Id", ""));
                        } catch (NoSuchFieldException e) {
                            logger.warn(e.getCause().getMessage());
                            //e.printStackTrace();
                        }
                    }
                } else if (field.getType() == List.class) {
                    if (field.getName().endsWith("Ids")) {
                        try {
                            component = new ListSelect(componentLabel);
                            component.setSizeFull();
                            field.setAccessible(true);
                            if (binder.getItemDataSource() != null && binder.getItemDataSource().getBean() != null) {
                                List<Integer> ids = (List<Integer>) field.get(binder.getItemDataSource().getBean());
                                if (ids != null && ids.size() > 0) {
                                    ((ListSelect) component).addItems(ids);
                                }
                            }
                            identifiable = bean.getClass().getDeclaredField(field.getName().replace("Ids", "Set"));
                        } catch (NoSuchFieldException e) {
                            logger.warn(e.getCause().getMessage());
                            //e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                } else if (field.getType() == Double.class) {
                    component = new TextField(componentLabel);
                    component.addValidator(new DoubleValidator());
                } else if (field.getType() == Boolean.class) {
                    component = new CheckBox(componentLabel);
                } else if (field.getType() instanceof Class && ((Class<?>) field.getType()).isEnum()) {
                    component = new ComboBox(componentLabel, IEnumUtils.asOptionList(field.getType()));
                    for (Object id : ((ComboBox) component).getItemIds()) {
                        ((ComboBox) component).setItemCaption(id, BundleExtractor.getStringValue(constantBundle, id.toString()));
                    }
                }

                if (component != null) {
                    if (this.mandatoryFields != null && this.mandatoryFields.contains(field.getName())) {
                        component.setImmediate(true);
                        component.setRequired(true);
                        component.setRequiredError(IMessageHelper.composeMsg(IMessageHelper.getDefaultString(ErrorConstantBundle.class, "RequiredFieldMsg"), componentLabel));
                    } else if (applyMandatory) {
                        component.setImmediate(mandatory);
                        component.setRequired(mandatory);
                        component.setRequiredError(IMessageHelper.composeMsg(IMessageHelper.getDefaultString(ErrorConstantBundle.class, "RequiredFieldMsg"), componentLabel));
                    }

                    component.setId(field.getName());
                    this.binder.bind(component, field.getName());

                    if (component.getValue() == null) {
                        component.clear();
                    }

                    if (this.readOnlyFields != null && this.readOnlyFields.contains(field.getName())) {
                        component.setReadOnly(true);
                    } else if (applyReadOnly) {
                        component.setReadOnly(readOnly);
                    }

                    if (AbstractTextField.class.isAssignableFrom(component.getClass())) {
                        ((AbstractTextField) component).setMaxLength(length);
                    }

                    if (identifiable != null) {
                        component.setData(identifiable);
                        this.fieldsMap.put(componentLabel, component);
                        layout.addComponent(component);
                        MButton selectButton = new MButton(FontAwesome.LIST, clickEvent -> {
                            java.lang.reflect.Field fieldData = (java.lang.reflect.Field) ((AbstractField) clickEvent.getButton().getData()).getData();
                            if (fieldData != null) {
                                Grid.SelectionMode selectMode = (fieldData.getType() == List.class ? Grid.SelectionMode.MULTI : Grid.SelectionMode.SINGLE);
                                ConsultWindow selectWindow = new ConsultWindow(UI.getCurrent(), module, fieldData, selectMode);
                                selectWindow.setIdFieled((AbstractField) clickEvent.getButton().getData());
                                selectWindow.Show();
                            }
                        });
                        selectButton.setData(component);

                        layout.addComponent(selectButton);
                    } else {
                        layout.addComponent(component);
                        this.fieldsMap.put(componentLabel, component);
                    }
                }
            }
        }
    }


    public void buildCustomLayoutWithComponents(CustomLayout layout, UI ui, IModule module) {
        String componentLabel = null;
        AbstractField component = null;
        java.lang.reflect.Field identifiable = null;
        for (java.lang.reflect.Field field : getDisplayableFields(this.displayedFields, this.hiddenFields)) {
            if (isBoundableField(field)) {
                componentLabel = BundleExtractor.getStringValue(constantBundle, field.getName());
                Boolean readOnly = BundleExtractor.isReadOnly(constantBundle, field.getName());
                Boolean mandatory = BundleExtractor.isMandatory(constantBundle, field.getName());
                Integer length = BundleExtractor.getLength(constantBundle, field.getName());
                component = null;
                identifiable = null;
                if (field.getType() == String.class && !field.getName().endsWith("Id")) {
                    if (field.getName().toUpperCase().contains("LOGIN")) {
                        component = new TextField();
                        component.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
                        component.setIcon(FontAwesome.USER);
                    } else if (field.getName().toUpperCase().contains("PASSWORD")) {
                        component = new PasswordField();
                        component.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
                        component.setIcon(FontAwesome.KEY);
                    } else if (field.getName().toUpperCase().contains("EMAIL")) {
                        component = new EmailField();
                        component.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
                        component.setIcon(FontAwesome.ENVELOPE);
                    } else if (field.getName().toUpperCase().endsWith("TEXTAREA")) {
                        component = new TextArea();
                    } else {
                        component = new TextField();
                    }
                } else if (field.getType() == Date.class) {
                    component = new DateField();
                    if (field.getName().endsWith("Time")) {
                        ((DateField) component).setResolution(Resolution.MINUTE);
                    }
                } else if (field.getType() == XMLGregorianCalendar.class) {
                    component = new DateField();
                    if (field.getName().endsWith("Time")) {
                        ((DateField) component).setResolution(Resolution.MINUTE);
                    }
                    component.setConverter(new XMLGregorianCalendarDateConverter());
                } else if (field.getType() == Integer.class || field.getType() == String.class) {
                    if (field.getType() == Integer.class) {
                        component = new IntegerField();
                    } else if (field.getType() == String.class) {
                        component = new TextField();
                    }

                    if (field.getName().endsWith("Id")) {
                        try {
                            identifiable = bean.getClass().getDeclaredField(field.getName().replace("Id", ""));
                        } catch (NoSuchFieldException e) {
                            logger.warn(e.getCause().getMessage());
                            //e.printStackTrace();
                        }
                    }
                } else if (field.getType() == List.class) {
                    if (field.getName().endsWith("Ids")) {
                        try {
                            component = new ListSelect();
                            component.setSizeFull();
                            field.setAccessible(true);
                            if (binder.getItemDataSource() != null && binder.getItemDataSource().getBean() != null) {
                                List<Integer> ids = (List<Integer>) field.get(binder.getItemDataSource().getBean());
                                if (ids != null && ids.size() > 0) {
                                    ((ListSelect) component).addItems(ids);
                                }
                            }
                            identifiable = bean.getClass().getDeclaredField(field.getName().replace("Ids", "Set"));
                        } catch (NoSuchFieldException e) {
                            logger.warn(e.getCause().getMessage());
                            //e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                } else if (field.getType() == Double.class) {
                    component = new TextField();
                    component.addValidator(new DoubleValidator());
                } else if (field.getType() == Boolean.class) {
                    component = new CheckBox();
                } else if (field.getType() instanceof Class && ((Class<?>) field.getType()).isEnum()) {
                    component = new ComboBox();
                    ((ComboBox) component).addItems(IEnumUtils.asOptionList(field.getType()));
                    for (Object id : ((ComboBox) component).getItemIds()) {
                        ((ComboBox) component).setItemCaption(id, BundleExtractor.getStringValue(constantBundle, id.toString()));
                    }
                }

                if (component != null) {
                    component.setSizeFull();

                    if (this.mandatoryFields != null && this.mandatoryFields.contains(field.getName())) {
                        component.setImmediate(true);
                        component.setRequired(true);
                        component.setRequiredError(IMessageHelper.composeMsg(IMessageHelper.getDefaultString(ErrorConstantBundle.class, "RequiredFieldMsg"), componentLabel));
                    } else if (applyMandatory) {
                        component.setImmediate(mandatory);
                        component.setRequired(mandatory);
                        component.setRequiredError(IMessageHelper.composeMsg(IMessageHelper.getDefaultString(ErrorConstantBundle.class, "RequiredFieldMsg"), componentLabel));
                    }

                    component.setId(field.getName());
                    this.binder.bind(component, field.getName());

                    if (component.getValue() == null) {
                        component.clear();
                    }

                    if (this.readOnlyFields != null && this.readOnlyFields.contains(field.getName())) {
                        component.setReadOnly(true);
                    } else if (applyReadOnly) {
                        component.setReadOnly(readOnly);
                    }

                    if (AbstractTextField.class.isAssignableFrom(component.getClass())) {
                        ((AbstractTextField) component).setMaxLength(length);
                    }

                    if (identifiable != null) {
                        component.setData(identifiable);
                        layout.addComponent(component, field.getName());
                        this.fieldsMap.put(componentLabel, component);
                        MButton selectButton = new MButton(FontAwesome.LIST, clickEvent -> {
                            java.lang.reflect.Field fieldData = (java.lang.reflect.Field) ((AbstractField) clickEvent.getButton().getData()).getData();
                            if (fieldData != null) {
                                Grid.SelectionMode selectMode = (fieldData.getType() == List.class ? Grid.SelectionMode.MULTI : Grid.SelectionMode.SINGLE);
                                ConsultWindow selectWindow = new ConsultWindow(UI.getCurrent(), module, fieldData, selectMode);
                                selectWindow.setIdFieled((AbstractField) clickEvent.getButton().getData());
                                selectWindow.Show();
                            }
                        });
                        selectButton.setData(component);

                        layout.addComponent(selectButton, field.getName() + "Btn");
                    } else {
                        layout.addComponent(component, field.getName());
                        this.fieldsMap.put(componentLabel, component);
                    }
                }
            }
        }
    }

    public String getCustomHtmlFile() {
        return ICustomCapable.getHtmlFileName(this);
    }

    class DoubleValidator implements Validator {
        @Override
        public void validate(Object value)
                throws InvalidValueException {
            if (value != null && !(value instanceof Double) && !(value instanceof Integer)) {
                throw new InvalidValueException("The value is not a number");
            }
        }
    }
}
