package com.cyj.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Spring Boot 应用启动类
 * 
 * @Description: 主模块
 * @ClassName: Application.java
 * @author ChenYongJia
 * @Date 2017-10-4 下午8:03:41
 * @Email 867647213@qq.com
 */
@EnableJpaRepositories(basePackages = "com.cyj.springboot.dao") // Spring Jpa 启用注解
@EntityScan(basePackages = "com.cyj.springboot.entity") // 扫描Jpa实体对象
@SpringBootApplication // Spring Boot 应用的标识
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);// 程序启动入口 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
	}
}
