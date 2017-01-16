package com.jing.springboot.datasource;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author jingsir
 **
 *         外部datasource加载
 */
@Configuration
@PropertySource("classpath:config/jdbc.properties")
public class CustomDatasource {

	@Value("${jdbc.driverClassName}")
	private String driverClassName;

	@Value("${jdbc.url}")
	private String url;

	@Value("${jdbc.username}")
	private String username;

	@Value("${jdbc.password}")
	private String password;

	@Bean
	public DataSource dataSource() {
		return new DataSourceBuilder(null).driverClassName(driverClassName).url(url).username(username)
				.password(password).build();
	}
}
