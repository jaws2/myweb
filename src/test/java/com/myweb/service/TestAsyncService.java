package com.myweb.service;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.spring.config.Spring4JavaAsyncConfig;

/**
 * @Title 测试Spring异步方法
 * @com.myweb.service TestAsyncService.java
 * @Describtion
 
 * @author 攀
 * @version 1.0
 * @2017年1月4日{time}
 */
public class TestAsyncService {
	private static AnnotationConfigApplicationContext context;

	public static void main(String[] args) {
		context = new AnnotationConfigApplicationContext(Spring4JavaAsyncConfig.class);
		AsyncTaskService asyncTaskService = context.getBean(AsyncTaskService.class);
		for (int i = 0; i < 10; i++) {
			asyncTaskService.executeAsyncTask(i);
			asyncTaskService.executeAsynTaskPlus(i);
		}

	}
}
