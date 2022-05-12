package com.hoangkhanh.khanhshop.service;

import com.hoangkhanh.khanhshop.model.CartItem;
import com.hoangkhanh.khanhshop.model.Product;
import com.hoangkhanh.khanhshop.model.User;
import com.hoangkhanh.khanhshop.repository.CartItemRepository;
import com.hoangkhanh.khanhshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class ShoppingCartService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductService productService;

    public List<CartItem> listCartItems(String userName){
        return cartItemRepository.findByUser(userRepository.findByUsername(userName));
    }

    public Integer addProductToCart(Long productId, Integer quantity, User user){
        Product product = productService.getProductByid(productId);
        CartItem cartItem = cartItemRepository.findByUserAndProduct(user, product);
        Integer addedQuantity = quantity;
        if (cartItem != null){
            addedQuantity = cartItem.getQuantity() + quantity;
            cartItem.setQuantity(addedQuantity);
        }else{
            cartItem = new CartItem();
            cartItem.setQuantity(quantity);
            cartItem.setProduct(product);
            cartItem.setUser(user);
        }

        cartItemRepository.save(cartItem);
        return addedQuantity;
    }

//    public void updateQuantity(Long productId, Integer quantity, User user){
//        cartItemRepository.updateQuantity(quantity, productId, user.getId());
//    }
}
