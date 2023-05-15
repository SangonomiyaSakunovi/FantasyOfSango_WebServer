package com.fantasy.sangoUser.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum BaseExceptionEnum {
    SYSTEM_ERROR(500, "Internal Server Error!"),
    LOGIN_ERROR(50001,"用户名或密码错误!"),
    REGISTER_ERROR(50002, "该用户已存在!"),
    INVALID_JWT(50003, "无效的token!"),
    NOT_LOGIN(50004, "未登录!");
    private final Integer code;
    private final String msg;
}
