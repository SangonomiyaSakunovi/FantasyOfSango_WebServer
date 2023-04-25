package com.fantasy.sangoUser.controller;

import com.fantasy.sangoCommon.entity.CommonResult;
import com.fantasy.sangoUser.dto.LoginDto;
import com.fantasy.sangoUser.dto.RegisterDto;
import com.fantasy.sangoUser.exception.BaseException;
import com.fantasy.sangoUser.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    @PostMapping("/login")
    public CommonResult<Integer> login(@RequestBody LoginDto loginDto) throws BaseException {
        return new CommonResult<Integer>().success().data(userService.login(loginDto.getAccount(), loginDto.getPassword()));
    }
    @PostMapping("/register")
    public CommonResult<Integer> register(@RequestBody RegisterDto registerDto) throws BaseException {
        return new CommonResult<Integer>().success().data(userService.register(registerDto));
    }
}
