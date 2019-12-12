package com.yygq.demo.service;

import com.yygq.demo.entity.Car;
import com.yygq.demo.entity.Order;
import com.yygq.demo.entity.User;

import java.util.List;

/**
 * order service
 * @author ame
 */
public interface OrderService {

    /**
     * insert order.
     * the param is different from other service
     * the reason is that we can just construct an order through car and users and need no other information
     * @param car
     * @param user
     * @return succeed {@code true} failure {@code false}
     */
    Boolean insert(Car car, User user);

    /**
     * delete by id
     * warning!warning!warning!warning!warning!
     * the id is string because we use sha-256 to generate the id
     * @param id
     * @return succeed {@code true} failure {@code false}
     */
    Boolean delete(String id);

    /**
     * update
     * @param order
     * @param id
     * @return succeed {@code true} failure {@code false}
     */
    Boolean update(Order order, String id);

    /**
     * get an order
     * @param id
     * @return an order
     */
    Order getOrder(String id);

    /**
     * get orders
     * @param order
     * @return list of orders
     */
    List<Order> getOrders(Order order);

    /**
     * get all orders
     * @return list of orders
     */
    List<Order> getAll();
}
