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
		log.info("myRetryListener open context: [{}], callback: [{}]",context,callback);
		return true;
	}
	
	@Override
	public <T,E extends Throwable> void close(RetryContext context,RetryCallback<T,E> callback,Throwable throwable) {
		log.info("myRetryListener close context: [{}], callback: [{}]",context,callback,throwable);
	}
	
	@Override
	public <T,E extends Throwable> void onError(RetryContext context,RetryCallback<T,E> callback,Throwable throwable) {
		log.info("myRetryListener onError context: [{}], callback: [{}]",context,callback,throwable);
	}
}
