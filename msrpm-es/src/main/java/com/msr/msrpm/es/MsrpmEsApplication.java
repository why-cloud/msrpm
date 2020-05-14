package com.msr.msrpm.es;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.msr")
@SpringBootApplication
public class MsrpmEsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsrpmEsApplication.class, args);
    }

}
