package com.jing.springboot.datasource;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jingsir
 **
 * <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
    	<property name="dataSource" ref="dataSource-mysql" />
    	<property name="typeAliasesPackage" value="com.jing.edu.model" />
    	<property name="mapperLocations" value="classpath:com/jing/resources/mapper/*.xml" />
    </bean>
    
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
    	<!-- joggle代表接口 -->
    	<property name="basePackage" value="com.jing.edu.mapper.joggle" />
    </bean>
 */
@Configuration
@AutoConfigureAfter(MybatisConfig.class)
public class MapperScannerConfig {

	private final String daoBasePackage = "com.jing.springboot.mapper" ;
	@Bean
	public MapperScannerConfigurer createMapperScanner(){
		MapperScannerConfigurer configurer = new MapperScannerConfigurer() ;
		//注入sqlsessionFactory
		configurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
		//设置扫描的dao接口路径
		configurer.setBasePackage(daoBasePackage);
		
		return configurer ;
	}
}
