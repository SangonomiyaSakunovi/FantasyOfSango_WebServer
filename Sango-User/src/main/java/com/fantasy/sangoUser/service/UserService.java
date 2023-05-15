package com.fantasy.sangoUser.service;

import com.fantasy.sangoUser.dto.RegisterDto;
import com.fantasy.sangoUser.exception.BaseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public interface UserService {
    Map<String,Object> login(String username, String password, HttpServletResponse response) throws BaseException;
    String register(RegisterDto registerDto) throws BaseException;
    Void isLogin(HttpServletRequest request) throws BaseException;
}
