package com.wx.springbootcommon.createBean.imp;

import org.springframework.context.annotation.ImportAware;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

/**
 * @version 1.0
 * @author 王兴
 * @date 2022/9/24 1:16
 * @message
 * ImportAware 可以获取注解中的内容
 */
public class ImportAwareImpl implements ImportAware {

	private String name;
	private String age;
	private String sex;

	@Override
	public void setImportMetadata(AnnotationMetadata importMetadata) {
		//可以拿到已给注解上所有注解的属性值，并放到一个map中
		Map<String, Object> map = importMetadata.getAnnotationAttributes(EnableMetadata.class.getName());
		//从map中拿到注解的所有属性信息
		AnnotationAttributes attrs = AnnotationAttributes.fromMap(map);
		name = attrs.get("name").toString();
		age = attrs.get("age").toString();
		sex = attrs.get("sex").toString();
	}

	public void print(){
		System.out.println(name + " " + age + " " + sex);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
}
