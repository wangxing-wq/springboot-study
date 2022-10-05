package com.wx.springbatchstudy.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @version 1.0
 * @author 王兴
 * @date 2022/9/11 7:22
 * @message
 */
@Configuration
@EnableBatchProcessing
public class BatchTable {

	@Resource
	JobBuilderFactory jobBuilderFactory;

	@Resource
	StepBuilderFactory stepBuilderFactory;

	@Resource
	JobRepository jobRepository;

	@Bean
	public Step step(){
		return stepBuilderFactory.get("step").tasklet(new Tasklet() {
			@Override
			public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
				System.out.println("处理批量作业开始===>");
				invokeMethod(contribution);
				// 读取给定批量文件位置

				System.out.println(contribution);
				System.out.println("处理批量作业结束===>");
				return RepeatStatus.FINISHED;
			}
		}).build();
	}

	@Bean
	public Job job(){
		return jobBuilderFactory.get("job").start(step()).build();
	}


	private static void invokeMethod(Object obj){
		Class<?> aClass = obj.getClass();
		Method[] methods = aClass.getMethods();
		for (Method method : methods) {
			if (method.getName().contains("get")) {
				method.setAccessible(true);
				try {
					Object invoke = method.invoke(obj);
					System.out.println("invoke method " + method.getName() + ": " + invoke);
				} catch (IllegalAccessException | InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
	}


}
