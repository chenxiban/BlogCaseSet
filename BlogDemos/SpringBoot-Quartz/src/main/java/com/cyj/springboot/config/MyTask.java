package com.cyj.springboot.config;

import org.springframework.stereotype.Component;

@Component("myTask")
public class MyTask {

	private int count = 0;

	public void say() {
		System.out.println("大家好,我是springboot任务调度=>" + count++);
	}

}
