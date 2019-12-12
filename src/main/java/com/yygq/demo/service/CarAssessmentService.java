package com.yygq.demo.service;

import com.yygq.demo.entity.Car;
import com.yygq.demo.entity.CarAssessment;

import java.util.List;

/**
 * car assessment service
 * @author ame
 */
public interface CarAssessmentService {

    Boolean insert(CarAssessment carAssessment);

    Boolean delete(Long id);

    Boolean update(CarAssessment carAssessment, Long id);

    CarAssessment getCarAssessment(Long id);

    List<CarAssessment> getCarAssessments(CarAssessment carAssessment);

    List<CarAssessment> getAll();
}
