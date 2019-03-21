package com.demo.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.demo.spring.dao.EmpDaoJPAImpl;

@Configuration
@ComponentScan(basePackages="com.demo.spring")
@EnableAspectJAutoProxy
public class AppConfig {

	@Bean
	public EmpDaoJPAImpl jpaBean() {
		return new EmpDaoJPAImpl();
	}
}
