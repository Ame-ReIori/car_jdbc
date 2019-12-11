package com.yygq.demo.dao;

import com.yygq.demo.dao.base.BaseDao;
import com.yygq.demo.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * order dao
 * @author ame
 */
public class OrderDao extends BaseDao<Order, String> {

    @Autowired
    public OrderDao(JdbcTemplate jdbcTemplate){
        super(jdbcTemplate);
    }

    public Integer insert(Order order){
        return super.insert(order, true);
    }

    public Integer delete(String id){
        return super.deleteById(id);
    }

    public Integer update(Order order, String id){
        return super.updateById(order, id, true);
    }

    public Order selectById(String id){
        return super.queryOneById(id);
    }

    public List<Order> selectOrderList(Order order){
        return super.queryByExample(order);
    }

    public List<Order> selectAll(){
        return super.queryAll();
    }
}
