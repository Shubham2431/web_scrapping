package com.varaisys.intranet.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author Kartik Khurana
 * @CreationDate - 13-10-2022
 * @ModifyDate - 13-10-2022
 * @Desc Class for configuration hibernate
 */

@Configuration
@EnableTransactionManagement()
@ComponentScan({ "com.varaisys.intranet.configuration" })
@PropertySource(value = "classpath:application.properties")
public class HibernateConfiguration {

	@Autowired
	private Environment environment;

	@Bean("mysql")
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] { "com.varaisys.intranet.model" });
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
		dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
		dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
		dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
		return dataSource;
	}

	private Properties hibernateProperties() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
		hibernateProperties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.dialect.show_sql"));
		hibernateProperties.put("hibernate.format_sql",
				environment.getRequiredProperty("hibernate.dialect.format_sql"));
		return hibernateProperties;
	}

	@Bean(name = "mydb")
	@Autowired
	public HibernateTransactionManager hibernateTransactionManager(@Qualifier("mysql") SessionFactory s) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(s);
		return transactionManager;
	}

}