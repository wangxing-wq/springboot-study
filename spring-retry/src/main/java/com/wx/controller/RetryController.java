package com.wx.controller;


import com.wx.web.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author 22343
 * RetryOperations：通过传递RetryCallback，进行重试操作。
 * BackOff：补偿值，一般指失败后多久进行重试的延迟值。
 * Sleeper：暂停应用的工具，通常用来应用补偿值。
 * BackOffPolicy：补偿策略，决定失败后如何确定补偿值。
 * RetryContext：重试上下文，代表了能被重试动作使用的资源。
 * RetryPolicy：重试策略，决定失败能否重试。
 * RecoveryCallback：定义一个动作recover，在重试耗尽后的动作。
 * RetryCallback：具体的重试动作。
 * RetryState：重试状态，通常包含一个重试的键值。
 * RetryStatistics和RetryListener，用来监控Retry的执行情况，并生成统计信息。
 * 代理原理:
 * RetryOperationsInterceptor 这个拦截器,内含一个RetryOperations 实例,是RetryTemplate 类,默认调用这个
 * 类execute(retryCallback, recoveryCallback),使用的注解@Retryable的配置都会转为RetryOperationsInterceptor
 * 里面的配置, 注: RetryTemplate回自己做Listener 的拦截
 * RetryTemplate.execute(retryCallback, recoveryCallback) 回调用代理调用方法,如果通过就直接返回结果
 * 不通过回根据策略结果不断进行循环
 */
@Slf4j
@Component
public class RetryController {

	private int count = 0;

	/**
	 * 重试拦截器的Bean名称
	 * String interceptor() default ""; Class<? extends Throwable>[] value() default {};
	 * 处理的异常
	 * Class<? extends Throwable>[] include() default {};
	 * 不处理的异常
	 * Class<? extends Throwable>[] exclude() default {};
	 * String label() default "";
	 * 是否时有状态的
	 * boolean stateful() default false;
	 * 设置最大尝试次数
	 * int maxAttempts() default 3;
	 * 评估为最大尝试次数
	 * String maxAttemptsExpression() default "";
	 * 补偿策略,对任务失败后进行补偿的测
	 * Backoff backoff() default @Backoff;
	 * 异常处理表达式,可以做判断,1 根据错误信息抑制重试 2. 根据错误信息回调用其他方法
	 * String exceptionExpression() default "";
	 * 配置的监听器
	 * String[] listeners() default {};
	 */
	@Retryable(
			//interceptor = "wx",
			include = RuntimeException.class,
			maxAttempts = 5,
			stateful = false,
			exclude = NullPointerException.class
	)
	public Result retry() {
		log.info("do something... {},count -- {}", LocalDateTime.now(), count);
		if (count < 8) {
			count++;
			throw new RuntimeException("manual exception" + count);
		}
		log.info("success {},count -- {}", LocalDateTime.now(), count);
		return Result.success("retry", "OK");
	}


	@Recover
	public Result recover(RuntimeException e) {
		System.out.println("失败回调方法---------------------->" + e.getMessage());
		return Result.fail("error");
	}

	//@CircuitBreaker(openTimeout = 1000, resetTimeout = 3000, value = NullPointerException.class)
	//public void circuitBreaker(int num) {
	//	log.info(" 进入断路器方法num={}", num);
	//	if (num > 8) {
	//		return;
	//	}
	//	Integer n = null;
	//	System.err.println(1 / n);
	//}


}
