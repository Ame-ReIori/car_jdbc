package com.yygq.demo.dao;

import com.yygq.demo.dao.base.BaseDao;
import com.yygq.demo.entity.Administer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * administer dao
 * @author ame
 */
@Repository
public class AdministerDao extends BaseDao<Administer, Long> {

    @Autowired
    public AdministerDao(JdbcTemplate jdbcTemplate){
        super(jdbcTemplate);
    }

    /**
     * insert
     * @param administer
     * @return success number
     */
    public Integer insert(Administer administer){
        return super.insert(administer, true);
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
     * @param administer
     * @param id
     * @return success number
     */
    public Integer update(Administer administer, Long id){
        return super.updateById(administer, id, true);
    }

    /**
     * select one admin
     * @param id
     * @return one admin
     */
    public Administer selectById(Long id){
        return super.queryOneById(id);
    }

    /**
     * select like administer
     * @param administer
     * @return list of admins
     */
    public List<Administer> selectAdministerList(Administer administer){
        return super.queryByExample(administer);
    }

    /**
     * select all
     * @return list of admins
     */
    public List<Administer> selectAll(){
        return super.queryAll();
    }
}
