package com.ysd.boot.utils;

import java.text.SimpleDateFormat;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration // Spring容器配置
public class MyUtilsCinfig {
	
	/*** 往Spring容器中放入一个ObjectMapper实例对象 * @return */
	@Bean("jackson")
	public ObjectMapper jacksonBean() {
		return new ObjectMapper();
	}

	/*** 往Spring容器中放入一个SimpleDateFormat实例对象 * @return */
	@Bean("dateFormat")
	public SimpleDateFormat dateFormatBean() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	}
	
}
