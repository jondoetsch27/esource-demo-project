package com.jdd.esource_demo_project.service;

import org.springframework.stereotype.Service;

@Service
public class EsourceDemoService {
    public Number[] availableNumbers() {
        return new Number[]{0, 1, 2};
    }
    public Number[] largestPrimeNumber(Number[] available) {
        return new Number[]{1};
    }
}
