package com.yygq.demo.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.yygq.demo.dao.InsuranceDao;
import com.yygq.demo.entity.Insurance;
import com.yygq.demo.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * implement
 * @author ame
 */
@Service
public class InsuranceServiceImpl implements InsuranceService {

    private final InsuranceDao insuranceDao;

    @Autowired
    public InsuranceServiceImpl(InsuranceDao insuranceDao){
        this.insuranceDao = insuranceDao;
    }

    @Override
    public Boolean insert(Insurance insurance) {
        return insuranceDao.insert(insurance) > 0;
    }

    @Override
    public Boolean delete(String id){
        return insuranceDao.delete(id) > 0;
    }

    @Override
    public Boolean update(Insurance insurance, String id){
        Insurance exist = getInsurance(id);
        BeanUtil.copyProperties(insurance, exist, CopyOptions.create().setIgnoreNullValue(true));
        return insuranceDao.update(insurance, id) > 0;
    }

    @Override
    public Insurance getInsurance(String id){
        return insuranceDao.selectById(id);
    }

    @Override
    public List<Insurance> getInsurances(Insurance insurance){
        return insuranceDao.selectInsuranceList(insurance);
    }

    @Override
    public List<Insurance> getAllInsurance(){
        return insuranceDao.selectAll();
    }
}
