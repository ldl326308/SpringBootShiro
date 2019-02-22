package com.nf.lc.myspringbootdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.nf.lc.myspringbootdemo.dao")
public class MySpringBootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySpringBootDemoApplication.class, args);
    }

}
