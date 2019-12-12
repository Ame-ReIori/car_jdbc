package com.yygq.demo.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.date.DateTime;
import cn.hutool.crypto.SecureUtil;
import com.yygq.demo.dao.OrderDao;
import com.yygq.demo.entity.Car;
import com.yygq.demo.entity.Order;
import com.yygq.demo.entity.User;
import com.yygq.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * implement
 * @author ame
 */
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderDao orderDao;

    @Autowired
    public OrderServiceImpl(OrderDao orderDao){
        this.orderDao = orderDao;
    }

    @Override
    public Boolean insert(Car car, User user){
        Order order = new Order();
        order.setCreateTime(new DateTime());
        order.setSellerId(car.getOwnerId());
        order.setCustomerId(user.getId());
        order.setCatId(car.getId());
        order.setStatus("0");
        order.setPrice(car.getPrice());

        String id = SecureUtil.sha256(order.getCreateTime().toString() + order.getCustomerId() + order.getSellerId() + order.getPrice().toString());
        order.setId(id);
        return orderDao.insert(order) > 0;
    }

    @Override
    public Boolean delete(String id){
        return orderDao.delete(id) > 0;
    }

    /**
     * we can only change status
     * when the order is generated, all the attribute except status is fixed for security
     * @param order
     * @param id
     * @return success {@code true} failure {@code false}
     */
    @Override
    public Boolean update(Order order, String id){
        Order exist = getOrder(id);
        BeanUtil.copyProperties(order, exist, CopyOptions.create().setIgnoreNullValue(true));
        return orderDao.update(exist, id) > 0;
    }

    @Override
    public Order getOrder(String id){
        return orderDao.selectById(id);
    }

    @Override
    public List<Order> getOrders(Order order){
        return orderDao.selectOrderList(order);
    }

    public List<Order> getAll(){
        return orderDao.selectAllOrder();
    }
}
