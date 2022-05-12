package com.hoangkhanh.khanhshop.model;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cart_items")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public double getTotal(){
        return this.product.getPrice()  * quantity;
    }

}
