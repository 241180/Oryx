package com.oryx.core.layout.editor;

import com.oryx.core.annotation.capable.IBundleCapable;
import com.oryx.core.annotation.capable.ICustomCapable;
import com.oryx.core.annotation.capable.ITypeByTokenCapable;
import com.oryx.core.annotation.decl.Tree;
import com.oryx.core.bundle.tools.BundleExtractor;
import com.oryx.core.helper.CommonServiceHelper;
import com.oryx.core.layout.CrudFormContext;
import com.oryx.core.layout.component.button.ButtonView;
import com.oryx.core.layout.component.button.EnumButtonAction;
import com.oryx.core.layout.component.button.IButtonView;
import com.oryx.core.layout.component.form.BeanForm;
import com.oryx.core.layout.component.form.IBeanForm;
import com.oryx.core.module.IModule;
import com.oryx.core.parameter.IClientParameterNames;
import com.oryx.core.provider.ITypeByTokenProvider;
import com.oryx.remote.webservice.element.model.XmlAbstractEntity;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.apache.log4j.Logger;
import org.vaadin.viritin.components.DisclosurePanel;
import org.vaadin.viritin.layouts.MPanel;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by 241180 on 05/01/2017.
 */
public abstract class AbstractEditorLayout<B> implements IEditorLayout<B> {
    final static Logger logger = Logger.getLogger(AbstractEditorLayout.class);

    private VerticalLayout rootLayout;
    private List<IBeanForm> editorFormViews;
    private IButtonView buttonView;
    private ITypeByTokenProvider typeByTokenProvider;
    private List<String> displayedFields;
    private List<String> hiddenFields;
    private List<String> mandatoryFields;
    private List<String> readOnlyFields;
    private List<String> filterFields;
    private B bean;
    private IModule module;

    public AbstractEditorLayout(B bean, IModule module) {
        this.bean = bean;
        this.module = module;
    }

    public VerticalLayout getVerticalLayout() {
        if (rootLayout == null) {
            rootLayout = new VerticalLayout();

            //Get field context : Displayed, Hidden, Filter, Mandatory, FieldStyle
            CrudFormContext fieldsContext = new CrudFormContext(this.getDisplayedFields(), this.getHhiddenFields(), this.getMandatoryFields(), this.getRreadOnlyFields(), this.getfilterFields());

            //Create Editor Form view
            this.editorFormViews = new ArrayList<>();
            IBeanForm editorFormView = new BeanForm(fieldsContext, bean, IBundleCapable.getBundleInterface(this), getTreeDepth(), true, true);
            this.editorFormViews.add(editorFormView);

            //Set layout content
            int depth = getTreeDepth();
            Panel editorPanel = null;
            if (getCustomHtmlFile() != null) {
                editorPanel = new MPanel(editorFormView.getCustomLayout(UI.getCurrent(), module, getCustomHtmlFile()));
            } else {
                editorPanel = new MPanel(editorFormView.getGridLayout(UI.getCurrent(), module));
            }

            rootLayout.addComponent(editorPanel);

            if (depth > 1) {
                //editorFormView.setEditable(false);

                for (Field field : bean.getClass().getDeclaredFields()) {
                    field.setAccessible(true);
                    if (XmlAbstractEntity.class.isAssignableFrom(field.getType())) {
                        try {
                            XmlAbstractEntity entity = (XmlAbstractEntity) field.get(bean);
                            if (entity == null) {
                                entity = (XmlAbstractEntity) field.getType().getConstructor().newInstance();
                                field.set(bean, entity);
                            }

                            IBeanForm subEditorFormView = new BeanForm(fieldsContext, entity, IBundleCapable.getBundleInterface(this), depth - 1, true, true);
                            DisclosurePanel disclosurePanel = null;
                            if (getCustomHtmlFile() != null) {
                                disclosurePanel = new DisclosurePanel(BundleExtractor.getStringValue(IBundleCapable.getBundleInterface(this), field.getName()), subEditorFormView.getCustomLayout(UI.getCurrent(), module, getCustomHtmlFile()));
                            } else {
                                disclosurePanel = new DisclosurePanel(BundleExtractor.getStringValue(IBundleCapable.getBundleInterface(this), field.getName()), subEditorFormView.getGridLayout(UI.getCurrent(), module));
                            }
                            disclosurePanel.setMargin(false);
                            disclosurePanel.setOpen(true);
                            disclosurePanel.setResponsive(true);
                            rootLayout.addComponent(new Panel(disclosurePanel));
                            this.editorFormViews.add(subEditorFormView);
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }

            //Create butons
            Boolean editorBtnWithNoCaption = Boolean.valueOf(CommonServiceHelper.getParameterService().getValue(UUID.fromString((String) VaadinSession.getCurrent().getAttribute("USER_ID")), IClientParameterNames.EDIT_BTN_WITH_NO_CAPTION));
            this.buttonView = new ButtonView(!editorBtnWithNoCaption, editorFormViews, EnumButtonAction.CANCEL, EnumButtonAction.VALIDATE);
            this.buttonView.setEditorFormView(this);
            this.buttonView.setDefaultComponentAlignment(Alignment.MIDDLE_RIGHT);

            Panel buttonsPanel = new MPanel(this.buttonView.getHorizontalLayout(UI.getCurrent(), module));
            rootLayout.addComponent(buttonsPanel);
        }

        return this.rootLayout;
    }

    public String getCustomHtmlFile() {
        return ICustomCapable.getHtmlFileName(this);
    }

    public int getTreeDepth() {
        Tree tree = this.getClass().getAnnotation(Tree.class);
        if (tree != null)
            return tree.depth();
        else {
            logger.error("No Tree depth associated for class " + this.getClass().getSimpleName());
            return 1;
        }
    }

    public ITypeByTokenProvider getTypeByTokenProvider() {
        if (typeByTokenProvider != null)
            return typeByTokenProvider;

        typeByTokenProvider = ITypeByTokenCapable.getInstance(this);
        return typeByTokenProvider;
    }

    public abstract String getFormTitle();

    public List<String> getDisplayedFields() {
        if (displayedFields != null)
            return displayedFields;
        displayedFields = CrudFormContext.getFieldValue(this, CrudFormContext.DISPLAYED_FIELDS);
        return displayedFields;
    }

    public List<String> getHhiddenFields() {
        if (hiddenFields != null)
            return hiddenFields;
        hiddenFields = CrudFormContext.getFieldValue(this, CrudFormContext.HIDDEN_FIELDS);
        return hiddenFields;
    }

    public List<String> getMandatoryFields() {
        if (mandatoryFields != null)
            return mandatoryFields;
        mandatoryFields = CrudFormContext.getFieldValue(this, CrudFormContext.MANDATORY_FIELDS);
        return mandatoryFields;
    }

    public List<String> getRreadOnlyFields() {
        if (readOnlyFields != null)
            return readOnlyFields;
        readOnlyFields = CrudFormContext.getFieldValue(this, CrudFormContext.READ_ONLY_FIELDS);
        return readOnlyFields;
    }

    public List<String> getfilterFields() {
        if (filterFields != null)
            return filterFields;
        filterFields = CrudFormContext.getFieldValue(this, CrudFormContext.FILTER_FIELDS);
        return filterFields;
    }
}
