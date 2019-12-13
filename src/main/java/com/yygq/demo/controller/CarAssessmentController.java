package com.yygq.demo.controller;

import com.yygq.demo.entity.CarAssessment;
import com.yygq.demo.service.CarAssessmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * car assessment controller
 *
 * @author ame
 */
@RestController
@Slf4j
public class CarAssessmentController {
    private final CarAssessmentService carAssessmentService;

    @Autowired
    public CarAssessmentController(CarAssessmentService carAssessmentService){
        this.carAssessmentService = carAssessmentService;
    }

}
