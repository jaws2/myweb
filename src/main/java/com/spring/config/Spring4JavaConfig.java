package com.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.myweb.service.UserService;
import com.myweb.service.UserServiceImpl;

@Configuration
@ComponentScan("com.myweb.service.*")
public class Spring4JavaConfig {
	
	@Bean
	public UserService getUserService(){
		return new UserServiceImpl();
	}
}
