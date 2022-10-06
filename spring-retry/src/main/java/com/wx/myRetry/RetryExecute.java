package com.wx.myRetry;

/**
 * @author 22343
 * @version 1.0
 */
public interface RetryExecute {
	
	
	<T,E extends Throwable> T execute(RetryContext<T,E> retryCallback,RetryCallBack<T,E> recoveryCallback) throws E;
	
}
