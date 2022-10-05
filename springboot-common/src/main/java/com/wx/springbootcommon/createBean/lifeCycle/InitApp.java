package com.wx.springbootcommon.createBean.lifeCycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @version 1.0
 * @author 王兴
 * @date 2022/9/24 16:16
 * @message
 * InitializingBean 注入Spring 时,初始化调用的方法
 * DisposableBean 注入Spring 时,销毁时调用的方法
 */
@SpringBootApplication
public class InitApp implements InitializingBean, DisposableBean {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(InitApp.class, args);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializedBean");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("DisposableBean");
	}
}
