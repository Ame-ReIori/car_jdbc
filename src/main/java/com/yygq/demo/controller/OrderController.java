package com.yygq.demo.controller;

import cn.hutool.core.lang.Dict;
import com.yygq.demo.entity.Order;
import com.yygq.demo.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * order controller
 * @author ame
 */
@RestController
@Slf4j
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }
    @RequestMapping(value = "/order")
    public Dict getAllCars(){
        List<Order> carAssessmentsList = orderService.getAll();
        return Dict.create().set("code", 200).set("msg", "success").set("data", carAssessmentsList);
    }

}
