package com.hoangkhanh.khanhshop.repository;

import com.hoangkhanh.khanhshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "Select * from products p where p.categoryid = ?1", nativeQuery = true)
    public List<Product> getProductsByCategory(Long id);
}
