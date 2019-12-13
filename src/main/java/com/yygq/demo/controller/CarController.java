package com.yygq.demo.controller;

import cn.hutool.core.lang.Dict;
import com.yygq.demo.entity.Car;
import com.yygq.demo.entity.User;
import com.yygq.demo.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @RequestMapping(value ="/car/greeting")
    public String test(){
        return "I am the bone of my sword. <br> Steel is my body, and fire is my blood. <br> I have created over a thousand blades. <br> Unknown to Death. <br> Nor known to Life. <br> Have withstood pain to create many weapons. <br> Yet, those hands will never hold anything. <br> So as I pray, unlimited blade works.";
    }

    @RequestMapping(value = "/car/insert")
    public Dict insert(@RequestParam(value = "userId")Long userId, @RequestParam(value = "userPhone")String userPhone, @RequestParam(value = "picture")String picture, @RequestParam(value = "price")Long price, @RequestParam(value = "transferTime")Integer transferTime, @RequestParam(value = "carType")String carType){
        Car car = new Car();
        car.setTransferTime(transferTime);
        car.setOwnerTel(userPhone);
        car.setIsSold(false);
        car.setIsAssess(false);
        car.setOwnerId(userId);
        car.setCarType(carType);
        car.setPicture(picture);
        car.setPrice(price);

        Boolean insert = carService.insert(car);
        return Dict.create().set("code", insert ? 200 : 500).set("msg", insert ? "success" : "failure").set("data", insert ? car : null);
    }

    @RequestMapping(value = "/car/delete")
    public Dict delete(@RequestParam(value = "carId")Long carId){
        Boolean delete = carService.delete(carId);
        return Dict.create().set("code", delete ? 200 : 500).set("msg", delete ? "success" : "failure");
    }

    @RequestMapping(value = "/car/update")
    public Dict update(@RequestParam(value = "detailImage1")String detailImage1, @RequestParam(value = "price")Long price, @RequestParam(value = "isAssess")Boolean isAssess, @RequestParam(value = "carId")Long carId){
        Car car = new Car();

        car.setPrice(price);
        car.setDetailImage1(detailImage1);
        car.setIsAssess(isAssess);
        Boolean update = carService.update(car, carId);
        return Dict.create().set("code", update ? 200 : 500).set("msg", update ? "success" : "failure").set("data", update ? car : null);
    }

    @RequestMapping(value = "/car/id")
    public Dict getCar(@RequestParam(value = "carId")Long carId){
        Car car = carService.getCar(carId);
        return Dict.create().set("code", 200).set("msg", "success").set("data", car);
    }

    @RequestMapping(value = "/car")
    public Dict getAllCars(){
        List<Car> carList = carService.getAll();
        return Dict.create().set("code", 200).set("msg", "success").set("data", carList);
    }

    @RequestMapping(value = "/car/get")
    public Dict getCars(@RequestParam(value = "userId")Long userId){
        Car car = new Car();
        car.setOwnerId(userId);
        List<Car> carList = carService.getCars(car);
        return Dict.create().set("code", 200).set("msg", "success").set("data", carList);
    }
}
