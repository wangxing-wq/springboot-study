package com.wx.springbootcommon.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Objects;

/**
 * @version 1.0
 * @author 王兴
 * @date 2022/9/23 1:17
 * @message
 */
public class ConditionImpl implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		Environment environment = context.getEnvironment();
		String property = environment.getProperty("condition.enable");
		if (Objects.equals(property, "true")) {
			return true;
		}
		return false;
	}

}
