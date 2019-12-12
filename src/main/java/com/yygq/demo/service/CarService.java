package com.yygq.demo.service;


import com.yygq.demo.entity.Car;
import com.yygq.demo.entity.User;

import java.util.List;

/**
 * car service
 *
 * @author ame
 */
public interface CarService {

    /**
     * who insert car
     * @param user
     * @param car
     * @return succeed {@code true} failure {@code false}
     */
    Boolean insert(User user, Car car);

    /**
     * delete car by id
     * @param id
     * @return succeed {@code true} failure {@code false}
     */
    Boolean delete(Long id);

    /**
     * update car
     * @param car
     * @param id
     * @return succeed {@code true} failure {@code false}
     */
    Boolean update(Car car, Long id);

    /**
     * get car by id
     * @param id
     * @return a car entity
     */
    Car getCar(Long id);

    /**
     * get car list
     * @param car
     * @return list of car
     */
    List<Car> getCars(Car car);

    /**
     * get all cars
     * @return list of car
     */
    List<Car> getAll();
}
