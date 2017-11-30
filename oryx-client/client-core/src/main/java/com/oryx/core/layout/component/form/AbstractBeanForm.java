package com.oryx.core.layout.component.form;

import com.oryx.core.bundle.IBundle;
import com.oryx.core.bundle.common.ErrorConstantBundle;
import com.oryx.core.bundle.helper.IMessageHelper;
import com.oryx.core.bundle.loader.IBundleLoader;
import com.oryx.core.bundle.tools.BundleExtractor;
import com.oryx.core.converter.XMLGregorianCalendarDateConverter;
import com.oryx.core.helper.CommonServiceHelper;
import com.oryx.core.layout.consult.ConsultWindow;
import com.oryx.core.layout.helper.IFormLayoutHelper;
import com.oryx.core.module.IModule;
import com.oryx.core.option.IEnumUtils;
import com.oryx.core.parameter.IClientParameterNames;
import com.oryx.core.provider.IListMethodProvider;
import com.vaadin.data.Validator;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.apache.log4j.Logger;
import org.apache.velocity.context.Context;
import org.vaadin.viritin.button.MButton;
import org.vaadin.viritin.fields.EmailField;
import org.vaadin.viritin.fields.IntegerField;
import org.vaadin.viritin.layouts.MGridLayout;

import javax.xml.datatype.XMLGregorianCalendar;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * Created by smbarki on 07/04/2017.
 */

public abstract class AbstractBeanForm<B> implements IBeanForm<B> {
    final static Logger logger = Logger.getLogger(AbstractBeanForm.class);
    //B For Bean
    private BeanFieldGroup<B> binder = null;
    private Class<B> beanType = null;
    private int depth = 1;
    private boolean applyReadOnly;
    private boolean applyMandatory;
    private Map<String, AbstractField> fieldsMap;
    private Class<? extends IBundle> constantBundle;
    private List<String> displayedFields;
    private List<String> hiddenFields;
    private List<String> mandatoryFields;
    private List<String> readOnlyFields;
    private Alignment defaultAlignment = Alignment.BOTTOM_LEFT;
    private Component rootLayout;

