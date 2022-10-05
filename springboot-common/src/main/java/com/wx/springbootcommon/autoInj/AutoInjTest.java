package com.wx.springbootcommon.autoInj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @version 1.0
 * @author 王兴
 * @date 2022/9/22 1:26
 * @message
 */
@SpringBootApplication
public class AutoInjTest implements CommandLineRunner {

	//@Autowired
	//ResourceDemo resourceDemo;

	@Autowired
	AutowiredTest autowiredTest;

	public static void main(String[] args){
		SpringApplication.run(AutoInjTest.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		//System.out.println(resourceDemo.fish);
		//System.out.println(resourceDemo.animal);
		System.out.println(autowiredTest.animal);
		System.out.println(autowiredTest.fish);
	}
}
