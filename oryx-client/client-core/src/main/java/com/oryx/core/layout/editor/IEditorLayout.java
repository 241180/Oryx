package com.oryx.core.layout.editor;

/**
 * Created by 241180 on 16/01/2017.
 */
public interface IEditorLayout<B> {
    public AbstractEditor.SaveHandler<B> getSaveHandler();

    public void validate();

    public void reset();

    public void cancel();

    public void closeWindow();

    public String getCustomHtmlFile();
}
