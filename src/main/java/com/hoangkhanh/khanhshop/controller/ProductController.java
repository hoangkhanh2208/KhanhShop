package com.hoangkhanh.khanhshop.controller;


import com.hoangkhanh.khanhshop.model.Product;
import com.hoangkhanh.khanhshop.repository.ProductRepository;
import com.hoangkhanh.khanhshop.service.CategoryService;
import com.hoangkhanh.khanhshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping("/productsByCategory/{id}")
    public String showProductsByCategory(@PathVariable(value = "id") Long id, Model model){
        model.addAttribute("products", productRepository.getProductsByCategory(id));
        model.addAttribute("categorys", categoryService.showAllCategorys());
        return "shop";
    }

    @RequestMapping("/shop")
    public String showShop(Model model){
        model.addAttribute("categorys", categoryService.showAllCategorys());
        model.addAttribute("products", productService.showAllProducts());
        return "shop";
    }

    @RequestMapping("/productdetail")
    public String showProductDetailById(@PathVariable(value = "id") Long id, Model model){
        Optional<Product> product =  productRepository.findById(id);
        model.addAttribute("product",product.get());
        return "product-details";
    }



}
