package com.wx.springbootcommon.autoInj;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.Callable;

/**
 * @version 1.0
 * @author 王兴
 * @date 2022/9/22 1:48
 * @message 动物
 * @Resource 按照Bean名称注入
 */
//@Component
public class ResourceDemo {

	@Resource
	Animal animal;

	@Resource(type = Dog.class)
	Animal fish;

}
