package com.yygq.demo.webController;

import cn.hutool.core.lang.Dict;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.sun.org.apache.xpath.internal.operations.Or;
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
* AssessorInfoController
* @author:tfountain
* */
@Controller
@Slf4j
public class AssessorInfoController {
    private final UserService userService;
    private final CarService carService;
    private final AssessorService assessorService;
    private final CarAssessmentService carAssessmentService;

    @Autowired
    public AssessorInfoController(UserService userService, CarService carService, AssessorService assessorService,CarAssessmentService carAssessmentService){
        this.userService = userService;
        this.carService = carService;
        this.assessorService = assessorService;
        this.carAssessmentService = carAssessmentService;
    }

    @RequestMapping("/assessorInfo")
    public String sayHelloAssessorInfo(){
        return "assessorpage_assess";
    }

    @RequestMapping("/RequsetAssessorInfo")
    @ResponseBody
    public Dict RequestUserInfo(@RequestBody AssessorInfoPost assessorInfoPost){
        System.out.println("RequestAssessorInfo_left");
        System.out.println(assessorInfoPost.getAssessor_id());
        System.out.println(assessorInfoPost.getPost_code());

        long assessorId = assessorInfoPost.getAssessor_id();
        Assessor assessor = assessorService.getAssessor(assessorId);
        System.out.println(assessor.toString());

        return Dict.create().set("assessor_name",assessor.getName()).set("assessor_level",assessor.getLevel())
                .set("assessor_phone",assessor.getPhone());
    }


    @RequestMapping("/assessorPageWaitingCarInfo")
    @ResponseBody
    public ArrayList<Dict> assessorPageWaitingCarInfo(@RequestBody AssessorInfoPost assessorInfoPost){
        try{
            Car tool = new Car();
            tool.setIsAssess(false);
            List <Car> cars = carService.getCars(tool);

            ArrayList<Dict> postCars = new ArrayList<>();
            for (Car car : cars){
                Dict index = Dict.create().set("car_type",car.getCarType()).set("car_master_name",userService.getUser(car.getOwnerId()).getName())
                        .set("car_master_phone",car.getOwnerTel()).set("is_assessed",car.getIsAssess()==true?"已评估":"未评估")
                        .set("car_ID",car.getCarId());
                postCars.add(index);
            }
                return postCars;
        }catch (Exception ex){
                ex.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/assessorPageDealtCarInfo")
    @ResponseBody
    public ArrayList<Dict> assessorPageDealtCarInfo(@RequestBody AssessorInfoPost assessorInfoPost){

        ArrayList<Dict> postCars = new ArrayList<>();
        try{
            System.out.println(carService.getCar(new Long(8)).toString());
            System.out.println("in dealt car info");
            System.out.println(assessorInfoPost.getAssessor_id());
            System.out.println(assessorInfoPost.getPost_code());

            Car tool = new Car();
            tool.setIsAssess(true);

            List <Car> cars = carService.getCars(tool);

            for (Car car : cars){
                CarAssessment carAssessment = carAssessmentService.getCarAssessment(car.getCarId());
                System.out.println(carAssessment.toString());
                System.out.println(carAssessment.getAssessorId());

                if(carAssessment.getAssessorId()!=assessorInfoPost.getAssessor_id())
                    continue;
                Dict index = Dict.create().set("car_type",car.getCarType()).set("car_master_name",car.getOwnerId())
                        .set("car_master_phone",car.getOwnerTel()).set("is_assessed",car.getIsAssess()==true?"已评估":"未评估")
                        .set("car_ID",car.getCarId());
                postCars.add(index);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return postCars;
    }

    @RequestMapping("/makeAssessment")
    @ResponseBody
    public String makeAssessment(@RequestBody MakeAssessment makeAssessment){
        System.out.println("in makeAssessment");
        try{
            CarAssessment carAssessment_up = new CarAssessment();
            carAssessment_up.setAssessorId(makeAssessment.getAssessor_id());
            carAssessment_up.setEngine(makeAssessment.getEngine_as());
            carAssessment_up.setWindow(makeAssessment.getWindows_as());
            carAssessment_up.setWheel(makeAssessment.getWheels_as());
            carAssessment_up.setCollision(makeAssessment.getCollsion_as());
            carAssessment_up.setLight(makeAssessment.getLights_as());
            carAssessment_up.setAppearance(makeAssessment.getAppearance_as());
            carAssessment_up.setDashboard(makeAssessment.getDashboard_as());
            carAssessment_up.setChassis(makeAssessment.getChassis_as());
            carAssessment_up.setSecuritySystem(makeAssessment.getSecurity_system_as());
            carAssessmentService.update(carAssessment_up,makeAssessment.getCar_id());
            /*
            想把这个是否更新评估的决定交给管理员去做
            Car car_up = new Car();
            car_up.setIsAssess(true);
            carService.update(car_up,makeAssessment.getCar_id());
          */
        }catch (Exception ex){
            ex.printStackTrace();
            return "0";
        }
        return "1";
    }
}

//三个界面的注销功能有问题,回不去