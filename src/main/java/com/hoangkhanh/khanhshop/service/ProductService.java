package com.hoangkhanh.khanhshop.service;

import com.hoangkhanh.blogweb.common.exception.ApiException;
import com.hoangkhanh.khanhshop.model.Product;
import com.hoangkhanh.khanhshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

@Controller
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> showAllProducts(){
        return productRepository.findAll();
    }

    public void create(Product product) {
        productRepository.save(product);
    }

    public Product getProductByid(Long id){
        Product product = productRepository.findById(id).orElseThrow(() -> new ApiException("Product does not exist", HttpStatus.NOT_FOUND));
        return product;
    }

}
