package com.yygq.demo.dao;

import com.yygq.demo.dao.base.BaseDao;
import com.yygq.demo.entity.Assessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * assessor dao
 * @author ame
 */
@Repository
public class AssessorDao extends BaseDao<Assessor, Long> {

    @Autowired
    public AssessorDao(JdbcTemplate jdbcTemplate){
        super(jdbcTemplate);
    }

    /**
     * insert assessor
     * @param assessor
     * @return success number
     */
    public Integer insert(Assessor assessor){
        return super.insert(assessor, true);
    }

    /**
     * delete assessor by id
     * @param id
     * @return success number
     */
    public Integer delete(Long id){
        return super.deleteById(id);
    }

    /**
     * update assessor
     * @param assessor
     * @param id
     * @return success number
     */
    public Integer update(Assessor assessor, Long id){
        return super.updateById(assessor, id, true);
    }

    /**
     * select an assessor by id
     * @param id
     * @return an assessor
     */
    public Assessor selectById(Long id){
        return super.queryOneById(id);
    }

    /**
     * select by example
     * @param assessor
     * @return list of assessor
     */
    public List<Assessor> selectAssessorList(Assessor assessor) {
        return super.queryByExample(assessor);
    }

    /**
     * select all
     * @return list of assessor
     */
    public List<Assessor> selectAllAssessor(){
        return super.queryAll();
    }
}