    public AbstractBeanForm(B bean, Class<? extends IBundle> constantBundle, int depth, boolean applyRadOnly, boolean applyMonadatory) {
        this.beanType = (Class<B>) bean.getClass();
        this.binder = new BeanFieldGroup<>(beanType);
        this.binder.setItemDataSource(bean);
        this.constantBundle = constantBundle;
        this.depth = depth;
        this.fieldsMap = new HashMap<>();
        this.applyMandatory = applyMonadatory;
        this.applyReadOnly = applyRadOnly;
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

    public Alignment getDefaultAlignment() {
        return defaultAlignment;
    }

    public void setDefaultAlignment(Alignment defaultAlignment) {
        this.defaultAlignment = defaultAlignment;
    }


    public GridLayout getGridLayout(UI ui, IModule module) {
        MGridLayout layout = new MGridLayout(4, beanType.getDeclaredFields().length);

        layout.setResponsive(true);
        layout.setSpacing(true);
        layout.setSizeUndefined();
        layout.setMargin(true);
        String componentLabel = null;
        AbstractField component = null;
        java.lang.reflect.Field identifiable = null;

        int row = 0;
        for (java.lang.reflect.Field field : getDisplayableFields(this.displayedFields, this.hiddenFields)) {
            if (IFormLayoutHelper.isBoundableField(field)) {
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
                        //component.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);

                    } else if (field.getName().toUpperCase().contains("PASSWORD")) {
                        component = new PasswordField();
                        //component.setIcon(FontAwesome.KEY);
                        //component.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
                    } else if (field.getName().toUpperCase().contains("EMAIL")) {
                        component = new EmailField();
                        //component.setIcon(FontAwesome.ENVELOPE);
                        //component.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
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
                            identifiable = beanType.getDeclaredField(field.getName().replace("Id", ""));
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
                            identifiable = beanType.getDeclaredField(field.getName().replace("Ids", "Set"));
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

    @Override
    public void buildLayoutWithComponents(AbstractLayout layout, UI ui, IModule module) {
        String componentLabel = null;
        AbstractField component = null;
        java.lang.reflect.Field identifiable = null;
        for (Field field : getDisplayableFields(this.displayedFields, this.hiddenFields)) {
            if (IFormLayoutHelper.isBoundableField(field)) {
                componentLabel = BundleExtractor.getStringValue(constantBundle, field.getName());
                Boolean readOnly = BundleExtractor.isReadOnly(constantBundle, field.getName());
                Boolean mandatory = BundleExtractor.isMandatory(constantBundle, field.getName());
                Integer length = BundleExtractor.getLength(constantBundle, field.getName());
                component = null;
                identifiable = null;
                if (field.getType() == String.class && !field.getName().endsWith("Id")) {
                    if (field.getName().toUpperCase().contains("LOGIN")) {
                        component = new TextField(componentLabel);
                        //component.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
                        //component.setIcon(FontAwesome.USER);
                    } else if (field.getName().toUpperCase().contains("PASSWORD")) {
                        component = new PasswordField(componentLabel);
                        //component.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
                        //component.setIcon(FontAwesome.KEY);
                    } else if (field.getName().toUpperCase().contains("EMAIL")) {
                        component = new EmailField(componentLabel);
                        //component.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
                        //component.setIcon(FontAwesome.ENVELOPE);
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
                            identifiable = beanType.getDeclaredField(field.getName().replace("Id", ""));
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
                            identifiable = beanType.getDeclaredField(field.getName().replace("Ids", "Set"));
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

    @Override
    public void buildCustomLayoutWithComponents(CustomLayout layout, UI ui, IModule module) {
        String componentLabel = null;
        AbstractField component = null;
        java.lang.reflect.Field identifiable = null;
        Boolean setCaption = Boolean.valueOf(CommonServiceHelper.getParameterService().getValue(IClientParameterNames.SET_FIELD_CAPTION));
        for (Field field : getDisplayableFields(this.displayedFields, this.hiddenFields)) {
            if (IFormLayoutHelper.isBoundableField(field)) {
                componentLabel = BundleExtractor.getStringValue(constantBundle, field.getName());
                Boolean readOnly = BundleExtractor.isReadOnly(constantBundle, field.getName());
                Boolean mandatory = BundleExtractor.isMandatory(constantBundle, field.getName());
                Integer length = BundleExtractor.getLength(constantBundle, field.getName());
                component = null;
                identifiable = null;
                if (field.getType() == String.class && !field.getName().endsWith("Id")) {
                    if (field.getName().toUpperCase().contains("LOGIN")) {
                        component = new TextField();
                        //component.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
                        //component.setIcon(FontAwesome.USER);
                    } else if (field.getName().toUpperCase().contains("PASSWORD")) {
                        component = new PasswordField();
                        //component.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
                        //component.setIcon(FontAwesome.KEY);
                    } else if (field.getName().toUpperCase().contains("EMAIL")) {
                        component = new EmailField();
                        //component.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
                        //component.setIcon(FontAwesome.ENVELOPE);
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
                            identifiable = beanType.getDeclaredField(field.getName().replace("Id", ""));
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
                            identifiable = beanType.getDeclaredField(field.getName().replace("Ids", "Set"));
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
                    if (setCaption) {
                        component.setCaption(componentLabel);
                    }
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
                        MButton selectButton = new MButton("...").withListener(clickEvent -> {
                            java.lang.reflect.Field fieldData = (java.lang.reflect.Field) ((AbstractField) clickEvent.getButton().getData()).getData();
                            if (fieldData != null) {
                                Grid.SelectionMode selectMode = (fieldData.getType() == List.class ? Grid.SelectionMode.MULTI : Grid.SelectionMode.SINGLE);
                                ConsultWindow selectWindow = new ConsultWindow(UI.getCurrent(), module, fieldData, selectMode);
                                selectWindow.setIdFieled((AbstractField) clickEvent.getButton().getData());
                                selectWindow.Show();
                            }
                        });
                        selectButton.addStyleName(ValoTheme.BUTTON_TINY);
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

    @Override
    public VerticalLayout getVerticalLayout(UI ui, IModule module) {
        if (rootLayout == null) {
            rootLayout = new VerticalLayout();
            ((VerticalLayout) rootLayout).setDefaultComponentAlignment(this.defaultAlignment);
            ((VerticalLayout) rootLayout).setSpacing(true);
            ((VerticalLayout) rootLayout).setMargin(true);
            ((VerticalLayout) rootLayout).setSizeUndefined();
            buildLayoutWithComponents(((VerticalLayout) rootLayout), ui, module);
        }
        return ((VerticalLayout) rootLayout);
    }

    @Override
    public HorizontalLayout getHorizontalLayout(UI ui, IModule module) {
        if (rootLayout == null) {
            rootLayout = new HorizontalLayout();
            ((HorizontalLayout) rootLayout).setDefaultComponentAlignment(this.defaultAlignment);
            ((HorizontalLayout) rootLayout).setSpacing(true);
            ((HorizontalLayout) rootLayout).setMargin(true);
            ((HorizontalLayout) rootLayout).setSizeUndefined();
            buildLayoutWithComponents(((HorizontalLayout) rootLayout), ui, module);
        }
        return ((HorizontalLayout) rootLayout);
    }

    @Override
    public FormLayout getFormLayout(UI ui, IModule module) {
        if (rootLayout == null) {
            rootLayout = new FormLayout();
            ((FormLayout) rootLayout).setDefaultComponentAlignment(this.defaultAlignment);
            ((FormLayout) rootLayout).setSpacing(true);
            ((FormLayout) rootLayout).setMargin(true);
            ((FormLayout) rootLayout).setSizeUndefined();
            buildLayoutWithComponents(((FormLayout) rootLayout), ui, module);
        }
        return ((FormLayout) rootLayout);
    }

    @Override
    public CustomLayout getCustomLayout(UI ui, IModule module, String customHtml) {
        if (rootLayout == null) {
            if (customHtml == null) {
                customHtml = this.beanType.getSimpleName().toLowerCase();
            }
            Context ctx = IBundleLoader.getContext(Locale.ENGLISH, customHtml);
            ctx.put("title", BundleExtractor.getStringValue(constantBundle, beanType.getSimpleName()));
            InputStream template = IBundleLoader.getLayoutTemplate(Locale.ENGLISH, customHtml);
            try {
                rootLayout = new CustomLayout(template);
            } catch (IOException e) {
                e.printStackTrace();
            }
            rootLayout.setSizeUndefined();

            buildCustomLayoutWithComponents(((CustomLayout) rootLayout), ui, module);
        }
        return ((CustomLayout) rootLayout);
    }

    @Override
    public void setDefaultComponentAlignment(Alignment defaultAlignment) {
        this.defaultAlignment = defaultAlignment;
    }

    @Override
    public B getBean() {
        B bean = null;

        if (binder.isValid()) {
            try {
                binder.commit();
                bean = binder.getItemDataSource().getBean();

                //recupération des id selectionné (ne peut pas etre fait par le commit)
                if (bean != null) {
                    for (java.lang.reflect.Field field : bean.getClass().getDeclaredFields()) {
                        if (field.getType() == List.class && field.getName().endsWith("Ids")) {
                            com.vaadin.ui.Field mField = binder.getField(field.getName());
                            field.setAccessible(true);
                            try {
                                IListMethodProvider.REMOVE_ALL_METHOD(field.getType()).invoke(field.get(bean));
                                IListMethodProvider.ADD_ALL_METHOD(field.getType(), Collection.class).invoke(field.get(bean), ((ListSelect) mField).getItemIds());
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            } catch (FieldGroup.CommitException e) {
                bean = null;
                e.printStackTrace();
                logger.error(IMessageHelper.getDefaultString(ErrorConstantBundle.class, "CommitFailed"));
            }
        } else {
            logger.error(IMessageHelper.getDefaultString(ErrorConstantBundle.class, "CommitFailed"));
        }

        return bean;
    }

    public List<Field> getAllBeanFields() {
        List<Field> visibleFields = null;
        for (Field field : this.beanType.getDeclaredFields()) {
            if (visibleFields == null) {
                visibleFields = new ArrayList<>();
            }

            visibleFields.add(field);
        }

        return visibleFields;
    }

    public List<Field> getDisplayableFields(List<String> displayedColumns, List<String> hiddenColumns) {
        if (displayedColumns == null && hiddenColumns == null)
            return getAllBeanFields();
        else {
            if (displayedColumns != null && displayedColumns.size() > 0) {
                List<Field> visibleFields = new ArrayList<>();
                for (Field field : this.beanType.getDeclaredFields()) {
                    if (displayedColumns.contains(field.getName())) {
                        visibleFields.add(field);
                    }
                }
                return visibleFields;
            } else if (hiddenColumns != null && hiddenColumns.size() > 0) {
                List<Field> visibleFields = new ArrayList<>();
                for (Field field : this.beanType.getDeclaredFields()) {
                    if (!hiddenColumns.contains(field.getName())) {
                        visibleFields.add(field);
                    }
                }
                return visibleFields;
            }
        }
        return null;
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
    public void fetchBeansByCriteria() {

    }

    @Override
    public Collection<B> getBeans() {
        return null;
    }

    @Override
    public void deleteBeans() {

    }

    public void setEditable(boolean editable) {
        for (AbstractField field : this.fieldsMap.values()) {
            field.setReadOnly(editable);
        }
    }

    public void setEnabled(boolean enabled) {
        for (AbstractField field : this.fieldsMap.values()) {
            field.setEnabled(enabled);
        }
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