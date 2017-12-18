package com.oryx.core.mvc.dialog.bean;

import com.oryx.core.bundle.common.ErrorConstantBundle;
import com.oryx.core.bundle.helper.IMessageHelper;
import com.oryx.core.bundle.tools.BundleExtractor;
import com.oryx.core.converter.XMLGregorianCalendarDateConverter;
import com.oryx.core.helper.CommonServiceHelper;
import com.oryx.core.layout.component.form.AbstractBeanForm;
import com.oryx.core.layout.consult.ConsultWindow;
import com.oryx.core.layout.helper.IFormLayoutHelper;
import com.oryx.core.mvc.dialog.AbstractDialogDescriptor;
import com.oryx.core.mvc.view.AbstractViewDescriptor;
import com.oryx.core.option.IEnumUtils;
import com.oryx.core.parameter.IClientParameterNames;
import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.vaadin.viritin.button.MButton;
import org.vaadin.viritin.fields.EmailField;
import org.vaadin.viritin.fields.IntegerField;

import javax.xml.datatype.XMLGregorianCalendar;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

/**
 * Created by SAMI on 07/12/2017.
 */
public class BeanDialogDescriptor<E> extends AbstractDialogDescriptor<E> implements IBeanDialogDescriptor<E> {

    @Override
    public void buildLayoutContent() {
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
                    component.addValidator(new AbstractBeanForm.DoubleValidator());
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
}
