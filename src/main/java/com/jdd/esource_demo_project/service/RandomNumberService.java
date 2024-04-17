package com.jdd.esource_demo_project.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomNumberService {
    private static final int MIN = 0;
    private static final int MAX = 50;

    public Integer[][] generateRandomNumbers() {
        Integer[][] numbers = new Integer[3][15];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                numbers[i][j] = new Random().nextInt(MIN, MAX);
            }
        }
        return numbers;
    }}
