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

    public Integer insert(CarAssessment carAssessment){
        return super.insert(carAssessment, true);
    }

    public Integer delete(Long id){
        return super.deleteById(id);
    }

    public Integer update(CarAssessment carAssessment, Long id){
        return super.updateById(carAssessment, id, true);
    }

    public CarAssessment selectById(Long id){
        return super.queryOneById(id);
    }

    public List<CarAssessment> selectCarAssessmentList(CarAssessment carAssessment){
        return super.queryByExample(carAssessment);
    }

    public List<CarAssessment> selectAllCarAssessment(){
        return super.queryAll();
    }


}
