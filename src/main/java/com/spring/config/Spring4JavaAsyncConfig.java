package com.spring.config;

import java.util.concurrent.Executor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.myweb.service.AsyncTaskService;

/**
 * 
 * @Title 测试Sprng的异步方法支持
 * @com.spring.config Spring4JavaAsyncConfig.java
 * @Describtion 实现AsyncConfigurer(异步配置接口),重写getAsyncExecutor方法,构造线程池任务的Executor,
 * 				猜想:
 * 				在执行所有被@Async注解的异步方法,Spring会使用动态代理拦截原有方法,再会动态生产一个callable的现实类,
 * 				通过call方法中调用被注解的方法,call方法的返回值就是被注解方法的返回值,再将callable任务提交到
 * 				Executor中执行,在拦截的方法中通过FutureTask.get()方法等待call方法的返回值
 * 				
 
 * @author 攀
 * @version 1.0
 * @2017年1月3日{time}
 */
@Configuration
@ComponentScan("com.myweb.service.*")
@EnableAsync //支持异步
public class Spring4JavaAsyncConfig implements AsyncConfigurer{

	@Override
	public Executor getAsyncExecutor() {
		// TODO Auto-generated method stub
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setCorePoolSize(5);
		taskExecutor.setMaxPoolSize(10);
		taskExecutor.setQueueCapacity(25);//任务队列容量
		taskExecutor.initialize();
		return taskExecutor;
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Bean
	public AsyncTaskService geTaskService(){
		return new AsyncTaskService();
	}
	
}
