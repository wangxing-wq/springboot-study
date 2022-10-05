package com.wx.springbootcommon.autoInj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @author 王兴
 * @date 2022/9/22 1:48
 * @message
 * 优先按照类型
 */
@Component
public class AutowiredTest {

	@Autowired
	Animal animal;

	@Autowired
	Animal fish;

	//@Autowired
	//Dog do;

}
