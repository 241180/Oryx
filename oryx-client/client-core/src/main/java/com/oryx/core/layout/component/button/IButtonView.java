package com.oryx.core.layout.component.button;

import com.oryx.core.layout.component.IView;
import com.oryx.core.layout.editor.IEditorLayout;
import com.vaadin.ui.Button;
import org.vaadin.viritin.button.MButton;

/**
 * Created by smbarki on 07/04/2017.
 */
public interface IButtonView<B> extends IView<B> {
    public void enableButton(String buttonName, boolean enabled);

    public MButton getButton(String buttonName, boolean enabled);

    public void refresh(Button.ClickEvent evt);

    public void create(Button.ClickEvent evt);

    public void edit(Button.ClickEvent evt);

    public void delete(Button.ClickEvent evt);

    public void filter(Button.ClickEvent evt);

    public void validate(Button.ClickEvent evt);

    public void reset(Button.ClickEvent evt);

    public void cancel(Button.ClickEvent evt);

    public IEditorLayout getEditorFormView();

    public void setEditorFormView(IEditorLayout editorFormView);

    public void addClickListener(EnumButtonAction action, Button.ClickListener listener);

    public void enableButton(EnumButtonAction action, boolean enabled);
}
