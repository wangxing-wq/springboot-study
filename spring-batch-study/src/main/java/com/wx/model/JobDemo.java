package com.wx.model;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@EnableBatchProcessing
public class JobDemo {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    //创建任务对象
    @Bean
    public Job jobDemoJob(){
        return jobBuilderFactory.get("jobDemoJob")
                //.start(step1())
                //next()指定下一个step,默认先执行step1再执行step2依次
                //.next(step2())
                //.next(step3())
                .start(step1())
                //on("COMPLETED"<结束step1>)用来指定一个条件
                .on("COMPLETED")
                //to(到达step2())
                .to(step2())
                //成功执行step2满足才会结束
                .from(step2()).on("COMPLETED").to(step3())
                //fail()表示step2执行失败step3是不能执行的
                /*.from(step2()).on("COMPLETED").fail()*/
                //stopAndRestart停止并重新启动 一般用于测试
                /*.from(step2()).on("COMPLETED").stopAndRestart(step2())*/
                //步骤执行完end（）
                .from(step3()).end()
                .build();

    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                //step具体实现功能
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                        //执行step1功能
                        System.out.println("step1");
                        return RepeatStatus.FINISHED;
                    }
                    //正常结束才会执行下一个
                }).build();
    }

    @Bean
    public Step step2() {
        return stepBuilderFactory.get("step2")
                //step具体实现功能
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                        //执行step1功能
                        System.out.println("step2");
                        return RepeatStatus.FINISHED;
                    }
                    //正常结束才会执行下一个
                }).build();
    }

    @Bean
    public Step step3() {
        return stepBuilderFactory.get("step3")
                //step具体实现功能
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                        //执行step1功能
                        System.out.println("step3");
                        return RepeatStatus.FINISHED;
                    }
                    //正常结束才会执行
                }).build();
    }
}

