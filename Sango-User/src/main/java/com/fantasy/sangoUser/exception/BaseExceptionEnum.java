package com.fantasy.sangoUser.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum BaseExceptionEnum {
    LOGIN_ERROR(50001,"用户名或密码错误!"),
    REGISTER_ERROR(50002, "该用户已存在!"),
    INVALID_JWT(50003, "无效的token!");
    private final Integer code;
    private final String msg;
}
