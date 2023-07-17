package com.ft1.cycleApp.controller;

import com.ft1.cycleApp.service.exception.*;
import com.ft1.cycleApp.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

/** Base class in controller layer */
public class BaseController {
    /** state code for success*/
    public static final int OK = 200;

    // request handling method, return value is pass to all end point
    // pass exception object to this method's parameter automatically
    // when exception occurs, is uniformly intercepted into this method, the return value send to fg
    @ExceptionHandler(ServiceException.class) // unified handling throwing exception
    public JsonResult<Void> handleException(Throwable e) {
        JsonResult<Void> result = new JsonResult<>(e);

        if (e instanceof UsernameDuplicatedException) {
            result.setState(4000);
            result.setMessage(("username existed exception"));
        } else if (e instanceof UserNotFoundException) {
            result.setState(5001);
            result.setMessage("user not exist exception");
        } else if (e instanceof PasswordNotMatchException) {
            result.setState(5002);
            result.setMessage("password not match exception");
        } else if (e instanceof InsertException) {
            result.setState(5000);
            result.setMessage("Unknown exception occur during sign up");
        } else if (e instanceof UpdateException) {
            result.setState(5001);
            result.setMessage("Unknown exception occur during update");
        } else if (e instanceof ProjectNotFoundException) {
            result.setState(5001);
            result.setMessage("User does not have any project");
        } else if (e instanceof BindException) {
            result.setState(5001);
            result.setMessage("err occurs at binding");
        } else if (e instanceof DeleteException) {
            result.setState(5001);
            result.setMessage("err occurs at delete");
        } else if (e instanceof EntityNotFoundException) {
            result.setState(5001);
            result.setMessage("entity not found");
        } else if (e instanceof NoteNotFoundException) {
            result.setState(5001);
            result.setMessage("note not found");
        } else if (e instanceof SetEntityException) {
            result.setState(5001);
            result.setMessage("err at setting attribute");
        } else if (e instanceof SetNameException) {
            result.setState(5001);
            result.setMessage("err occurs at setting name");
        } else if (e instanceof TagNotFoundException) {
            result.setState(5001);
            result.setMessage("tag not found");
        } else if (e instanceof UpdateException) {
            result.setState(5001);
            result.setMessage("err occurs at updating information");
        }

        return result;
    }

    /**
     * get uid of session object
     * @param session session object
     * @return uid of current login user
     * */
    protected final Integer getuidFromSession(HttpSession session) {
        return Integer.valueOf(session.getAttribute("uid")
                .toString());
    }

    /**
     * get username of current login user
     * @param session session object
     * @return username of current login user
     * */
    protected final String getUsernameFromSession(
            HttpSession session) {
        return session.getAttribute("username").toString();
    }

    /**
     * get project of current proejct
     * @param session session object
     * @return project id of current project
     * */
    protected final Integer getProjectIdFromSession(
            HttpSession session) {
        return Integer.valueOf(session.getAttribute("projectId").toString());
    }
}
