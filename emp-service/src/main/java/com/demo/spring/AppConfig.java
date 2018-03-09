package com.demo.spring;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "com.demo.spring")
@EnableTransactionManagement
@PropertySource(value="datasource.properties")
public class AppConfig {
	
/*	@Bean
	public DriverManagerDataSource ds(){
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/springdb");
        ds.setUsername("root");
        ds.setPassword("password");
        return ds;
	}*/
    
	@Bean
	@ConfigurationProperties("app.datasource")
	public DataSource dataSource(){
		return DataSourceBuilder.create().build(); 
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
		LocalContainerEntityManagerFactoryBean emfb= new LocalContainerEntityManagerFactoryBean();
				emfb.setDataSource(dataSource());
	    HibernateJpaVendorAdapter hba = new HibernateJpaVendorAdapter();
	    hba.setDatabase(Database.MYSQL);
	    hba.setShowSql(true);
	    emfb.setJpaVendorAdapter(hba);
	    emfb.setPackagesToScan("com.demo.spring");
	    return emfb;
	}
	
	@Bean
	public JpaTransactionManager transactionManager(){
		JpaTransactionManager txm = new JpaTransactionManager();
		txm.setEntityManagerFactory(entityManagerFactory().getObject());
		return txm;
	}
	
	
}
