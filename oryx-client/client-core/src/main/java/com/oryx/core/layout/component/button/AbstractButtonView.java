package com.oryx.core.layout.component.button;

import com.oryx.core.bundle.tools.BundleExtractor;
import com.oryx.core.layout.component.IBeanView;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.layout.editor.IEditorLayout;
import com.oryx.core.module.IModule;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.vaadin.viritin.button.MButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by smbarki on 07/04/2017.
 */
public abstract class AbstractButtonView<B> implements IButtonView<B> {

    private Map<EnumButtonAction, MButton> buttonMap;
    private List<MButton> buttonOrderList; // to keep buttons order
    private List<IBeanView> views;
    private IEditorLayout<B> editorFormView;
    private Alignment defaultAlignment = Alignment.MIDDLE_LEFT;
    private Component rootLayout;

    //https://www.iconfinder.com
    public AbstractButtonView(Boolean withCaption, List<IBeanView> views, EnumButtonAction... actions) {
        super();
        this.views = views;
        if (this.buttonMap == null)
            this.buttonMap = new HashMap<>();

        if (this.buttonOrderList == null)
            this.buttonOrderList = new ArrayList<>();

        for (EnumButtonAction action : actions) {
            MButton button = null;
            switch (action) {
                case REFRESH: {
                    if (withCaption)
                        button = new MButton(FontAwesome.REFRESH, BundleExtractor.getStringValue(ButtonViewConstantsBundle.class, action.name()) //
                                , this::refresh);
                    else
                        button = new MButton(FontAwesome.REFRESH, this::refresh);
                }
                break;
                case CREATE: {
                    if (withCaption)
                        button = new MButton(FontAwesome.PLUS_SQUARE_O, BundleExtractor.getStringValue(ButtonViewConstantsBundle.class, action.name()) //
                                , this::create);
                    else
                        button = new MButton(FontAwesome.PLUS_SQUARE_O, this::create);
                }
                break;
                case EDIT: {
                    if (withCaption)
                        button = new MButton(FontAwesome.EDIT, BundleExtractor.getStringValue(ButtonViewConstantsBundle.class, action.name()) //
                                , this::edit);
                    else
                        button = new MButton(FontAwesome.EDIT, this::edit);
                }
                break;
                case DELETE: {
                    if (withCaption)
                        button = new MButton(FontAwesome.TRASH, BundleExtractor.getStringValue(ButtonViewConstantsBundle.class, action.name()) //
                                , this::delete);
                    else
                        button = new MButton(FontAwesome.TRASH, this::delete);
                    //button = new MButton(new ThemeResource("icon/remove32x32.png"), this::delete);
                }
                break;
                case FILTER: {
                    if (withCaption)
                        button = new MButton(FontAwesome.FILTER, BundleExtractor.getStringValue(ButtonViewConstantsBundle.class, action.name()) //
                                , this::filter);
                    else
                        button = new MButton(FontAwesome.FILTER, this::filter);
                }
                break;
                case VALIDATE: {
                    if (withCaption)
                        button = new MButton(FontAwesome.BOLT, BundleExtractor.getStringValue(ButtonViewConstantsBundle.class, action.name()) //
                                , this::validate);
                    else
                        button = new MButton(FontAwesome.BOLT, this::validate);
                }
                break;
                case RESET: {
                    if (withCaption)
                        button = new MButton(FontAwesome.CIRCLE_THIN, BundleExtractor.getStringValue(ButtonViewConstantsBundle.class, action.name()) //
                                , this::reset);
                    else
                        button = new MButton(FontAwesome.CIRCLE_THIN, this::reset);
                }
                break;
                case CANCEL: {
                    if (withCaption)
                        button = new MButton(FontAwesome.CLOSE, BundleExtractor.getStringValue(ButtonViewConstantsBundle.class, action.name()) //
                                , this::cancel);
                    else
                        button = new MButton(FontAwesome.CLOSE, this::cancel);
                }
                break;
            }

            if (withCaption) {
                button.setSizeFull();
                button.addStyleName(ValoTheme.BUTTON_PRIMARY);
                button.addStyleName(ValoTheme.BUTTON_SMALL);
                button.addStyleName(ValoTheme.BUTTON_ICON_ALIGN_RIGHT);
            } else {
                button.setSizeUndefined();
                button.addStyleName(ValoTheme.BUTTON_PRIMARY);
                button.addStyleName(ValoTheme.BUTTON_LARGE);
                button.addStyleName(ValoTheme.BUTTON_ICON_ONLY);
                button.addStyleName(ValoTheme.BUTTON_ICON_ALIGN_TOP);
            }

            this.buttonMap.put(action, button);
            this.buttonOrderList.add(button);
        }
    }

