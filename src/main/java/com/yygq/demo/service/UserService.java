package com.yygq.demo.service;

import com.yygq.demo.entity.User;

import java.util.List;

/**
 * user service
 * @author ame
 * @desciption: what we can do with the table user
 */
public interface UserService {
    /**
     * add user
     * @param user
     * @return succeed {@code true} failure {@code false}
     */
    Boolean insert(User user);

    /**
     * delete user
     * @param id
     * @return succeed {@code true} failure {@code false}
     */
    Boolean delete(Long id);

    /**
     * update user
     * @param user
     * @param id
     * @return succeed {@code true} failure {@code false}
     */
    Boolean update(User user, Long id);

    /**
     * get one user
     * @param id
     * @return a user entity
     */
    User getUser(Long id);

    /**
     * get user list
     * @param user
     * @return list of users
     */
    List<User> getUsers(User user);

    /**
     * get all users
     *
     * @return list of all users
     */
    List<User> getAllUsers();
}
