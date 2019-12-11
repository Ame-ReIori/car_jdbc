package com.yygq.demo.dao;

import com.yygq.demo.dao.base.BaseDao;
import com.yygq.demo.entity.Insurance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * insurance dao
 * @author ame
 */
public class InsuranceDao extends BaseDao<Insurance, String> {

    @Autowired
    public InsuranceDao(JdbcTemplate jdbcTemplate){
        super(jdbcTemplate);
    }

    public Integer insert(Insurance insurance){
        return super.insert(insurance, true);
    }

    public Integer delete(String id){
        return super.deleteById(id);
    }

    public Integer update(Insurance insurance, String id){
        return super.updateById(insurance, id, true);
    }

    public Insurance selectById(String id){
        return super.queryOneById(id);
    }

    public List<Insurance> selectInsuranceList(Insurance insurance){
        return super.queryByExample(insurance);
    }

    public List<Insurance> selectAll(){
        return super.queryAll();
    }

}
