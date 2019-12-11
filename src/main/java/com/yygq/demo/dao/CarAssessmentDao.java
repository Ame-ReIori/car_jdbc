package com.yygq.demo.dao;

import com.yygq.demo.dao.base.BaseDao;
import com.yygq.demo.entity.CarAssessment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * car assessment dao
 * @author ame
 */
public class CarAssessmentDao extends BaseDao<CarAssessment, String> {

    @Autowired
    public CarAssessmentDao(JdbcTemplate jdbcTemplate){
        super(jdbcTemplate);
    }

    public Integer insert(CarAssessment carAssessment){
        return super.insert(carAssessment, true);
    }

    public Integer delete(String id){
        return super.deleteById(id);
    }

    public Integer update(CarAssessment carAssessment, String id){
        return super.updateById(carAssessment, id, true);
    }

    public CarAssessment selectById(String id){
        return super.queryOneById(id);
    }

    public List<CarAssessment> selectCarAssessmentList(CarAssessment carAssessment){
        return super.queryByExample(carAssessment);
    }

    public List<CarAssessment> selectAll(){
        return super.queryAll();
    }


}
