package com.cyj.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring Boot HelloWorld 案例
 *
 * Created by bysocket on 16/4/26.
 */
@RestController
public class HelloWorldController {

	/**
	 * http://localhost:8080
	 * 
	 * @return
	 */
	@RequestMapping("/")
	public String sayHello() {
		return "欢迎进入SpringBoot世界!";
	}
}
