package com.wx.springbootconfig;

import com.wx.springbootconfig.config.EnableMyFeature;
import com.wx.springbootconfig.config.MyBean;
import com.wx.springbootconfig.config.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

/**
 * @author 22343
 */
@SpringBootApplication
@Slf4j
//@EnableMyFeature
//@Import(MyBean.class)
public class SpringbootConfigApplication implements CommandLineRunner {

	@Autowired
	Person person;

	@Autowired
	ApplicationContext applicationContext;

	//@Autowired
	//RestTemplate restTemplate;
	//
	//@Bean
	//public RestTemplate restTemplate(){
	//	HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
	//	factory.setConnectTimeout(30000);
	//	factory.setReadTimeout(30000);
	//	return new RestTemplate(factory);
	//}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootConfigApplication.class, args);
		System.out.println(log.getClass());
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(applicationContext.getBean("demo"));
	}
}
