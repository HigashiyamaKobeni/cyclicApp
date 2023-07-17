package com.ft1.cycleApp.mapper;

import com.ft1.cycleApp.entity.User;


/**
 * Persistent Interface of user module
 * */
//@Mapper
public interface UserMapper {

    /**
     * insert user data
     * @param user user data
     * @return affected lines number (lines affected by add, delete, modify as return value, according return value to judge if execute method)
     */
    Integer insertUser(User user);

    /**
     * according username to serach user data
     * @param username username
     * @return if find related user, return user data, or return null
     * */
    User findByUsername(String username);

    /**
     * modify password via userid
     * @param uid user id
     * @param password new password
     * @Integer affected line number
     * */
    Integer updatePasswordByUid(Integer uid,
                                String password);

    /**
     * query use data via user id
     * @param uid user id
     * @return if query success return object, or return null
     * */
    User findByUid(Integer uid);

    /**
     * update user data
     * @param user userdata
     * @return return affected lines
     * */
    Integer updateInfoByUid(User user);
}
