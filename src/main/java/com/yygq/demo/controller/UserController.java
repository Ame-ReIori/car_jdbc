package com.yygq.demo.controller;

import cn.hutool.core.lang.Dict;
import com.yygq.demo.entity.Assessor;
import com.yygq.demo.service.AssessorService;
import com.yygq.demo.service.UserService;
import com.yygq.demo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * user controller
 *
 * @author ame
 */
@RestController
@Slf4j
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(value ="/user/greeting")
    public String test(){
        return "I am the bone of my sword. <br> Steel is my body, and fire is my blood. <br> I have created over a thousand blades. <br> Unknown to Death. <br> Nor known to Life. <br> Have withstood pain to create many weapons. <br> Yet, those hands will never hold anything. <br> So as I pray, unlimited blade works.";
    }

    @RequestMapping(value = "/user/insert")
    public Dict insert(@RequestParam(value = "username")String username, @RequestParam(value = "password")String password, @RequestParam(value = "phone")String phone){
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        user.setPhone(phone);
        user.setMoney(0L);
        user.setStatus(1);

        Boolean insert = userService.insert(user);
        return Dict.create().set("code", insert ? 200 : 500).set("msg", insert ? "success" : "failure").set("data", insert ? user : null);
    }

    @RequestMapping(value = "/user/delete")
    public Dict delete(@RequestParam(value = "userId")Long userId){
        Boolean delete = userService.delete(userId);
        return Dict.create().set("code", delete ? 200 : 500).set("msg", delete ? "success" : "failure");
    }

    @RequestMapping(value = "/user/update")
    public Dict update(@RequestParam(value = "realname")String realName, @RequestParam(value = "identitynumber")String identityNumber, @RequestParam(value = "userId")Long userId){
        User user = new User();

        user.setRealName(realName);
        user.setIdentityNumber(identityNumber);

        Boolean update = userService.update(user, userId);
        return Dict.create().set("code", update ? 200 : 500).set("msg", update ? "success" : "failure").set("data", update ? user : null);
    }

    @GetMapping(value = "/user/id")
    public Dict getUser(@RequestParam(name = "userId")Long userId){
        User user = userService.getUser(userId);
        return Dict.create().set("code", 200).set("msg", "success").set("data", user);
    }

    @GetMapping(value = "/user")
    public Dict getAllUsers(){
        List<User> userList = userService.getAllUsers();
        return Dict.create().set("code", 200).set("msg", "success").set("data", userList);
    }

    @RequestMapping("/user/get")
    public Dict getUsers(@RequestParam(value = "username")String username){
        User user = new User();
        user.setName(username);
        List<User> userList = userService.getUsers(user);
        return Dict.create().set("code", 200).set("msg", "success").set("data", userList);
    }
}
