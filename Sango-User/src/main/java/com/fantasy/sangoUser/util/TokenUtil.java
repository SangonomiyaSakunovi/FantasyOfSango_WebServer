package com.fantasy.sangoUser.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fantasy.sangoCommon.entity.User;

import java.util.Date;

public class TokenUtil {
    private TokenUtil() {
        throw new IllegalStateException("Utility class");
    }
    private static final long EXPIRE_TIME = 1800000;
    public static String getToken(User user) {
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        String token;
        // 将 user id 保存到 token 里面
        token= JWT.create().withAudience(user.getAccount())
                //30分钟后token过期
                .withExpiresAt(date)
                // 以 password 作为 token 的密钥
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
