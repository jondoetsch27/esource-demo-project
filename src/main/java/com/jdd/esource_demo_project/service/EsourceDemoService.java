package com.jdd.esource_demo_project.service;

import java.util.Arrays;
import java.util.ArrayList;
import org.springframework.stereotype.Service;


@Service
public class EsourceDemoService {
    private static final int MIN = 0;
    private static final int MAX = 50;

    private final RandomNumberService randomNumberService;
    public EsourceDemoService(RandomNumberService randomNumberService) {
        this.randomNumberService = randomNumberService;
    }

    public Integer[] availableNumbers() {
        Integer[][] randomNumbers = randomNumberService.generateRandomNumbers();

        ArrayList<Integer> availableNumbers = new ArrayList<>();
        for (int k = MIN; k <= MAX; k++) {
            if (!Arrays.asList(randomNumbers[0]).contains(k)
                && !Arrays.asList(randomNumbers[1]).contains(k)
                && !Arrays.asList(randomNumbers[2]).contains(k)
            ) {
                availableNumbers.add(k);
            }
        }

        return availableNumbers.toArray(Integer[]::new);
    }

    public Integer largestPrimeNumber(Integer[] availableNumbers) {
        Integer largest = null;

        for (Integer number : availableNumbers) {
            if (!isPrime(number)) {
                continue;
            } else if (isPrime(number) && largest == null) {
                largest = number;
            } else if (isPrime(number) && largest != null && number <= largest) {
                continue;
            } else if (isPrime(number) && largest != null && number > largest) {
                largest = number;
            }
        }

        return largest;
    }

    private boolean isPrime(Integer number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i < number; ++i) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
