package com.jdd.esource_demo_project.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jdd.esource_demo_project.service.EsourceDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EsourceDemoController {

    private EsourceDemoService esourceDemoService;

    public EsourceDemoController(EsourceDemoService esourceDemoService) {
        this.esourceDemoService = esourceDemoService;
    }

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/one")
    public ResponseEntity<Number[]> userStoryOne() {
        ResponseEntity<Number[]> responseEntity;
        try {
            responseEntity = new ResponseEntity<>(esourceDemoService.availableNumbers(), HttpStatus.OK);
        } catch (Exception exception) {
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    // TODO: figure out why @RequestParam doesn't automatically bind Number[]
    @GetMapping("/two")
    public ResponseEntity<Number[]> userStoryTwo(@RequestParam String availableNumbers) {
        Number[] numbers;
        ResponseEntity<Number[]> responseEntity;

        try {
            numbers = objectMapper.readValue(availableNumbers, Number[].class);
        } catch (Exception exception) {
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            return responseEntity;
        }

        try {
            responseEntity = new ResponseEntity<>(esourceDemoService.largestPrimeNumber(numbers), HttpStatus.OK);
        } catch (Exception exception) {
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
