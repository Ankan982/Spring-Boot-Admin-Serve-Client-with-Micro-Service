package com.microservice.service2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app-service2")
public class AppServiceController {

	private static final Logger logHandle = LoggerFactory.getLogger(AppServiceController.class);

	@GetMapping("/getApp")
	public ResponseEntity<String> getService() {
		logHandle.info("Inside the method of getService of App Service 2.");

		return ResponseEntity.ok("Response coming from App Service 2");
	}

}
