package com.jims.work.model;

/**
 * Created by Administrator on 2017/1/9.
 */

public class ListCanlendarItemModel {
    private String title;
    private String images;

    public ListCanlendarItemModel(String title, String images) {
        this.title = title;
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
