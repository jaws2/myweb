package com.myweb.service.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 
 * @Title Windows系统条件
 * @com.myweb.service.condition WindowsCondition.java
 * @Describtion
 
 * @author 攀
 * @version 1.0
 * @2017年1月7日 下午4:22:12
 */
public class WindowsCondition implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		// TODO Auto-generated method stub
		return context.getEnvironment().getProperty("os.name").contains("Windows");
	}

}
