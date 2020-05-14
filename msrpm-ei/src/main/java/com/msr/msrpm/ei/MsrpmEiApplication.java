package com.msr.msrpm.ei;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.msr")
@SpringBootApplication
public class MsrpmEiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsrpmEiApplication.class, args);
    }

}
