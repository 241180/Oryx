package com.oryx.core.layout.component.form;

import com.oryx.core.helper.CommonServiceHelper;
import com.oryx.core.parameter.IClientParameterNames;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.Field;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;
import org.vaadin.viritin.layouts.MPanel;

import java.util.UUID;

/**
 * Created by smbarki on 15/08/2017.
 */
public class AutoGeneratedWindow<B> extends Window {
    private B bean;

    public AutoGeneratedWindow(B bean) {
        super(bean.getClass().getSimpleName()); // Set window caption

        this.setModal(true);
        this.center();
        Boolean autoGenWindowFullSize = Boolean.valueOf(CommonServiceHelper.getParameterService().getValue(UUID.fromString((String) (String) VaadinSession.getCurrent().getAttribute("USER_ID")), IClientParameterNames.AUTO_GEN_WINDOW_FULL_SIZE));
        if (autoGenWindowFullSize) {
            this.setSizeFull();
        } else {
            this.setSizeUndefined();
        }

        this.bean = bean;

        CustomLayout layout = new CustomLayout(bean.getClass().getSimpleName().toLowerCase());
        //VerticalLayout ui = new VerticalLayout();
        //ui.setSpacing(true);
        layout.setSizeFull();
        //ui.setMargin(true);
        setContent(new MPanel(layout));

        FieldGroup fieldGroup = new BeanFieldGroup<B>((Class<B>) bean.getClass());

        // We need an item data source before we create the fields to be able to
        // find the properties, otherwise we have to specify them by hand
        fieldGroup.setItemDataSource(new BeanItem<B>(bean));

        // Loop through the properties, build fields for them and add the fields
        // to this UI
        for (Object propertyId : fieldGroup.getUnboundPropertyIds())
            try {
                Field<?> field = new TextField();
                fieldGroup.bind(field, propertyId);
                field.setReadOnly(true);
                layout.addComponent(field, (String) propertyId);
            } catch (Exception e) {
                e.printStackTrace();
            }

    }
}