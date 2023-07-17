package com.ft1.cycleApp.mapper;

import com.ft1.cycleApp.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


// @SpringBootTest: annotate current class is a test class, will be filtered when packaging
@SpringBootTest
// @RunWith: run the module test class (class can not run without @RunWith), pass a parameter, parameter must be SpringRunner class type
@RunWith(SpringRunner.class)
public class UserMapperTests {
    // idea will check interface, interface can not create Bean directly (solved by dynamic proxy)

    @Autowired
    private UserMapper userMapper;
    /**
     * module test method must meet: can run individually, will not run whole project
     * 1. must be annotated by @Test
     * 2. return type must be void
     * 3. parameter can not be any type
     * 4. access modifier must be public
     * */
    @Test
    public void insert() {
        User user = new User();
        user.setUsername("test001");
        user.setPassword("123");
        Integer rows = userMapper.insertUser(user);
        System.out.println(rows);
    }

    @Test
    public void findByUsername() {
        User user = userMapper.findByUsername("testusername");
        System.out.println(user);
    }

    @Test
    public void updatePasswordByUid() {
        userMapper.updatePasswordByUid(3 , "001");
    }

    @Test
    public void findByUid() {
        System.out.println(userMapper.findByUid(3));
    }

    @Test
    public void updateInfoByUid() {
        User user = new User();
        user.setUid(6);
        user.setEmail("logintest@com");
        userMapper.updateInfoByUid(user);
    }

}
