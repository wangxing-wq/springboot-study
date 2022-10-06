package com.wx.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.RetryListener;
import org.springframework.stereotype.Component;

/**
 * @author 22343
 * @version 1.0
 * @date 2022/10/4 20:36
 */
@Slf4j
@Component
public class MyRetryListener implements RetryListener {
	@Override
	public <T,E extends Throwable> boolean open(RetryContext context,RetryCallback<T,E> callback) {
		// 此处可以获取重试的上下文
		System.out.println(context.getAttribute("label"));
		int retryCount = context.getRetryCount();
		RetryContext parent = context.getParent();
		Throwable lastThrowable = context.getLastThrowable();
		if (parent != null) {
			log.info("retry count: parent = [{}]",parent);
		}
		log.info("retry count: retry count = [{}]",retryCount);
		if (lastThrowable != null) {
			log.error("last retryCount error",lastThrowable);
		}
		return true;
	}
	
	@Override
	public <T,E extends Throwable> void close(RetryContext context,RetryCallback<T,E> callback,Throwable throwable) {
	}
	
	@Override
	public <T,E extends Throwable> void onError(RetryContext context,RetryCallback<T,E> callback,Throwable throwable) {
	}
}
