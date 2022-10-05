package com.wx.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.retry.RetryListener;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.listener.RetryListenerSupport;
import org.springframework.retry.policy.MapRetryContextCache;
import org.springframework.retry.policy.TimeoutRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

/**
 * @author 22343
 * @date 2022/10/4 12:55
 * @desc
 */
//@Configuration
public class RetryConfig {

	@Autowired
	private RetryProperties retryProperties;

	@Bean
	public RetryTemplate retryTemplate(){
		RetryTemplate retryTemplate = new RetryTemplate();
		// 重试策略
		TimeoutRetryPolicy retryPolicy = new TimeoutRetryPolicy();
		retryPolicy.setTimeout(1000L);
		retryTemplate.setRetryPolicy(retryPolicy);
		// 重试后的补偿策略
		FixedBackOffPolicy backOffPolicy = new FixedBackOffPolicy();
		backOffPolicy.setBackOffPeriod(5000L);
		retryTemplate.setBackOffPolicy(backOffPolicy);
		// 监听器设置
		retryTemplate.setListeners(new RetryListener[] {new RetryListenerSupport(), new MyRetryListener()});
		// mapRetryContextCache
		MapRetryContextCache mapRetryContextCache = new MapRetryContextCache();
		mapRetryContextCache.setCapacity(10);
		retryTemplate.setRetryContextCache(mapRetryContextCache);

		retryTemplate.setThrowLastExceptionOnExhausted(true);
		return retryTemplate;
	}

}
