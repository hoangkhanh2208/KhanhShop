package com.hoangkhanh.khanhshop.service;

import com.hoangkhanh.khanhshop.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class UserService {

//    public User getCurrentlyLoggerInUser(Principal user){
//        if (authentication == null) return null;
//
//        User user = null;
//        Object principal = authentication.getPrincipal();
//
//        if(principal instanceof UserDetailImpl){
//            user = ((UserDetailImpl)principal).getUser();
//        }
//
//        return user;
//    }
}
