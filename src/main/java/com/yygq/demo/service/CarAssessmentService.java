package com.yygq.demo.service;

import com.yygq.demo.entity.CarAssessment;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * car assessment service
 * @author ame
 */
@Service
public interface CarAssessmentService {

    /**
     * insert
     * this entity is generated step one by one.
     * so i think when it's showed to car assessor, the car_id field should be filled
     * and when it's showed to admin, the car_id and assessor_id field should be both filled
     * when it's showed to user, the three field mentioned above should be filled
     * @param carAssessment
     * @return succeed {@code true} failure {@code false}
     */
    Boolean insert(CarAssessment carAssessment);

    /**
     * delete
     * @param id
     * @return succeed {@code true} failure {@code false}
     */
    Boolean delete(Long id);

    /**
     * update
     * @param carAssessment
     * @param id
     * @return succeed {@code true} failure {@code false}
     */
    Boolean update(CarAssessment carAssessment, Long id);

    /**
     * get one
     * @param id
     * @return one car assessment
     */
    CarAssessment getCarAssessment(Long id);

    /**
     * get like carAssessment
     * @param carAssessment
     * @return list of car assessments
     */
    List<CarAssessment> getCarAssessments(CarAssessment carAssessment);

    /**
     * get all
     * @return list of car assessmnets
     */
    List<CarAssessment> getAll();
}
