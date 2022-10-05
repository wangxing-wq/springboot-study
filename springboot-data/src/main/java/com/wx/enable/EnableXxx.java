package com.wx.enable;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @version 1.0
 * @author 王兴
 * @date 2022/3/7 23:02
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(ImportCustomBeanDefinitionRegistrar.class)
public @interface EnableXxx {
}
