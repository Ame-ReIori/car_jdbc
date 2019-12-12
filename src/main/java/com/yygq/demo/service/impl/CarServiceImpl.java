package com.yygq.demo.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.yygq.demo.dao.CarDao;
import com.yygq.demo.entity.Car;
import com.yygq.demo.entity.User;
import com.yygq.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * the implement of car service
 *
 * @author ame
 */
@Service
public class CarServiceImpl implements CarService {

    private final CarDao carDao;

    @Autowired
    public CarServiceImpl(CarDao carDao){
        this.carDao = carDao;
    }

    @Override
    public Boolean insert(User user, Car car){
        car.setOwnerId(user.getId());
        car.setOwnerPhone(user.getPhoneNumber());
        return carDao.insert(car) > 0;
    }

    @Override
    public Boolean delete(Long id){
        return carDao.delete(id) > 0;
    }

    @Override
    public Boolean update(Car car, Long id){
        Car exist = getCar(id);
        BeanUtil.copyProperties(car, exist, CopyOptions.create().setIgnoreNullValue(true));
        return carDao.update(exist, id) > 0;
    }

    @Override
    public Car getCar(Long id){
        return carDao.selectById(id);
    }

    @Override
    public List<Car> getCars(Car car){
        return carDao.selectCarList(car);
    }

    @Override
    public List<Car> getAll(){
        return carDao.selectAll();
    }
}
