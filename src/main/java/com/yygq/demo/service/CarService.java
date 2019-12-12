package com.yygq.demo.service;


import com.yygq.demo.entity.Car;

/**
 * car service
 *
 * @author ame
 */
public interface CarService {

    Boolean insert(Car car);

    Boolean delete(Long id);

    Boolean update(Car car, Long id);

    Car getCar()
}
