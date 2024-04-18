package com.jdd.esource_demo_project.service;

import java.util.Random;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class RandomNumberService {

    private final Integer getMin;
    private final Integer getMax;
    public RandomNumberService(@Qualifier("getMin") Integer getMin, @Qualifier("getMax") Integer getMax) {
        this.getMin = getMin;
        this.getMax = getMax;
    }

    public Integer[][] generateRandomNumbers() {
        Integer[][] numbers = new Integer[3][15];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                numbers[i][j] = new Random().nextInt(getMin, getMax);
            }
        }
        return numbers;
    }}
