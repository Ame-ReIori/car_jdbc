package com.yygq.demo.controller;

import cn.hutool.core.lang.Dict;
import com.yygq.demo.entity.Administer;
import com.yygq.demo.service.AdministerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class AdminController {
    private final AdministerService administerService;

    @Autowired
    public AdminController(AdministerService administerService){
        this.administerService = administerService;
    }
    @RequestMapping(value = "/admin")
    public Dict getAllCars(){
        List<Administer> administerList = administerService.getAll();
        return Dict.create().set("code", 200).set("msg", "success").set("data", administerList);
    }

}
