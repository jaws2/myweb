package com.myweb.service;

import org.springframework.scheduling.annotation.Async;

public class AsyncTaskService {
	
	@Async
	public void executeAsyncTask(Integer i){
		System.out.println("执行异步任务: "+i);
	}
	
	public void executeAsynTaskPlus(Integer i){
		System.out.println("执行异步任务: "+(++i));
	}
}
