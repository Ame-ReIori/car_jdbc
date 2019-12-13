package com.yygq.demo.dao;

import com.yygq.demo.dao.base.BaseDao;
import com.yygq.demo.entity.CarAssessment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * car assessment dao
 * @author ame
 */
@Repository
public class CarAssessmentDao extends BaseDao<CarAssessment, Long> {

    @Autowired
    public CarAssessmentDao(JdbcTemplate jdbcTemplate){
        super(jdbcTemplate);
    }

    /**
     * insert
     * @param carAssessment
     * @return success number
     */
    public Integer insert(CarAssessment carAssessment){
        return super.insert(carAssessment, true);
    }

    /**
     * delete
     * @param id
     * @return success number
     */
    public Integer delete(Long id){
        return super.deleteById(id);
    }

    /**
     * update
     * @param carAssessment
     * @param id
     * @return success number
     */
    public Integer update(CarAssessment carAssessment, Long id){
        return super.updateById(carAssessment, id, true);
    }

    /**
     * select one
     * @param id
     * @return a car assessment
     */
    public CarAssessment selectById(Long id){
        return super.queryOneById(id);
    }

    /**
     * select like carAssessment
     * @param carAssessment
     * @return list of car assessments
     */
    public List<CarAssessment> selectCarAssessmentList(CarAssessment carAssessment){
        return super.queryByExample(carAssessment);
    }

    /**
     * select all
     * @return list of car assessments
     */
    public List<CarAssessment> selectAllCarAssessment(){
        return super.queryAll();
    }


}
