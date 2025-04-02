package com.curso.cfg;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {

		registry.addMapping("/**")
			.allowedOrigins("*")
			.allowedMethods("GET", "OPTIONS", "HEAD", "POST", "PUT", "DELETE")
			.allowedHeaders("*")
			.exposedHeaders("Origin", "X-Requested-With", "Content-Type", "Accept");

		// Add more mappings...
	}
}