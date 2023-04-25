package com.fantasy.sangoUser.exception;



import com.fantasy.sangoCommon.entity.CommonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BaseExceptionHandler {
    @ExceptionHandler(Exception.class)
    public CommonResult<Exception> exceptionHandler(Exception e) {
        if (e instanceof BaseException) {
            BaseException be = (BaseException) e;
            return new CommonResult<Exception>().fail().message(be.getMessage()).code(be.getCode());
        } else {
            return new CommonResult<Exception>().fail().message(e.getMessage());
        }
    }
}
