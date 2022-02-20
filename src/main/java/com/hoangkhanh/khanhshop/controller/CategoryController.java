package com.hoangkhanh.khanhshop.controller;

import com.hoangkhanh.khanhshop.repository.ProductRepository;
import com.hoangkhanh.khanhshop.service.CategoryService;
import com.hoangkhanh.khanhshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

}
