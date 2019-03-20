package com.weng.framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 启动类
 *
 **/
@EnableSwagger2
@SpringBootApplication
public class SampleApiStarterApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(SampleApiStarterApplication.class, args);
	}
}