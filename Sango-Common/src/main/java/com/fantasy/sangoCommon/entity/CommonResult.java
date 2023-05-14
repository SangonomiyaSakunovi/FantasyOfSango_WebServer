package com.fantasy.sangoCommon.entity;

import org.springframework.http.HttpStatus;
public class CommonResult<T> {
    private int code;
    private String message;
    private T data;

    public CommonResult<T> code(HttpStatus status){
        this.code=status.value();
        return this;
    }

    public CommonResult<T> code(Integer code){
        this.code = code;
        return this;
    }

    public CommonResult<T> message(String message){
        this.message = message;
        return this;
    }

    public CommonResult<T> data(T data){
        this.data=data;
        return this;
    }

    public CommonResult<T> fail(){
        this.code(HttpStatus.INTERNAL_SERVER_ERROR);
        this.message(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        return this;
    }
    public CommonResult<T> success() {
        this.code(HttpStatus.OK);
        this.message(HttpStatus.OK.getReasonPhrase());
        return this;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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
