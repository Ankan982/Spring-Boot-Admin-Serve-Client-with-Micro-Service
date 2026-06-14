package com.microservice.service1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Service1Application {
	
	private static final Logger logHandle = LoggerFactory.getLogger(Service1Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Service1Application.class, args);
		logHandle.info("App Service 1 is up!!");
	}

}
