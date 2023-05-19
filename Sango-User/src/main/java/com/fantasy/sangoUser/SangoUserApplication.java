package com.fantasy.sangoUser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.fantasy.sangoUser.mapper")
@EnableDiscoveryClient
public class SangoUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(SangoUserApplication.class, args);
    }

}
