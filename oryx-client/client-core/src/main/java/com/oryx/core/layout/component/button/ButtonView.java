package com.oryx.core.layout.component.button;

import com.oryx.core.layout.component.IBeanView;

import java.util.List;

/**
 * Created by smbarki on 07/04/2017.
 */
public class ButtonView<B> extends AbstractButtonView<B> {
    public ButtonView(Boolean withCaption, List<IBeanView> views, EnumButtonAction... actions) {
        super(withCaption, views, actions);
    }
}
