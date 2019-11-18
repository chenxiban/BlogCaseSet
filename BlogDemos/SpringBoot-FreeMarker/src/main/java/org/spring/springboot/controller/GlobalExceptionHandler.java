package org.spring.springboot.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @Description: 全局异常处理类
 * @ClassName: GlobalExceptionHandler.java
 * @author ChenYongJia
 * @Date 2017-10-5 下午6:27:21
 * @Email 867647213@qq.com
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
	
	@ExceptionHandler(RuntimeException.class) // 捕获所有运行时异常
	public String exceptionHandler() {
		return "error";
	}
	
}
