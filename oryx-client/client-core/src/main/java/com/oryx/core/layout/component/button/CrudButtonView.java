package com.oryx.core.layout.component.button;


import com.oryx.core.layout.component.IBeanView;

import java.util.List;

/**
 * Created by smbarki on 07/04/2017.
 */
public class CrudButtonView<B> extends AbstractButtonView<B> {
    public CrudButtonView(Boolean withCaption, List<IBeanView> views, EnumButtonAction... actions) {
        super(withCaption, views, EnumButtonAction.REFRESH, EnumButtonAction.FILTER, EnumButtonAction.CREATE, EnumButtonAction.EDIT, EnumButtonAction.DELETE);
    }
}
