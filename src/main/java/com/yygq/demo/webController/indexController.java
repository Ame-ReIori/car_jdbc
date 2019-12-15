package com.yygq.demo.webController;

import cn.hutool.core.lang.Dict;
import cn.hutool.crypto.SecureUtil;
import com.yygq.demo.constant.Const;
import com.yygq.demo.entity.Car;
import com.yygq.demo.entity.User;
import com.yygq.demo.service.CarService;
import com.yygq.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/*
 * indexController
 * @author:tfountain
 * */
import java.util.ArrayList;
import java.util.List;

/*able to
* login
* logon
* logout
* show the relevant car info
* but pic cannot be shown normally,due to the path which i am checking
* */
@Controller
@Slf4j
public class indexController {
    private final UserService userService;
    private final CarService carService;

    @Autowired
    public indexController(UserService userService,CarService carService){
        this.userService = userService;
        this.carService = carService;
    }

    @RequestMapping("index")
    public String sayHelloIndex(){
        return "index";
    }


    @RequestMapping("/logon")
    @ResponseBody
    public String logon(@RequestBody User user){
        user.setMoney(new Long(0));
        System.out.println(user.toString());
        try{

            Boolean insert = userService.insert(user);
        /*
            User u = userService.getUser(user.getUserId());
            u.setMoney(new Long("100000000000000000"));
            userService.update(u,user.getUserId());
          */
        }catch (Exception ex){
            ex.printStackTrace();
            return "1";
        }
        return "0";
    }
    @RequestMapping("/login")
    @ResponseBody
    public Dict login(@RequestBody User user){
        System.out.println(user.toString());
        try{
            User tool = new User();
            tool.setName(user.getName());//按照名字索引得到user
            List<User> userList = userService.getUsers(tool);
            User  u = userList.get(0);

            String temp = user.getPassword();//111
            String salt = u.getSalt();
            String pass = SecureUtil.sha256(temp + Const.SALT_PREFIX + salt);
            if(pass.equals(u.getPassword()))
                return Dict.create().set("code", '0').set("username", u.getName()).set("user_balance", u.getMoney())
                        .set("user_mail",u.getEmail()).set("user_phone",u.getPhone()).set("userid",u.getUserId());
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return Dict.create().set("code",'1');
    }

    //some bugs here too,imges unable to show normally
    @RequestMapping("/carInfo_onPage")
    @ResponseBody
    public Dict carInfoOnPage(@RequestBody Page page) {
        //System.out.println(page.getPage_num());
        int n = page.getPage_num();
        System.out.println(n);
        Dict dict = Dict.create();

        for (int i = 1; i + 4 * (n - 1) <= carService.getAll().size(); i++) {
            ArrayList<Car> carArrayList = new ArrayList<>();
            carArrayList.add(carService.getCar(new Long(i)));
            Car car = carService.getCar(new Long(i + 4 * (n - 1)));
            dict.set("car_model" + i, car.getCarType()).set("car_intro" + i, "车主电话：" + car.getOwnerTel() + '\n' + "价格：" + car.getPrice() + '\n' + car.getTransferTime() + "手车")
                    .set("car_id" + i, car.getCarId()).set("car_img" + i, "img/detail_car_img/car" + car.getCarId() + "_detail.jpg");
        }
        return dict;
    }
}
//只有第一页有图。。
