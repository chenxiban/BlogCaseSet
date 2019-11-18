package org.spring.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description: Spring Boot 应用启动类 主模块
 * @ClassName: Application.java
 * @author ChenYongJia
 * @Date 2017-10-4 上午10:25:23
 * @Email 867647213@qq.com
 */
@MapperScan("org.spring.springboot.dao") // mapper 接口类扫描包配置
@SpringBootApplication // Spring Boot 应用的标识
public class Application {

	public static void main(String[] args) {
		// 程序启动入口
		// 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
		SpringApplication.run(Application.class, args);
	}
}
