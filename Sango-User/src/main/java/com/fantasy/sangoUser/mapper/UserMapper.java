package com.fantasy.sangoUser.mapper;

import com.fantasy.sangoCommon.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User selectUserByAccount(@Param("Account") String Account);
    int insertUser(@Param("Account") String Account, @Param("Password") String Password,
                   @Param("_id") String _id,@Param("Nickname") String Nickname);
}
