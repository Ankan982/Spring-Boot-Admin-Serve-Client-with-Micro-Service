package com.admin.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
public class ServerApplication {
	
	private static final Logger logHandle = LoggerFactory.getLogger(ServerApplication.class);

	public static void main(String[] args) {
		logHandle.info("Admin Serve is up!!");

		SpringApplication.run(ServerApplication.class, args);
	}

}
