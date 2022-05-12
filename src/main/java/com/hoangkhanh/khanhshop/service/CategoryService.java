package com.hoangkhanh.khanhshop.service;

import com.hoangkhanh.khanhshop.model.Category;
import com.hoangkhanh.khanhshop.model.Product;
import com.hoangkhanh.khanhshop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> showAllCategorys(){
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id){
        Optional<Category> category = categoryRepository.findById(id);
        return  category.get();
    }

}
