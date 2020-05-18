package com.msr.msrpm.es;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.msr"})

public class EsApplication {
    public static void main(String[] args) {

        SpringApplication.run(EsApplication.class);
    }
}
