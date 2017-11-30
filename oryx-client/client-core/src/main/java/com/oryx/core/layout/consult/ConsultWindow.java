package com.oryx.core.layout.consult;

import com.oryx.core.bundle.common.ErrorConstantBundle;
import com.oryx.core.bundle.helper.IMessageHelper;
import com.oryx.core.gui.ILayout;
import com.oryx.core.gui.enums.EnumLayoutStyle;
import com.oryx.core.helper.CommonServiceHelper;
import com.oryx.core.layout.IFormLayout;
import com.oryx.core.layout.component.button.ButtonView;
import com.oryx.core.layout.component.button.EnumButtonAction;
import com.oryx.core.layout.component.button.IButtonView;
import com.oryx.core.module.ILayoutForSelectionKey;
import com.oryx.core.module.IModule;
import com.oryx.core.parameter.IClientParameterNames;
import com.oryx.core.provider.IEntityMethodProvider;
import com.vaadin.data.Container;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.*;
import org.vaadin.viritin.layouts.MPanel;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;


/**
 * Created by 241180 on 23/03/2017.
 */
public class ConsultWindow extends Window {
    private VerticalLayout rootLayout;
    private Class<?> genericListClass;
    private IButtonView buttonView;
    private IModule module;
    private UI ui;
    private Field field;
    private Grid.SelectionMode selectMode;
    private AbstractField idFieled;
    private ILayout layout;

    public ConsultWindow(UI ui, IModule module, Field field, Grid.SelectionMode selectMode) {
        super();
        this.ui = ui;
        this.module = module;
        this.field = field;
        this.setCaption(field.getName());
        this.selectMode = selectMode;
    }

    public void setUi(UI ui) {
        this.ui = ui;
    }

    public AbstractField getIdFieled() {
        return idFieled;
    }

    public void setIdFieled(AbstractField idFieled) {
        this.idFieled = idFieled;
    }

