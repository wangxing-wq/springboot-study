package com.wx.springbootcommon.createBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

/**
 * @version 1.0
 * @author 王兴
 * @date 2022/9/21 23:35
 * @message
 * Configuration 这个类替代里spring.xml 可与注册Bean
 * ComponentScan 这个类可以扫描其他Spring的注解
 * Configurable 其他类new 的时候这个类也可以使用自动注入
 */
@Configuration
@SpringBootApplication
@ComponentScan(
		excludeFilters = {
				@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = Person.class)
		}
		//ANNOTATION, 注解 排除哪些注解,不会被Spring扫描
		//ASSIGNABLE_TYPE, 类,排除哪些类型不会被Spring 扫描
		//REGEX, 正则 通过在正则,确定那些包不会被扫描
		//CUSTOM 自定义 自己的类实现接口自定义排除
)
@EnableSpringConfigured
@EnableLoadTimeWeaving
public class ComponentScanLearn implements CommandLineRunner {


	@Bean
	public String staticBean(){
		return "component";
	}

	public static void main(String[] args) {
		SpringApplication.run(ComponentScanLearn.class,args);
		//AnnotationConfigApplicationContext annotation = new AnnotationConfigApplicationContext(ComponentScanLearn.class);
		//for (String beanDefinitionName : annotation.getBeanDefinitionNames()) {
		//	Object bean = annotation.getBean(beanDefinitionName);
		//	System.out.println(beanDefinitionName + "===" + bean);
		//}
		//// 测试Configurable
		//ResourceDemo bean = annotation.getBean(ResourceDemo.class);
		//bean.testConfigurable();
	}


	@Autowired
	Person person;

	@Override
	public void run(String... args) throws Exception {
		person.testConfigurable();
	}
}
