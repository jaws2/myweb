package com.myweb.service;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.config.Spring4JavaELConfig;

public class TestSpringEL {
	private static AnnotationConfigApplicationContext context;

	public static void main(String[] args) {
		context = new AnnotationConfigApplicationContext(Spring4JavaELConfig.class);
		Spring4JavaELConfig config = context.getBean(Spring4JavaELConfig.class);
		config.outputResource();
	}
}