    public void Show() {
        this.setModal(true);
        this.center();

        Boolean consultWindowFullSize = Boolean.valueOf(CommonServiceHelper.getParameterService().getValue(UUID.fromString((String) VaadinSession.getCurrent().getAttribute("USER_ID")), IClientParameterNames.CONS_WINDOW_FULL_SIZE));
        if (consultWindowFullSize) {
            this.setSizeFull();
        } else {
            this.setSizeUndefined();
        }

        if (this.rootLayout == null) {
            this.rootLayout = new VerticalLayout();
            this.rootLayout.setMargin(false);
            VerticalLayout entityListLayout = new VerticalLayout();
            entityListLayout.setSizeFull();
            entityListLayout.setMargin(false);
            entityListLayout.setSpacing(true);
            if (field != null) {
                if (field.getType() == List.class) {
                    ParameterizedType genericListType = (ParameterizedType) field.getGenericType();
                    this.genericListClass = (Class<?>) genericListType.getActualTypeArguments()[0];
                    this.layout = (IFormLayout) module.getBoundObject(ILayoutForSelectionKey.class, this.genericListClass);
                } else {
                    this.layout = (IFormLayout) module.getBoundObject(ILayoutForSelectionKey.class, field.getType());
                }
            }

            if (this.layout != null) {
                if (this.field.getType() == List.class) {
                    entityListLayout.addComponent(this.layout.initialize(null, selectMode, EnumLayoutStyle.CONSULT));
                    //this.ui.getBasicCrudButtons().updateButtonForSelection();
                    List<UUID> selectIds = new ArrayList<>();

                    if (((ListSelect) idFieled).getItemIds() != null && ((ListSelect) idFieled).getItemIds().size() > 0) {
                        try {
                            for (Object o : ((ListSelect) idFieled).getItemIds()) {
                                if (o instanceof String) {
                                    selectIds.add(UUID.fromString((String) o));
                                } else if (o instanceof UUID) {
                                    selectIds.add((UUID) o);
                                }
                            }
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                    }

                    ((IFormLayout) this.layout).refresh();
                    ((IFormLayout) this.layout).setSelectedValues(selectIds);
                } else {
                    entityListLayout.addComponent(this.layout.initialize(null, selectMode, EnumLayoutStyle.CONSULT));
                    //this.ui.getBasicCrudButtons().updateButtonForSelection();
                    UUID selectId = null;

                    if (idFieled.getValue() != null && !((String) idFieled.getValue()).isEmpty()) {
                        try {
                            if (idFieled.getValue() instanceof String) {
                                selectId = UUID.fromString((String) idFieled.getValue());
                            } else if (idFieled.getValue() instanceof UUID) {
                                selectId = (UUID) idFieled.getValue();
                            }
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                            selectId = null;
                        }
                    }

                    ((IFormLayout) this.layout).refresh();
                    ((IFormLayout) this.layout).setSelectedValue(selectId);
                }
            }
            this.rootLayout.addComponent(new MPanel(entityListLayout));

            Boolean consultBtnWithNoCaption = Boolean.valueOf(CommonServiceHelper.getParameterService().getValue(UUID.fromString((String) VaadinSession.getCurrent().getAttribute("USER_ID")), IClientParameterNames.CONS_BTN_WITH_NO_CAPTION));
            this.buttonView = new ButtonView(!consultBtnWithNoCaption, null
                    , EnumButtonAction.CANCEL
                    , EnumButtonAction.VALIDATE);
            this.buttonView.addClickListener(EnumButtonAction.CANCEL, clickEvent -> {
                ui.removeWindow(this);
                if (this.layout != null) {
                    //this.ui.getBasicCrudButtons().updateButtonForEdition();
                }
                this.close();
            });

            this.buttonView.addClickListener(EnumButtonAction.VALIDATE, clickEvent -> {
                try {
                    boolean canValidate = false;
                    if (this.field.getType() == List.class) {
                        Collection<Object> values = ((IFormLayout) this.layout).getSelectedValues();
                        Field itemsField = ((ListSelect) this.idFieled).getClass().getSuperclass().getDeclaredField("items");
                        if (itemsField != null) {
                            itemsField.setAccessible(true);
                            ((Container) itemsField.get(((ListSelect) this.idFieled))).removeAllItems();
                        }
                        if (values != null && values.size() > 0) {
                            canValidate = true;
                            for (Object o : values) {
                                String getId = (String) IEntityMethodProvider.GET_ID_METHOD(o.getClass()).invoke(o);
                                if (getId != null && !getId.isEmpty()) {
                                    UUID id = UUID.fromString(getId);
                                    if (id != null) {
                                        ((ListSelect) this.idFieled).addItem(id);
                                    }
                                }
                            }
                        }
                    } else {
                        Object value = ((IFormLayout) this.layout).getSelectedValue();
                        if (value != null) {
                            canValidate = true;
                            String getId = (String) IEntityMethodProvider.GET_ID_METHOD(value.getClass()).invoke(value);
                            if (getId != null && !getId.isEmpty()) {
                                UUID id = UUID.fromString(getId);
                                if (id != null) {
                                    this.idFieled.setValue(id.toString());
                                }
                            }
                        }
                    }
                    if (canValidate) {
                        this.close();
                    } else {
                        Notification.show(IMessageHelper.getDefaultString(ErrorConstantBundle.class, "SelectionIsEmpty"));
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } finally {
                }
            });

            this.buttonView.setDefaultComponentAlignment(Alignment.MIDDLE_RIGHT);
            Panel btnPanel = new MPanel(this.buttonView.getHorizontalLayout(UI.getCurrent(), module));
            this.rootLayout.addComponent(btnPanel);

            this.setContent(this.rootLayout);
        }

        ui.addWindow(this);
    }

    @Override
    public void close() {
        ui.removeWindow(this);
        super.close();
    }
}
