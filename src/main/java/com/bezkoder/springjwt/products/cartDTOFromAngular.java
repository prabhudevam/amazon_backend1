package com.bezkoder.springjwt.products;

import com.bezkoder.springjwt.models.User;

public class cartDTOFromAngular {
    public int cart_id;
   // public int quantity;
    public product_page product_page;
    public User user;

    public cartDTOFromAngular(int cart_id,  com.bezkoder.springjwt.products.product_page product_page, User user) {
        this.cart_id = cart_id;
        //this.quantity = quantity;
        this.product_page = product_page;
        this.user = user;
    }
}
