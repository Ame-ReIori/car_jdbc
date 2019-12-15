package com.yygq.demo.webController;

import cn.hutool.core.lang.Dict;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.yygq.demo.entity.*;
import com.yygq.demo.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/*
 * recv_AdministerInfo
 * @author:tfountain
 * */
@Controller
@Slf4j
public class AdminInfoController {
    private final AssessorService assessorService;
    private final UserService userService;
    private final CarService carService;
    private final CarAssessmentService carAssessmentService;
    private final OrderService orderService;
    private final AdministerService administerService;

    @Autowired
    public AdminInfoController(UserService userService, CarService carService, AssessorService assessorService, CarAssessmentService carAssessmentService,
                               OrderService orderService, AdministerService administerService) {
        this.userService = userService;
        this.carService = carService;
        this.assessorService = assessorService;
        this.carAssessmentService = carAssessmentService;
        this.orderService = orderService;
        this.administerService = administerService;
    }
    @RequestMapping("/adminInfo")
    public String sayHelloAdminInfo(){
        return "adminpage_users";
    }

    @RequestMapping("/RequsetAdminInfo")
    @ResponseBody
    public Dict RequestAdminInfo(@RequestBody AdminInfoPost adminInfoPost){
        System.out.println("RequestAdminInfo_left");
        System.out.println(adminInfoPost.getAdmin_id());
        System.out.println(adminInfoPost.getPost_code());
        return Dict.create().set("admin_name",administerService.getAdmin(adminInfoPost.getAdmin_id()).getName())
                .set("admin_phone",administerService.getAdmin(adminInfoPost.getAdmin_id()).getPhone());
    }


    @RequestMapping("/adminPageUserInfo")
    @ResponseBody
    public ArrayList<Dict> AdminPageUserInfo(@RequestBody AdminInfoPost adminInfoPost){
        System.out.println("adminPageUserInfo");
        System.out.println(adminInfoPost.getPost_code());
        System.out.println(adminInfoPost.getAdmin_id());

        ArrayList<Dict> postUser = new ArrayList<>();
        if (adminInfoPost.getPost_code() == 65) {
            try{
                List<User> users = userService.getAllUsers();

                for (User user : users){
                    Dict index = Dict.create().set("name",user.getName()).set("phone",user.getPhone())
                            .set("money",user.getMoney()).set("create_time",user.getCreateTime())
                            .set("last_login_time",user.getLastLoginTime()).set("status",user.getStatus()==1?"启用中":"禁用中")
                            .set("user_ID",user.getUserId());
                    postUser.add(index);
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return postUser;
    }


    @RequestMapping("/adminPageCarInfo")
    @ResponseBody
    public ArrayList<Dict> adminPageCarInfo(@RequestBody AdminInfoPost adminInfoPost){
        System.out.println("adminPageCarInfo");
        System.out.println(adminInfoPost.getPost_code());
        System.out.println(adminInfoPost.getAdmin_id());

        ArrayList<Dict> postCar = new ArrayList<>();
        if (adminInfoPost.getPost_code() == 85) {
            try{
                Car tool = new Car();
                tool.setIsAssess(false);

                List<Car> cars = carService.getCars(tool);

                for (Car car : cars){
                    Dict index = Dict.create().set("car_type",car.getCarType()).set("car_master",userService.getUser(car.getOwnerId()).getName())
                            .set("master_phone",userService.getUser(car.getOwnerId()).getPhone()).set("price",car.getPrice())
                            .set("transfer_time",car.getTransferTime()).set("assess_status",car.getIsAssess()==true?"已评估":"未评估")
                            .set("car_ID",car.getCarId());
                    postCar.add(index);
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return postCar;
    }


    @RequestMapping("/adminPageAssessorInfo")
    @ResponseBody
    public ArrayList<Dict> adminPageAssessorInfo(@RequestBody AdminInfoPost adminInfoPost){
        System.out.println("adminPageAssessorInfo");
        System.out.println(adminInfoPost.getPost_code());
        System.out.println(adminInfoPost.getAdmin_id());

        ArrayList<Dict> postAssessor = new ArrayList<>();
        if (adminInfoPost.getPost_code() == 95) {
            try{
                List<Assessor> assessors = assessorService.getAll();

                for (Assessor assessor : assessors){
                    Dict index = Dict.create().set("name",assessor.getName()).set("phone",assessor.getPhone())
                            .set("level",assessor.getLevel()).set("assessor_ID",assessor.getAssessId()).set("status",assessor.getStatus()==0?"启用中":"未启用");
                    postAssessor.add(index);
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return postAssessor;
    }

    @RequestMapping("/opOnUser")
    @ResponseBody
    public String opOnUser(@RequestBody opUserInfo opuserInfo){
        User tool = new User();
        if (opuserInfo.getPost_code()==70){
            tool.setStatus(1);
            userService.update(tool,opuserInfo.getOp_user_ID());
            return "1";
        }else if(opuserInfo.getPost_code()==75){
            tool.setStatus(0);
            userService.update(tool,opuserInfo.getOp_user_ID());
            return "1";
        }else if(opuserInfo.getPost_code()==80){
            userService.delete(opuserInfo.getOp_user_ID());
            return "1";
        }
        return "0";
    }
//因为cookie中获取不到评估师id，所以不要用启用禁用功能！
    @RequestMapping("/opOnAssessor")
    @ResponseBody
    public String opOnAssessor(@RequestBody opAssessorInfo opassessorInfo){
        Assessor tool = new Assessor();
        if (opassessorInfo.getPost_code()==100){
            tool.setStatus(0);
            assessorService.update(tool,opassessorInfo.getOp_assessor_ID());
            return "1";
        }else if(opassessorInfo.getPost_code()==105){
            tool.setStatus(1);
            assessorService.update(tool,opassessorInfo.getOp_assessor_ID());
            return "1";
        }else if(opassessorInfo.getPost_code()==110){
            assessorService.delete(opassessorInfo.getOp_assessor_ID());
            return "1";
        }
        return "0";
    }
    @RequestMapping("/opOnCar")
    @ResponseBody
    public String opOnCar(@RequestBody opCarInfo opcarInfo) {
        Car car = new Car();
        if(opcarInfo.getPost_code()==90){
            car.setIsAssess(true);
            carService.update(car,opcarInfo.getOp_car_ID());
            return "1";
        }else return "0";
    }

}
