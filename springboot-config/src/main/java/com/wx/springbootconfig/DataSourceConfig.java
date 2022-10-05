package com.wx.springbootconfig;

import com.wx.springbootconfig.config.DefaultUserServiceImpl;
import com.wx.springbootconfig.config.UserService;
import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author 22343
 */
@Component
@ConfigurationProperties(prefix = "my.datasource")
@Data
public class DataSourceConfig{

	private String driver;

	private String username;

	private String password;

	private int active;

	private int max;

	private int min;

	private int core;

}
