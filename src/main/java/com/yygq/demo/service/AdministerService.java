package com.yygq.demo.service;

import com.yygq.demo.entity.Administer;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * admin service
 * @author ame
 */
@Service
public interface AdministerService {

    /**
     * insert
     * like user. they are actually the same entity.
     * @param administer
     * @return succeed {@code true} failure {@code false}
     */
    Boolean insert(Administer administer);

    /**
     * delete
     * @param id
     * @return succeed {@code true} failure {@code false}
     */
    Boolean delete(Long id);

    /**
     * update
     * @param administer
     * @param id
     * @return succeed {@code true} failure {@code false}
     */
    Boolean update(Administer administer, Long id);

    /**
     * get one
     * @param id
     * @return admin
     */
    Administer getAdmin(Long id);

    /**
     * get like administer
     * @param administer
     * @return list of admins
     */
    List<Administer> getAdmins(Administer administer);

    /**
     * get all
     * @return list of admins
     */
    List<Administer> getAll();
}
