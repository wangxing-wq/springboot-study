package com.wx.myRetry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.ExhaustedRetryException;

import java.util.Random;

/**
 * @author 22343
 * @version 1.0
 */
@Slf4j
public class MyRetryTemplate implements RetryExecute {
	
	private final int condition;
	
	public MyRetryTemplate(int condition) {
		this.condition = condition;
	}
	
	public static void main(String[] args) throws Throwable {
		MyRetryTemplate myRetryTemplate = new MyRetryTemplate(2);
		String result = myRetryTemplate.execute(() -> {
			System.out.println("retry execute");
			return "context";
		},(RetryCallBack<String,Throwable>) () -> {
			System.out.println("-------->回调方法");
			return "back";
		});
		System.out.println(result);
	}
	
	@Override
	public <T,E extends Throwable> T execute(RetryContext<T,E> context,RetryCallBack<T,E> callBack) throws E, ExhaustedRetryException {
		// 调用,回调
		// 计算测率
		T result = null;
		int i = new Random().nextInt(condition + 3) + condition >> 1;
		log.info("random: [{}],condition: [{}],result: [{}]",i,condition,i > condition);
		while (i < condition) {
			// 循环调用策略
			// 调用这个重试的方法,
			try {
				result = context.doWithRetry();
			} catch (Throwable e) {
				// 添加异常到上下文对象
				throw new RuntimeException(e);
			}
			i++;
		}
		// 进行兜底,如果有兜底方法就调用,要求参数列表和返回值列表与retry 一致
		if (result == null && callBack != null) {
			result = callBack.callBack();
		}
		return result;
	}
	
}
