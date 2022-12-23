package com.kiosk.cafe.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@MapperScan(basePackages = { "com.kiosk.cafe.mapper" })
public class WebMvcConfiguration implements WebMvcConfigurer {

}
