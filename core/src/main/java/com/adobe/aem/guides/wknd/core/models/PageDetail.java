package com.adobe.aem.guides.wknd.core.models;

import com.day.cq.wcm.api.Page;

import java.util.Iterator;

public class PageDetail {

    private String title;
    private String path;

    public PageDetail(String title, String path) {
        this.title = title;
        this.path = path;
    }

    public PageDetail() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
