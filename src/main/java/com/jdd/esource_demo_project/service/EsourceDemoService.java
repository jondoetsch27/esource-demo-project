package com.jdd.esource_demo_project.service;

import java.util.Arrays;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class EsourceDemoService {

    private final Integer getMin;
    private final Integer getMax;
    public EsourceDemoService(@Qualifier("getMin") Integer getMin, @Qualifier("getMax") Integer getMax) {
        this.getMin = getMin;
        this.getMax = getMax;
    }

    public Integer[] availableNumbers(Integer[][] randomNumbers) {
        ArrayList<Integer> availableNumbers = new ArrayList<>();
        for (int k = getMin; k <= getMax; k++) {
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
