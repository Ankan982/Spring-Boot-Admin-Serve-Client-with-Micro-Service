package com.microservice.service1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.service1.service.ApiLoadTestService;

@RestController
@RequestMapping("/app-service1")
public class AppServiceController {

	private static final Logger logHandle = LoggerFactory.getLogger(AppServiceController.class);
	
	private final ApiLoadTestService loadTestService;

    public AppServiceController(ApiLoadTestService loadTestService) {
        this.loadTestService = loadTestService;
    }

	@GetMapping("/getApp")
	public ResponseEntity<String> getService() {
		logHandle.info("Inside the method of getService of App Service 1.");

		return ResponseEntity.ok("Response coming from App Service 1");
	}
	
	// Trigger endpoint: e.g., localhost:8080/start-test?threads=5&calls=10
    @GetMapping("/start-test")
    public String startTest(
            @RequestParam(defaultValue = "3") int threads,
            @RequestParam(defaultValue = "5") int calls) {
        
        // This runs asynchronously in the background worker threads
        loadTestService.runMultiThreadedTest(threads, calls);
        
        return String.format("Load test triggered with %d threads, each making %d calls with a 1s delay.", threads, calls);
    }

}
