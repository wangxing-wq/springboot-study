package com.wx.springbootcommon.createBean.imp;

import java.lang.annotation.*;

/**
 * @version 1.0
 * @author 王兴
 * @date 2022/9/24 1:21
 * @message
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EnableMetadata {

	String name();
	String age();
	String sex();

}
