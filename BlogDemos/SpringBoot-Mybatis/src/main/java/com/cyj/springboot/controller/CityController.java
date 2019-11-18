package com.cyj.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cyj.springboot.service.CityService;

@RestController
@RequestMapping("/city")
public class CityController {

	@Autowired
	private CityService service;

	/**
	 * http://localhost:80/city/queryCityByName?name=郑
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping("/queryCityByName")
	public Object queryCityByName(String name) {
		return service.queryCityByName(name);
	}

}
