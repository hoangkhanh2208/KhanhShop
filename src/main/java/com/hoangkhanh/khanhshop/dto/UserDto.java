package com.hoangkhanh.khanhshop.dto;

import lombok.Data;

@Data
public class UserDto {
    private String fullname;
    private String email;
    private String address;
    private Integer phone;
    private String photo;
}
