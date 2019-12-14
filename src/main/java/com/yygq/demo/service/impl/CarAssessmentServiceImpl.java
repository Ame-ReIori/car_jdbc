package com.yygq.demo.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.yygq.demo.dao.CarAssessmentDao;
import com.yygq.demo.entity.Car;
import com.yygq.demo.entity.CarAssessment;
import com.yygq.demo.service.CarAssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.websocket.OnClose;
import java.util.List;

/**
 * implement
 * @author ame
 */
@Service
public class CarAssessmentServiceImpl implements CarAssessmentService {

    private final CarAssessmentDao carAssessmentDao;

    @Autowired
    public CarAssessmentServiceImpl(CarAssessmentDao carAssessmentDao){
        this.carAssessmentDao = carAssessmentDao;
    }

    @Override
    public Boolean insert(CarAssessment carAssessment){
        System.out.println(carAssessment.toString());
        return carAssessmentDao.insert(carAssessment) > 0;
    }

    @Override
    public Boolean delete(Long id){
        return carAssessmentDao.delete(id) > 0;
    }

    @Override
    public Boolean update(CarAssessment carAssessment, Long id){
        CarAssessment exist = getCarAssessment(id);
        BeanUtil.copyProperties(carAssessment, exist, CopyOptions.create().setIgnoreNullValue(true));
        return carAssessmentDao.update(exist, id) > 0;
    }

    @Override
    public CarAssessment getCarAssessment(Long id){
        return carAssessmentDao.selectById(id);
    }

    @Override
    public List<CarAssessment> getCarAssessments(CarAssessment carAssessment){
        return carAssessmentDao.selectCarAssessmentList(carAssessment);
    }

    public List<CarAssessment> getAll(){
        return carAssessmentDao.selectAllCarAssessment();
    }




}
