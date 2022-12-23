/*
package com.bezkoder.springjwt.products;

import org.springframework.stereotype.Component;

import javax.persistence.*;
*/
/*
@Component
@Entity*//*

public class Usercart {
    @Id
    @GeneratedValue
    public int id;

    @ManyToOne
    @JoinColumn(name = "product_prod_id")
    public product_page product;
  //  public int
  quantity;

    public Usercart() {
    }

    public Usercart(int id, product_page product) {
        this.id = id;
        this.product = product;
        //this.quantity = quantity;
    }

    public product_page getProduct() {
        return product;
    }

    public void setProduct(product_page product) {
        this.product = product;
    }

}
*/
