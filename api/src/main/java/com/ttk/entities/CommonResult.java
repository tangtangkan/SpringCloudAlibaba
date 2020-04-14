package com.ttk.entities;

public class CommonResult<T> {

    private Integer code;

    private String message;

    private T data;

    public CommonResult () {}

    public CommonResult (Integer code, String message, T object) {
        this.code = code;
        this.message = message;
        this.data = object;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
