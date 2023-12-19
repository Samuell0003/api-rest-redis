package com.iftm.apirestredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ApiRestRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiRestRedisApplication.class, args);
    }

}
