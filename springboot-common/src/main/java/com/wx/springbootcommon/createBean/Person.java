package com.wx.springbootcommon.createBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @version 1.0
 * @author 王兴
 * @date 2022/9/22 0:09
 * @message
 */
@Repository
public class Person {

	public void testConfigurable(){
		ControllerModel controllerModel = new ControllerModel();
		controllerModel.serviceModel.study();
	}

}
