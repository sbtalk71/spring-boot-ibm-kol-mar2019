package com.demo.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

//@Configuration
public class JpaConfig {
	/*
	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springdb?useSSL=false");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}

	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean lcb = new LocalContainerEntityManagerFactoryBean();
		lcb.setDataSource(dataSource());
		lcb.setPackagesToScan("com.demo.spring.entity");

		HibernateJpaVendorAdapter va = new HibernateJpaVendorAdapter();
		va.setDatabase(Database.MYSQL);
		va.setShowSql(true);

		lcb.setJpaVendorAdapter(va);
		return lcb;
	}
	
	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager txm= new JpaTransactionManager();
		txm.setEntityManagerFactory(entityManagerFactory().getObject());
		return txm;
	}
	*/
}
