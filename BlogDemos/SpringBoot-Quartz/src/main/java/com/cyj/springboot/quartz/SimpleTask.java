package com.cyj.springboot.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cyj.springboot.config.MyTask;

@Component
@EnableScheduling
public class SimpleTask {

	@Autowired
	private MyTask myTask;
	@Resource
	private SimpleDateFormat dateFormat;

	@Scheduled(fixedRate = 1000 * 3) // 每隔三秒
	public void reportCurrentTime() {
		myTask.say();// 执行任务方法
		System.out.println("每隔3秒任务调度一次  现在时间 " + dateFormat.format(new Date()));
	}

	@Scheduled(cron = "*/5 * * * * ? ") // 每隔5秒
	public void reportCurrentByCron() {
		System.out.println(
				"每隔5秒任务调度一次 Scheduling Tasks Examples By Cron: The time is now " + dateFormat.format(new Date()));
	}

}
