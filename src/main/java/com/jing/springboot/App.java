package com.jing.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Hello world!
 *
 * @SpringBootApplication=@Configuration+@ComponentScan+@EnableAutoConfiguration
 * 
 * @Configuration≈<beans></beans>即相当于spring的<beans></beans>
 * 
 * @ComponentScan default=<context:component-scan base-package="com.jing.springboot"/>即默认扫描当前包及子包
 * 
 * @EnableAutoConfiguration Springboot根据项目导入的jar依赖推测项目如何部署Spring并采用相应的策略来配合配置
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		SpringApplication.run(App.class, args);
	}

}
