package com.spring.config;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

/**
 * @Title 测试Spring EL表达式
 * @com.spring.config Spring4JavaELConfig.java
 * @Describtion
 
 * @author 攀
 * @version 1.0
 * @2017年1月3日{time}
 */
@Configuration
@ComponentScan("com.myweb.service.*")
@PropertySource("classpath:com/spring/config/test.properties") //注入文件资源
public class Spring4JavaELConfig {
	
	@Value("注入属性")
	private String testString;
	
	@Value("#{systemProperties['os.name']}")//注入系统属性
	private String osName;
	
	@Value("#{T(java.lang.Math).random()*100.0}") //注入运算表达式
	private double randomNum;
	
//	@Value("#{demoELService.another}")//注意容器里面其它Bean的属性
//	private String fromAnother;
	
	@Value("classpath:com/spring/config/test.txt") //注入文件资源
	private Resource testFlie;
	
	@Value("http://www.baidu.com") //注入网络资源
	private Resource testURL;
	
	@Value("${book.name}")
	private String bookName;
	
	@Autowired
	private Environment environment;
	
	@Bean //创建一个属性文件定位配置对象
	public static PropertySourcesPlaceholderConfigurer propertyConfig(){
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	public void outputResource(){
		try {
			System.out.println(testString);
			System.out.println(osName);
			System.out.println(randomNum);
			//System.out.println(fromAnother);
			System.out.println(IOUtils.toString(testFlie.getInputStream()));
			System.out.println(IOUtils.toString(testURL.getInputStream()));
			System.out.println(bookName);
			System.out.println(environment.getProperty("book.author"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
