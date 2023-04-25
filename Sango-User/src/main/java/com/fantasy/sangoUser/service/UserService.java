package com.fantasy.sangoUser.service;

import com.fantasy.sangoUser.dto.RegisterDto;
import com.fantasy.sangoUser.exception.BaseException;

public interface UserService {
    Integer login(String username, String password) throws BaseException;
    Integer register(RegisterDto registerDto) throws BaseException;
}
