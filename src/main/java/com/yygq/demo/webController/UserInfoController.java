package com.yygq.demo.webController;
/*
 * UserInfoController
 * @author:tfountain
 * */
import cn.hutool.core.lang.Dict;
import com.sun.org.apache.xpath.internal.operations.Or;
import com.yygq.demo.entity.Car;
import com.yygq.demo.entity.Order;
import com.yygq.demo.entity.User;
import com.yygq.demo.service.CarService;
import com.yygq.demo.service.OrderService;
import com.yygq.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class UserInfoController {
    private final UserService userService;
    private final CarService carService;
    private final OrderService orderService;

    @Autowired
    public UserInfoController(UserService userService,CarService carService,OrderService orderService){
        this.userService = userService;
        this.carService = carService;
        this.orderService = orderService;
    }

    @RequestMapping("/userpage_user_info")
    public String sayHelloUserInfo(){
        return "userpage_user_info";
    }


    //car和order的两个界面的用户资料刷新有问题，是哪里的问题呢 让zyf查一下
    @RequestMapping("/RequsetUserInfo")
    @ResponseBody
    public Dict RequestUserInfo(@RequestBody UserInfoPost userInfoPost){
        System.out.println("RequestUserInfo_left");
        System.out.println(userInfoPost.getUser_id());
        System.out.println(userInfoPost.getPost_code());

        long userId = userInfoPost.getUser_id();
        User user = userService.getUser(userId);
        System.out.println(user.toString());

        if (userInfoPost.getPost_code()==15)
            return Dict.create().set("avatar",user.getAvatar()).set("user_name",user.getName());
        return null;
    }



    @RequestMapping("/RequsetInfo")
    @ResponseBody
    public Dict RequestInfo(@RequestBody UserInfoPost userInfoPost){
        System.out.println(userInfoPost.toString());
        long userId = userInfoPost.getUser_id();
        User user = userService.getUser(userId);
        if (userInfoPost.getPost_code()==20)
            return Dict.create().set("user_name",user.getName()).set("user_avatar",user.getAvatar())
                    .set("user_email",user.getEmail()).set("user_phone",user.getPhone());
        return null;
    }


    //这里前端有问题，两次密码输入一致会弹窗，我测试的时候忽略了if，后端的更新功能是正常的，   提醒zyf改！
    @RequestMapping("/DeviceInfo")
    @ResponseBody
    public String DeviceInfo(@RequestBody DeviceInfo deviceInfo){
        try{
            System.out.println(deviceInfo.getPassword());
            System.out.println(deviceInfo.getUser_id());

            User user = new User();
            user.setPassword(deviceInfo.getPassword());
            user.setName(deviceInfo.getUser_name());
            user.setUserId(deviceInfo.getUser_id());
            user.setEmail(deviceInfo.getMail());
            user.setPhone(deviceInfo.getPhone());
            userService.update(user,deviceInfo.getUser_id());
            return "1";
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "0";
    }


    @RequestMapping("/userPageCarInfo")
    @ResponseBody
    public ArrayList<Dict> postUserPageCarInfo(@RequestBody UserInfoPost userInfoPost){
        System.out.println("postUserPageCarInfo");
        System.out.println(userInfoPost.getPost_code());
        System.out.println(userInfoPost.getUser_id());

        ArrayList<Dict> postCars = new ArrayList<>();
        if (userInfoPost.getPost_code() == 35) {
            try{
                Car tool = new Car();
                tool.setOwnerId(userInfoPost.getUser_id());
                List <Car> cars = carService.getCars(tool);

                for (Car car : cars){
                    Dict index = Dict.create().set("car_type",car.getCarType()).set("price",car.getPrice())
                            .set("state",car.getIsSold()==true?"已售":"在售").set("car_ID",car.getCarId())
                            .set("car_img","img/detail_car_img/car" + car.getCarId() + "_detail.jpg");
                    postCars.add(index);
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return postCars;
    }

    @RequestMapping("/userPageOrderInfo")
    @ResponseBody
    public ArrayList<Dict> postUserPageOrderInfo(@RequestBody UserInfoPost userInfoPost){
        System.out.println("postUserPageOrderInfo");
        System.out.println(userInfoPost.getPost_code());
        System.out.println(userInfoPost.getUser_id());

        ArrayList<Dict> postOrders = new ArrayList<>();
        if (userInfoPost.getPost_code() == 30) {
            try{
                Order tool = new Order();
                tool.setCustomerId(userInfoPost.getUser_id());
                List <Order> orders = orderService.getOrders(tool);

                for (Order order : orders){
                    Dict index = Dict.create().set("create_time",order.getCreateTime()).set("car_type",carService.getCar(order.getCarId()).getCarType())
                            .set("saler",order.getSalerId()).set("state",order.getOrderState());
                    postOrders.add(index);
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return postOrders;
    }

}

//三个界面的注销功能有问题,回不去