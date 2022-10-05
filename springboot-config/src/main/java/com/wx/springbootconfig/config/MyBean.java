package com.wx.springbootconfig.config;

import javax.annotation.PostConstruct;

/**
 * @version 1.0
 * @author 王兴
 * @date 2022/1/19 4:28
 */
public class MyBean {

	@PostConstruct
	public void init() {
		System.out.println("myBean init .................");
	}

}
