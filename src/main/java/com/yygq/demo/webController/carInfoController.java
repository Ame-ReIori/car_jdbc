package com.yygq.demo.webController;

import cn.hutool.core.lang.Dict;
import com.yygq.demo.entity.Car;
import com.yygq.demo.service.AssessorService;
import com.yygq.demo.service.CarService;
import com.yygq.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class carInfoController {
    private final AssessorService assessorService;
    private final UserService userService;
    private final CarService carService;

    @Autowired
    public carInfoController(UserService userService,CarService carService,AssessorService assessorService){
        this.userService = userService;
        this.carService = carService;
        this.assessorService = assessorService;
    }

    @RequestMapping("/postImg")
    @ResponseBody
    public Dict postImg(@RequestBody CarId carId){
        System.out.println(carId);
        Car car =carService.getCar(new Long(carId.getCar_id()));
        return Dict.create().set("img","/static/img/detail_car_img/car" + car.getCarId() + "_detail");
    }
/*
    @RequestMapping("/postcarInfo")
    @ResponseBody
    public Dict postInfo(@RequestBody CarId carId){
        System.out.println(carId);
        Long carid =new Long(carId.getCar_id());
        Car car = carService.getCar(carid);
        return Dict.create().set("car_type",car.getCarType()).set("owner_usr",car.getOwnerId())
                .set("owner_tel",car.getOwnerTel()).set("transfer_time",car.getTransferTime())
                .set("car_price",car.getPrice()).set
    }
*/
}
