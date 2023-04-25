package com.fantasy.sangoUser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.fantasy.sangoUser.mapper")
public class SangoServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SangoServerApplication.class, args);
    }

}
