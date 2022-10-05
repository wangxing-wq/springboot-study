package com.wx.springbootcommon.createBean.imp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * @version 1.0
 * @author 王兴
 * @date 2022/9/24 1:24
 * @message
 */
@SpringBootApplication
@EnableMetadata(name = "wx",age = "1",sex = "aa")
@Import(ImportAwareImpl.class)
public class SpringImportTest implements CommandLineRunner {

	public static void main(String[] args){
		ConfigurableApplicationContext run = SpringApplication.run(SpringImportTest.class, args);
		ImportAwareImpl bean = run.getBean(ImportAwareImpl.class);
		bean.print();
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
