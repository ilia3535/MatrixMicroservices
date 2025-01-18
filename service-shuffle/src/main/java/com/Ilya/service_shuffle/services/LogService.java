package com.Ilya.service_shuffle.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LogService {

    @Value("${log.service.url}")
    private String logServiceUrl;

    private final RestTemplate restTemplate;

    @Autowired
    public LogService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Async
    public void logRequest(Object request) {
        restTemplate.postForObject(logServiceUrl, request, String.class);
    }
}
