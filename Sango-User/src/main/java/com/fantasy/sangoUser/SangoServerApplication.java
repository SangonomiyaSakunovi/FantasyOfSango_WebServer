package com.fantasy.sangoUser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.fantasy.sangoUser.mapper")
@EnableEurekaClient
public class SangoServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SangoServerApplication.class, args);
    }

}
