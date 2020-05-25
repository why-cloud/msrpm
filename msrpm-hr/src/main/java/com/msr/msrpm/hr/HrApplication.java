package com.msr.msrpm.hr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
//(exclude = DataSourceAutoConfiguration.class)
@SpringBootApplication
@ComponentScan({"com.msr"})
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})

public class HrApplication {
    public static void main(String[] args) {
        SpringApplication.run(HrApplication.class);
    }
}

