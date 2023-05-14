package com.fantasy.sangoUser.service;

import com.fantasy.sangoUser.dto.RegisterDto;
import com.fantasy.sangoUser.exception.BaseException;

import java.util.Map;

public interface UserService {
    Map<String,Object> login(String username, String password) throws BaseException;
    String register(RegisterDto registerDto) throws BaseException;
}
