package com.wx.springbootdata;

import com.wx.enable.CustomBean;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;

@SpringBootTest
public class ImportBeanDefinitionRegistrarTest {

	//只管注入即可，
	@Resource
	CustomBean bean;
	//
	@Resource
	ApplicationContext applicationContext;

	@Test
	public void test_register_custom_bean() {
		System.out.println(bean);
	}
}
