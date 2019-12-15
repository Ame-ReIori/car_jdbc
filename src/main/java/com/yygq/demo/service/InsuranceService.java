package com.yygq.demo.service;

import com.yygq.demo.entity.Insurance;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * insurance service
 * @author ame
 */
@Service
public interface InsuranceService {

    /**
     * insert
     * at least need car_id and owner_id
     * because actually the user can generate the insurance information but do not provide the detail of insurance
     * however, in this situation, the insurance_id has been generated, so need car_id and owner_id to locate the owner and the car
     * @param insurance
     * @return succeed {@code true} failure {@code false}
     */
    Boolean insert(Insurance insurance);

    /**
     * delete
     * @param id
     * @return succeed {@code true} failure {@code false}
     */
    Boolean delete(String id);

    /**
     * update
     * @param insurance
     * @param id
     * @return succeed {@code true} failure {@code false}
     */
    Boolean update(Insurance insurance, String id);

    /**
     * get one
     * @param id
     * @return insurance
     */
    Insurance getInsurance(String id);

    /**
     * get like insurance
     * @param insurance
     * @return list of insurances
     */
    List<Insurance> getInsurances(Insurance insurance);

    /**
     * get all
     * @return list of insurances
     */
    List<Insurance> getAllInsurance();
}
