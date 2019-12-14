package com.yygq.demo.controller;

import cn.hutool.core.lang.Dict;
import com.yygq.demo.entity.CarAssessment;
import com.yygq.demo.service.CarAssessmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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


    /*
    insert assessor_ID/window/wheel/light/collision failed!
     */
    @RequestMapping(value = "/carAssessment")
    public Dict getAllCars(){
        List<CarAssessment> carAssessmentsList = carAssessmentService.getAll();
        return Dict.create().set("code", 200).set("msg", "success").set("data", carAssessmentsList);
    }

}
