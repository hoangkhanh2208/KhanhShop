package com.hoangkhanh.khanhshop.common.util;

import com.hoangkhanh.khanhshop.dto.ProductDto;
import com.hoangkhanh.khanhshop.model.Product;
import lombok.Data;

@Data
public class ProductMapper {

    public static Product toProduct(ProductDto productDto){
        Product product = new Product();
        product.setName(productDto.getName());
        product.setQuantity(productDto.getQuantity());
        product.setPrice(productDto.getPrice());
        product.setAbout(productDto.getAbout());
        product.setCreateDate(productDto.getCreateDate());
        product.setAvailable(productDto.getAvailable());
        return product;
    }

    public static ProductDto toProductDto(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setImage(product.getImage());
        productDto.setPhotosImagePath(product.getPhotosImagePath());
        productDto.setQuantity(product.getQuantity());
        productDto.setPrice(product.getPrice());
        productDto.setAbout(product.getAbout());
        productDto.setCreateDate(product.getCreateDate());
        productDto.setAvailable(product.getAvailable());
        productDto.setCategoryId(product.getCategory().getId());
        return productDto;
    }

}
