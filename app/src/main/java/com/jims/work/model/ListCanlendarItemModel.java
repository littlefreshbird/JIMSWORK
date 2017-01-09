package com.jims.work.model;

/**
 * Created by Administrator on 2017/1/9.
 */

public class ListCanlendarItemModel {
    private String title;
    private String images;
    private String address;
    private String keshi;

    public ListCanlendarItemModel(String title, String images, String address, String keshi) {
        this.title = title;
        this.images = images;
        this.address = address;
        this.keshi = keshi;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getKeshi() {
        return keshi;
    }

    public void setKeshi(String keshi) {
        this.keshi = keshi;
    }
}
