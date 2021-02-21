package com.solitardj9.msa.serviceInterface.common;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {
	
	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
		//
		registry.addRedirectViewController("/application-socail-service/v2/api-docs", "/v2/api-docs");
		
		registry.addRedirectViewController("/swagger-resources/configuration/ui", "/swagger-resources/configuration/ui");
		
		registry.addRedirectViewController("/swagger-resources/configuration/security", "/swagger-resources/configuration/security");
		
		registry.addRedirectViewController("/swagger-resources", "/swagger-resources");
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//
		registry.addResourceHandler("/swagger-ui.html**")
		.addResourceLocations("classpath:/META-INF/resources/swagger-ui.html");
		
		registry.addResourceHandler("/webjars/**")
		.addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		//
		registry.addMapping("/**")
		.allowedMethods("*")
		.allowedOrigins("*");
	}
	
	@Bean
	public Docket api() {
		Set<String> schemes = new HashSet<>();
		schemes.add("http");
		schemes.add("https");
		
		return new Docket(DocumentationType.SWAGGER_2)
				.protocols(schemes)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.ant("/**"))
				.build();
	}
}