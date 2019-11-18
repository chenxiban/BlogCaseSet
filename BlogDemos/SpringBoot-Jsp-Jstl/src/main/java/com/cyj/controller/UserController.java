package com.cyj.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	/**
	 * http://localhost:8080/indexjsp?name=Jim
	 * 
	 * @param view
	 * @return
	 */
	@RequestMapping("/indexjsp")
	public ModelAndView index(ModelAndView view, String name) {
		System.out.println("成功访问了 indexjsp");
		view.addObject("msg", name + ",欢迎访问SpringBoot+JSP集成项目");
		view.setViewName("index");
		return view;
	}

	/**
	 * http://localhost:8080/jstljsp?name=Tom SpringBoot中使用JSP页面中的JSTL标签
	 * 
	 * @param view
	 * @param name
	 * @return
	 */
	@RequestMapping("/jstljsp")
	public ModelAndView queryAll(ModelAndView view, String name) {
		System.out.println("成功访问了 jstljsp");
		List<String> list = new ArrayList<String>();
		list.add(name);
		list.add("张三");
		list.add("李四");
		view.addObject("list", list);
		view.setViewName("list");
		return view;
	}

	// 静态资源访问路径 http://localhost:8080/js/my.js

}
