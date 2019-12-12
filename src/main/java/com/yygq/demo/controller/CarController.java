package com.yygq.demo.controller;

import com.yygq.demo.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * car controller
 *
 * @author ame
 */
@RestController
@Slf4j
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService){
        this.carService = carService;
    }
}
