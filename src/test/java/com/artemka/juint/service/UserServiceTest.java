package com.artemka.juint.service;

import com.artemka.junit.dto.User;
import com.artemka.junit.service.UserService;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class UserServiceTest {
    private UserService userService;
    @BeforeAll
    static void init(){
        System.out.println("Before all: ");
    }
    @BeforeEach
    void prepare(){
        System.out.println("Before each: "+this);
        userService=new UserService();
    }
    @Test
    void usersEmptyIfNoUsersAdded(){
        System.out.println("Test 1: "+this);
        var users=userService.getAll();
        Assertions.assertTrue(users.isEmpty(),()->"User list should be empty");
    }
    @Test
    void usersSizeIfUsersAdded(){
        System.out.println("Test 2: "+this);
        userService.add(new User());
        userService.add(new User());
        var users=userService.getAll();
        Assertions.assertEquals(2,users.size());
    }
    @AfterEach
    void deleteDataFromDatabase(){
        System.out.println("After each: "+this);
    }
    @AfterAll
    static void closeConnectionPool(){
        System.out.println("After all: ");
    }
}
