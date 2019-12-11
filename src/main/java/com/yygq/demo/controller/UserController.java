package com.yygq.demo.controller;

import cn.hutool.core.lang.Dict;
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

    @PostMapping(value = "/user")
    public Dict insert(@RequestBody User user){
        System.out.println("insert");
        Boolean insert = userService.insert(user);
        return Dict.create().set("code", insert ? 200 : 500).set("msg", insert ? "success" : "failure").set("data", insert ? user : null);
    }

    @DeleteMapping(value = "/user/{id}")
    public Dict delete(@PathVariable Long id){
        Boolean delete = userService.delete(id);
        return Dict.create().set("code", delete ? 200 : 500).set("msg", delete ? "success" : "failure");
    }

    @RequestMapping(value = "/test_login")
    @ResponseBody
    public String Test_update(@RequestBody User user){
        System.out.println(user.getPassword());
        System.out.println(user.getUsername());
        long id = 1;
        Boolean update = userService.update(user, id);
        System.out.println("get user!");
        return "0";
    }

    @PutMapping(value = "/user/{id}")
    public Dict update(@RequestBody User user, @PathVariable Long id){
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

    @GetMapping(value = "/user/usersample")
    public Dict getUsers(User user){
        List<User> userList = userService.getUsers(user);
        return Dict.create().set("code", 200).set("msg", "success").set("data", userList);
    }
}
