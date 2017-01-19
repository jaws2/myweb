package com.myweb.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.springframework.scheduling.annotation.Scheduled;

public class ScheduleTaskService {
	
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");
	
	/**
	 * 如果需要以固定速率执行，只要将注解中指定的属性名称改成fixedRate即可，
	 * 以下方法将以一个固定速率5s来调用一次执行，这个周期是以上一个任务开始时间为基准，
	 * 从上一任务开始执行后5s再次调用
	 * void
	 */
	@Scheduled(fixedRate = 5000L)
	public void reportCurrentTime(){
		System.out.println("每隔5秒执行一次" + DATE_FORMAT.format(Calendar.getInstance().getTime()));
	}
	
	/**
	 * 上面方法将以一个固定延迟时间5秒钟调用一次执行，这个周期是以上一个调用任务的完成时间为基准，
	 * 在上一个任务完成之后，2s后再次执行
	 * void
	 */
//	@Scheduled(fixedDelay = 2000L)
//	public void fixedDelayExecution(){
//		System.out.println("每次在最近一次调用任务完成时间的基础上再延迟2秒后执行" + DATE_FORMAT.format(Calendar.getInstance().getTime())+"执行");
//	}
	
	/**
	 * 对于固定延迟和固定速率的任务，可以指定一个初始延迟表示该方法在第一被调用执行之前等待的毫秒数：
	 * void
	 */
	@Scheduled(initialDelay = 3000L,fixedRate=10000L)
	public void initialDelayExecution(){
		System.out.println("每隔10秒执行一次,首次执行延迟3秒" + DATE_FORMAT.format(Calendar.getInstance().getTime())+"执行");
	}
	
	
	/**
	 * 如果简单的定期调度不能满足，那么cron表达式提供了可能
	 * 与Linux和Unix操作系统的cron类似
	 * void
	 */
	@Scheduled(cron = "0 20 17 ? * *") 
	public void fixTimeExecution(){
		System.out.println("通过cron和表达式在指定时间" + DATE_FORMAT.format(Calendar.getInstance().getTime())+"执行");
	}
}
