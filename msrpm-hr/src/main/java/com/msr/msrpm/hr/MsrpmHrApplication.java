package com.msr.msrpm.hr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.msr")
@SpringBootApplication
public class MsrpmHrApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsrpmHrApplication.class, args);
    }

}
