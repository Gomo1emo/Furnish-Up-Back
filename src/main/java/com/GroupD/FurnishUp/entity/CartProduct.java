package com.GroupD.FurnishUp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name="CART_PRODUCT")
public class CartProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
    @ManyToOne
    @JoinColumn(name="cart_id")
    private Cart cart;

    @ManyToOne
    @JoinTable(name="product_id")
    private Products products;


    public CartProduct() {
        products = null;
    }
    public CartProduct(Cart cart, Products products) {
        this.cart=cart;
        this.products = products;
    }
}
