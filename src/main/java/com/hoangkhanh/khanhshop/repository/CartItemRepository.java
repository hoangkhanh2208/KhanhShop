package com.hoangkhanh.khanhshop.repository;

import com.hoangkhanh.khanhshop.model.CartItem;
import com.hoangkhanh.khanhshop.model.Product;
import com.hoangkhanh.khanhshop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    public List<CartItem> findByUser(User user);

    public CartItem findByUserAndProduct(User user, Product product);

//    @Query("UPDATE cart_items c SET c.quantity = ?1 WHERE c.product.id = ?2 " +
//            "AND c.user.id = ?3")
//    @Modifying
//    public void updateQuantity(Integer quantity, Long productId, Long userId);
}
