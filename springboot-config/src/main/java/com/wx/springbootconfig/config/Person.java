package com.wx.springbootconfig.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @author 王兴
 * @date 2022/1/18 1:01
 */
@Component
@ConfigurationProperties("person")
@Data
public class Person {

	private String name = "王兴";

	private int age = 0;

	private String sex = "男";

	private String address = "河南省";



}
