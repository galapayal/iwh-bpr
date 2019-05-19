package com.iwh.bpr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.iwh.bpr.dao.AuthenticationDao;
import com.iwh.bpr.dao.CompetitorDao;
import com.iwh.bpr.dao.CompetitorDaoImpl;
import com.iwh.bpr.dao.FinancialDao;
import com.iwh.bpr.dao.FinancialDaoImpl;
import com.iwh.bpr.service.AuthenticationService;
import com.iwh.bpr.service.AuthenticationServiceImpl;
import com.iwh.bpr.service.CompetitorService;
import com.iwh.bpr.service.CompetitorServiceImpl;
import com.iwh.bpr.service.FinancialService;
import com.iwh.bpr.service.FinancialServiceImpl;

@Configuration
@ComponentScan(basePackages = { "com.iwh.bpr.config", "com.iwh.bpr.controller" })
@EnableWebMvc
@ImportResource("classpath:/applicationContext.xml")
public class MvcConfiguration extends WebMvcConfigurerAdapter {
	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean
	public AuthenticationDao getAuthenticationDao() {
		return new AuthenticationDao();
	}
	
	@Bean
	public FinancialDao getFinancialDao() {
		return new FinancialDaoImpl();
	}
	
	@Bean
	public CompetitorDao getCompetitorDao() {
		return new CompetitorDaoImpl();
	}

	@Bean
	public FinancialService getFinancialService() {
		FinancialServiceImpl financialServiceImpl = new FinancialServiceImpl();
		financialServiceImpl.setFinancialDao(getFinancialDao());;
		return financialServiceImpl;
	}
	@Bean
	public AuthenticationService getAuthenticationService() {
		AuthenticationServiceImpl authenticationServiceImpl = new AuthenticationServiceImpl();
		authenticationServiceImpl.setAuthenticationdao(getAuthenticationDao());
		return authenticationServiceImpl;
	}
	
	@Bean
	public CompetitorService getCompetitorService() {
		CompetitorServiceImpl competitorServiceImpl = new CompetitorServiceImpl();
		competitorServiceImpl.setCompetitorDao(getCompetitorDao());
		return competitorServiceImpl;
	}
}
