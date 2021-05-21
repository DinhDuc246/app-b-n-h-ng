package com.example.hyhy.Models;

public class SimpleVerticalModel {
    public SimpleVerticalModel(){

    }
    private int pro_img;
    private String simple_title;
    private String simple_description;
    private String simple_saleoff;

    public int getPro_img() {
        return pro_img;
    }

    public void setPro_img(int pro_img) {
        this.pro_img = pro_img;
    }

    public String getSimple_title() {
        return simple_title;
    }

    public void setSimple_title(String simple_title) {
        this.simple_title = simple_title;
    }

    public String getSimple_description() {
        return simple_description;
    }

    public void setSimple_description(String simple_description) {
        this.simple_description = simple_description;
    }

    public String getSimple_saleoff() {
        return simple_saleoff;
    }

    public void setSimple_saleoff(String simple_saleoff) {
        this.simple_saleoff = simple_saleoff;
    }

    public String getTv_ratting() {
        return tv_ratting;
    }

    public void setTv_ratting(String tv_ratting) {
        this.tv_ratting = tv_ratting;
    }

    public SimpleVerticalModel(int pro_img, String simple_title, String simple_description, String simple_saleoff, String tv_ratting) {
        this.pro_img = pro_img;
        this.simple_title = simple_title;
        this.simple_description = simple_description;
        this.simple_saleoff = simple_saleoff;
        this.tv_ratting = tv_ratting;
    }

    private String tv_ratting;
}
