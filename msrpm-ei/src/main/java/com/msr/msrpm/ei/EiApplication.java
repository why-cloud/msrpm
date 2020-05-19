package com.msr.msrpm.ei;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.msr"})

public class EiApplication {
    public static void main(String[] args) {

        SpringApplication.run(EiApplication.class);
    }
}

