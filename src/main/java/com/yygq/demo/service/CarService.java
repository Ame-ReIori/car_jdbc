package com.yygq.demo.service;


import com.yygq.demo.entity.Car;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * car service
 *
 * @author ame
 */
@Service
public interface CarService {

    /**
     * who insert car
     * warning!warning!warning!warning!warning!
     * when a user upload a car, you need fill car entity with user's id and user's phone and other essential car information
     * then the other things will be processed by program
     * @param car
     * @return succeed {@code true} failure {@code false}
     */
    Boolean insert(Car car);

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
