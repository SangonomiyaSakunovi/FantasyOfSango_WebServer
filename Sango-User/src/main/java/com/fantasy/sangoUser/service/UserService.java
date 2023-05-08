package com.fantasy.sangoUser.service;

import com.fantasy.sangoUser.dto.RegisterDto;
import com.fantasy.sangoUser.exception.BaseException;

public interface UserService {
    String  login(String username, String password) throws BaseException;
    String register(RegisterDto registerDto) throws BaseException;
}
