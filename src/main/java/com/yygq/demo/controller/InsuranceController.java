package com.yygq.demo.controller;

import com.yygq.demo.service.InsuranceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * insurance controller
 * @author ame
 */
@RestController
@Slf4j
public class InsuranceController {
    private final InsuranceService insuranceService;

    @Autowired
    public InsuranceController(InsuranceService insuranceService){
        this.insuranceService = insuranceService;
    }
}
