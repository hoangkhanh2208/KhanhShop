package com.hoangkhanh.khanhshop.repository;

import com.hoangkhanh.khanhshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "Select * from products p where p.categoryid = ?1", nativeQuery = true)
    public List<Product> getProductsByCategory(Long id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "DELETE FROM products WHERE id IN(?1)")
    void delProduct(List<Long> productId);
}
