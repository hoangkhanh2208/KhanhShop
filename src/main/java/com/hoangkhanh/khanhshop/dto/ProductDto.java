package com.hoangkhanh.khanhshop.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private String image;
    private String photosImagePath;
    private Integer quantity;
    private Double price;
    private String about;
    //    private String brand;
    private Date createDate = new Date();
    private Boolean available;
    private Long categoryId;

}
