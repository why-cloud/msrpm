package com.msr.msrpm.hr;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.msr"})

public class HrApplication {
    public static void main(String[] args) {

        SpringApplication.run(HrApplication.class);
    }
}

