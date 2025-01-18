package com.Ilya.service_log.controller;

import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LogRequestController {

    @Async
    @PostMapping("/log")
    public void logRequest(@RequestBody Object request) {
        System.out.println("Request: " + request);
    }
}
