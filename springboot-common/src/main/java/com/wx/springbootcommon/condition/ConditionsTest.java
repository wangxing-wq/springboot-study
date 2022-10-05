package com.wx.springbootcommon.condition;

import org.springframework.beans.BeansException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

/**
 * @version 1.0
 * @author 王兴
 * @date 2022/9/23 1:15
 * @message
 * Conditional指定注入的条件,这个条件可以通过实现Condition的类实现,这个可以拥有多个实现,Spring
 * 自己也有实现好的在可以使用,可以看这个包下的实现类
 * {@link org.springframework.boot.autoconfigure.condition}
 */
@SpringBootApplication
public class ConditionsTest implements CommandLineRunner, ApplicationContextAware {

	@Bean
	@Conditional(ConditionImpl.class)
	@ConditionalOnBean
	public String str(){
		return "Conditions";
	}

	public static void main(String[] args){
		SpringApplication.run(ConditionsTest.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(this.getClass());
		System.out.println(str());
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println(applicationContext.containsBean("str"));
	}
}
