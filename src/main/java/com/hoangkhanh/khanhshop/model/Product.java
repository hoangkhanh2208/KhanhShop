package com.hoangkhanh.khanhshop.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    private String image;
    @NotNull
    private Integer quantity;
    @NotNull
    private Double price;
    @NotBlank(message = "About not empty")
    private String about;
    @NotNull
    private Integer discount;
    @Temporal(TemporalType.DATE)
    @Column(name = "Createdate")
    private Date createDate = new Date();
    @NotNull
    private Boolean available;
    @ManyToOne
    @JoinColumn(name = "Categoryid")
    private Category category;

//    @OneToMany(mappedBy = "product")
//    private List<OrderDetail> orderDetails;
}
