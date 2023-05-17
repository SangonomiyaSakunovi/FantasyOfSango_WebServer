package com.fantasy.sangoUser.service;

import com.fantasy.sangoUser.dto.RegisterDto;
import com.fantasy.sangoUser.dto.UserDto;
import com.fantasy.sangoUser.exception.BaseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public interface UserService {
    HashMap<String,String> tokenMap = new HashMap<>(16);
    Map<String,Object> login(String username, String password, HttpServletResponse response) throws BaseException;
    String register(RegisterDto registerDto) throws BaseException;
    UserDto isLogin(HttpServletRequest request) throws BaseException;
    Void logout(HttpServletRequest request,HttpServletResponse response)throws BaseException;
}
