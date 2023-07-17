package com.ft1.cycleApp.controller;

import com.ft1.cycleApp.entity.User;
import com.ft1.cycleApp.service.IUserService;
// import com.ft1.circleApplication.service.exception.InsertException;
// import com.ft1.circleApplication.service.exception.UsernameDuplicatedException;
import com.ft1.cycleApp.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RestController // @Controller
@RequestMapping("users")
public class UserController extends BaseController {
    @Autowired
    private IUserService userService;

    /**
     * 1. receive data method: set request method parameter with pojo to receive fg data
     * SpringBoot will compare fg url parameter with attribute, if same, inject to pojo attribute
     * */
    @RequestMapping("reg")
    // @ResponseBody // respond result send to fg with json format
    public JsonResult<Void> reg(User user) {
        userService.reg(user);
        return new JsonResult<>(OK);
    }

    /** the exception handling is uniform to base controller */
    /*
        @RequestMapping("reg")
        // @ResponseBody // respond result send to fg with json format
        public JsonResult<Void> reg(User user) {
            // create respond result object
            JsonResult<Void> result = new JsonResult<>();
            try {
                userService.reg(user);
                result.setState(200);
                result.setMessage("Sign up success");
            } catch (UsernameDuplicatedException e) {
                result.setState(4000);
                result.setMessage(("username existed (from controller)"));
            } catch (InsertException e) {
                result.setState(5000);
                result.setMessage("Unknown exception occur during sign up");
            }

            return result;
        }
    */

    /**
     * agreement > configuration, omit lots configurations and annotations
     * 2. receive data method: set request method parameter to non-pojo type
     * SpringBoot will compare request parameters with method parameters, if same, do dependency injection automatically
     * */
    @RequestMapping("login")
    public JsonResult<User> login(String username, String password, HttpSession session) {
        User data = userService.login(username, password);

        // bind data to session object (global variable)
        session.setAttribute("uid", data.getUid());
        session.setAttribute("username", data.getUsername());

        // get binding data from session
        System.out.println(getuidFromSession(session));
        System.out.println(getUsernameFromSession(session));

        return new JsonResult<User>(OK, data);
    }

    @RequestMapping("change_password")
    public JsonResult<Void> changePassword(String oldPassword,
                                           String newPassword,
                                           HttpSession session) {
        Integer uid = getuidFromSession(session);

        String username = getUsernameFromSession(session);

        userService.changePassword(uid, username, oldPassword, newPassword);

        return new JsonResult<>(OK);
    }

    @RequestMapping("get_by_uid")
    public JsonResult<User> getByUid(HttpSession session) {
        User data = userService.getByUid(getuidFromSession(session));

        return new JsonResult<>(OK, data);
    }

    @RequestMapping("change_info")
    public JsonResult<Void> changeInfo(User user, HttpSession session) {
        
        Integer uid = getuidFromSession(session);
        String username = getUsernameFromSession(session);

        userService.changeInfo(uid, username, user);
        return new JsonResult<>(OK);
    }

}
