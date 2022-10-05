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
			retry = retryController.retry();
		} catch (Exception e) {
			retry = Result.fail("message","test retry failed");
			log.error("error retrying {}",e.getMessage());
		}
		System.out.println(gson.toJson(retry,Result.class));
	}
	
}
