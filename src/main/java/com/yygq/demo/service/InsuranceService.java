package com.yygq.demo.service;

import com.yygq.demo.entity.Insurance;

import java.util.List;

/**
 * insurance service
 * @author ame
 */
public interface InsuranceService {

    Boolean insert(Insurance insurance);

    Boolean delete(String id);

    Boolean update(Insurance insurance, String id);

    Insurance getInsurance(String id);

    List<Insurance> getInsurances(Insurance insurance);

    List<Insurance> getAllInsurance();
}
