package com.hoangkhanh.khanhshop.controller;

import com.hoangkhanh.khanhshop.model.User;
import com.hoangkhanh.khanhshop.repository.UserRepository;
import com.hoangkhanh.khanhshop.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class ShoppingCartRestController {

    @Autowired
    private ShoppingCartService cartService;

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/cart/add/{pid}/{qty}")
    public String addProductToCart(@PathVariable("pid") Long productId,
                                   @PathVariable("qty") Integer quantity,
                                   Principal principal
    ){
        if (principal == null){
            return "You must login to add this product to your shopping cart.";
        }

        User user = userRepository.findByUsername(principal.getName());

        Integer addedQuantity = cartService.addProductToCart(productId, quantity, user);

        return addedQuantity + "item(s) of this product were added to your shopping cart.";
    }

}
