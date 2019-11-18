package com.cyj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Spring Boot 应用启动类
 * 
 * @Description: 主模块
 * @ClassName: Application.java
 * @author ChenYongJia
 * @Date 2017-10-5 下午6:43:59
 * @Email 867647213@qq.com
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);// 程序启动入口 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
	}

	/**
	 * STS中运行不需要 需要把web项目打成war包部署到外部tomcat运行时需要改变启动方式
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Application.class);
	}

}
