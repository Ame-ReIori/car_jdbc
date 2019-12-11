package com.yygq.demo.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.yygq.demo.constant.Const;
import com.yygq.demo.dao.UserDao;
import com.yygq.demo.service.UserService;
import com.yygq.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * the implement of UserService
 *
 * @author ame
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao){
        this.userDao = userDao;
    }

    /**
     * insert user
     *
     * @param user
     * @return success {@code true} failure {@code false}
     */
    @Override
    public Boolean insert(User user){
        System.out.println("insert");
        String temp = user.getPassword();
        String salt = IdUtil.simpleUUID();
        String pass = SecureUtil.sha256(temp + Const.SALT_PREFIX + salt);
        user.setPassword(pass);
        user.setSalt(salt);

        String username = user.getUsername();
        String phoneNumber = user.getPhoneNumber();
        String money = String.valueOf(user.getMoney());
        String identityNumber = user.getIdentityNumber();
        String status = String.valueOf(user.getStatus());
        String mac = SecureUtil.sha256(username + pass + salt + phoneNumber + money + identityNumber + status);
        user.setMac(mac);
        return userDao.insert(user) > 0;
    }

    /**
     * delete user
     *
     * @param id
     * @return success {@code true} failure {@code false}
     */
    @Override
    public Boolean delete(Long id){
        return userDao.delete(id) > 0;
    }

    /**
     * update user
     *
     * @param user
     * @param id
     * @return success {@code true} failure {@code false}
     */
    @Override
    public Boolean update(User user, Long id){
        User exist = getUser(id);
        if(StrUtil.isNotBlank(user.getPassword())){
            String temp = user.getPassword();
            String salt = IdUtil.simpleUUID();
            String pass = SecureUtil.sha256(temp + Const.SALT_PREFIX + salt);
            user.setPassword(pass);
            user.setSalt(salt);

            String username = user.getUsername();
            String phoneNumber = user.getPhoneNumber();
            String money = String.valueOf(user.getMoney());
            String identityNumber = user.getIdentityNumber();
            String status = String.valueOf(user.getStatus());
            String mac = SecureUtil.sha256(username + pass + salt + phoneNumber + money + identityNumber + status);
            user.setMac(mac);
        }
        BeanUtil.copyProperties(user, exist, CopyOptions.create().setIgnoreNullValue(true));
        exist.setLastUpdateTime(new DateTime());
        return userDao.update(user, id) > 0;
    }

    /**
     * select one user by id
     *
     * @param id
     * @return one user
     */
    @Override
    public User getUser(Long id){
        System.out.println("getuser");
        return userDao.selectById(id);
    }

    /**
     * select users
     *
     * @param user
     * @return list of users
     */
    @Override
    public List<User> getUsers(User user){
        System.out.println("getusers");
        return userDao.selectUserList(user);
    }

    /**
     * select all users
     *
     * @return list of users
     */
    @Override
    public List<User> getAllUsers(){
        System.out.println("get all users");
        return userDao.selectAllUser();
    }



}
