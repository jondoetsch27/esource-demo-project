package com.jdd.esource_demo_project.service;

import org.springframework.stereotype.Service;

@Service
public class EsourceDemoService {
    public Integer[] availableNumbers() {
        return new Integer[]{0, 1, 2};
    }
    public Integer[] largestPrimeNumber(Integer[] available) {
        return new Integer[]{1};
    }
}
