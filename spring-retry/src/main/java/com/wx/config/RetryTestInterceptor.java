package com.wx.config;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

@Component("wx")
public class RetryTestInterceptor implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		//实现具体的拦截策略
		System.out.println("retry test interceptor");
		return invocation.proceed();
	}
}
