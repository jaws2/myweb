package com.spring.init;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import com.spring.config.MvcJavaConfig;


/**
 * @Title Web应用初始化
 * @com.spring.init WebInitializer.java
 * @Describtion  实现此接口的类会在Tomcat启动之后扫描项目WEB-INFO/lib,找到现实ServletContainerInitializer
 * 				 接口的类,Spring中的{@link} #SpringServletContainerInitializer,实现此接口
 * @author jaws
 * @version 1.0
 * @2017年1月7日 下午11:44:24
 */
public class WebInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		//注解配置Web应用上下文
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		//注册Spring的Java配置类
		context.register(MvcJavaConfig.class);
		//设置ServletContext(servlet的上下文)
		context.setServletContext(servletContext);
		//添加dispather servlet,并把spring的上下文传递到servlet中,与之前在web.xml配置类似,只是改变为Java写配置
		Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
		//设置serlvet拦截的访问路径
		servlet.addMapping("/");
		//设置servlet启动顺序为Web容器启动应用后自动启动该servlet,无须首次访问才启动
		servlet.setLoadOnStartup(1);
	}

}
