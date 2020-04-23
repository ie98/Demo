package com.exmaple.Demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication

public class DemoApplication {   //项目启动类

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
