package com.fantasy.sangoUser.controller;

import com.fantasy.sangoCommon.entity.CommonResult;
import com.fantasy.sangoUser.dto.LoginDto;
import com.fantasy.sangoUser.dto.RegisterDto;
import com.fantasy.sangoUser.dto.UserDto;
import com.fantasy.sangoUser.exception.BaseException;
import com.fantasy.sangoUser.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    @PostMapping("/login")
    public CommonResult<Map<String,Object>> login(@RequestBody LoginDto loginDto, HttpServletResponse response) throws BaseException {
        return new CommonResult<Map<String,Object>>().success().data(userService.login(loginDto.getAccount(), loginDto.getPassword(), response));
    }
    @PostMapping("/register")
    public CommonResult<String> register(@RequestBody RegisterDto registerDto) throws BaseException {
        return new CommonResult<String>().success().data(userService.register(registerDto));
    }
    @GetMapping("/isLogin")
    public CommonResult<UserDto> isLogin(HttpServletRequest request) throws BaseException {
        return new CommonResult<UserDto>().success().data(userService.isLogin(request));
    }
    @PostMapping("/logout")
    public CommonResult<Void> logout(HttpServletRequest request,HttpServletResponse response) throws BaseException {
        return new CommonResult<Void>().success().data(userService.logout(request,response));
    }
}
