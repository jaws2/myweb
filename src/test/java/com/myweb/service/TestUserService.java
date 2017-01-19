package com.myweb.service;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jaws.mylib.util.ListUtil;
import com.spring.config.Spring4JavaConfig;

/**
 * 
 * @Title 通过普通Java类main方法测试
 * @com.myweb.service TestUserService.java
 * @Describtion
 
 * @author 攀
 * @version 1.0
 * @2017年1月3日{time}
 */
public class TestUserService {
	private static AnnotationConfigApplicationContext context;

	public static void main(String[] args) {
		context = new AnnotationConfigApplicationContext(Spring4JavaConfig.class);
		UserService userService = context.getBean(UserService.class);
		ListUtil.printSimpleList(userService.getAllRegisteredUser());
	}
	
	
	
}
