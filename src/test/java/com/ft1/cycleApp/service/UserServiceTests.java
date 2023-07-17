package com.ft1.cycleApp.service;

import com.ft1.cycleApp.entity.User;
import com.ft1.cycleApp.service.exception.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

// @SpringBootTest: annotate current class is a test class, will be filtered when packaging
@SpringBootTest
// @RunWith: run the module test class (class can not run without @RunWith), pass a parameter, parameter must be SpringRunner class type
@RunWith(SpringRunner.class)
public class UserServiceTests {
    // idea will check interface, interface can not create Bean directly (solved by dynamic proxy)

    @Autowired
    private IUserService userService;
    /**
     * module test method must meet: can run individually, will not run whole project
     * 1. must be annotated by @Test
     * 2. return type must be void
     * 3. parameter can not be any type
     * 4. access modifier must be public
     * */
    @Test
    public void reg() {
        try {
            User user = new User();
            user.setUsername("updatetest");
            user.setPassword("123");
            userService.reg(user);
            System.out.println("pass");
        } catch (ServiceException e) {
            // get class object then class name
            System.out.println(e.getClass().getSimpleName());
            // get specified information of exception
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void login() {
        User user =
                userService.login("logintest", "123");

        System.out.println(user);
    }

    @Test
    public void changePassword() {
        userService.changePassword(4, "test002", "123", "456");
    }

    @Test
    public void getByUid() {
        System.err.println(userService.getByUid(6));
    }

    @Test
    public void changeInfo() {
         User result = new User();
         result.setEmail("logintest3@com");

         userService.changeInfo(6, "admin", result);
    }


}
