package com.fantasy.sangoUser.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.fantasy.sangoUser.dto.RegisterDto;
import com.fantasy.sangoCommon.entity.User;
import com.fantasy.sangoUser.exception.BaseException;
import com.fantasy.sangoUser.exception.BaseExceptionEnum;
import com.fantasy.sangoUser.mapper.UserMapper;
import com.fantasy.sangoUser.service.UserService;
import com.fantasy.sangoUser.util.TokenUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    @Override
    public Map<String,Object> login(String username, String password, HttpServletResponse response) throws BaseException{
        Map<String,Object> resultMap = new HashMap<>(2);
        User user = userMapper.selectUserByAccount(username);
        if (user == null) {
            throw new BaseException(BaseExceptionEnum.LOGIN_ERROR);
        }
        //将密码md5加密后与数据库中的密码进行比对
        String newPassword = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!newPassword.equals(user.getPassword())) {
            throw new BaseException(BaseExceptionEnum.LOGIN_ERROR);
        }
        Cookie cookie = new Cookie("token", TokenUtil.getToken(user));
        // 单位：秒
        cookie.setMaxAge(1800);
        cookie.setPath("/");
        response.addCookie(cookie);
        resultMap.put("account",user.getAccount());
        resultMap.put("token", TokenUtil.getToken(user));
        return resultMap;
    }
    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.READ_COMMITTED)
    public String register(RegisterDto registerDto) throws BaseException{
        User user = userMapper.selectUserByAccount(registerDto.getAccount());
        if (user != null) {
            throw new BaseException(BaseExceptionEnum.REGISTER_ERROR);
        }
        //将密码md5加密后与数据库中的密码进行比对
        String newPassword = DigestUtils.md5DigestAsHex(registerDto.getPassword().getBytes());
        userMapper.insertUser(registerDto.getAccount(), newPassword,"UserInfos_"+registerDto.getAccount(),registerDto.getNickName());
        user = userMapper.selectUserByAccount(registerDto.getAccount());
        if (user == null) {
            throw new BaseException(BaseExceptionEnum.REGISTER_ERROR);
        } else {
            return user.getAccount();
        }
    }

    @Override
    public Void isLogin(HttpServletRequest request) throws BaseException {
        // 判断cookie是否有username，如果有代表登陆过
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie != null && "token".equals(URLDecoder.decode(cookie.getName(), StandardCharsets.UTF_8))) {
                    String token = cookie.getValue();
                    try {
                        JWT.decode(token).getAudience().get(0);
                        return null;
                    } catch (JWTDecodeException j) {
                        throw new BaseException(BaseExceptionEnum.INVALID_JWT);
                    }
                }
            }
        }
        throw new BaseException(BaseExceptionEnum.NOT_LOGIN);
    }
}
