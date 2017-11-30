package com.oryx.core.layout.grid;

import com.oryx.core.annotation.capable.IBundleCapable;
import com.oryx.core.bundle.common.InformationConstantBundle;
import com.oryx.core.bundle.helper.IMessageHelper;
import com.oryx.core.bundle.tools.BundleExtractor;
import com.oryx.core.delegate.IDelegate;
import com.oryx.core.factory.FactoryProvider;
import com.oryx.core.layout.editor.AbstractEditor;
import com.oryx.core.message.ErrorMessageProvider;
import com.oryx.core.module.IModule;
import com.oryx.core.provider.IEntityMethodProvider;
import com.oryx.core.provider.ITypeByTokenProvider;
import com.oryx.core.service.ICrudServiceDelegate;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

/**
 * Created by 241180 on 05/01/2017.
 */
public abstract class AbstractGrid<B> extends AbstractGridLayout<B> {
    private IDelegate serviceDelegate;
    private IModule module;
    private B bean;

    public AbstractGrid(IDelegate service
            , IModule module) {
        super(module);
        this.bean = bean;
        this.module = module;
        this.serviceDelegate = service;
    }

    public IDelegate getServiceDelegate() {
        return serviceDelegate;
    }

    public void setServiceDelegate(ICrudServiceDelegate serviceDelegate) {
        this.serviceDelegate = serviceDelegate;
    }

    public abstract Window getEditorWindow(IModule module, B bean, AbstractEditor.SaveHandler saveHandler);

    public void showWindowForEdit(UI ui, IModule module) {
        B bean = getSlectedBean();
        if (bean != null) {
            ui.addWindow(getEditorWindow(module, bean, (window, XmlUser) -> {
                performAndValidateEdition(window.getWindow(), ui, (B) bean);
            }));
        } else
            Notification.show(IMessageHelper.getDefaultString(InformationConstantBundle.class, "NoObjectToBeProcessed"));
    }

    public void showWindowForCreate(UI ui, IModule module) {
        B bean = (B) FactoryProvider.create(getTypeByTokenProvider().getClassType(ITypeByTokenProvider.Target.ENTITY));
        if (bean != null) {
            ui.addWindow(getEditorWindow(module, bean, (window, XmlUser) -> {
                performAndValidateCreation(window.getWindow(), ui, (B) bean);
            }));
        } else
            Notification.show(IMessageHelper.getDefaultString(InformationConstantBundle.class, "NoObjectToBeProcessed"));
    }

    private boolean hasErrors() {
        if (((ICrudServiceDelegate) this.getServiceDelegate()).getResponseErrCode() != null) {
            Notification.show(ErrorMessageProvider.getMessage(((ICrudServiceDelegate) this.getServiceDelegate()).getResponseErrCode()) + "\n" + ((ICrudServiceDelegate) this.getServiceDelegate()).getResponseMessage());
            return true;
        } else {
            return false;
        }
    }

    public void performAndValidateEdition(Window window, UI ui, B bean) {
        try {
            ((ICrudServiceDelegate) this.getServiceDelegate()).update(bean);
        } finally {
            if (!hasErrors()) {
                if (((ICrudServiceDelegate) this.getServiceDelegate()).getResponseBeans() != null && !((ICrudServiceDelegate) this.getServiceDelegate()).getResponseBeans().isEmpty()) {
                    refreshGridRows();
                    Notification.show(IMessageHelper.composeMsg(IMessageHelper.getDefaultString(InformationConstantBundle.class, "UpdatedInfoMsg")
                            , String.valueOf(1)
                            , getBeanName()
                    ));
                } else {
                    Notification.show(ErrorMessageProvider.getMessage(((ICrudServiceDelegate) this.getServiceDelegate()).getResponseErrCode()) + "\n" + ((ICrudServiceDelegate) this.getServiceDelegate()).getResponseMessage());
                }

                window.close();
                ui.removeWindow(window);
            }
        }
    }

    @Override
    public void editBean() {
        showWindowForEdit(UI.getCurrent(), this.module);
    }

    public void performAndValidateCreation(Window window, UI ui, B bean) {
        try {
            ((ICrudServiceDelegate) this.getServiceDelegate()).create(bean);
        } finally {
            if (!hasErrors()) {
                if (((ICrudServiceDelegate) this.getServiceDelegate()).getResponseBeans() != null && !((ICrudServiceDelegate) this.getServiceDelegate()).getResponseBeans().isEmpty()) {
                    for (Object createdBean : ((ICrudServiceDelegate) this.getServiceDelegate()).getResponseBeans()) {
                        addBean((B) createdBean);
                    }

                    Notification.show(IMessageHelper.composeMsg(IMessageHelper.getDefaultString(InformationConstantBundle.class, "CreatedInfoMsg")
                            , String.valueOf(1)
                            , getBeanName()
                    ));
                } else {
                    Notification.show(ErrorMessageProvider.getMessage(((ICrudServiceDelegate) this.getServiceDelegate()).getResponseErrCode()) + "\n" + ((ICrudServiceDelegate) this.getServiceDelegate()).getResponseMessage());
                }

                window.close();
                ui.removeWindow(window);
            }
        }
    }


