package com.yygq.demo.service;

import com.yygq.demo.entity.Assessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * assessor service
 * @author ame
 */
public interface AssessorService {

    /**
     * insert
     * need real_name, password, phone. these are definitely needed from web
     * and when web interacts with this program, you should fill level field by initial level or other level.
     * @param assessor
     * @return succeed {@code true} failure {@code false}
     */
    Boolean insert(Assessor assessor);

    /**
     * delete
     * @param id
     * @return succeed {@code true} failure {@code false}
     */
    Boolean delete(Long id);

    /**
     * update
     * @param assessor
     * @param id
     * @return succeed {@code true} failure {@code false}
     */
    Boolean update(Assessor assessor, Long id);

    /**
     * get an assessor
     * @param id
     * @return an assessor entity
     */
    Assessor getAssessor(Long id);

    /**
     * get assessors
     * @param assessor
     * @return list of assessors
     */
    List<Assessor> getAssessors(Assessor assessor);

    /**
     * get all assessors
     * @return list of assessors
     */
    List<Assessor> getAll();
}
