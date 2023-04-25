package com.fantasy.sangoUser.mapper;

import com.fantasy.sangoUser.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User selectUserByAccount(@Param("Account") String Account);
    int insertUser(@Param("Account") String Account, @Param("Password") String Password,@Param("PlayerId") int PlayerId);
}
