package com.msr.msrpm.rm;



import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.msr"})
public class RmApplication {
    public static void main(String[] args) {

        SpringApplication.run(RmApplication.class);
    }
}


