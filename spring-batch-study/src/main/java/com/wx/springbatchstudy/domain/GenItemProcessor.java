package com.wx.springbatchstudy.domain;

import org.springframework.batch.item.ItemProcessor;

/**
 * @version 1.0
 * @author 王兴
 * @date 2022/9/10 18:28
 * @message
 */
public class GenItemProcessor implements ItemProcessor<GenTable, GenTable> {

	@Override
	public GenTable process(GenTable item) throws Exception {
		System.out.println(item);
		return null;
	}
}
