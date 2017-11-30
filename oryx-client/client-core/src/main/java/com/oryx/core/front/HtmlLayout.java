package com.oryx.core.front;

import java.util.List;

/**
 * Created by smbarki on 04/09/2017.
 */
public class HtmlLayout implements IHtmlLayout {
    private String title;
    private Integer width;
    private Integer height;
    private List<String> data;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
