package com.wx.springbootcommon.createBean.factoryBean;

import com.wx.springbootcommon.createBean.Person;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @version 1.0
 * @author 王兴
 * @date 2022/9/24 15:22
 * @message spring 支持的Bean
 * FactoryBean 是一个工厂Bean,通过这个Bean,可以获取这个Bean构建的对象
 * 默认通过Bean名称获取的是这个工厂bean生成的对象,如果加上前缀&,获取的是这个Bean本身
 */
@SpringBootApplication
public class FactoryBeanDemo implements FactoryBean<Person> {

	public static void main(String[] args){
		ConfigurableApplicationContext run = SpringApplication.run(FactoryBeanDemo.class, args);
		System.out.println(run.getBean("factoryBeanDemo"));
		System.out.println(run.getBean("&factoryBeanDemo"));
	}

	@Override
	public Person getObject() {
		return new Person();
	}

	@Override
	public Class<?> getObjectType() {
		return Person.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}
}
