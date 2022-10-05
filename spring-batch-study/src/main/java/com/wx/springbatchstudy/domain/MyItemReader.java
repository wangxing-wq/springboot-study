package com.wx.springbatchstudy.domain;

import org.springframework.batch.item.file.ResourceAwareItemReaderItemStream;
import org.springframework.batch.item.support.AbstractItemCountingItemStreamItemReader;
import org.springframework.core.io.Resource;

/**
 * @version 1.0
 * @author 王兴
 * @date 2022/9/11 6:09
 * @message
 */
public class MyItemReader<T> extends AbstractItemCountingItemStreamItemReader<T> implements
		ResourceAwareItemReaderItemStream<T> {
	@Override
	public void setResource(Resource resource) {
		System.out.println("Resource");
	}

	@Override
	protected T doRead() throws Exception {
		System.out.println("doRead");
		return null;
	}

	@Override
	protected void doOpen() throws Exception {
		System.out.println("doOpen");
	}

	@Override
	protected void doClose() throws Exception {
		System.out.println("doClose");
	}
}
