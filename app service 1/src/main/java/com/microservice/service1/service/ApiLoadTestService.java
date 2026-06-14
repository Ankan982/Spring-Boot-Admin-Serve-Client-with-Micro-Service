package com.microservice.service1.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class ApiLoadTestService {

    private static final Logger logger = LoggerFactory.getLogger(ApiLoadTestService.class);
    private final RestTemplate restTemplate;

    public ApiLoadTestService() {
        // Initialize the standard RestTemplate
        this.restTemplate = new RestTemplate();
    }

    public void runMultiThreadedTest(int threadCount, int callsPerThread) {
        // Target API Endpoint
        String targetUrl = "http://localhost:5030/app-service2/getApp";
        
        // Create a fixed thread pool to manage concurrent execution
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);

        logger.info("Starting load test with {} threads hitting {}...", threadCount, targetUrl);

        for (int i = 0; i < threadCount; i++) {
            final int threadId = i + 1;
            
            executor.submit(() -> {
                for (int j = 0; j < callsPerThread; j++) {
                    try {
                        logger.info("[Thread-{}] Making API call {}/{}", threadId, (j + 1), callsPerThread);
                        
                        // RestTemplate blocks the thread until it receives a response
                        String response = restTemplate.getForObject(targetUrl, String.class);

                        logger.debug("[Thread-{}] Response received: {}", threadId, response);

                    } catch (Exception e) {
                        logger.error("[Thread-{}] API call failed: {}", threadId, e.getMessage());
                    }

                    // 1-second delay after each call
                    try {
                        Thread.sleep(1000); 
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        logger.warn("[Thread-{}] Thread was interrupted", threadId);
                        break;
                    }
                }
                logger.info("[Thread-{}] Completed all assigned tasks.", threadId);
            });
        }

        // Initiates an orderly shutdown where previously submitted tasks are executed
        executor.shutdown();
    }
}