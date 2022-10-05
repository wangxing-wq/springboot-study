package com.wx.enable;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @version 1.0
 * @author 王兴
 * @date 2022/3/7 23:03
 */
public class ImportCustomBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {


	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		//到这里就很明白了，
		String simpleName = CustomBean.class.getName();
		RootBeanDefinition rootBeanDefinition = new RootBeanDefinition();
		rootBeanDefinition.setBeanClass(CustomBean.class);
		MutablePropertyValues propertyValues = new MutablePropertyValues();
		propertyValues.add("name", "Savey");
		rootBeanDefinition.setPropertyValues(propertyValues);
		registry.registerBeanDefinition(simpleName, rootBeanDefinition);
	}

	//@Override
	//public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
	//	//获取EnableCustoBean注释的属性
	//	final Map<String, Object> attributes = importingClassMetadata.getAnnotationAttributes(EnableCustomBean.class.getName());
	//
	//	//获取包扫描
	//	ClassPathScanningCandidateComponentProvider pathScanningCandidateComponentProvider = new ClassPathScanningCandidateComponentProvider(false);
	//
	//	//添加过滤 带有Savey这个注解的类
	//	pathScanningCandidateComponentProvider.addIncludeFilter(new AnnotationTypeFilter(Savey.class));
	//
	//	LinkedHashSet<BeanDefinition> candidateComponents = new LinkedHashSet<>();
	//
	//	for (String basePackages : (String[]) attributes.get("basePackages")) {
	//		candidateComponents.addAll(pathScanningCandidateComponentProvider.findCandidateComponents(basePackages));
	//	}
	//
	//	//注册Bean
	//	for (BeanDefinition candidateComponent : candidateComponents) {
	//		registry.registerBeanDefinition(candidateComponent.getBeanClassName(), candidateComponent);
	//	}
	//}
}