    @Override
    public IEditorLayout getEditorFormView() {
        return editorFormView;
    }

    @Override
    public void setEditorFormView(IEditorLayout editorFormView) {
        this.editorFormView = editorFormView;
    }

    @Override
    public void enableButton(String buttonName, boolean enabled) {
        buttonMap.get(buttonName).setEnabled(enabled);
    }

    @Override
    public MButton getButton(String buttonName, boolean enabled) {
        return buttonMap.get(buttonName);
    }

    @Override
    public void buildLayoutWithComponents(AbstractLayout layout, UI ui, IModule module) {
        for (MButton button : buttonOrderList) {
            layout.addComponent(button);
        }
    }

    @Override
    public void buildCustomLayoutWithComponents(CustomLayout layout, UI ui, IModule module) {
        for (MButton button : buttonOrderList) {
            layout.addComponent(button);
        }
    }

    public void initCommonLayoutStyle(Layout layout) {
        if (AbstractComponent.class.isAssignableFrom(layout.getClass())) {
            ((AbstractComponent) layout).setImmediate(true);
        }
        if (Layout.AlignmentHandler.class.isAssignableFrom(layout.getClass())) {
            ((Layout.AlignmentHandler) layout).setDefaultComponentAlignment(this.defaultAlignment);
        }

        if (Layout.SpacingHandler.class.isAssignableFrom(layout.getClass())) {
            ((Layout.SpacingHandler) layout).setSpacing(true);
        }

        if (Layout.MarginHandler.class.isAssignableFrom(layout.getClass())) {
            ((Layout.MarginHandler) layout).setMargin(true);
        }

        if (this.defaultAlignment == Alignment.MIDDLE_RIGHT) {
            layout.setSizeFull();
        } else {
            layout.setSizeUndefined();
        }
    }

    @Override
    public VerticalLayout getVerticalLayout(UI ui, IModule module) {
        if (this.rootLayout == null) {
            this.rootLayout = new VerticalLayout();
            initCommonLayoutStyle(((VerticalLayout) this.rootLayout));

            if (this.defaultAlignment == Alignment.BOTTOM_CENTER) {
                HorizontalLayout pushLayout = new HorizontalLayout();
                pushLayout.setSizeUndefined();
                ((VerticalLayout) this.rootLayout).addComponent(pushLayout);
            }

            buildLayoutWithComponents(((VerticalLayout) this.rootLayout), ui, module);

            if (this.defaultAlignment == Alignment.TOP_CENTER) {
                HorizontalLayout pushLayout = new HorizontalLayout();
                pushLayout.setSizeUndefined();
                ((VerticalLayout) this.rootLayout).addComponent(pushLayout);
            }
        }

        return ((VerticalLayout) this.rootLayout);
    }

