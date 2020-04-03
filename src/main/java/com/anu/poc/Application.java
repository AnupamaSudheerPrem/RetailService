package com.anu.poc;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.anu.poc.exception.RestTemplateErrorHandler;

@SpringBootApplication
public class Application {

	
	static Logger LOGGER = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		LOGGER.info("Starting the application");
    }
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
	   return builder.errorHandler(new RestTemplateErrorHandler()).build();
	}

}
