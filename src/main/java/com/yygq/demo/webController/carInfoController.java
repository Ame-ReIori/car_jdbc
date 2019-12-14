package com.yygq.demo.webController;

import cn.hutool.core.lang.Dict;
import cn.hutool.crypto.SecureUtil;
import com.yygq.demo.constant.Const;
import com.yygq.demo.entity.*;
import com.yygq.demo.service.*;
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
    private final CarAssessmentService carAssessmentService;
    private final OrderService orderService;

    @Autowired
    public carInfoController(UserService userService, CarService carService, AssessorService assessorService,
                             CarAssessmentService carAssessmentService,OrderService orderService) {
        this.userService = userService;
        this.carService = carService;
        this.assessorService = assessorService;
        this.carAssessmentService = carAssessmentService;
        this.orderService = orderService;

    }

    //some bugs here,imges unable to show,due to the path
    @RequestMapping("/postImg")
    @ResponseBody
    public Dict postImg(@RequestBody CarId carId) {
        System.out.println("postImg" + carId.getCar_id());
        Car car = carService.getCar(new Long(carId.getCar_id()));
        return Dict.create().set("img", "/img/detail_car_img/car" + car.getCarId() + "_detail.jpg");
    }

    @RequestMapping("/postcarInfo")
    @ResponseBody
    public Dict postInfo(@RequestBody CarId carId) {
        System.out.println("postcarInfo" + carId.getCar_id());
        Long carid = new Long(carId.getCar_id());
        Car car = carService.getCar(carid);
        System.out.println(car.toString());

        CarAssessment carAssessment = carAssessmentService.getCarAssessment(carid);
        System.out.println(carAssessment.toString());

        //Assessor assessor = assessorService.getAssessor(new Long(1));
        Long assessorId = carAssessment.getAssessorId();
        Assessor assessor = assessorService.getAssessor(assessorId);

        return Dict.create().set("car_type", car.getCarType()).set("owner_usr", userService.getUser(car.getOwnerId()).getName())
                .set("owner_tel", car.getOwnerTel()).set("transfer_time", car.getTransferTime())
                .set("car_price", car.getPrice()).set("assessor_level", assessor.getLevel()).set("assessor_tel", assessor.getPhone())
                .set("engine", carAssessment.getEngine()).set("windows", carAssessment.getWindow()).set("wheels", carAssessment.getWheel()).set("collision", carAssessment.getCollision())
                .set("lights", carAssessment.getLight()).set("appearance", carAssessment.getAppearance()).set("dashboard", carAssessment.getDashboard()).set("chassis", carAssessment.getChassis())
                .set("security_system", carAssessment.getSecuritySystem()).set("owner_id", car.getOwnerId());
        /*
        return Dict.create().set("car_type", car.getCarType()).set("owner_usr", userService.getUser(car.getOwnerId()).getName())
                .set("owner_tel", car.getOwnerTel()).set("transfer_time", car.getTransferTime())
                .set("car_price", car.getPrice()).set("assessor_level", assessor.getLevel()).set("assessor_tel", assessor.getPhone())
                .set("engine", "normal").set("windows", "good").set("wheels", "normal").set("collision", "no collision")
                .set("lights", "normal").set("appearance", "good").set("dashboard", "good").set("chassis", "normal")
                .set("security_system", "not bad").set("owner_id", car.getOwnerId());
        */
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

            System.out.println( "from web:"+user.toString());
            System.out.println( SecureUtil.sha256(user.getIdentityNumber()));
            System.out.println( "from db:"+u.toString());

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
    public String makeOrder(@RequestBody Order order){
        try {
            System.out.println(order.toString());
            //update customer wallet
            Long current_money = userService.getUser(order.getCustomerId()).getMoney()-order.getDealPrice();
            User user = new User();
            user.setMoney(current_money);

            userService.update(user,order.getCustomerId());

            //update the state of car
            Car car = carService.getCar(order.getCarId());
            car.setIsSold(true);
            carService.update(car,order.getCarId());

            orderService.insert(order);
            return "0";
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return "1";
    }
}
//订单一旦成交之后，卖家钱包应该增加金额，汽车资料从数据库中删除
