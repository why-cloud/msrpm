package com.msr.msrpm.tm;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.msr"})
@MapperScan("com.msr")
public class TmApplication {
    public static void main(String[] args) {
        SpringApplication.run(TmApplication.class);
    }
}
