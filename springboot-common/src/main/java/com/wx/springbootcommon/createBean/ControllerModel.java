package com.wx.springbootcommon.createBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Controller;

/**
 * @version 1.0
 * @author 王兴
 * @date 2022/9/22 0:10
 * @message
 */
@Configurable(preConstruction = true)
//@Controller
public class ControllerModel {

	@Autowired
	ServiceModel serviceModel;

}