    @Override
    public void createBean() {
        showWindowForCreate(UI.getCurrent(), this.module);
    }

    @Override
    public B getBean() {
        return getSlectedBean();
    }

    @Override
    public Collection<B> getBeans() {
        return getSlectedBeans();
    }

    @Override
    public void fetchBeans() {
        try {
            ((ICrudServiceDelegate) this.serviceDelegate).findAll();
        } finally {
            if (!hasErrors()) {
                clearContainer();
                addBeans(((ICrudServiceDelegate) this.serviceDelegate).getResponseBeans());

                Notification.show(
                        IMessageHelper.composeMsg(
                                IMessageHelper.getDefaultString(InformationConstantBundle.class, "RetrievedInfoMsg")
                                , String.valueOf(
                                        ((ICrudServiceDelegate) this.serviceDelegate).getResponseBeans() != null
                                                ? ((ICrudServiceDelegate) this.serviceDelegate).getResponseBeans().size()
                                                : 0)
                                , getBeanName()

                        ));
            }
        }
    }

    public void deleteBean() {
        B bean = getSlectedBean();
        if (bean != null) {
            try {
                ((ICrudServiceDelegate) this.serviceDelegate).delete(bean);
            } finally {
                if (!hasErrors()) {
                    for (Object deletedBean : ((ICrudServiceDelegate) this.serviceDelegate).getResponseBeans()) {
                        removeBean((B) deletedBean);
                    }
                    Notification.show(IMessageHelper.composeMsg(IMessageHelper.getDefaultString(InformationConstantBundle.class, "DeletedInfoMsg")
                            , String.valueOf(((ICrudServiceDelegate) this.serviceDelegate).getResponseBeans() != null ? ((ICrudServiceDelegate) this.serviceDelegate).getResponseBeans().size() : 0)
                            , getBeanName()
                    ));
                }
            }
        } else
            Notification.show(IMessageHelper.getDefaultString(InformationConstantBundle.class, "NoObjectToBeProcessed"));
    }

    public void deleteBeans() {
        List<B> beans = getSlectedBeans();
        if (beans != null && beans.size() > 0) {
            try {
                ((ICrudServiceDelegate) this.serviceDelegate).delete(beans);
            } finally {
                if (!hasErrors()) {
                    for (Object deletedBean : ((ICrudServiceDelegate) this.serviceDelegate).getResponseBeans()) {
                        for (Object toBeDeletedBean : beans) {
                            try {
                                UUID tbdelUuid = UUID.fromString((String) IEntityMethodProvider.GET_ID_METHOD(toBeDeletedBean.getClass()).invoke(toBeDeletedBean));
                                UUID delUuid = UUID.fromString((String) IEntityMethodProvider.GET_ID_METHOD(deletedBean.getClass()).invoke(deletedBean));

                                if (tbdelUuid.equals(delUuid)) {
                                    removeBean((B) toBeDeletedBean);
                                }
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    Notification.show(IMessageHelper.composeMsg(IMessageHelper.getDefaultString(InformationConstantBundle.class, "RetrievedInfoMsg")
                            , String.valueOf(((ICrudServiceDelegate) this.serviceDelegate).getResponseBeans() != null ? ((ICrudServiceDelegate) this.serviceDelegate).getResponseBeans().size() : 0)
                            , getBeanName()
                    ));
                }
            }
        } else
            Notification.show(IMessageHelper.getDefaultString(InformationConstantBundle.class, "NoObjectToBeProcessed"));
    }

    public void fetchBeansByCriteria() {
        B bean = getFilterBean();
        if (bean != null) {
            try {
                ((ICrudServiceDelegate) this.serviceDelegate).findByCriteria(bean);
            } finally {
                if (!hasErrors()) {
                    clearContainer();
                    addBeans(((ICrudServiceDelegate) this.serviceDelegate).getResponseBeans());
                    Notification.show(IMessageHelper.composeMsg(IMessageHelper.getDefaultString(InformationConstantBundle.class, "RetrievedInfoMsg")
                            , String.valueOf(((ICrudServiceDelegate) this.serviceDelegate).getResponseBeans() != null ? ((ICrudServiceDelegate) this.serviceDelegate).getResponseBeans().size() : 0)
                            , getBeanName()
                    ));
                }
            }
        } else
            Notification.show(IMessageHelper.getDefaultString(InformationConstantBundle.class, "NoFilterModelProvided"));
    }

    public String getFormTitle() {
        return BundleExtractor.getStringValue(IBundleCapable.getBundleInterface(this), "FORM_TITLE");
    }

    public String getBeanName() {
        return BundleExtractor.getStringValue(IBundleCapable.getBundleInterface(this), getTypeByTokenProvider().getClassType(ITypeByTokenProvider.Target.ENTITY).getSimpleName());
    }
}
