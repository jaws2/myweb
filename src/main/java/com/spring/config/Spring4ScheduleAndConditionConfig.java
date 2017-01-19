package com.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.myweb.service.LinuxListService;
import com.myweb.service.ListService;
import com.myweb.service.ScheduleTaskService;
import com.myweb.service.WindowsListService;
import com.myweb.service.condition.LinuxCondition;
import com.myweb.service.condition.WindowsCondition;

@Configuration
@ComponentScan("com.myweb.service.*")
@EnableScheduling //支持计划任务
public class Spring4ScheduleAndConditionConfig {
	
	@Bean
	public ScheduleTaskService geScheduleTaskService(){
		return new ScheduleTaskService();
	}
	
	//WindowsCondition是条件类,Spring将根据条件类实现的condition接口matches方法判断,
	//是否调用此方法构造对象
	@Bean
	@Conditional(WindowsCondition.class)
	public ListService getWindowsService(){
		return new WindowsListService();
	}
	
	@Bean
	@Conditional(LinuxCondition.class)
	public ListService getLinuxService(){
		return new LinuxListService();
	}
}
