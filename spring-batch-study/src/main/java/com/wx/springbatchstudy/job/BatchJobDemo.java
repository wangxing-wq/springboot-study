package com.wx.springbatchstudy.job;

import com.wx.model.Person;
import com.wx.springbatchstudy.domain.GenItemProcessor;
import com.wx.springbatchstudy.domain.GenTable;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobInterruptedException;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.MultiResourceItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.builder.MultiResourceItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.annotation.Resource;
import java.util.List;

/**
 * @version 1.0
 * @author 王兴
 * @date 2022/9/10 1:43
 * @message
 */

public class BatchJobDemo {

	@Resource
	JobBuilderFactory jobBuilderFactory;

	@Resource
	StepBuilderFactory stepBuilderFactory;

	@Resource
	JobRepository jobRepository;


	/**
	 * 定义文件的处理
	 * @return
	 */
	@Bean
	public MultiResourceItemReader<GenTable> multiResourceItemReader(){
		//MultiResourceItemReader multiResourceItemReader = new MultiResourceItemReader();
		//multiResourceItemReader.setResources(new ClassPathResource[]{new ClassPathResource("sample-data.csv"),new ClassPathResource("student.csv")});
		//multiResourceItemReader.setComparator();
		//multiResourceItemReader.setDelegate();
		//multiResourceItemReader.setSaveState();
		//multiResourceItemReader.setStrict();
		return new MultiResourceItemReaderBuilder<GenTable>()
				.name("multiResourceItemReader")
				.resources(new ClassPathResource[]{new ClassPathResource("sample-data.csv"),new ClassPathResource("student.csv")})
				.delegate(new FlatFileItemReaderBuilder<GenTable>()
						.name("personItemReader")
						.delimited()
						.names("firstName", "lastName")
						.fieldSetMapper(new BeanWrapperFieldSetMapper<GenTable>() {{
							setTargetType(GenTable.class);
						}})
						.build())
				.build();
	}

	@Bean
	public MultiResourceItemWriter multiResourceItemWriter(){
		return new MultiResourceItemWriter();
	}



	@Bean
	public Step batchStep(){
		return stepBuilderFactory.get("batchStep")
				.<GenTable, GenTable>chunk(10)
				.reader(multiResourceItemReader())
				.processor(new GenItemProcessor())
				.writer(new ItemWriter<GenTable>() {
					@Override
					public void write(List<? extends GenTable> items) throws Exception {
						System.out.println("===");
					}
				})
				.build();
	}

	@Bean
	public Job batchJob(){
		return jobBuilderFactory.get("batchJob").start(batchStep()).build();
	}

}

