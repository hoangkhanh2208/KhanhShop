package com.hoangkhanh.khanhshop.controller;

import com.hoangkhanh.khanhshop.model.Product;
import com.hoangkhanh.khanhshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    public String showHome(Model model){
        model.addAttribute("products", productService.showAllProducts());
        return "index";
    }

    @RequestMapping("/product-details")
    public String showProductDetails(){
        return "product-details";
    }

    @RequestMapping("/cart")
    public String showCart(){
        return "cart";
    }

    @RequestMapping("/checkout")
    public String showCheckout(){
        return "checkout";
    }
}
