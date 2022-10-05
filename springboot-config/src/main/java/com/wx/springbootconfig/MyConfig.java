package com.wx.springbootconfig;

import com.wx.springbootconfig.Demo;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @version 1.0
 * @author 王兴
 * @date 2022/1/23 12:40
 */
@Configuration
public class MyConfig {

	@Bean
	@Profile("dev")
	public Demo demo(){
		return new Demo();
	}

}
