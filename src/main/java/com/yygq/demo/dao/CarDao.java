package com.yygq.demo.dao;

import com.yygq.demo.dao.base.BaseDao;
import com.yygq.demo.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 /**
 * car dao
 * @author ame
 */
@Repository
public class CarDao extends BaseDao<Car, Long> {

    @Autowired
    public CarDao(JdbcTemplate jdbcTemplate){
        super(jdbcTemplate);
    }

    public Integer insert(Car car){
        return super.insert(car, true);
    }

    public Integer delete(Long id){
        return super.deleteById(id);
    }

    public Integer update(Car car, Long id){
        return super.updateById(car, id, true);
    }

    public Car selectById(Long id){
        return super.queryOneById(id);
    }

    public List<Car> selectCarList(Car car){
        return super.queryByExample(car);
    }

    public List<Car> selectAll(){
        return super.queryAll();
    }




}
