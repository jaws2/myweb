package com.myweb.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.config.Spring4JavaELConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={Spring4JavaELConfig.class})
public class Junit4TestSpringEL {
	@Autowired
	Spring4JavaELConfig elConfig;
	
	@Test
	public void testSpringEL(){
		elConfig.outputResource();
	}
}
