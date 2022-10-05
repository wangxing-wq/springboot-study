package com.wx.config;

import org.springframework.beans.BeansException;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.retry.RetryListener;
import org.springframework.retry.RetryPolicy;
import org.springframework.retry.backoff.BackOffPolicy;
import org.springframework.retry.policy.RetryContextCache;
import org.springframework.stereotype.Component;

/**
 * @author 22343
 * @date 2022/10/4 12:55
 * @version 1.0
 */
@Component
@ConfigurationProperties(prefix = "retry")
public class RetryProperties implements ApplicationContextAware {

	private boolean throwLastExceptionOnExhausted = true;
	private BackOffPolicy backOffPolicy;
	private String backOff = "always";
	private RetryListener[] listeners;
	private RetryContextCache retryContextCache;
	private RetryPolicy retryPolicy;
	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	public boolean isThrowLastExceptionOnExhausted() {
		return throwLastExceptionOnExhausted;
	}

	public void setThrowLastExceptionOnExhausted(boolean throwLastExceptionOnExhausted) {
		this.throwLastExceptionOnExhausted = throwLastExceptionOnExhausted;
	}

	public BackOffPolicy getBackOffPolicy() {
		// 获取策略,
		return backOffPolicy;
	}

	public void setBackOffPolicy(BackOffPolicy backOffPolicy) {
		this.backOffPolicy = backOffPolicy;
	}

	public RetryListener[] getListeners() {
		return listeners;
	}

	public void setListeners(RetryListener[] listeners) {
		this.listeners = listeners;
	}

	public RetryContextCache getRetryContextCache() {
		return retryContextCache;
	}

	public void setRetryContextCache(RetryContextCache retryContextCache) {
		this.retryContextCache = retryContextCache;
	}

	public RetryPolicy getRetryPolicy() {
		return retryPolicy;
	}

	public void setRetryPolicy(RetryPolicy retryPolicy) {
		this.retryPolicy = retryPolicy;
	}

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public String getBackOff() {
		return backOff;
	}

	public void setBackOff(String backOff) {
		this.backOff = backOff;
	}
}
