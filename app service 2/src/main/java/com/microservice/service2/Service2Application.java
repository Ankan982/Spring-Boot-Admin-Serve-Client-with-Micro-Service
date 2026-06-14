package com.microservice.service2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Service2Application {

	private static final Logger logHandle = LoggerFactory.getLogger(Service2Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Service2Application.class, args);
		logHandle.info("App Service 2 is up!!");
	}
}
