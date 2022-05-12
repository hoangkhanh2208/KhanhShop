package com.hoangkhanh.khanhshop.controller;

import com.hoangkhanh.khanhshop.common.util.ProductMapper;
import com.hoangkhanh.khanhshop.dto.ProductDto;
import com.hoangkhanh.khanhshop.model.Product;
import com.hoangkhanh.khanhshop.repository.UserRepository;
import com.hoangkhanh.khanhshop.service.CategoryService;
import com.hoangkhanh.khanhshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/home")
    public String showAdminHome(){
        return "admin/index";
    }

    @GetMapping("/products")
    public String showAllProduct(Model model){
        model.addAttribute("products", productService.showAllProducts());
        model.addAttribute("categorys", categoryService.showAllCategorys());
        return "admin/products";
    }

    @GetMapping("/users")
    public String showAllUser(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "admin/accounts";
    }

    @GetMapping("/add-product")
    public String addProduct(Model model){
        model.addAttribute("product", new ProductDto());
        model.addAttribute("categorys", categoryService.showAllCategorys());
        return "admin/add-product";
    }

    @PostMapping("/handle-add-product")
    public String handelAddProduct( @ModelAttribute ProductDto productDto,
                                    @RequestParam("photo") MultipartFile multipartFile) throws IOException {
        productService.addProduct(productDto, multipartFile );
        return "redirect:/admin/products";
    }

    @GetMapping("/edit-product")
    public String editProductById(@RequestParam("id") Long id, Model model){
        Product product = productService.getProductByid(id);
        model.addAttribute("product", ProductMapper.toProductDto(product));
        model.addAttribute("categorys", categoryService.showAllCategorys());
        return "admin/edit-product";
    }

    @PostMapping("/handle-edit-product")
    public String handleEditProduct(@ModelAttribute ProductDto productDto,
                                    @RequestParam("photo") MultipartFile multipartFile ) throws IOException {
        productService.editProduct(productDto, multipartFile);
        return "redirect:/admin/products";
    }


    @GetMapping("/deleteProducts")
    public String deleteProduct(@RequestParam(name = "productIds")  Long[] productId){
        productService.delProducts(productId);
        return "redirect:/admin/products";
    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteProductById(@PathVariable("id") Long id){
        productService.delProduct(id);
        return "redirect:/admin/products";
    }
}
