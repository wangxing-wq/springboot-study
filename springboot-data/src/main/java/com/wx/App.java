package com.wx;

import com.wx.enable.CustomBean;
import com.wx.enable.EnableXxx;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;

/**
 * @author 22343
 */
@SpringBootApplication
@EnableXxx
public class App implements CommandLineRunner {
	//只管注入即可，
	@Resource
	CustomBean bean;
	//
	@Resource
	ApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(bean);
	}
}
