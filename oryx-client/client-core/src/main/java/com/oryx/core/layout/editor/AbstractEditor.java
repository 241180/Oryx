package com.oryx.core.layout.editor;

import com.oryx.core.annotation.capable.IBundleCapable;
import com.oryx.core.bundle.tools.BundleExtractor;
import com.oryx.core.helper.CommonServiceHelper;
import com.oryx.core.module.IModule;
import com.oryx.core.parameter.IClientParameterNames;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Window;

import java.util.UUID;

/**
 * Created by 241180 on 05/01/2017.
 */
public abstract class AbstractEditor<B> extends AbstractEditorLayout<B> {

    private AbstractEditor.SaveHandler<B> saveHandler;
    private Window win;

    public AbstractEditor(B bean, SaveHandler<B> saveHandler, IModule module) {
        super(bean, module);
        this.saveHandler = saveHandler;
    }

    public Window getWindow() {
        if (win == null) {
            win = new Window();

            win.setModal(true);
            win.center();
            win.setCaption(this.getFormTitle());
            win.setContent(this.getVerticalLayout());
            Boolean editorWindowFullSize = Boolean.valueOf(CommonServiceHelper.getParameterService().getValue(UUID.fromString((String) VaadinSession.getCurrent().getAttribute("USER_ID")), IClientParameterNames.EDIT_WINDOW_FULL_SIZE));
            if (editorWindowFullSize) {
                win.setSizeFull();
            } else {
                win.setSizeUndefined();
            }
        }

        return win;
    }

    public AbstractEditor.SaveHandler<B> getSaveHandler() {
        return saveHandler;
    }

    public void setSaveHandler(AbstractEditor.SaveHandler<B> saveHandler) {
        this.saveHandler = saveHandler;
    }

    @Override
    public void validate() {
    }

    @Override
    public void cancel() {

    }

    public String getFormTitle() {
        return BundleExtractor.getStringValue(IBundleCapable.getBundleInterface(this), "FORM_TITLE");
    }

    @Override
    public void closeWindow() {
        this.win.close();
    }

    @Override
    public void reset() {
        this.win.close();
    }

    @FunctionalInterface
    public interface SaveHandler<B> {
        void save(AbstractEditor<B> window, B bean);
    }
}
