package com.hoangkhanh.khanhshop.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Entity
@Table(name = "Accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Username not blank")
    private String username;
    @NotBlank(message = "Password not blank")
    private String password;
    private String fullname;
    @NotEmpty
    @Email
    private String email;
    private String address;
    private Integer phone;
    private String photo;
    @NotNull
    private boolean activated;
    @NotNull
    private boolean admin;

//    @OneToMany(mappedBy = "account")
//    private List<Order> orders;
}
