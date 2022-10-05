package com.wx.springbatchstudy;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

/**
 * @author wx
 * @version 1.0
 * Spring Batch作为Spring的子项目，是一款轻量级的综合批处理框架，通过它可以构建出壮健的企业级批处理应用，
 * 因为基于Spring，所以开发者十分容易上手使用。SpringBatch不仅提供了统一的读写接口、丰富的任务处理方式、
 * 可重用的功能，还包括了日志，事务管理，任务统计、弹性处理等功能。使开发人员可以更多的关注业务处理过程。
 * 功能:
 * 支持对多种数据源进行操作
 * 能够定义不同job之间的顺序关系
 * 能够定义每个job的输入和输出数据操作
 * 对异常输入数据有校验机制和弹性处理
 * 支持job重跑等处理机制
 */
@EnableBatchProcessing
@SpringBootApplication
public class SpringBatchStudyApplication implements CommandLineRunner {



	public static void main(String[] args) {
		SpringApplication.run(SpringBatchStudyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
