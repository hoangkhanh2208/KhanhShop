package com.hoangkhanh.khanhshop.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "Users")
public class User {

    public static final String ROLE_EMPLOYEE = "EMPLOYEE";
    public static final String ROLE_USER = "USER";
    public static final String ROLE_MANAGER = "MANAGER";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotBlank(message = "Username not blank")
    private String username;

    @NotBlank(message = "Password not blank")
    private String password;

    private String fullname;
    @NotEmpty
    @Column(unique = true)
    @Email
    private String email;
    private String address;
    private Integer phone;
    private String photo;
    @NotNull
    private boolean activated;
    @Column(name = "User_Role", length = 20, nullable = false)
    private String userRole;

}
