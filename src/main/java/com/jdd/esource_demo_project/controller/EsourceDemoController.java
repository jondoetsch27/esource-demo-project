package com.jdd.esource_demo_project.controller;

import com.jdd.esource_demo_project.model.EsourceDemoModel;
import com.jdd.esource_demo_project.service.EsourceDemoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EsourceDemoController {

    private final EsourceDemoService esourceDemoService;
    public EsourceDemoController(EsourceDemoService esourceDemoService) {
        this.esourceDemoService = esourceDemoService;
    }

    @GetMapping("/run")
    public ResponseEntity<EsourceDemoModel> runEsourceDemo() {
        Integer[] availableNumbers;
        Integer largestPrimeNumber;
        ResponseEntity<EsourceDemoModel> responseEntity;

        try {
            availableNumbers = esourceDemoService.availableNumbers();
            largestPrimeNumber = esourceDemoService.largestPrimeNumber(availableNumbers);
            responseEntity = new ResponseEntity<>(new EsourceDemoModel(availableNumbers, largestPrimeNumber), HttpStatus.OK);
        } catch (Exception exception) {
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }
}
