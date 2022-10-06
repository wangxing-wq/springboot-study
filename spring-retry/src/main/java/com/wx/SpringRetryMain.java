package com.wx;

import com.google.gson.Gson;
import com.wx.controller.RetryController;
import com.wx.web.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

/**
 * @author 22343
 * SpringRetry 总结
 * 核心的调用类是RetryOperations {@link org.springframework.retry.RetryOperations} 这个类提供了
 * 操作重试的接口核心参数有一下几个
 * RetryCallback<T, E> retryCallback 重试回调
 * RecoveryCallback<T> recoveryCallback 恢复方法
 * RetryState retryState 标志可重试
 * 后边可以根据SpringRetry 模仿写一个重试框架
 */
@Slf4j
@EnableRetry(proxyTargetClass=false)
@SpringBootApplication
public class SpringRetryMain implements CommandLineRunner {
	
	final
	RetryController retryController;
	
	public SpringRetryMain(RetryController retryController) {
		this.retryController = retryController;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringRetryMain.class,args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Result retry = null;
		Gson gson = new Gson();
		// 处理接口, 回调方式
		// function(fun,callback(e){
		// 处理回调
		// });
		try {
			// Windows Compatible,重试两次测试stataFul
			retry = retryController.retry();
		} catch (Exception e) {
			retry = Result.fail("message","test retry failed");
			log.error("error retrying {}",e.getMessage());
		}
		System.out.println(gson.toJson(retry,Result.class));
	}
	
}
