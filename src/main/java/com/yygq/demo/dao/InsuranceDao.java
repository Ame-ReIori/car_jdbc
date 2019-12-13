package com.yygq.demo.dao;

import com.yygq.demo.dao.base.BaseDao;
import com.yygq.demo.entity.Insurance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * insurance dao
 * @author ame
 */
@Repository
public class InsuranceDao extends BaseDao<Insurance, String> {

    @Autowired
    public InsuranceDao(JdbcTemplate jdbcTemplate){
        super(jdbcTemplate);
    }

    /**
     * insert
     * @param insurance
     * @return success number
     */
    public Integer insert(Insurance insurance){
        return super.insert(insurance, true);
    }

    /**
     * delete
     * @param id
     * @return success number
     */
    public Integer delete(String id){
        return super.deleteById(id);
    }

    /**
     * update
     * @param insurance
     * @param id
     * @return success number
     */
    public Integer update(Insurance insurance, String id){
        return super.updateById(insurance, id, true);
    }

    /**
     * select one
     * @param id
     * @return one insurance
     */
    public Insurance selectById(String id){
        return super.queryOneById(id);
    }

    /**
     * select like insurance
     * @param insurance
     * @return list of insurances
     */
    public List<Insurance> selectInsuranceList(Insurance insurance){
        return super.queryByExample(insurance);
    }

    /**
     * select all
     * @return list of insurances
     */
    public List<Insurance> selectAll(){
        return super.queryAll();
    }

}
