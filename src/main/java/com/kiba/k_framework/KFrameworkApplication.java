package com.kiba.k_framework;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.kiba.k_framework.mapper")
@SpringBootApplication
public class KFrameworkApplication
{

    public static void main(String[] args) {
        SpringApplication.run(KFrameworkApplication.class, args);
    }

}
