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

    @RequestMapping(value ="/greeting")
    public String test(){
        return "test succeed";
    }

    @RequestMapping(value = "/test/insert")
    public Dict insert(@RequestParam(value = "username")String username, @RequestParam(value = "password")String password, @RequestParam(value = "phonenumber")String phonenumber, @RequestParam(value = "identitynumber")String identitynumber){
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        user.setPhone(phonenumber);
        user.setIdentityNumber(identitynumber);
        user.setMoney(0L);

        Boolean insert = userService.insert(user);
        return Dict.create().set("code", insert ? 200 : 500).set("msg", insert ? "success" : "failure").set("data", insert ? user : null);
    }

    @RequestMapping(value = "/test/delete")
    public Dict delete(@RequestParam(value = "id")Long id){
        Boolean delete = userService.delete(id);
        return Dict.create().set("code", delete ? 200 : 500).set("msg", delete ? "success" : "failure");
    }

    @RequestMapping(value = "/test/update")
    public Dict update(@RequestParam(value = "username")String username, @RequestParam(value = "id")Long id){
        User user = new User();

        user.setName(username);

        Boolean update = userService.update(user, id);
        return Dict.create().set("code", update ? 200 : 500).set("msg", update ? "success" : "failure").set("data", update ? user : null);
    }

    @GetMapping(value = "/user/{id}")
    public Dict getUser(@PathVariable Long id){
        User user = userService.getUser(id);
        return Dict.create().set("code", 200).set("msg", "success").set("data", user);
    }

    @GetMapping(value = "/user")
    public Dict getAllUsers(){
        List<User> userList = userService.getAllUsers();
        return Dict.create().set("code", 200).set("msg", "success").set("data", userList);
    }

    @RequestMapping("/getusertest")
    public Dict getUsers(@RequestParam(value = "username")String username){
        User user = new User();
        user.setName(username);
        List<User> userList = userService.getUsers(user);
        return Dict.create().set("code", 200).set("msg", "success").set("data", userList);
    }
}
