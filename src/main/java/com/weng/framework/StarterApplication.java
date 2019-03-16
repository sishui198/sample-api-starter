package com.weng.framework;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 启动类
 *
 **/
@EnableSwagger2
@SpringBootApplication
public class StarterApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(StarterApplication.class, args);
	}
}