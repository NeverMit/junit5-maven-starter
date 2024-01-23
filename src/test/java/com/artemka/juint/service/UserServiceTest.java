package com.artemka.juint.service;

import com.artemka.junit.dto.User;
import com.artemka.junit.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserServiceTest {
    @BeforeEach
    void prepare(){
        System.out.println("Before each: "+this);
    }
    @Test
    void usersEmptyIfNoUsersAdded(){
        System.out.println("Test 1: "+this);
        var userService=new UserService();
        var users=userService.getAll();
        Assertions.assertTrue(users.isEmpty(),()->"User list should be empty");
    }
    @Test
    void usersSizeIfUsersAdded(){
        System.out.println("Test 2: "+this);
        var userService=new UserService();
        userService.add(new User());
        userService.add(new User());

        var users=userService.getAll();
        Assertions.assertEquals(2,users.size());
    }
}
