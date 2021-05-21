package com.example.hyhy.Models;

public class CartModel {
    public CartModel(){

    }
    private int img_cart;
    private String number_cart;

    public int getImg_cart() {
        return img_cart;
    }

    public void setImg_cart(int img_cart) {
        this.img_cart = img_cart;
    }

    public String getNumber_cart() {
        return number_cart;
    }

    public void setNumber_cart(String number_cart) {
        this.number_cart = number_cart;
    }

    public String getTitle_cart() {
        return title_cart;
    }

    public void setTitle_cart(String title_cart) {
        this.title_cart = title_cart;
    }

    public String getTv_price() {
        return tv_price;
    }

    public void setTv_price(String tv_price) {
        this.tv_price = tv_price;
    }

    public CartModel(int img_cart, String number_cart, String title_cart, String tv_price) {
        this.img_cart = img_cart;
        this.number_cart = number_cart;
        this.title_cart = title_cart;
        this.tv_price = tv_price;
    }

    private String title_cart;
    private String tv_price;
}
