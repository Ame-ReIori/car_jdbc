package com.yygq.demo.dao;

import com.yygq.demo.dao.base.BaseDao;
import com.yygq.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * user dao
 * @author ame
 * @description: user dao
 */
@Repository
public class UserDao extends BaseDao<User, Long> {

    @Autowired
    public UserDao(JdbcTemplate jdbcTemplate){
        super(jdbcTemplate);
    }

    /**
     * insert user
     *
     * @param user
     * @return success number
     */
    public Integer insert(User user){
        return super.insert(user, true);
    }

    /**
     * delete user by id
     *
     * @param id
     * @return success number
     */
    public Integer delete(Long id){
        return super.deleteById(id);
    }

    /**
     * update user by id
     *
     * @param user
     * @param id
     * @return success number
     */
    public Integer update(User user, Long id){
        return super.updateById(user, id, true);
    }

    /**
     * select one user by id
     *
     * @param id
     * @return one user
     */
    public User selectById(Long id){
        return super.queryOneById(id);
    }

    /**
     * select users
     *
     * @param user
     * @return list of users
     */
    public List<User> selectUserList(User user) {
        return super.queryByExample(user);
    }

    /**
     * select all users
     *
     * @return list of users
     */
    public List<User> selectAllUser() {
        return super.queryAll();
    }
}
