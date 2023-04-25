package com.fantasy.sangoUser.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseException extends Exception{
    private Integer code;
    public BaseException(BaseExceptionEnum baseExceptionEnum){
        super(baseExceptionEnum.getMsg());
        this.code = baseExceptionEnum.getCode();
    }

    public BaseException(Integer code, String message){
        super(message);
        this.code = code;
    }
}
