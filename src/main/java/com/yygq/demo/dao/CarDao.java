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

    /**
     * insert
     * @param car
     * @return success number
     */
    public Integer insert(Car car){
        return super.insert(car, true);
    }

    /**
     * delete
     * @param id
     * @return success number
     */
    public Integer delete(Long id){
        return super.deleteById(id);
    }

    /**
     * update
     * @param car
     * @param id
     * @return success number
     */
    public Integer update(Car car, Long id){
        return super.updateById(car, id, true);
    }

    /**
     * select one
     * @param id
     * @return a car
     */
    public Car selectById(Long id){
        return super.queryOneById(id);
    }

    /**
     * select cars like car
     * @param car
     * @return list of cars
     */
    public List<Car> selectCarList(Car car){
        return super.queryByExample(car);
    }

    /**
     * select all cars
     * @return list of cars
     */
    public List<Car> selectAll(){
        return super.queryAll();
    }




}
