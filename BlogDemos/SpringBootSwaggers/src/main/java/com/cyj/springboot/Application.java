package com.cyj.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @Description: Spring Boot 应用启动类
 * @ClassName: Application.java
 * @author ChenYongJia
 * @Date 2018年8月11日 下午3:59:36
 * @Email 867647213@qq.com
 */
@EnableSwagger2
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		// 程序启动入口
		// 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
		SpringApplication.run(Application.class, args);
	}
}
