package com.hoangkhanh.khanhshop.controller;

import com.hoangkhanh.khanhshop.dto.OrderInfo;
import com.hoangkhanh.khanhshop.model.CartItem;
import com.hoangkhanh.khanhshop.model.User;
import com.hoangkhanh.khanhshop.repository.CartItemRepository;
import com.hoangkhanh.khanhshop.repository.UserRepository;
import com.hoangkhanh.khanhshop.service.ShoppingCartService;
import com.hoangkhanh.khanhshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService cartService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @GetMapping("")
    public String showCart(Model model,
                           Principal principal){
        List<CartItem> cartItems = null;
        if(principal != null){
            cartItems = cartService.listCartItems(principal.getName());
        }

        model.addAttribute("cartItems", cartItems);
        return "cart";
    }

    @PostMapping("/addProductsCart")
    public String addProductsToCart(@ModelAttribute("orderInfo") OrderInfo orderInfo,
                                   Principal principal){
        if (principal == null){
            return "You must login to add this product to your shopping cart.";
        }

        User user = userRepository.findByUsername(principal.getName());

        Integer addedQuantity = cartService.addProductToCart(orderInfo.getProductId(), orderInfo.getQuantity(), user);

        return "redirect:/cart";
    }

    @GetMapping("/addProductToCart/{id}")
    public String addProductToCart(@PathVariable("id") Long pid, Principal principal){
        if (principal == null){
            return "You must login to add this product to your shopping cart.";
        }

        User user = userRepository.findByUsername(principal.getName());

        Integer addedQuantity = cartService.addProductToCart(pid, 1, user);

        return "redirect:/cart";
    }

    @GetMapping("/deleteCart/{id}")
    public String deleteCart(@PathVariable("id") Long id){
        cartItemRepository.deleteById(id);
        return "redirect:/cart";
    }

    @GetMapping("/checkout")
    public String showCheckout(Model model,  Principal principal){
        User user = userRepository.findByUsername(principal.getName());
        List<CartItem> cartItems = null;
        if(principal != null){
            cartItems = cartService.listCartItems(principal.getName());
        }

        int total = 0;
        for (CartItem a : cartItems){
            total += a.getTotal();
        }


        model.addAttribute("cartItems", cartItems);
        model.addAttribute("user", user);
        model.addAttribute("subtotal", total);
        return "checkout";
    }
}
