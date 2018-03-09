package com.demo.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "com.demo.spring")
@EnableTransactionManagement
public class AppConfig {
	
	@Bean
	public DriverManagerDataSource ds(){
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/springdb");
        ds.setUsername("root");
        ds.setPassword("password");
        return ds;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerfactory(){
		LocalContainerEntityManagerFactoryBean emfb= new LocalContainerEntityManagerFactoryBean();
				emfb.setDataSource(ds());
	    HibernateJpaVendorAdapter hba = new HibernateJpaVendorAdapter();
	    hba.setDatabase(Database.MYSQL);
	    hba.setShowSql(true);
	    emfb.setJpaVendorAdapter(hba);
	    emfb.setPackagesToScan("com.demo.spring.dao");
	    return emfb;
	}
	
	@Bean
	public JpaTransactionManager transactionManager(){
		JpaTransactionManager txm = new JpaTransactionManager();
		txm.setEntityManagerFactory(entityManagerfactory().getObject());
		return txm;
	}
	
	
}
