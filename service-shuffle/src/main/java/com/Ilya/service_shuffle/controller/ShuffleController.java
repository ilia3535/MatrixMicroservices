package com.Ilya.service_shuffle.controller;


import com.Ilya.service_shuffle.services.LogService;
import com.Ilya.service_shuffle.services.ShuffleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shuffle")
public class ShuffleController {

    private final ShuffleService shuffleService;
    private final LogService logService;

    @Autowired
    public ShuffleController(ShuffleService shuffleService, LogService logService) {
        this.shuffleService = shuffleService;
        this.logService = logService;
    }


    @PostMapping
    public List<Integer> shuffleNumbers(@RequestBody int number) {
        List<Integer> shuffledList = shuffleService.getShuffledArray(number);

        logService.logRequest(shuffledList);

        return shuffledList;
    }

}
