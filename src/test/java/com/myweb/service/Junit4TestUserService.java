package com.myweb.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.jaws.mylib.util.ListUtil;
import com.spring.config.Spring4JavaConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={Spring4JavaConfig.class})//设置注销后,Spring会自动根据配置类构建对象容器
public class Junit4TestUserService {
	
	@Autowired
	private UserService userService;
	
	@Test
	public void getAllRegisteredUserTest(){
		ListUtil.printSimpleList(userService.getAllRegisteredUser());
	}
}
