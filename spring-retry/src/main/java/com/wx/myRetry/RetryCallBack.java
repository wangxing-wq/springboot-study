package com.wx.myRetry;

/**
 * @author 22343
 * @version 1.0
 */
public interface RetryCallBack<T,E extends Throwable> {
	
	/**
	 * 执行具有重试语义的操作。操作通常应该是幂等的,
	 * 但实现可以选择在重试操作时实现补偿语义
	 * @return T
	 * @throws E of type E if processing fails
	 */
	T callBack() throws E;
}
