package com.yygq.demo.webController;

import cn.hutool.core.lang.Dict;
import cn.hutool.crypto.SecureUtil;
import com.yygq.demo.constant.Const;
import com.yygq.demo.entity.Car;
import com.yygq.demo.entity.Order;
import com.yygq.demo.entity.User;
import com.yygq.demo.service.AssessorService;
import com.yygq.demo.service.CarService;
import com.yygq.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Slf4j
public class carInfoController {
    private final AssessorService assessorService;
    private final UserService userService;
    private final CarService carService;

    @Autowired
    public carInfoController(UserService userService, CarService carService, AssessorService assessorService) {
        this.userService = userService;
        this.carService = carService;
        this.assessorService = assessorService;
    }

    //some bugs here,imges unable to show,due to the path
    @RequestMapping("/postImg")
    @ResponseBody
    public Dict postImg(@RequestBody CarId carId) {
        System.out.println("postImg" + carId.getCar_id());
        Car car = carService.getCar(new Long(carId.getCar_id()));
        return Dict.create().set("img", "/static/img/detail_car_img/car" + car.getCarId() + "_detail");
    }

    @RequestMapping("/postcarInfo")
    @ResponseBody
    public Dict postInfo(@RequestBody CarId carId) {
        System.out.println("postcarInfo" + carId.getCar_id());
        Long carid = new Long(carId.getCar_id());
        Car car = carService.getCar(carid);
        return Dict.create().set("car_type", car.getCarType()).set("owner_usr", userService.getUser(car.getOwnerId()).getName())
                .set("owner_tel", car.getOwnerTel()).set("transfer_time", car.getTransferTime())
                .set("car_price", car.getPrice()).set("assessor_level", "99999").set("assessor_tel", "1111111")
                .set("engine", "normal").set("windows", "good").set("wheels", "normal").set("collision", "no collision")
                .set("lights", "normal").set("appearance", "good").set("dashboard", "good").set("chassis", "normal")
                .set("security_system", "not bad").set("owner_id", car.getOwnerId());
    }
    @RequestMapping("/verify")
    @ResponseBody
    public String verifyInfo(@RequestBody User user){
        System.out.println(user.toString());
        try{
            User tool = new User();
            tool.setUserId(user.getUserId());
            List<User> userList = userService.getUsers(tool);
            User  u = userList.get(0);

            System.out.println( SecureUtil.sha256(user.getIdentityNumber()));
            System.out.println( u.toString());

            String temp = user.getPassword();
            String salt = u.getSalt();
            String pass = SecureUtil.sha256(temp + Const.SALT_PREFIX + salt);
            if(pass.equals(u.getPassword())&& u.getIdentityNumber().equals(SecureUtil.sha256(user.getIdentityNumber()))&&u.getPhone().equals(u.getPhone()))
                return "0";
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "1";
    }

    @RequestMapping("/makeOrder")
    @ResponseBody
    public String makeOrder(@RequestBody Order oder){
        try {
            System.out.println(oder.toString());
            return "0";
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return "1";
    }
}
