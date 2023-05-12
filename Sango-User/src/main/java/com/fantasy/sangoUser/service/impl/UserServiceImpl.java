package com.fantasy.sangoUser.service.impl;

import com.fantasy.sangoUser.dto.RegisterDto;
import com.fantasy.sangoCommon.entity.User;
import com.fantasy.sangoUser.exception.BaseException;
import com.fantasy.sangoUser.exception.BaseExceptionEnum;
import com.fantasy.sangoUser.mapper.UserMapper;
import com.fantasy.sangoUser.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import javax.annotation.Resource;
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public String login(String username, String password) throws BaseException{
        User user = userMapper.selectUserByAccount(username);
        if (user == null) {
            throw new BaseException(BaseExceptionEnum.LOGIN_ERROR);
        }
        //将密码md5加密后与数据库中的密码进行比对
        String newPassword = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!newPassword.equals(user.getPassword())) {
            throw new BaseException(BaseExceptionEnum.LOGIN_ERROR);
        }
        return user.get_id();
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
        return "success";
    }
}