    @Override
    public HorizontalLayout getHorizontalLayout(UI ui, IModule module) {
        if (this.rootLayout == null) {
            this.rootLayout = new HorizontalLayout();
            initCommonLayoutStyle(((HorizontalLayout) this.rootLayout));

            if (this.defaultAlignment == Alignment.MIDDLE_RIGHT) {
                HorizontalLayout pushLayout = new HorizontalLayout();
                pushLayout.setSizeFull();
                ((HorizontalLayout) this.rootLayout).addComponent(pushLayout);
            }

            buildLayoutWithComponents(((HorizontalLayout) this.rootLayout), ui, module);

            if (this.defaultAlignment == Alignment.MIDDLE_LEFT) {
                HorizontalLayout pushLayout = new HorizontalLayout();
                pushLayout.setSizeFull();
                ((HorizontalLayout) this.rootLayout).addComponent(pushLayout);
            }
        }

        return (HorizontalLayout) this.rootLayout;
    }

    @Override
    public FormLayout getFormLayout(UI ui, IModule module) {
        if (this.rootLayout == null) {
            this.rootLayout = new FormLayout();
            initCommonLayoutStyle(((FormLayout) this.rootLayout));
            buildLayoutWithComponents(((FormLayout) this.rootLayout), ui, module);
        }
        return ((FormLayout) this.rootLayout);
    }

    @Override
    public GridLayout getGridLayout(UI ui, IModule module) {
        if (this.rootLayout == null) {
            this.rootLayout = new GridLayout();
            initCommonLayoutStyle(((GridLayout) this.rootLayout));
            buildLayoutWithComponents(((GridLayout) this.rootLayout), ui, module);
        }
        return ((GridLayout) this.rootLayout);
    }

    @Override
    public CustomLayout getCustomLayout(UI ui, IModule module, String customHtml) {
        if (this.rootLayout == null) {
            this.rootLayout = new CustomLayout(customHtml);
            initCommonLayoutStyle(((CustomLayout) this.rootLayout));
            buildLayoutWithComponents(((CustomLayout) this.rootLayout), ui, module);
        }
        return ((CustomLayout) this.rootLayout);
    }

    @Override
    public void setDefaultComponentAlignment(Alignment defaultAlignment) {
        this.defaultAlignment = defaultAlignment;
    }

    @Override
    public void refresh(Button.ClickEvent evt) {
        if (this.views != null && !this.views.isEmpty()) {
            for (IBeanView view : this.views) {
                view.fetchBeans();
            }
        }
    }

    @Override
    public void create(Button.ClickEvent evt) {
        if (this.views != null && !this.views.isEmpty()) {
            for (IBeanView view : this.views) {
                view.createBean();
            }
        }
    }

    @Override
    public void edit(Button.ClickEvent evt) {
        if (this.views != null && !this.views.isEmpty()) {
            for (IBeanView view : this.views) {
                view.editBean();
            }
        }
    }

    @Override
    public void delete(Button.ClickEvent evt) {
        if (this.views != null && !this.views.isEmpty()) {
            for (IBeanView view : this.views) {
                view.deleteBeans();
            }
        }
    }

    @Override
    public void filter(Button.ClickEvent evt) {
        if (this.views != null && !this.views.isEmpty()) {
            for (IBeanView view : this.views) {
                view.fetchBeansByCriteria();
            }
        }
    }

    @Override
    public void validate(Button.ClickEvent evt) {
        if (editorFormView != null && this.views != null && !this.views.isEmpty()) {
            B bean = null;
            int index = 0;
            for (IBeanView view : this.views) {
                if (index == 0)
                    bean = (B) view.getBean();
                else
                    view.getBean();

                index++;
            }

            if (bean != null) {
                this.editorFormView.getSaveHandler().save((AbstractEditor<B>) this.editorFormView, bean);
            }
        }
    }

    @Override
    public void reset(Button.ClickEvent evt) {
        if (this.editorFormView != null) {
            this.editorFormView.reset();
        }
    }

    @Override
    public void cancel(Button.ClickEvent evt) {
        if (this.editorFormView != null) {
            this.editorFormView.closeWindow();
        }
    }

    @Override
    public void addClickListener(EnumButtonAction action, Button.ClickListener listener) {
        buttonMap.get(action).addClickListener(listener);
    }

    @Override
    public void enableButton(EnumButtonAction action, boolean enabled) {
        buttonMap.get(action).setEnabled(enabled);
    }
}
