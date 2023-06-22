package com.kgcoffee.web.order.domain.basket;


public class BasketDto {
    private int basket_id;
    private int product_count;
    private int product_price;
    private String product_name;
    private int fk_menu_id;
    private String fk_user_id;


    public BasketDto(int basket_id, int product_count, int product_price, String product_name, int fk_menu_id, String fk_user_id) {
        this.basket_id = basket_id;
        this.product_count = product_count;
        this.product_price = product_price;
        this.product_name = product_name;
        this.fk_menu_id = fk_menu_id;
        this.fk_user_id = fk_user_id;
    }

    public int getBasket_id() {
        return basket_id;
    }

    public int getProduct_count() {
        return product_count;
    }

    public int getProduct_price() {
        return product_price;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getFk_user_id() {
        return fk_user_id;
    }

    public int getFk_menu_id() {
        return fk_menu_id;
    }

    public void setBasket_id(int basket_id) {
        this.basket_id = basket_id;
    }

    public void setProduct_count(int product_count) {
        this.product_count = product_count;
    }

    public void setProduct_price(int product_price) {
        this.product_price = product_price;
    }

    public void setFk_user_id(String fk_user_id) {
        this.fk_user_id = fk_user_id;
    }

    public void setFk_menu_id(int fk_menu_id) {
        this.fk_menu_id = fk_menu_id;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "basket_id=" + basket_id +
                ", product_count=" + product_count +
                ", product_price=" + product_price +
                ", fk_menu_id=" + fk_menu_id +
                ", fk_user_id='" + fk_user_id + '\'' +
                '}';
    }
}
