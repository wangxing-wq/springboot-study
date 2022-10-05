package com.wx.springbootcommon.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @version 1.0
 * @author 王兴
 * @date 2022/9/24 16:32
 * @message
 */
@SpringBootApplication
public class ProcessorApp implements BeanPostProcessor {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(ProcessorApp.class, args);
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
	}
}
