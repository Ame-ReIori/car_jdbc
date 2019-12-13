package com.yygq.demo.dao;

import com.yygq.demo.dao.base.BaseDao;
import com.yygq.demo.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * order dao
 * @author ame
 */
@Repository
public class OrderDao extends BaseDao<Order, String> {

    @Autowired
    public OrderDao(JdbcTemplate jdbcTemplate){
        super(jdbcTemplate);
    }

    /**
     * insert
     * @param order
     * @return success number
     */
    public Integer insert(Order order){
        return super.insert(order, true);
    }

    /**
     * delete
     * @param id
     * @return success number
     */
    public Integer delete(String id){
        return super.deleteById(id);
    }

    /**
     * update
     * @param order
     * @param id
     * @return success number
     */
    public Integer update(Order order, String id){
        return super.updateById(order, id, true);
    }

    /**
     * select one
     * @param id
     * @return one order
     */
    public Order selectById(String id){
        return super.queryOneById(id);
    }

    /**
     * select like order
     * @param order
     * @return list of orders
     */
    public List<Order> selectOrderList(Order order){
        return super.queryByExample(order);
    }

    /**
     * select all
     * @return list of orders
     */
    public List<Order> selectAllOrder(){
        return super.queryAll();
    }
}
