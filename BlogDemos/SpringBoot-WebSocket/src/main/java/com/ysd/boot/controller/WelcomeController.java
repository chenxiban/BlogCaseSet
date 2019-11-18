package com.ysd.boot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
	
	
	/**
	 * http://localhost:8080
	 * @return
	 */
	@RequestMapping("/")
	public String welcome(HttpSession session) {
		session.setAttribute("user", "我是HttpSession中的数据");
		return "index.html";
	}

}
