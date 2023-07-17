package com.ft1.cycleApp.util;

import java.io.Serializable;

/**
 * Respond with Json format data
 * */
public class JsonResult<E> implements Serializable {
    /** state code */
    private Integer state;
    /** description information */
    private String message;
    /** date */
    private E data;

    public JsonResult() {
    }

    public JsonResult(Integer state) {
        this.state = state;
    }

    public JsonResult(Throwable e) {
        this.message = e.getMessage();
    }

    public JsonResult(Integer state, E date) {
        this.state = state;
        this.data = date;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}
