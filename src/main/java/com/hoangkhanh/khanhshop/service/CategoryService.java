package com.hoangkhanh.khanhshop.service;

import com.hoangkhanh.khanhshop.model.Category;
import com.hoangkhanh.khanhshop.model.Product;
import com.hoangkhanh.khanhshop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> showAllCategorys(){
        return categoryRepository.findAll();
    }

}
