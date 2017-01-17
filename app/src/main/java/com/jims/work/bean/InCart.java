package com.jims.work.bean;

/**
 * Created by gong on 2017/1/17.
 */
public class InCart {

    String listId;	//id

    String Name;	//名称

    int Icon;	//图片

    String Detail;	//种类

    double Price;	//价格

    public InCart(String listId, String name, int icon, String detail, double price) {
        this.listId = listId;
        Name = name;
        Icon = icon;
        Detail = detail;
        Price = price;
    }

    public String getListId() {
        return listId;
    }

    public void setListId(String listId) {
        this.listId = listId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getIcon() {
        return Icon;
    }

    public void setIcon(int icon) {
        Icon = icon;
    }

    public String getDetail() {
        return Detail;
    }

    public void setDetail(String detail) {
        Detail = detail;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }
}
