package com.jdd.esource_demo_project.service;

import com.jdd.esource_demo_project.EsourceDemoProjectTestConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import({EsourceDemoProjectTestConfiguration.class})
public class EsourceDemoServiceTests {

    private EsourceDemoService subject;

    @Autowired
    private Integer getMin;

    @Autowired
    private Integer getMax;

    @BeforeEach
    public void setUp() {
        subject = new EsourceDemoService(getMin, getMax);
    }

    @Test
    public void availableNumbersTest() {
        Integer[][] randomNumberMock = new Integer[][]{
            {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29},
            {31, 33, 35, 37, 39, 41, 43, 45, 47, 49, 0, 2, 4, 6, 8},
            {10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38}
        };
        Integer[] expectedResult = new Integer[]{40, 42, 44, 46, 48, 50};
        Integer[] actualResult = subject.availableNumbers(randomNumberMock);
        Assertions.assertArrayEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @CsvSource({"2,3,5,7,11", "13,17,19,23,29", "31,37,41,43,47"})
    public void largestPrimeNumberTest(String num1, String num2, String num3, String num4, String num5) {
        Integer[] availableNumbers = new Integer[]{
            Integer.valueOf(num1),
            Integer.valueOf(num2),
            Integer.valueOf(num3),
            Integer.valueOf(num4),
            Integer.valueOf(num5)
        };
        Integer expectedResult = Integer.valueOf(num5);
        Integer actualResult = subject.largestPrimeNumber(availableNumbers);
        Assertions.assertEquals(expectedResult, actualResult);
    }
}
