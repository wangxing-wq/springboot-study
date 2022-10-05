package com.wx.springbootcommon.createBean;

import ch.qos.logback.core.filter.Filter;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @version 1.0
 * @author 王兴
 * @date 2022/9/23 1:32
 * @message
 */
public class BeanScannFilter implements TypeFilter {
	@Override
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
		return false;
	}
}
