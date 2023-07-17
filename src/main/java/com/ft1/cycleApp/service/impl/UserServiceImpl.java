package com.ft1.cycleApp.service.impl;

import com.ft1.cycleApp.entity.User;
import com.ft1.cycleApp.mapper.UserMapper;
import com.ft1.cycleApp.service.IUserService;
import com.ft1.cycleApp.service.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

/** Implement class of service layer of user module*/
@Service    // @Service: grant class to spring, auto generate object and maintain object
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String username, String password) {
        // search user by username, if not exist in db throw exception
        User result = userMapper.findByUsername(username);

        if (result == null) {
            throw new UserNotFoundException("user not exist");
        }

        // check password if match
        // 1. get encrypted password in db
        String oldPassword = result.getPassword();
        // 2. encrypt user password with same md5 rule
        // 2.1. get salt value from user object
        String salt = result.getSalt();
        // 2.2. compare with password passed by user
        String newMd5Password = getMD5Password(password, salt);
        // 3. compare the password
        if (!newMd5Password.equals(oldPassword)) {
            throw new PasswordNotMatchException("password not match");
        }

        // invoke mapper layer to pass user object to invoker
        // User user = UserMapper.findByUsername(username);
        // reduce data size, rise system performance
        User user = new User();

        user.setUsername(result.getUsername());
        user.setUid(result.getUid());

        return user;
    }

    @Override
    public void reg(User user) {
        // via user parameter receive username pass by
        String username = user.getUsername();
        // invoke findByUsername(username) to make sure username is available
        User result = userMapper.findByUsername(username);
        // if result set is null, or throws UsernameDuplicatedException()
        if (result != null) {
            // throws exception
            throw new UsernameDuplicatedException("username existed");
        }

        // add salt
        String oldPassword = user.getPassword();
        // get salt (a random salt)
        String salt = UUID.randomUUID().toString().toUpperCase();
        user.setSalt(salt);
        // put salt and password together
        String md5Password = getMD5Password(oldPassword, salt);
        // put salted password into user
        user.setPassword(md5Password);

        // implement of execution register service function (rows==1)
        Integer rows = userMapper.insertUser(user);
        if (rows != 1) {
            throw new InsertException("Unknown exception occur during registration");
        }
    }

    /** define a md5 encryption operation */
    private String getMD5Password(String password, String salt) {
        // password salted operation: md5 algorithm
        // (string + password + string) --- md5 algorithm, load 3 times
        // salt + pw + salt --- salt is a random string
        for (int i = 0; i < 3; i++) {
            password = DigestUtils.md5DigestAsHex((salt+password+salt).getBytes()).toUpperCase();
        }
        return password;
    }

    @Override
    public void changePassword(Integer uid,
                               String username,
                               String oldPassword,
                               String newPassword) {
        User result = userMapper.findByUid(uid);

        if (result == null) {
            throw new UserNotFoundException("user not exist");
        }

        // compare old password with new password
        String oldMD5Password =
                getMD5Password(oldPassword, result.getSalt());

        if (!result.getPassword().equals(oldMD5Password)) {
            throw new PasswordNotMatchException("password wrong");
        }

        String newMD5Password =
                getMD5Password(newPassword, result.getSalt());

        Integer rows = userMapper.updatePasswordByUid(uid, newMD5Password);

        if (rows != 1) {
            throw new UpdateException("error at update");
        }
    }

    @Override
    public User getByUid(Integer uid) {
        User result = userMapper.findByUid(uid);

        if (result == null) {
            throw new UserNotFoundException("user data not exist");
        }
        
        User user = new User();

        user.setUid(result.getUid());

        user.setUsername(result.getUsername());

        user.setEmail(result.getEmail());

        return user;
    }

    @Override
    public void changeInfo(Integer uid, String username, User user) {
        User result = userMapper.findByUid(uid);

        if (result == null) {
            throw new UserNotFoundException("user data not exist");
        }

        user.setUid(uid);
        user.setUsername(username);

        Integer rows = userMapper.updateInfoByUid(user);
        if (rows != 1) {
            throw new UpdateException("Unknown error occurs at updating");
        }
    }

}
