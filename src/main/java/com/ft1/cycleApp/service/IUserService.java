package com.ft1.cycleApp.service;

import com.ft1.cycleApp.entity.User;

/** Service layer interface of user module*/
public interface IUserService {


    /**
     * User register method
     * @param user User object
     * */
    void reg(User user);

    /**
     * user login function
     * @param username username
     * @param password password
     * @return current matched user data, if no user return null
     * */
    User login(String username, String password);

    void changePassword(Integer uid,
                        String username,
                        String oldPassword,
                        String newPassword);

    User getByUid(Integer uid);

    void changeInfo(Integer uid, String username, User user);
}
