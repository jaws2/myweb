package com.myweb.service;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.config.Spring4ScheduleAndConditionConfig;

public class TestScheduleAndCondition {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Spring4ScheduleAndConditionConfig.class);
		ListService service = context.getBean(ListService.class);
		System.out.println(context.getEnvironment().getProperty("os.name")+"系统的列表命令为: " + service.showListCmd());
	}
}
