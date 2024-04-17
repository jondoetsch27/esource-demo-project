package com.jdd.esource_demo_project.controller;

import com.jdd.esource_demo_project.service.EsourceDemoService;
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

    @GetMapping("/two")
    public ResponseEntity<Number[]> userStoryTwo(@RequestParam Number[] availableNumbers) {
        ResponseEntity<Number[]> responseEntity;
        try {
            responseEntity = new ResponseEntity<>(esourceDemoService.largestPrimeNumber(availableNumbers), HttpStatus.OK);
        } catch (Exception exception) {
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
