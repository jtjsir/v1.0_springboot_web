package com.jing.springboot.datasource;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

/**
 * @author jingsir
 **
 *         创建mybatis bean
 *         
 *  <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
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
@EnableTransactionManagement
public class MybatisConfig implements TransactionManagementConfigurer {

	//可采用spring.datasource属性配置数据源，这里采用外部加载
	@Resource
	public DataSource dataSource;

	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactory createSqlSessionFac() {
		SqlSessionFactory sessionFactory = null;

		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		// 设置model扫描包路径
//		factoryBean.setTypeAliasesPackage("");
		// 注入数据源
		factoryBean.setDataSource(dataSource);
		// 设置mapper xml扫描路径
//		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		try {
//			factoryBean.setMapperLocations(resolver.getResources(""));
			sessionFactory = factoryBean.getObject();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return sessionFactory;
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
