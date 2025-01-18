package com.Ilya.service_shuffle.services;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ShuffleService {


    public List<Integer> getShuffledArray(int number) {
        if (number < 1 || number > 1000) {
            throw new IllegalArgumentException("Number must be between 1 and 1000");
        }

        List<Integer> array = IntStream.rangeClosed(1, number)
                .boxed()
                .collect(Collectors.toList());
        Random random = new Random();

        for (int i = array.size() - 1; i > 0; i--) {
            int n = random.nextInt(i + 1);

            Collections.swap(array, i, n);
        }
        return array;
    }
}
