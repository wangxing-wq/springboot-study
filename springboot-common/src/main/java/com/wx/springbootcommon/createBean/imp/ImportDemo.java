package com.wx.springbootcommon.createBean.imp;

import com.wx.springbootcommon.createBean.Person;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author 王兴
 * @version 1.0
 * @date 2022/9/23 1:51
 * @message
 * @Configuration、ImportSelector、importbeandefinitionregistry
 */
@Import(value = {Person.class,ImportAwareImpl.class})
@ImportAutoConfiguration
public class ImportDemo implements ImportSelector, ImportBeanDefinitionRegistrar,ImportAware {
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		// 可以给出多个类的引用,让Spring加载这些类
		return new String[0];
	}

	@Override
	public void setImportMetadata(AnnotationMetadata importMetadata) {

	}

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		ImportBeanDefinitionRegistrar.super.registerBeanDefinitions(importingClassMetadata, registry);
	}

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {
		ImportBeanDefinitionRegistrar.super.registerBeanDefinitions(importingClassMetadata, registry, importBeanNameGenerator);
	}
}
