package com.amdocs.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@EnableTransactionManagement // enables HibTx (@Transactional)
@EnableWebMvc	// Spring Mvc Activated
// Load all Properties into Spring Container
@PropertySource("classpath:application.properties")
//	All Layered Classes Common Packages
@ComponentScan("com.amdocs")
public class AppConfig {

	@Autowired
	private Environment env;

	/**
	 * DATABASE SETUP
	 */

	// 1. Datasource using its IMPLEMENTATION Class setting the PROPERTIES
	@Bean
	public DataSource ds()
	{
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName(env.getProperty("db.driver"));
		bds.setUrl(env.getProperty("db.url"));
		bds.setUsername(env.getProperty("db.user"));
		bds.setPassword(env.getProperty("db.pwd"));
		return bds;
	}

	// Create HibernateProperties
	@Bean
	public Properties props()
	{
		Properties p = new Properties();
		p.put("hibernate.dialect" ,env.getProperty("orm.dialect"));
		p.put("hibernate.show_sql", env.getProperty("orm.showsql"));
		p.put("hibernate.format_sql", env.getProperty("orm.fmtsql"));
		p.put("hibernate.hbm2ddl.auto", env.getProperty("orm.ddlauto"));
		return p;
	}

	// 2. LocSessFactBean Setting Datasource, HibernateProperities & PACKAGE of MODEL Classes
	@Bean
	public LocalSessionFactoryBean sfb()
	{
		LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
		sf.setDataSource(ds());
		sf.setHibernateProperties(props());
//		sf.setAnnotatedClasses(ShipmentType.class, Uom.class);
		sf.setPackagesToScan("com.amdocs.model");
		return sf;
	}

	// 3 HibernateTemplate setting SessionFactory
	@Bean
	public HibernateTemplate ht()
	{
		HibernateTemplate h = new HibernateTemplate();
		h.setSessionFactory( sfb().getObject());
		return h;
	}

	// 4. HibernateTXManager setting SessionFactory
	@Bean
	public HibernateTransactionManager htm()
	{
		HibernateTransactionManager htx = new HibernateTransactionManager();
		htx.setSessionFactory(sfb().getObject());
		return htx;
	}

	/**
	 * MVC SETUP
	 */
	// 5 . InternalResourceViewResolver setting PREFIX and SUFFIX
	@Bean
	public InternalResourceViewResolver ivr()
	{
		InternalResourceViewResolver view = new InternalResourceViewResolver();
		view.setPrefix(env.getProperty("mvc.prefix"));
		view.setSuffix(env.getProperty("mvc.suffix"));
		return view;
	}
}
